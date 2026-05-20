# University System - Student Service

A Spring Boot microservice for managing student information in the University System project.

## Features

- Create new students
- Retrieve all students
- RESTful API architecture
- Layered architecture (Controller → Service → Repository)
- H2 in-memory database
- Swagger/OpenAPI documentation
- Spring Data JPA integration
- Validation support

---

## Technologies Used

- Java 21
- Spring Boot 3.3.5
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok
- Swagger/OpenAPI
- Gradle

---

## Project Structure

```text
student-service
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── az.edu.ada.wm2.studentservice
│   │   │       ├── controller
│   │   │       │   └── StudentController.java
│   │   │       ├── model
│   │   │       │   └── Student.java
│   │   │       ├── repository
│   │   │       │   └── StudentRepository.java
│   │   │       ├── service
│   │   │       │   └── StudentService.java
│   │   │       └── StudentServiceApplication.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│
├── build.gradle
├── settings.gradle
└── README.md
```

---

## Architecture

```text
Controller → Service → Repository → Database
```

### Controller Layer
Handles HTTP requests and responses.

### Service Layer
Contains business logic.

### Repository Layer
Handles database operations using Spring Data JPA.

### Database Layer
Uses H2 in-memory database for data storage.

---

## Getting Started

### Prerequisites

Install the following before running the project:

- Java 21
- IntelliJ IDEA (recommended)
- Gradle

---

## Clone Repository

```bash
git clone https://github.com/nebiyev321/lab8-nebiyev321.git
```

---

## Navigate to Project

```bash
cd university-system/student-service
```

---

## Run Application

Using Gradle:

```bash
./gradlew bootRun
```

Or run `StudentServiceApplication.java` directly from IntelliJ IDEA.

---

## Application URL

```text
http://localhost:8081
```

---

## Swagger Documentation

Swagger UI:

```text
http://localhost:8081/swagger-ui/index.html
```

---

## H2 Database Console

H2 Console:

```text
http://localhost:8081/h2-console
```

### H2 Configuration

| Property | Value |
|----------|-------|
| JDBC URL | jdbc:h2:mem:testdb |
| Username | sa |
| Password | leave empty |

---

## API Endpoints

### Get All Students

#### Request

```http
GET /students
```

#### Response Example

```json
[
  {
    "id": 1,
    "firstName": "Vidadi",
    "lastName": "Nabiyev",
    "email": "vidadi@example.com"
  }
]
```

---

### Create Student

#### Request

```http
POST /students
```

#### Request Body

```json
{
  "firstName": "Vidadi",
  "lastName": "Nabiyev",
  "email": "vidadi@example.com"
}
```

#### Response Example

```json
{
  "id": 1,
  "firstName": "Vidadi",
  "lastName": "Nabiyev",
  "email": "vidadi@example.com"
}
```

---

## application.properties

```properties
spring.application.name=student-service

server.port=8081

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

---

## Main Dependencies

```gradle
implementation 'org.springframework.boot:spring-boot-starter-web'
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
implementation 'org.springframework.boot:spring-boot-starter-validation'

runtimeOnly 'com.h2database:h2'

compileOnly 'org.projectlombok:lombok'
annotationProcessor 'org.projectlombok:lombok'

implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0'
```

---

## Future Improvements

- Add update and delete endpoints
- Implement DTOs
- Add exception handling
- Add unit tests
- PostgreSQL integration
- Docker support
- Authentication and authorization

---

## Author

**Vidadi Nabiyev**  
ADA University  
IT Student

---

## License

This project was developed for educational purposes.