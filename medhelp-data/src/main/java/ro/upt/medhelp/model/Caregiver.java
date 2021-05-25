package ro.upt.medhelp.model;

import ro.upt.medhelp.dao.CaregiverDAO;

import java.time.LocalDate;

public class Caregiver {
    private String phone;
    private LocalDate birthDate;
    private Integer age;
    private String address;
    private Boolean available;

    public Caregiver() {

    }

    public Caregiver(String phone, LocalDate birthDate, Integer age, String address, Boolean available) {
        this.phone = phone;
        this.birthDate = birthDate;
        this.age = age;
        this.address = address;
        this.available = available;
    }

    public static Caregiver castCaregiverDAO(CaregiverDAO caregiverDAO) {
        if (caregiverDAO != null) {
            Caregiver caregiver = new Caregiver();
            caregiver.setPhone(caregiverDAO.getPhone());
            caregiver.setAge(caregiverDAO.getAge());
            caregiver.setAddress(caregiverDAO.getAddress());
            caregiver.setBirthDate(caregiverDAO.getBirthDate());
            caregiver.setAvailable(caregiverDAO.getAvailable());
            return caregiver;
        }
        return null;
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
