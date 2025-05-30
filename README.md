# api-cadastro-alunos
API REST que realiza algumas operações básicas para gerenciamento de alunos e cursos

## Tecnologias utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Web
- Bean Validation (Jakarta)
- Banco H2
- Swagger OpenAPI
- Lombok
- ModelMapper
- Maven

## Estrutura do projeto

- Controller
- Service
- Dto
- Model
- Repository
- Config
- Exception
- application.properties
- README.md

## Funcionalidades

- CRUD completo das entidades principais
- Realionamento entre entidades
- Validações com Jakarta Bean Validation
- Documentação com Swagger
- Tratamento de exceções

## Endpoints principais

GET /alunos/all - lista todos os alunos
POST /cursos - Salva um novo curso
POST /matricula - Matricula um aluno em um curso
GET /alunos/buscarNome - Retorna um aluno pelo nome

## Documentação da API em:

http://localhost:8080/swagger-ui.html

## Aprendizados

- Durante o desenvolvimento deste projeto, aprofundei meus conhecimentos em:

- Arquitetura de camadas com Spring Boot

- Boas práticas RESTful

- Validação de dados e controle de exceções

- Uso de DTOs e ModelMapper para separar domínio de transporte

- Swagger para documentação de APIs

- Uso do Maven e configuração de dependências

## Como rodar o projeto

# Clone o repositório
git clone https://github.com/Offhugo/api-cadastro-alunos

# Acesse o diretório
cd seu-repositorio

# Rode a aplicação (Linux/macOS)
./mvnw spring-boot:run

# ou (Windows)
mvnw spring-boot:run


