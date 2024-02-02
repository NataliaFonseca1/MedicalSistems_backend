## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- [Java](https://www.oracle.com/java/technologies/javase-downloads.html): Versão 8 ou superior.
- [Maven](https://maven.apache.org/download.cgi): Ferramenta de gerenciamento de build e dependências para Java.

## Clonando o Repositório

https://github.com/NataliaFonseca1/MedicalSistems_backend.git
cd seu-projeto

## Construir e Executar o projeto: 


mvn clean install 
java -jar target/nome-do-arquivo-jar.jar


obs: substituir "seu-projeto-0.0.1-SNAPSHOT.jar" pelo nome real do arquivo JAR gerado durante a construção do projeto.


## Linguagens, Frameworks e bibliotecas:

Java

Spring Boot

Spring JPA

Bouncycastle

## Banco de Dados 

PostgreSQL

##Configuração Banco de Dados: 

No arquivo application.properties (ou application.yml), configure o banco de dados:

spring.datasource.url=jdbc:postgresql://localhost:5432/clinica
spring.datasource.username=admin
spring.datasource.password=admin
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update

## Comandos SQL para a criação do Banco de Dados:

CREATE DATABASE clinica; 
CREATE USER admin 
WITH PASSWORD 'admin';

## pgAdmin

Instalação do pgAdmin para manipularção do PostgreSQL localmente:
pgAdmin Download.
