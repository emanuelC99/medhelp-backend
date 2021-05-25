package ro.upt.medhelp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import ro.upt.medhelp.dao.PatientDAO;

import java.time.LocalDate;

public class Patient {
    private String CNP;
    private LocalDate birthDate;
    private String address;
    private String phone;
    private String sex;
    private Integer age;
    private String insuranceId;
    private BloodGroup bloodGroup;

    public Patient() {
    }

    public Patient(String CNP, LocalDate birthDate, String address, String phone, String sex, Integer age, String insuranceId, BloodGroup bloodGroup) {
        this.CNP = CNP;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.sex = sex;
        this.age = age;
        this.insuranceId = insuranceId;
        this.bloodGroup = bloodGroup;
    }

    public static Patient castPatientDAO(PatientDAO patientDAO) {
        if (patientDAO != null) {
            Patient patient = new Patient();
            patient.setAddress(patientDAO.getAddress());
            patient.setCNP(patientDAO.getCNP());
            patient.setAge(patientDAO.getAge());
            patient.setBirthDate(patientDAO.getBirthDate());
            patient.setInsuranceId(patientDAO.getInsuranceId());
            patient.setBloodGroup(patientDAO.getBloodGroup());
            patient.setSex(patientDAO.getSex());
            patient.setPhone(patientDAO.getPhone());
            return patient;
        } else {
            return null;
        }
    }

    public String getCNP() {
        return CNP;
    }

    @JsonProperty("CNP")
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
}
