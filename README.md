# RESTful Product Catalogue API

This project is a simple Spring Boot lab assignment that builds a RESTful Product Catalogue API. It lets users create, read, update, and delete products using a clean layered structure.

## Technologies Used

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 Database
- Swagger / OpenAPI
- MockMvc Tests

## How to Run

On Linux or macOS:

```bash
./mvnw spring-boot:run
```

On Windows:

```powershell
mvnw.cmd spring-boot:run
```

## How to Run Tests

On Linux or macOS:

```bash
./mvnw test
```

On Windows:

```powershell
mvnw.cmd test
```

## Swagger UI

`http://localhost:8080/swagger-ui.html`

## H2 Console

`http://localhost:8080/h2-console`

## Endpoint Summary

| Method | Endpoint | Description |
| --- | --- | --- |
| GET | `/api/v1/products` | Get all products |
| GET | `/api/v1/products/{id}` | Get one product by id |
| POST | `/api/v1/products` | Create a new product |
| PUT | `/api/v1/products/{id}` | Update an existing product |
| DELETE | `/api/v1/products/{id}` | Delete a product |

## Project Structure

- `com.ctbe.productservice` - main application class
- `com.ctbe.productservice.controller` - REST controller
- `com.ctbe.productservice.dto` - request and response DTOs
- `com.ctbe.productservice.exception` - custom exception and global handler
- `com.ctbe.productservice.model` - JPA entity classes
- `com.ctbe.productservice.repository` - data access layer
- `com.ctbe.productservice.service` - business logic layer
