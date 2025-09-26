# 📌 Task Manager API

A simple **Task Management REST API** built with **Spring Boot**, **Spring Data JPA (Hibernate)**, and **PostgreSQL**.  
This project demonstrates industry-standard layering: **Controller → Service → Repository → Database**.

---

## ✅ Features
- Create, Read, Update, Delete (CRUD) tasks
- RESTful APIs with proper HTTP status codes
- Database persistence using PostgreSQL & Hibernate
- Layered architecture (Controller, Service, Repository)
- Error handling with `ResponseEntity`

---

##  API Endpoints

### Get all tasks
- **GET** `/tasks`
    - Returns `200 OK` with list of tasks
    - Returns `204 No Content` if no tasks exist

### Get task by ID
- **GET** `/tasks/{id}`
    - Returns `200 OK` with task
    - Returns `404 Not Found` if task missing

### Create a task
- **POST** `/tasks`
    - Request body:
      ```json
      {
        "title": "Learn Spring Boot",
        "description": "Build a REST API project"
      }
      ```
    - Returns `201 Created` with saved task (including generated ID)

### Update a task
- **PUT** `/tasks/{id}`
    - Request body:
      ```json
      {
        "title": "Updated title",
        "description": "Updated description"
      }
      ```
    - Returns `200 OK` with updated task
    - Returns `404 Not Found` if task does not exist

### Delete a task
- **DELETE** `/tasks/{id}`
    - Returns `200 OK` if deleted
    - Returns `404 Not Found` if task does not exist
