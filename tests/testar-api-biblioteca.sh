#!/usr/bin/env bash

curl -i -X POST http://localhost:8080/livros \
  -H 'Content-Type: application/json' \
  -d '{"titulo":"Dom Casmurro","autor":"Machado de Assis","isbn":"9788535914849","anoPublicacao":1899}'
# Cria um livro. Esperado: 201 e o livro com o ID gerado.
# Nos comandos abaixo, substitua /1 pelo ID retornado nesta resposta.
# Se o ISBN já estiver cadastrado, use outro valor no POST e no PUT.

curl -i http://localhost:8080/livros
# Lista todos os livros. Esperado: 200 e uma lista JSON.

curl -i http://localhost:8080/livros/1
# Busca o livro pelo ID. Esperado: 200 e os dados do livro.

curl -i -X PUT http://localhost:8080/livros/1 \
  -H 'Content-Type: application/json' \
  -d '{"titulo":"Dom Casmurro - Edição revisada","autor":"Machado de Assis","isbn":"9788535914849","anoPublicacao":1900}'
# Atualiza o livro. Esperado: 200 e os dados atualizados.

curl -i -X DELETE http://localhost:8080/livros/1
# Exclui o livro. Esperado: 204, sem corpo na resposta.
