# Employee Management REST API

A Spring Boot REST API for managing **Employee** details with a one-to-one relationship to **Job Details**.

## 🚀 Features
- Add, update, delete, fetch employees
- Each employee has job details (title, salary, experience)
- REST API with JSON responses
- Uses Spring Boot, JPA, Hibernate, and MySQL

## 🛠️ Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## 📌 API Endpoints
- `GET /employees` → Get all employees
- `GET /employees/{id}` → Get employee by ID
- `POST /employees` → Add new employee
- `PUT /employees/{id}` → Update employee
- `DELETE /employees/{id}` → Delete employee

## 📝 Example Request (POST)
```json
{
  "empName": "John Doe",
  "empLocation": "Pune",
  "jobDetails": {
    "jobTitle": "Software Engineer",
    "salary": 75000.00,
    "experience": 3
  }
}
