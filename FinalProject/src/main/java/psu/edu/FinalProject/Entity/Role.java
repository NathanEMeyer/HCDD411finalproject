package psu.edu.FinalProject.Entity;

import jakarta.persistence.*;
import java.util.List;

import org.springframework.security.core.userdetails.User;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_name", nullable = false, unique = true, length = 50)
    private String roleName;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> users;

    // --- Constructors ---

    public Role() {}

    public Role(String roleName) {
        this.roleName = roleName;
    }

    // --- Getters and Setters ---

    public Integer getRoleId()             { return roleId; }
    public void setRoleId(Integer roleId)  { this.roleId = roleId; }

    public String getRoleName()            { return roleName; }
    public void setRoleName(String name)   { this.roleName = name; }

    public List<User> getUsers()           { return users; }
    public void setUsers(List<User> users) { this.users = users; }
}