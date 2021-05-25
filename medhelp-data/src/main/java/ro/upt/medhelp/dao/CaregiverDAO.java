package ro.upt.medhelp.dao;

import ro.upt.medhelp.model.Caregiver;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "CAREGIVERS")
@Table(name = "CAREGIVERS")
public class CaregiverDAO {

    @Id
    @Column(name = "caregiverId")
    private Long caregiverId;
    @Column(name = "phone", unique = true)
    private String phone;
    @Column(name = "birthDate")
    private LocalDate birthDate;
    @Column(name = "age")
    private Integer age;
    @Column(name = "address")
    private String address;
    @Column(name = "available")
    private Boolean available = false;
    @OneToOne
    @MapsId
    private UserDAO user;
    @OneToMany(
            mappedBy = "caregiver",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PatientDAO> patients = new ArrayList<>();

    public List<PatientDAO> getPatients() {
        return patients;
    }

    public void setPatients(List<PatientDAO> patients) {
        this.patients = patients;
    }

    public CaregiverDAO() {

    }

    public CaregiverDAO(String phone, LocalDate birthDate, Integer age, String address, Boolean available) {
        this.phone = phone;
        this.birthDate = birthDate;
        this.age = age;
        this.address = address;
        this.available = available;
    }

    public CaregiverDAO(Caregiver caregiver) {
        this.phone = caregiver.getPhone();
        this.birthDate = caregiver.getBirthDate();
        this.age = caregiver.getAge();
        this.address = caregiver.getAddress();
    }

    public void castCaregiverModel(Caregiver caregiver) {
        this.phone = caregiver.getPhone();
        this.birthDate = caregiver.getBirthDate();
        this.age = caregiver.getAge();
        this.address = caregiver.getAddress();
        this.available = caregiver.getAvailable();
    }

    public Long getCaregiverId() {
        return caregiverId;
    }

    public void setCaregiverId(Long caregiverId) {
        this.caregiverId = caregiverId;
    }

    public UserDAO getUsers() {
        return user;
    }

    public void setUsers(UserDAO user) {
        this.user = user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
