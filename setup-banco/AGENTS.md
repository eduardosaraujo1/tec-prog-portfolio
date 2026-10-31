# Repository notes

- This workspace contains two independent Maven/Spring Boot apps; run commands from the relevant app directory, not the workspace root. Both target Java 21 and include `mvnw`.
- This is academic coursework: keep implementations simple and readable. Under each app's main Java package, organize code in `model`, `controller`, `service`, and `repository` packages.
- Build/run/test `api-task-mgr` or `api-biblioteca` with `./mvnw test`, `./mvnw spring-boot:run`, or `./mvnw -Dtest=TestClass test` from that app directory.
- Both apps use Spring Boot 4.1.2, JPA, Spring MVC, and the PostgreSQL driver. Their `application.properties` currently only sets the application name; datasource settings are not configured. The existing `contextLoads` tests therefore fail until datasource settings are supplied (or tests are changed to avoid requiring a DB).
- There is one shared local PostgreSQL database for both projects. Check `DB_SPEC.md` before connecting, changing credentials, provisioning/replacing the container, or modifying database state; record every database setup/access change there. Never delete its named data volume as routine cleanup.
- The library app's Java package is `br.edu.fatecpg.api_biblioteca` (underscore, not hyphen).
