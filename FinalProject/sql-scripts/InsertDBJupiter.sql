-- Sample employee records

INSERT INTO employees (
    first_name, last_name, start_date, start_salary,
    contract_signed, ssn_encrypted, birthdate,
    phone_number, emergency_contact_name, emergency_contact_phone
) VALUES
    ('Alice',   'Reyes',   '2022-03-15', 58000.00, 1, 'ENCRYPTED_SSN_1', '1990-06-20', '555-0101', 'Bob Reyes',    '555-0102'),
    ('Marcus',  'Chen',    '2021-07-01', 72000.00, 1, 'ENCRYPTED_SSN_2', '1985-11-03', '555-0201', 'Linda Chen',   '555-0202'),
    ('Priya',   'Sharma',  '2023-01-10', 65000.00, 1, 'ENCRYPTED_SSN_3', '1993-04-17', '555-0301', 'Raj Sharma',   '555-0302');

-- User accounts (passwords: admin123 / manager123 / emp123)
INSERT INTO users (username, password_hash, employee_id) VALUES
    ('admin',       '{bcrypt}$2a$10$/V4RHi1TyxTQTuPU7VQvXuzG622ZUBVnMedFXBbgHo53X9Hen0hAO', NULL),
    ('mgr.chen',    '{bcrypt}$2a$10$VUjrs8ZxTJTcQFmGQaNyuuAItYNrx.VlUVgfn2vozjgM/VPN.wIDq', 2),
    ('a.reyes',     '{bcrypt}$2a$10$Idceh9bq4w0AUWVmGdESLOWKHbnDClC6BRPXEzxzAXzLp6hYYL0Sq', 1);

INSERT INTO roles(employee_user, role_name) VALUES
    ('admin','ROLE_ADMIN'),
    ('mgr.chen','ROLE_MANAGER'),
    ('a.reyes','ROLE_EMPLOYEE');