# Task Manager API

A full-stack Task Management web application built with **Spring Boot**, **PostgreSQL**, and a simple **HTML/JavaScript frontend**.

This app allows users to register, log in, and manage personal tasks. All tasks are tied to the authenticated user, with support for creating, reading, updating, and deleting tasks.

---

## Features

- User Registration & Login (with hashed passwords using BCrypt)
- Task CRUD operations (Create, Read, Update, Delete)
- Each user only sees their own tasks
- PostgreSQL database integration
- RESTful API design
- Docker support for easy DB setup

---

## Technologies Used

- **Backend**: Java, Spring Boot, Spring Security, Spring Data JPA
- **Database**: PostgreSQL
- **Frontend**: HTML, Vanilla JavaScript, Fetch API
- **Other**: Docker, Lombok

---

## Getting Started

### Requirements

- Java 17+
- Maven
- Docker (optional for PostgreSQL)

---

### Setup Instructions

1. **Clone the repo**  
   ```bash
   git clone https://github.com/your-username/task-manager-api.git
   cd task-manager-api
   ```

2. **Start PostgreSQL via Docker (optional)**  
   ```bash
   docker-compose up -d
   ```

3. **Run the app**  
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the frontend**  
   Open `index.html` in your browser.

---

## API Endpoints

### Auth
- `POST /api/users/register` – Register new user
- `POST /api/users/login` – Log in user

### Tasks
- `POST /api/tasks/create/{userId}` – Create task
- `GET /api/tasks/user/{userId}` – Get tasks for a user
- `PUT /api/tasks/update` – Update a task
- `DELETE /api/tasks/delete/{taskId}` – Delete a task

