# Cadastro de Produtos

Aplicação MVC com Java 21, Spring Boot, Thymeleaf e Bootstrap 5.3, seguindo o tutorial até o nível avançado.

## Executar no Windows

```powershell
.\mvnw.cmd spring-boot:run
```

Acesse <http://localhost:8080>. Para executar os testes:

```powershell
.\mvnw.cmd test
```

## Fluxo e armazenamento

- `/cadastrar`: cadastra nome, preço, categoria e estoque. Preços negativos são rejeitados no servidor.
- `/lista`: lista os produtos e permite busca parcial por nome **ou** categoria, sem diferenciar maiúsculas de minúsculas. Uma busca vazia exibe todos os produtos.
- O botão **Remover** envia POST para `/remover/{id}` e usa o UUID do produto.
- O controller depende de `ProdutoStorageService`. A implementação padrão é `ProdutoH2StorageService` (`@Primary`), com transações e `ProdutoRepository` do Spring Data JPA.
- `ProdutoArrayStorageService` permanece disponível como implementação alternativa em memória, com a mesma interface.
- `insert` rejeita IDs existentes; `update` exige um ID existente; `upsert` insere ou atualiza. `getByUuid` retorna `Optional<Produto>`.
- `list(limit, offset)` aceita limite positivo e offset a partir de zero. Um offset além do fim retorna lista vazia.

O H2 é embarcado e **em memória**, com URL `jdbc:h2:mem:cadastro-produtos`. Não exige instalação de banco externo. O Hibernate cria o esquema ao iniciar e o remove ao encerrar (`create-drop`); **os dados são perdidos ao reiniciar a aplicação**.

## Referências

- [Spring Data JPA — consultas derivadas, Containing e IgnoreCase](https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html)
- [H2 — bancos em memória](https://h2database.com/html/features.html#in_memory_databases)
