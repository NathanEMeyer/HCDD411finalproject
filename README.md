# Employee Management System - HCDD411 Final Project

A Spring Boot-based web application for managing employee information with user authentication and role-based access control.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Technologies](#technologies)
- [Setup & Installation](#setup--installation)
- [Running the Application](#running-the-application)
- [Database Configuration](#database-configuration)
- [API Endpoints](#api-endpoints)

## 📖 Overview

This application provides a comprehensive solution for employee management with secure login functionality and role-based authorization. Users can view and manage employee information through an intuitive web interface.

## ✨ Features

- **User Authentication**: Secure login system with password management
- **Role-Based Access Control**: Different permissions based on user roles
- **Employee Management**: Create, read, update, and manage employee records
- **Responsive UI**: HTML-based interface with Bootstrap styling
- **Database Integration**: MySQL database for persistent data storage

## 🔧 Prerequisites

- Java 11 or higher
- Maven 3.6+
- MySQL 5.7+
- Git (for cloning the repository)

## 📁 Project Structure

```
FinalProject/
├── src/
│   ├── main/
│   │   ├── java/psu/edu/FinalProject/
│   │   │   ├── Controller/          # REST controllers
│   │   │   ├── Service/             # Business logic layer
│   │   │   ├── DAO/                 # Data access objects
│   │   │   ├── Entity/              # Entity models
│   │   │   └── security/            # Security configuration
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── login-page.html
│   │       ├── employee-form.html
│   │       └── jupiter-homepage.html
│   └── test/                        # Unit tests
├── sql-scripts/                     # Database initialization
│   ├── CreateDBJupiter.sql
│   └── InsertDBJupiter.sql
└── pom.xml                          # Maven configuration
```

## 🛠 Technologies

- **Backend**: Spring Boot, Spring MVC, Spring Security
- **Database**: MySQL with JPA/Hibernate ORM
- **Frontend**: HTML, CSS, Thymeleaf
- **Build Tool**: Maven
- **Testing**: JUnit

## ⚙️ Setup & Installation

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd HCDD411finalproject/FinalProject
   ```

2. **Create MySQL Database**:
   ```bash
   mysql -u root -p < sql-scripts/CreateDBJupiter.sql
   mysql -u root -p < sql-scripts/InsertDBJupiter.sql
   ```

3. **Configure Database Connection**:
   Update `src/main/resources/application.properties` with your MySQL credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/jupiter
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

4. **Build the Project**:
   ```bash
   mvn clean install
   ```

## 🚀 Running the Application

### Using Maven:
```bash
mvn spring-boot:run
```

### Using Java directly:
```bash
java -jar target/FinalProject-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080`

### Accessing the Application:
- **Login Page**: `http://localhost:8080/login`
- **Homepage**: `http://localhost:8080/`

## 🗄️ Database Configuration

The application uses MySQL with the following schema:

- **CreateDBJupiter.sql**: Sets up database tables and schema
- **InsertDBJupiter.sql**: Populates initial test data

Ensure MySQL is running and accessible before starting the application.

## 🔌 API Endpoints

### Employee Management
- `GET /employees` - Retrieve all employees
- `GET /employees/{id}` - Get employee by ID
- `POST /employees` - Create new employee
- `PUT /employees/{id}` - Update employee
- `DELETE /employees/{id}` - Delete employee

### Authentication
- `GET /login` - Login page
- `POST /login` - Process login
- `GET /logout` - Logout user

## 📝 Notes

- Login credentials and user roles are managed in the database
- All endpoints (except login) require authentication
- The application implements Spring Security for role-based access control

---

For more information, see [HELP.md](FinalProject/HELP.md)
