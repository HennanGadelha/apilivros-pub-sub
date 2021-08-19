## Micronaut 2.5.11 Documentation

- [User Guide](https://docs.micronaut.io/2.5.11/guide/index.html)
- [API Reference](https://docs.micronaut.io/2.5.11/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/2.5.11/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---



## Seguir os comandos realizados ##

## Criando container com imagem do nats

docker run -d --name nats-main -p 4222:4222 -p 6222:6222 -p 8222:8222 nats

## Criando container docker com imagem do scylla

- docker run --name apilivros -p 9042:9042 --hostname apilivros -d scylladb/scylla

## Entrando no shell cql do container criado (aguardar 90s para realizar comando)

- docker exec -it apilivros cqlsh

## Criando keyspace

- CREATE KEYSPACE livrosdb WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 3};

## Usando keyspace

- use livrosdb;

## Criando tabela no keyspace 

- CREATE TABLE livro ( id uuid, titulo text, editora text, PRIMARY KEY((id)));

