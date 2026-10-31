#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd)"
CONTAINER=lista-7-postgres
VOLUME=lista-7-postgres-data

if ! command -v docker >/dev/null 2>&1 || ! docker info >/dev/null 2>&1; then
    echo 'Erro: instale/inicie o Docker (Docker Desktop no Windows/macOS).' >&2
    exit 1
fi

if [[ ! -f "$SCRIPT_DIR/banco.sql" ]]; then
    echo "Erro: arquivo nao encontrado: $SCRIPT_DIR/banco.sql" >&2
    exit 1
fi

if docker container inspect "$CONTAINER" >/dev/null 2>&1; then
    echo "Reutilizando $CONTAINER, sem alterar credenciais ou dados existentes."
    docker start "$CONTAINER" >/dev/null
else
    docker run -d --name "$CONTAINER" --restart unless-stopped \
        -e POSTGRES_DB=lista7 \
        -e POSTGRES_USER=lista7 \
        -e POSTGRES_PASSWORD=lista7_dev \
        -p 127.0.0.1:5432:5432 \
        -v "$VOLUME:/var/lib/postgresql" \
        --mount "type=bind,source=$SCRIPT_DIR/banco.sql,target=/docker-entrypoint-initdb.d/01-banco.sql,readonly" \
        postgres:18 >/dev/null
fi

# TCP evita confundir o servidor temporario da inicializacao com o definitivo.
PRONTO=false
for ((tentativa = 1; tentativa <= 60; tentativa++)); do
    if docker exec "$CONTAINER" pg_isready -h 127.0.0.1 -U lista7 -d lista7 >/dev/null 2>&1; then
        PRONTO=true
        break
    fi
    sleep 1
done

if [[ "$PRONTO" != true ]]; then
    echo "Erro: PostgreSQL nao ficou pronto. Consulte: docker logs $CONTAINER" >&2
    exit 1
fi

# Confere senha e tabelas inclusive ao reutilizar um container/volume antigo.
if ! docker exec -e PGPASSWORD=lista7_dev "$CONTAINER" \
    psql -h 127.0.0.1 -U lista7 -d lista7 -X -v ON_ERROR_STOP=1 \
    -c 'SELECT id FROM public.livro LIMIT 0; SELECT id FROM public.tarefa LIMIT 0;' >/dev/null; then
    echo 'Erro: credenciais ou tabelas incompativeis. Nenhum dado foi apagado.' >&2
    echo "Consulte DB_SPEC.md e: docker logs $CONTAINER" >&2
    exit 1
fi

echo 'PostgreSQL pronto em localhost:5432. Banco: lista7; usuario: lista7; senha: lista7_dev.'
echo 'Inicie uma API por vez e execute o respectivo script testar-*.sh (ver README.md).'
