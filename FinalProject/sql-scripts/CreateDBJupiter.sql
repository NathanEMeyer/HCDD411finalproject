-- ============================================================
-- Jupiter Company — Employee Management System
-- MySQL Schema
-- ============================================================

CREATE DATABASE IF NOT EXISTS jupiter_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE jupiter_db;

-- ------------------------------------------------------------
-- 2. EMPLOYEES
-- Core employee records with all required fields
-- SSN stored encrypted (you encrypt in Java before inserting)
-- ------------------------------------------------------------
CREATE TABLE employees (
    employee_id             INT             NOT NULL AUTO_INCREMENT,
    first_name              VARCHAR(100)    NOT NULL,
    last_name               VARCHAR(100)    NOT NULL,
    start_date              DATE            NOT NULL,
    start_salary            DECIMAL(12, 2)  NOT NULL,
    contract_signed         TINYINT(1)      NOT NULL DEFAULT 0,
    ssn_encrypted           VARCHAR(512)    NOT NULL,   -- store AES-encrypted value
    birthdate               DATE            NOT NULL,
    phone_number            VARCHAR(20)     NOT NULL,
    emergency_contact_name  VARCHAR(200)    NOT NULL,
    emergency_contact_phone VARCHAR(20)     NOT NULL,
    created_at              TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at              TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP
                                            ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (employee_id)
);

-- ------------------------------------------------------------
-- 3. USERS
-- Login accounts linked to a role and optionally an employee
-- Passwords stored as BCrypt hashes (Spring Security standard)
-- ------------------------------------------------------------
CREATE TABLE users (
    user_id     INT          NOT NULL AUTO_INCREMENT,
    username    VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,  -- BCrypt hash from Spring Security
    employee_id INT          DEFAULT NULL, -- nullable: admins may not be employees
    is_active   TINYINT(1)   NOT NULL DEFAULT 1,
    PRIMARY KEY (user_id),
    CONSTRAINT fk_users_employee
        FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
        ON DELETE SET NULL
);

CREATE TABLE roles (
    employee_user VARCHAR(50)NOT NULL UNIQUE,
    role_name VARCHAR(50)  NOT NULL,
    PRIMARY KEY (employee_user),
    FOREIGN KEY (employee_user) REFERENCES users(username)
);