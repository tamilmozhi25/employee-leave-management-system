Employee Leave Management System

A simple Spring Boot project that helps manage employees and their leave requests.

Features

1. Add, update, view, and delete employee records (CRUD)
2. Submit and manage leave requests
3. Connects with MySQL database
4. Swagger UI integration for testing APIs
5. Clean RESTful API design

Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger (OpenAPI)
- Maven

How to Run

1. Clone this repository:(bash)
   git clone https://github.com/tamilmozhi25/employee-leave-management-system.git

2. Import into IntelliJ or Eclipse

3. Configure MySQL in application.properties

4.Run the application as a Spring Boot app

5. Visit Swagger UI:  http://localhost:8081/swagger-ui/index.html

API Endpoints

Employee APIs

POST /employees – Add a new employee
(http://localhost:8081/employee)

GET /employees – Get all employees
(http://localhost:8081/employee)

GET /employees/{id} – Get employee by ID
(http://localhost:8081/employee/5)

PUT /employees/{id} – Update employee by ID
(http://localhost:8081/employee/5)

DELETE /employees/{id} – Delete employee by ID
(http://localhost:8081/employee/5)

Leave Request APIs

POST /leaves – Submit a new leave request
(http://localhost:8081/leave)

GET /leaves/Pending – Get all Pending leave requests
(http://localhost:8081/leave/pending)

GET /leaves/{id} – Get leave request by ID
(http://localhost:8081/leave/101)

PUT /leaves/{id} – Update leave request
(http://localhost:8081/leave/status/1?status=APPROVED)
