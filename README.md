Bienvenido a mi primera aplicacion  Dashboard 

# Task Manager API

REST API for task management built with Spring Boot. 
Supports full CRUD operations, priority levels, and JWT authentication.

Will be update with new features  like : Edit, list of task already done  and user info.

## 🚀 Tech Stack

- Java 17
- Spring Boot 3
- Spring Security + JWT
- Spring Data JPA / Hibernate
- H2 Database (dev) / PostgreSQL (prod)
- JUnit 5 + Mockito
- Maven

## 📋 Features

- ✅ Create, read, update and delete tasks
- ✅ Filter tasks by status and priority
- ✅ Mark tasks as complete
- ✅ JWT Authentication (register & login)
- ✅ Kanban dashboard UI

## 🛠 Getting Started

### Prerequisites
- Java 17+
- Maven

### Run locally
git clone https://github.com/EricCortez/Task-Manager.git
cd Task-Manager
./mvnw spring-boot:run

API will be available at http://localhost:8080

## 📡 API Endpoints

### Auth
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/auth/register | Register new user |
| POST | /api/auth/login | Login & get JWT token |

### Tasks
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/tasks | Get all tasks |
| POST | /api/tasks | Create task |
| PUT | /api/tasks/{id} | Update task |
| DELETE | /api/tasks/{id} | Delete task |
| PATCH | /api/tasks/{id}/complete | Mark as complete |
| GET | /api/tasks/filter?completed= | Filter by status |

## 🧪 Running Tests
./mvnw test

## 📸 Screenshots
<img width="1235" height="629" alt="image" src="https://github.com/user-attachments/assets/5da9045c-5121-40de-b28d-e027aaeb549b" />
