package ro.upt.medhelp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.upt.medhelp.dao.DoctorDAO;
import ro.upt.medhelp.dao.UserDAO;
import ro.upt.medhelp.model.Doctor;
import ro.upt.medhelp.repositories.DoctorRepository;
import ro.upt.medhelp.repositories.UserRepository;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, UserRepository userRepository, UserService userService) {
        this.doctorRepository = doctorRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public Doctor addDoctor(String email, Doctor doctor) {
        UserDAO existingUser = userService.findUserRaw(email);
        if (existingUser != null) {
            if (existingUser.getDoctor() == null) {
                DoctorDAO newDoctor = new DoctorDAO(doctor);
                existingUser.setDoctor(newDoctor);
                newDoctor.setUser(existingUser);
                userRepository.save(existingUser);
                return Doctor.castDoctorDAO(newDoctor);
            }
        }
        return null;
    }

    public Doctor findDoctor(String email) {
        UserDAO existingUser = userService.findUserRaw(email);
        if (existingUser != null) {
            if (existingUser.getDoctor() != null) {
                return Doctor.castDoctorDAO(existingUser.getDoctor());
            }
            return null;
        } else {
            return null;
        }
    }

    public void deleteDoctor(String email) {
        UserDAO existingUser = userService.findUserRaw(email);
        if (existingUser != null) {
            Long userId = userService.findUserRaw(email).getUserId();
            if (existingUser.getDoctor() != null) {
                doctorRepository.deleteById(userId);
            }
            userRepository.deleteById(userId);
        }
    }

    public Doctor updateDoctor(String email, Doctor doctor) {
        UserDAO existingUser = userService.findUserRaw(email);
        if (existingUser != null) {
            DoctorDAO existingDoctor = existingUser.getDoctor();
            if (existingDoctor != null) {
                existingDoctor.castDoctorModel(doctor);
                userRepository.save(existingUser);
                return Doctor.castDoctorDAO(existingDoctor);
            }
            return null;
        } else
            return null;
    }

}
