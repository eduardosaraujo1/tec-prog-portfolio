#!/usr/bin/env bash

# Execute os comandos individualmente, com a API em execução.
# Nas URLs abaixo, substitua 1 pelo ID retornado na criação.

curl -i -X POST http://localhost:8080/tarefas \
    -H 'Content-Type: application/json' \
    -d '{"descricao":"Estudar Spring Boot","concluida":false,"prioridade":3}'
# Cria uma tarefa. Esperado: 201 Created e o JSON com o ID gerado.

curl -i http://localhost:8080/tarefas
# Lista todas as tarefas. Esperado: 200 OK e uma lista JSON.

curl -i http://localhost:8080/tarefas/1
# Busca a tarefa pelo ID. Esperado: 200 OK e o JSON da tarefa.

curl -i -X PUT http://localhost:8080/tarefas/1 \
    -H 'Content-Type: application/json' \
    -d '{"descricao":"Estudar Spring Boot e testar a API","concluida":true,"prioridade":5}'
# Atualiza a tarefa e marca como concluída. Esperado: 200 OK e o JSON atualizado.

curl -i http://localhost:8080/tarefas/1
# Consulta novamente para conferir os dados atualizados. Esperado: 200 OK.

curl -i -X DELETE http://localhost:8080/tarefas/1
# Exclui a tarefa criada. Esperado: 204 No Content, sem corpo.

curl -i http://localhost:8080/tarefas/1
# Confirma a exclusão. Esperado: 404 Not Found.
