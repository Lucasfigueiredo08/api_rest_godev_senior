# Teste GoDev - Senior Sistemas

Tecnologias Utilizadas
* JPA
* Spring Boot
* PostgreSQL
* IDE Intellij
* Client HTTP Insomnia
* Java 8


## Endpoints
### CRUD Item
Para `CADASTRAR` um item no banco de dados:
`POST` http://localhost:8080/api/items
{
description: string,
value: double,
type: char 
}

Para `BUSCAR` todos os itens no banco de dados:
`GET` http://localhost:8080/api/items 

Para `BUSCAR` um item no banco de dados pelo ID:
`GET` http://localhost:8080/api/items/{id}

Para `DELETAR`  um item no banco de dados pelo ID:
`DELETE`http://localhost:8080/api/items/{id}

Para `ATUALIZAR`  um item no banco de dados pelo ID:
`PUT`http://localhost:8080/api/items/{id}
{
description: string,
value: double,
type: char
}

### CRUD Pedido
Para `CADASTRAR` um pedido no banco de dados:
`POST` http://localhost:8080/api/orders
{
number: integer,
date: timestamp,
percentualDiscount: double
}

Para `BUSCAR` todos os pedidos no banco de dados:
`GET` http://localhost:8080/api/orders

Para `BUSCAR` um pedido no banco de dados pelo ID:
`GET` http://localhost:8080/api/orders/{id}

Para `DELETAR`  um pedido no banco de dados pelo ID:
`DELETE`http://localhost:8080/api/orders/{id}

Para `ATUALIZAR`  um pedido no banco de dados pelo ID:
`PUT`http://localhost:8080/api/orders/{id}
{
number: integer,
date: timestamp,
percentualDiscount: double,
totalValue: double
}

Para `CONCLUIR`um pedido no banco de dados pelo ID:
`POST` http://localhost:8080/api/orders/{id}/close
{
order: UUID, // id do pedido
percentualDiscount: double
}






