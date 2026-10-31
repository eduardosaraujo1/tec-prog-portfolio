# Shared local PostgreSQL

- Container: `lista-7-postgres`, image `postgres:18`, persistent Docker volume `lista-7-postgres-data`, host port `5432`.
- Shared database: `lista7`; username: `lista7`; password: `lista7_dev`.
- These are local-development credentials only; do not reuse them in production or expose the service outside the local development environment.
- Start an existing stopped container with `docker start lista-7-postgres`. Check status with `docker ps -a --filter name=lista-7-postgres`.
- Original provisioning command (creates the persistent container and volume):

  ```sh
  docker run -d --name lista-7-postgres --restart unless-stopped \
    -e POSTGRES_DB=lista7 -e POSTGRES_USER=lista7 -e POSTGRES_PASSWORD=lista7_dev \
    -p 5432:5432 -v lista-7-postgres-data:/var/lib/postgresql postgres:18
  ```

- Both Spring apps share this database. Configure app connections from the values above as needed. Ask before changing these credentials or removing/replacing the container or volume, and update this file whenever database access or setup changes.

## Application access

- `api-biblioteca/src/main/resources/application.properties` now defaults to the shared database above. URL, username and password can be overridden with `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME` and `SPRING_DATASOURCE_PASSWORD`.
- The library app's Maven plugin starts the JVM with `-Duser.timezone=America/Sao_Paulo` so the JDBC driver does not send the rejected legacy timezone `Brazil/East`. IDE and `java -jar` launches should use the same JVM option. This changes only the client timezone; no server, credential or volume changes are required.
- The library app uses `spring.jpa.hibernate.ddl-auto=update`: starting it creates/updates the `livro` table and its constraints without recreating the shared database.
- Library automated tests use the `test` profile with an isolated H2 in-memory database; they do not access the shared PostgreSQL database.
- `api-task-mgr/src/main/resources/application.properties` now defaults to the shared database above, with optional overrides through `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD` (or the standard `SPRING_DATASOURCE_*` variables).
- The task-manager app uses `spring.jpa.hibernate.ddl-auto=update`: starting it creates/updates the `tarefa` table and its constraints without recreating the shared database.
- Task-manager automated tests use the `test` profile with an isolated H2 in-memory database; they do not access the shared PostgreSQL database. No container, volume or credential changes were made.

## Reproducible setup for the coursework delivery

- `banco.sql` reproduces the schema inspected from the shared PostgreSQL 18 database (schema-only `pg_dump`): `public.livro`, `public.tarefa`, identity sequences starting at 1, primary keys, unique ISBN and the priority range check. It deliberately contains no application records.
- The SQL is a **psql** script for a fresh installation, run by a superuser: it creates the `lista7` login/database if missing, sets the local password to `lista7_dev`, and creates the tables as `lista7`. It is not a migration to reapply to an existing schema.
- `iniciar-postgres.sh` (Bash) and `iniciar-postgres.cmd` (Windows Command Prompt) create the same container/volume and credentials documented above, using `postgres:18`, mounting the SQL read-only under `/docker-entrypoint-initdb.d/01-banco.sql`. The PostgreSQL 18 data mount remains `/var/lib/postgresql`.
- New containers publish **only `127.0.0.1:5432:5432`**, rather than all network interfaces. The existing container's port bindings, credentials, schema and data are not changed by this addition.
- Both scripts reuse an existing container without reapplying SQL or changing its credentials. They wait for TCP readiness and verify password authentication and access to both tables. Existing volumes are preserved; Docker only executes initialization SQL on an empty data directory.
- The connection remains `jdbc:postgresql://localhost:5432/lista7`, user `lista7`, password `lista7_dev`; no application configuration changes are needed. See `README.md` for the professor's startup/test instructions and the existing HTTP scripts' ID assumptions.
- Validation used an isolated, automatically removed `portfolio-ddl-verificacao` container with a temporary in-memory data mount and no published ports. Its normalized schema dump matched the original; credential access, initial IDs and constraint enforcement passed. The Bash initializer also passed against the existing container, including invocation from another directory. The shared database/volume were not modified; the Windows initializer still requires validation on Windows.
