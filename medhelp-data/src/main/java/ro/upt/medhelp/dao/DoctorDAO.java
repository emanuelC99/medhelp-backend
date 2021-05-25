package ro.upt.medhelp.dao;

import ro.upt.medhelp.model.Doctor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "DOCTORS")
@Table(name = "DOCTORS")
public class DoctorDAO {

    @Id
    @Column(name = "doctorId")
    private Long doctorId;
    @Column(name = "sealNumber")
    private String sealNumber;
    @Column(name = "officeAddress")
    private String officeAddress;
    @Column(name = "experience")
    private Integer experience;
    @Column(name = "specialization")
    private String specialization;
    @Column(name = "age")
    private Integer age;
    @Column(name = "birthDate")
    private LocalDate birthDate;
    @Column(name = "phone")
    private String phone;
    @OneToOne
    @MapsId
    private UserDAO user;
    @OneToMany(
            mappedBy = "doctor",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MedicalRecordDAO> medicalRecords = new ArrayList<>();

    public List<MedicalRecordDAO> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecordDAO> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public DoctorDAO() {
    }

    public DoctorDAO(String sealNumber, String officeAddress, Integer experience, String specialization, Integer age, LocalDate birthDate, String phone) {
        this.sealNumber = sealNumber;
        this.officeAddress = officeAddress;
        this.experience = experience;
        this.specialization = specialization;
        this.age = age;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    public DoctorDAO(Doctor doctor) {
        this.sealNumber = doctor.getSealNumber();
        this.officeAddress = doctor.getOfficeAddress();
        this.experience = doctor.getExperience();
        this.specialization = doctor.getSpecialization();
        this.age = doctor.getAge();
        this.birthDate = doctor.getBirthDate();
        this.phone = doctor.getPhone();
    }

    public void castDoctorModel(Doctor doctor) {
        this.sealNumber = doctor.getSealNumber();
        this.officeAddress = doctor.getOfficeAddress();
        this.experience = doctor.getExperience();
        this.specialization = doctor.getSpecialization();
        this.age = doctor.getAge();
        this.birthDate = doctor.getBirthDate();
        this.phone = doctor.getPhone();
    }

    public void addMedicalRecord(MedicalRecordDAO medicalRecord) {
        medicalRecords.add(medicalRecord);
        medicalRecord.setDoctor(this);
    }

    public void removeMedicalRecord(MedicalRecordDAO medicalRecord) {
        medicalRecords.remove(medicalRecord);
        medicalRecord.setDoctor(null);
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getSealNumber() {
        return sealNumber;
    }

    public void setSealNumber(String sealNumber) {
        this.sealNumber = sealNumber;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserDAO getUser() {
        return user;
    }

    public void setUser(UserDAO user) {
        this.user = user;
    }
}
