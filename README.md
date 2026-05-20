# University System Microservices

A Spring Boot microservices-based University System project built with Java 21, Spring Boot, OpenFeign, H2 Database, and REST APIs.

---

# Technologies Used

| Technology | Version |
|------------|---------|
| Java | 21 |
| Spring Boot | 3.3.5 |
| Spring Data JPA | 3 |
| Spring Web | 6 |
| Spring Validation | Latest |
| OpenFeign | Latest |
| H2 Database | Latest |
| Swagger/OpenAPI | 2.6.0 |
| Gradle | Latest |

---

# Project Structure

```text
university-system
│
├── student-service
│   │
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── az.edu.ada.wm2.studentservice
│   │   │   │       ├── controller
│   │   │   │       │   └── StudentController.java
│   │   │   │       ├── dto
│   │   │   │       │   └── StudentDto.java
│   │   │   │       ├── model
│   │   │   │       │   └── Student.java
│   │   │   │       ├── repository
│   │   │   │       │   └── StudentRepository.java
│   │   │   │       ├── service
│   │   │   │       │   └── StudentService.java
│   │   │   │       └── StudentServiceApplication.java
│   │   │   │
│   │   │   └── resources
│   │   │       └── application.properties
│   │   │
│   │   └── test
│   │
│   ├── build.gradle
│   └── README.md
│
├── course-service
│   │
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── az.edu.ada.wm2.courseservice
│   │   │   │       ├── client
│   │   │   │       │   └── StudentClient.java
│   │   │   │       ├── controller
│   │   │   │       │   └── CourseController.java
│   │   │   │       ├── dto
│   │   │   │       │   ├── CourseDto.java
│   │   │   │       │   └── StudentDto.java
│   │   │   │       ├── model
│   │   │   │       │   └── Course.java
│   │   │   │       ├── repository
│   │   │   │       │   └── CourseRepository.java
│   │   │   │       ├── service
│   │   │   │       │   └── CourseService.java
│   │   │   │       └── CourseServiceApplication.java
│   │   │   │
│   │   │   └── resources
│   │   │       └── application.properties
│   │   │
│   │   └── test
│   │
│   ├── build.gradle
│   └── README.md
│
├── build.gradle
├── settings.gradle
└── README.md
```

---

# Student Service

Runs on:

```text
http://localhost:9090
```

Swagger UI:

```text
http://localhost:9090/swagger-ui.html
```

## Features

- Create student
- Get all students
- Get student by ID
- Update student
- Delete student
- Search student by name

---

# Course Service

Runs on:

```text
http://localhost:8081
```

Swagger UI:

```text
http://localhost:8081/swagger-ui.html
```

## Features

- Create course
- Get all courses
- Get course by ID
- Update course
- Delete course
- Enroll students into courses
- Get students in a course
- Inter-service communication using OpenFeign

---

# H2 Database Console

## Student Service

```text
http://localhost:9090/h2-console
```

## Course Service

```text
http://localhost:8081/h2-console
```

### H2 Login Credentials

```text
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password:
```

---

# Running the Project

## Clone Repository

```bash
git clone https://github.com/SITE-ADA/lab8-nebiyev321.git
cd university-system
```

---

# Build Project

```bash
gradlew clean build
```

---

# Run Student Service

```bash
gradlew :student-service:bootRun
```

---

# Run Course Service

```bash
gradlew :course-service:bootRun
```

---

# API Testing

Use Swagger UI or Postman.

---

# Example Student Request

```json
{
  "name": "Vidadi Nabiyev",
  "email": "vidadi@example.com",
  "age": 21
}
```

---

# Example Course Request

```json
{
  "title": "Cyber Security",
  "code": "CS301",
  "credits": 6,
  "prerequisiteCourseId": 0
}
```

---

# Enrollment Endpoint

```http
POST /api/v1/courses/{courseId}/students/{studentId}
```

Example:

```text
POST /api/v1/courses/1/students/1
```

---

# Author

Vidadi Nabiyev

ADA University  
IT Student

---

## License

This project was developed for educational purposes.
