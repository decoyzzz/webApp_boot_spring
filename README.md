# Task Manager API

A simple REST API application for managing tasks using Spring Boot.  
Data is stored in a JSON file.

---

## Features

- Get the list of all tasks (`GET /tasks`)
- Add a new task (`POST /tasks`)
- Toggle task status (done/undone) (`PUT /tasks/{id}`)
- Delete a task (`DELETE /tasks/{id}`)

---

## Technologies

- Java 21  
- Spring Boot 3.5.3  
- JSON as a simple data storage (file `tasks.json`)

---

# How to run

1. Clone the repository from https://github.com/decoyzzz/TODO_List_webApp_backend.git

2. Open the project directory
./webApp_boot_spring/mywebapp

3. Run the application
./mvnw spring-boot:run

4. The API will be avaliable at http://localhost:8080/tasks