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

These foundations can be applied to systems involving users, products, orders, financial records, logistics, authentication, and other domains where structured backend processing is required.

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
