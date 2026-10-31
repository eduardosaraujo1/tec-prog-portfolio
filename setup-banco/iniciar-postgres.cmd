@echo off
setlocal
set "CONTAINER=lista-7-postgres"
set "VOLUME=lista-7-postgres-data"

docker info >nul 2>&1
if errorlevel 1 (
    echo Erro: instale/inicie o Docker Desktop com containers Linux. 1>&2
    exit /b 1
)

if not exist "%~dp0banco.sql" (
    echo Erro: banco.sql deve estar na mesma pasta deste script. 1>&2
    exit /b 1
)

docker container inspect "%CONTAINER%" >nul 2>&1
if errorlevel 1 goto :criar

echo Reutilizando %CONTAINER%, sem alterar credenciais ou dados existentes.
docker start "%CONTAINER%" >nul
if errorlevel 1 goto :erro
goto :aguardar

:criar
docker run -d --name "%CONTAINER%" --restart unless-stopped ^
    -e POSTGRES_DB=lista7 ^
    -e POSTGRES_USER=lista7 ^
    -e POSTGRES_PASSWORD=lista7_dev ^
    -p 127.0.0.1:5432:5432 ^
    -v "%VOLUME%:/var/lib/postgresql" ^
    --mount "type=bind,source=%~dp0banco.sql,target=/docker-entrypoint-initdb.d/01-banco.sql,readonly" ^
    postgres:18 >nul
if errorlevel 1 goto :erro

:aguardar
rem TCP evita detectar o servidor temporario usado durante a inicializacao.
for /l %%I in (1,1,60) do (
    docker exec "%CONTAINER%" pg_isready -h 127.0.0.1 -U lista7 -d lista7 >nul 2>&1
    if not errorlevel 1 goto :pronto
    timeout /t 1 /nobreak >nul
)
echo Erro: PostgreSQL nao ficou pronto. 1>&2
goto :erro

:pronto
docker exec -e PGPASSWORD=lista7_dev "%CONTAINER%" ^
    psql -h 127.0.0.1 -U lista7 -d lista7 -X -v ON_ERROR_STOP=1 ^
    -c "SELECT id FROM public.livro LIMIT 0; SELECT id FROM public.tarefa LIMIT 0;" >nul
if errorlevel 1 (
    echo Erro: credenciais ou tabelas incompativeis. Nenhum dado foi apagado. 1>&2
    goto :erro
)

echo PostgreSQL pronto em localhost:5432. Banco: lista7; usuario: lista7; senha: lista7_dev.
echo Inicie uma API por vez e execute o respectivo script testar-*.sh ^(ver README.md^).
exit /b 0

:erro
echo Consulte DB_SPEC.md e execute: docker logs %CONTAINER% 1>&2
exit /b 1
