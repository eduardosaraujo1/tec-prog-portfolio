# Instruções do repositório

- Antes de alterar arquivos, confirme com o desenvolvedor por meio de pergunta clarificadora; não presuma requisitos.
- Para arquitetura e práticas, consulte `Aula - Cadastro de Produtos com Thymeleaf.pdf` na raiz. Siga MVC e use POJOs como no material; a exceção de versão é Java 21, configurado no `pom.xml`.
- Em templates Thymeleaf, use Bootstrap 5.3 (prevalece sobre o Bootstrap 4.6 do PDF) e prefira Atomic CSS.
- Ao concluir cada tarefa, crie um commit com mensagem que descreva as alterações.

## Projeto e comandos

- Aplicação Spring Boot 4.1.2; código Java no pacote-base `br.edu.fatecpg.cadastro_produtos` e classe de entrada `CadastroProdutosApplication`.
- Use o Maven Wrapper: `mvnw.cmd test` para os testes e `mvnw.cmd spring-boot:run` para executar no Windows.
- Atualmente o `pom.xml` inclui apenas `spring-boot-starter` e `spring-boot-starter-test`; Web e Thymeleaf ainda não estão configurados.
