package ro.upt.medhelp.dao;

import org.hibernate.annotations.NaturalId;
import ro.upt.medhelp.model.BloodGroup;
import ro.upt.medhelp.model.Patient;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "PATIENTS")
@Table(name = "PATIENTS")
public class PatientDAO {

    @Id
    @Column(name = "patientId")
    private Long patientId;
    @Column(name = "CNP", unique = true)
    @NaturalId(mutable = true)
    private String CNP;
    @Column(name = "birthDate")
    private LocalDate birthDate;
    @Column(name = "address")
    private String address;
    @Column(name = "phone", unique = true)
    private String phone;
    @Column(name = "sex")
    private String sex;
    @Column(name = "age")
    private Integer age;
    @Column(name = "insuranceId")
    private String insuranceId;
    @Column(name = "bloodGroup")
    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;
    @OneToOne
    @MapsId
    private UserDAO user;
    @OneToMany(
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MedicalRecordDAO> medicalRecords = new ArrayList<>();
    @OneToMany(
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<SensorDAO> sensors = new ArrayList<>();

    public List<SensorDAO> getSensors() {
        return sensors;
    }

    public void setSensors(List<SensorDAO> sensors) {
        this.sensors = sensors;
    }

    public CaregiverDAO getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(CaregiverDAO caregiver) {
        this.caregiver = caregiver;
    }


    public List<MedicalRecordDAO> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecordDAO> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private CaregiverDAO caregiver;

    public CaregiverDAO getCaregiverDAO() {
        return caregiver;
    }

    public void setCaregiverDAO(CaregiverDAO caregiver) {
        this.caregiver = caregiver;
    }

    public PatientDAO() {

    }

    public PatientDAO(String CNP, LocalDate birthDate, String address, String phone, String sex, Integer age, String insuranceId, BloodGroup bloodGroup) {
        this.CNP = CNP;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.sex = sex;
        this.age = age;
        this.insuranceId = insuranceId;
        this.bloodGroup = bloodGroup;
    }

    public PatientDAO(Patient patient) {
        this.CNP = patient.getCNP();
        this.birthDate = patient.getBirthDate();
        this.address = patient.getAddress();
        this.phone = patient.getPhone();
        this.sex = patient.getSex();
        this.age = patient.getAge();
        this.insuranceId = patient.getInsuranceId();
        this.bloodGroup = patient.getBloodGroup();
    }

    public void castPatientModel(Patient patient) {
        this.CNP = patient.getCNP();
        this.birthDate = patient.getBirthDate();
        this.address = patient.getAddress();
        this.phone = patient.getPhone();
        this.sex = patient.getSex();
        this.age = patient.getAge();
        this.insuranceId = patient.getInsuranceId();
        this.bloodGroup = patient.getBloodGroup();
    }

    public void addMedicalRecord(MedicalRecordDAO medicalRecord) {
        medicalRecords.add(medicalRecord);
        medicalRecord.setPatient(this);
    }

    public void removeMedicalRecord(MedicalRecordDAO medicalRecord) {
        medicalRecords.remove(medicalRecord);
        medicalRecord.setPatient(null);
    }

    public void addSensor(SensorDAO sensor) {
        sensors.add(sensor);
        sensor.setPatient(this);
    }

    public void removeMedicalRecord(SensorDAO sensor) {
        sensors.remove(sensor);
        sensor.setPatient(this);
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public UserDAO getUsers() {
        return user;
    }

    public void setUsers(UserDAO user) {
        this.user = user;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientDAO)) return false;
        return patientId != null && patientId.equals(((PatientDAO) o).getPatientId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
