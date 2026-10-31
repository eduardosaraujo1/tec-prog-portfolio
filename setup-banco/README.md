# Execução para avaliação

## Pré-requisitos

- Docker em execução (no Windows, Docker Desktop com containers Linux).
- JDK 21; o Maven Wrapper já está incluído nos projetos.
- Bash e `curl` para os testes HTTP. No Windows, use o Git Bash.
- Portas `5432` e `8080` disponíveis e internet para baixar imagens/dependências na primeira execução.

## 1. Iniciar o banco

Na pasta raiz da entrega, execute **uma** das opções:

```sh
# Linux/macOS (Bash)
bash iniciar-postgres.sh
```

```bat
rem Windows (Prompt de Comando)
iniciar-postgres.cmd
```

Os scripts podem ser chamados de outra pasta: localizam `banco.sql` ao lado
deles. O PostgreSQL 18 fica disponível em `localhost:5432`, banco `lista7`, usuário
`lista7`, senha `lista7_dev`, conforme as configurações padrão das duas APIs.
Essas credenciais são exclusivamente para desenvolvimento/avaliação local.

Em um volume novo, `banco.sql` cria as tabelas `livro` e `tarefa`, suas identidades,
chaves e restrições. Não copia registros do ambiente de desenvolvimento:
o primeiro registro de cada tabela recebe ID `1`.

O container `lista-7-postgres` e o volume `lista-7-postgres-data` são persistentes.
Executar o inicializador novamente não limpa os dados nem reaplica o SQL.
O script aguarda o banco e verifica acesso e presença das tabelas antes de informar sucesso.

## 2. Iniciar uma API

As duas APIs usam a porta `8080`: execute **uma por vez**, sem variáveis de
ambiente que substituam as configurações padrão de conexão.

```sh
# Biblioteca: em um terminal na raiz da entrega
cd api-biblioteca
./mvnw spring-boot:run
```

Ou, para o gerenciador de tarefas:

```sh
cd api-task-mgr
./mvnw spring-boot:run
```

No Prompt de Comando do Windows, substitua `./mvnw` por `mvnw.cmd`.
Aguarde a mensagem `Started ...Application` antes de testar. Para trocar de API,
encerre a atual com `Ctrl+C` e inicie a outra.

## 3. Executar os testes HTTP existentes

Em outro terminal Bash, na raiz da entrega, execute o teste da API iniciada:

```sh
bash testar-api-biblioteca.sh
# OU, com a API de tarefas em execução:
bash testar-task-mgr.sh
```

Os scripts imprimem as respostas HTTP; não fazem asserções automáticas.
Em um banco novo, as URLs com ID `1` funcionam na primeira execução de cada teste.
Nas próximas execuções, mesmo após excluir registros, os IDs continuam avançando:
execute os comandos individualmente, substituindo o ID nas URLs pelo retornado
no `POST`, conforme os comentários dos próprios scripts. O ISBN também precisa
ser único caso o livro de uma execução anterior ainda exista.

Os testes Java (`./mvnw test` em cada projeto) usam H2 e não precisam do container.

## Diagnóstico e preservação dos dados

- Se a porta `5432` estiver ocupada, libere-a antes de iniciar; não altere apenas
  a porta do Docker sem ajustar também a conexão das aplicações.
- Consulte `docker logs lista-7-postgres` se a inicialização falhar.
- O SQL de `/docker-entrypoint-initdb.d` só é executado pelo Postgres quando o
  volume está vazio. Um volume antigo não recebe automaticamente este DDL;
  falhas de acesso/tabelas exigem conferir sua configuração, não apagar dados.
- Para parar: `docker stop lista-7-postgres`. Para retomar, execute novamente
  o inicializador. Não é necessário excluir o container ou o volume.
- Detalhes do ambiente compartilhado estão em [DB_SPEC.md](DB_SPEC.md).
