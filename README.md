# Academic Management API

A RESTful backend application built with **Java 17 and Spring Boot** for managing students, courses, and enrollments.

This project was developed as a practical exercise to apply backend development concepts, with emphasis on **REST APIs, layered architecture, data persistence, validation, DTOs, exception handling, and separation of responsibilities**.

Rather than focusing only on CRUD operations, the project demonstrates the backend foundations used to build more complex applications.

---

## What This Project Demonstrates

This project demonstrates practical knowledge of:

- REST API development
- Layered architecture
- Separation of responsibilities
- Service-layer business logic
- Repository pattern
- DTOs
- Data validation
- Exception handling
- JPA and Hibernate
- Spring Data JPA
- Relational data persistence
- API design
- Maven project management
- Object-oriented programming

These foundations can be applied to systems involving users, products, orders, financial records, logistics, and other domains where structured backend processing is required.

---

## Architecture

The application follows a layered architecture where each component has a defined responsibility.

```text
                    HTTP Request
                         |
                         v
              +----------------------+
              |      Controller      |
              |    REST API Layer     |
              +----------+-----------+
                         |
                         v
              +----------------------+
              |       Service        |
              |   Business Logic     |
              +----------+-----------+
                         |
                         v
              +----------------------+
              |      Repository      |
              |   Data Access Layer  |
              +----------+-----------+
                         |
                         v
              +----------------------+
              |    JPA / Hibernate   |
              +----------+-----------+
                         |
                         v
              +----------------------+
              |         H2           |
              |     Database         |
              +----------------------+
```

DTOs, validation, and exception handling support the application across these layers without mixing unrelated responsibilities.

---

## Architectural Goals

The main objective of the architecture is to keep responsibilities separated.

| Component | Responsibility |
|-----------|----------------|
| Controller | Handles HTTP requests and responses |
| DTO | Defines data exchanged through the API |
| Validation | Ensures incoming data follows defined rules |
| Service | Contains and coordinates application logic |
| Repository | Handles persistence operations |
| JPA / Hibernate | Maps Java objects to database records |
| Exception Layer | Handles application errors consistently |

This separation makes the code easier to understand, maintain, test, and evolve.

---

## Domain

The application works with an academic domain composed primarily of:

- Students
- Courses
- Enrollments

The API provides operations for managing these entities and their relationships.

This domain was intentionally chosen as a practical environment for applying backend concepts rather than as a production academic management product.

---

## API Capabilities

The application provides REST endpoints for operations such as:

- Creating students
- Retrieving students
- Updating students
- Removing students
- Creating courses
- Retrieving courses
- Updating courses
- Removing courses
- Managing enrollments

The API uses HTTP methods according to their intended REST semantics.

```text
POST    -> Create
GET     -> Retrieve
PUT     -> Update
DELETE  -> Remove
```

---

## DTOs

Data Transfer Objects are used to separate the API representation from the persistence models.

Instead of exposing domain entities directly through every endpoint, DTOs define the information expected by the API.

This approach helps:

- Control exposed data
- Separate API contracts from persistence models
- Apply validation rules
- Reduce coupling between layers
- Make future API changes easier

---

## Validation

The application uses **Jakarta Bean Validation** to validate incoming data.

Validation is performed at the API boundary before invalid information reaches the application logic.

This provides a clear separation between:

```text
HTTP Input
    |
    v
Validation
    |
    v
Application Logic
    |
    v
Persistence
```

---

## Exception Handling

The project includes dedicated exception handling to prevent application errors from being mixed directly with controller logic.

This allows the API to provide appropriate responses when operations cannot be completed.

Examples include situations such as:

- Requested resource not found
- Invalid input
- Invalid operation
- Domain-related errors

Keeping exception handling separated improves readability and makes the API behavior easier to maintain.

---

## Data Persistence

The persistence layer uses:

- Spring Data JPA
- JPA
- Hibernate
- H2 Database

Repositories encapsulate database operations, preventing persistence details from being directly coupled to controllers or application logic.

The persistence technology can also be replaced or adapted for other relational databases with limited impact on the rest of the application.

---

## Project Structure

The backend is organized around application responsibilities.

```text
CadEscolar/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── MeusCodigos/
│   │   │       └── CadEscolar/
│   │   │           ├── Config/
│   │   │           ├── Exception/
│   │   │           ├── Repository/
│   │   │           ├── Rest/
│   │   │           │   ├── Controller/
│   │   │           │   └── DTO/
│   │   │           ├── Service/
│   │   │           └── domain/
│   │   │               ├── Enums/
│   │   │               └── Model/
│   │   │
│   │   └── resources/
│   │
│   └── test/
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

The structure separates HTTP concerns, application logic, persistence, domain models, configuration, and error handling.

---

## Technology Stack

### Language

- Java 17

### Backend

- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate

### Persistence

- H2 Database
- JPA

### API

- REST
- DTOs
- Jakarta Bean Validation
- OpenAPI / Swagger

### Development

- Maven
- Lombok
- ModelMapper
- Spring Boot DevTools

---

## What These Foundations Enable

The concepts applied in this project form the foundation for more complex backend systems.

With the same architectural principles, the application can evolve to support features such as:

- Authentication and authorization
- More complex business rules
- Transaction management
- External API integrations
- Background processing
- Different database technologies
- Automated testing
- Logging and monitoring
- Asynchronous communication
- Distributed services
- Production deployment

The important aspect is not the academic domain itself, but the ability to apply these backend principles to different problems.

---

## Project Context

This project was created as a practical environment for applying backend development concepts with Java and Spring Boot.

The main objective was to move beyond isolated programming exercises and practice building a complete REST backend with:

- Defined application layers
- Persistent data
- API contracts
- Validation
- Error handling
- Object-relational mapping
- Separation of responsibilities

It represents an earlier stage of my backend development journey and serves as a foundation for more complex projects.

---

## Running the Project

Clone the repository:

```bash
git clone https://github.com/Offhugo/api-cadastro-alunos.git
```

Navigate to the backend:

```bash
cd api-cadastro-alunos/BackEnd/CadEscolar
```

Run with Maven Wrapper:

### Linux / macOS

```bash
./mvnw spring-boot:run
```

### Windows

```bash
mvnw.cmd spring-boot:run
```

---

## API Documentation

The project includes API documentation through **OpenAPI / Swagger**, allowing the available endpoints and request structures to be explored directly through the application.

---

## Author

**Hugo Mendes**

Backend Developer focused on **Java/Spring Boot and Python/FastAPI**, with interests in backend architecture, APIs, databases, automated testing, integrations, and software engineering.

GitHub: https://github.com/Offhugo
