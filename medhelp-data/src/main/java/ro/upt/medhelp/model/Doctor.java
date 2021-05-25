package ro.upt.medhelp.model;

import ro.upt.medhelp.dao.DoctorDAO;

import java.time.LocalDate;

public class Doctor {
    private String sealNumber;
    private String officeAddress;
    private Integer experience;
    private String specialization;
    private Integer age;
    private LocalDate birthDate;
    private String phone;

    public Doctor() {

    }

    public Doctor(String sealNumber, String officeAddress, Integer experience, String specialization, Integer age, LocalDate birthDate, String phone) {
        this.sealNumber = sealNumber;
        this.officeAddress = officeAddress;
        this.experience = experience;
        this.specialization = specialization;
        this.age = age;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    public static Doctor castDoctorDAO(DoctorDAO doctorDAO) {
        if (doctorDAO != null) {
            Doctor doctor = new Doctor();
            doctor.setAge(doctorDAO.getAge());
            doctor.setBirthDate(doctorDAO.getBirthDate());
            doctor.setExperience(doctorDAO.getExperience());
            doctor.setSealNumber(doctorDAO.getSealNumber());
            doctor.setPhone(doctorDAO.getPhone());
            doctor.setOfficeAddress(doctorDAO.getOfficeAddress());
            doctor.setSpecialization(doctorDAO.getSpecialization());
            return doctor;
        }
        return null;
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
}
