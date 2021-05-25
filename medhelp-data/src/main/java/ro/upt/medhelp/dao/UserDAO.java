package ro.upt.medhelp.dao;

import ro.upt.medhelp.model.User;
import ro.upt.medhelp.model.UserRole;

import javax.persistence.*;

@Entity(name = "USERS")
@Table(name = "USERS")
public class UserDAO {

    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @Column(name = "isActive", columnDefinition = "boolean default false")
    private Boolean isActive = false;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private DoctorDAO doctor;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PatientDAO patient;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CaregiverDAO caregiver;

    public UserDAO() {
    }


    public UserDAO(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.userRole = user.getUserRole();
    }

    public UserDAO(String username, String firstName, String lastName, String password, String email, UserRole userRole, Boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
        this.isActive = isActive;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public DoctorDAO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDAO doctor) {
        this.doctor = doctor;
    }

    public PatientDAO getPatient() {
        return patient;
    }

    public void setPatient(PatientDAO patient) {
        this.patient = patient;
    }

    public CaregiverDAO getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(CaregiverDAO caregiver) {
        this.caregiver = caregiver;
    }
}
