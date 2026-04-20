package psu.edu.FinalProject.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "start_salary")
    private BigDecimal startSalary;

    @Column(name = "contract_signed")
    private Boolean contractSigned = false;

    // Stored AES-encrypted — encrypt/decrypt in the service layer
    @Column(name = "ssn_encrypted")
    private String ssnEncrypted;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "emergency_contact_name")
    private String emergencyContactName;

    @Column(name = "emergency_contact_phone")
    private String emergencyContactPhone;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;



    // --- Constructors ---

    public Employee() {}

    public Employee(String firstName, String lastName, LocalDate startDate,
                    BigDecimal startSalary, Boolean contractSigned, String ssnEncrypted,
                    LocalDate birthdate, String phoneNumber,
                    String emergencyContactName, String emergencyContactPhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.startSalary = startSalary;
        this.contractSigned = contractSigned;
        this.ssnEncrypted = ssnEncrypted;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
    }

    // --- Getters and Setters ---

    public Integer getEmployeeId()                        { return employeeId; }
    public void setEmployeeId(Integer employeeId)         { this.employeeId = employeeId; }

    public String getFirstName()                          { return firstName; }
    public void setFirstName(String firstName)            { this.firstName = firstName; }

    public String getLastName()                           { return lastName; }
    public void setLastName(String lastName)              { this.lastName = lastName; }

    public LocalDate getStartDate()                       { return startDate; }
    public void setStartDate(LocalDate startDate)         { this.startDate = startDate; }

    public BigDecimal getStartSalary()                    { return startSalary; }
    public void setStartSalary(BigDecimal startSalary)    { this.startSalary = startSalary; }

    public Boolean getContractSigned()                    { return contractSigned; }
    public void setContractSigned(Boolean contractSigned) { this.contractSigned = contractSigned; }

    public String getSsnEncrypted()                       { return ssnEncrypted; }
    public void setSsnEncrypted(String ssnEncrypted)      { this.ssnEncrypted = ssnEncrypted; }

    public LocalDate getBirthdate()                       { return birthdate; }
    public void setBirthdate(LocalDate birthdate)         { this.birthdate = birthdate; }

    public String getPhoneNumber()                        { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber)        { this.phoneNumber = phoneNumber; }

    public String getEmergencyContactName()               { return emergencyContactName; }
    public void setEmergencyContactName(String emergencyContactName)         { this.emergencyContactName = emergencyContactName; }

    public String getEmergencyContactPhone()              { return emergencyContactPhone; }
    public void setEmergencyContactPhone(String emergencyContactPhone)        { this.emergencyContactPhone = emergencyContactPhone; }

    public LocalDateTime getCreatedAt()                   { return createdAt; }
    public LocalDateTime getUpdatedAt()                   { return updatedAt; }
}
