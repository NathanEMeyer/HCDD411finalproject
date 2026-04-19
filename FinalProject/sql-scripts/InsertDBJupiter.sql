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
INSERT INTO users (username, password_hash, role_id, employee_id) VALUES
    ('admin',       '$2a$12$Pt.Z8zWLZkzS1QxFLB/pue2SdIOB3S3j1/e4mq5qlYEFiO5t3Ck0m', 1, NULL),
    ('mgr.chen',    '$2a$12$XKUVvRJbXdl7pHFHiJO4EOKECCXFXaJGfQ9EOOJ6Wd7T.Ye/UZfmy', 2, 2),
    ('a.reyes',     '$2a$12$9nFmUj8RX2PFqDlYGEi.m.bBkF7IcxX3WBr3fC5Tl2LvgHk8k6JKi', 3, 1);