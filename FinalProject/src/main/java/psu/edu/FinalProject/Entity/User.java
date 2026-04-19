package psu.edu.FinalProject.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "username", nullable = false, unique = true, length = 100)
    private String username;

    // BCrypt hash — never store plaintext
    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    // --- Constructors ---

    public User() {}

    public User(String username, String passwordHash, Role role, Employee employee) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
        this.employee = employee;
    }

    // --- Getters and Setters ---

    public Integer getUserId()                    { return userId; }
    public void setUserId(Integer userId)         { this.userId = userId; }

    public String getUsername()                   { return username; }
    public void setUsername(String username)      { this.username = username; }

    public String getPasswordHash()               { return passwordHash; }
    public void setPasswordHash(String passwordHash)      { this.passwordHash = passwordHash; }

    public Role getRole()                         { return role; }
    public void setRole(Role role)                { this.role = role; }

    public Employee getEmployee()                 { return employee; }
    public void setEmployee(Employee employee)    { this.employee = employee; }

    public Boolean getIsActive()                  { return isActive; }
    public void setIsActive(Boolean isActive)     { this.isActive = isActive; }
}