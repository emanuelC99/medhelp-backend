package ro.upt.medhelp.services;

import org.springframework.stereotype.Service;
import ro.upt.medhelp.dao.PatientDAO;
import ro.upt.medhelp.dao.UserDAO;
import ro.upt.medhelp.model.Patient;
import ro.upt.medhelp.repositories.PatientRepository;
import ro.upt.medhelp.repositories.UserRepository;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    public PatientService(PatientRepository patientRepository, UserRepository userRepository, UserService userService) {
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public Patient addPatient(String email, Patient patient) {
        UserDAO existingUser = userService.findUserRaw(email);
        if (existingUser != null) {
            if (existingUser.getPatient() == null) {
                PatientDAO newPatient = new PatientDAO(patient);
                existingUser.setPatient(newPatient);
                newPatient.setUsers(existingUser);
                userRepository.save(existingUser);
                return Patient.castPatientDAO(newPatient);
            }
        }
        return null;
    }

    public Patient findPatient(String email) {
        UserDAO existingUser = userService.findUserRaw(email);
        if (existingUser != null) {
            if (existingUser.getPatient() != null) {
                return Patient.castPatientDAO(existingUser.getPatient());
            }
            return null;
        } else {
            return null;
        }
    }

    public void deletePatient(String email) {
        UserDAO existingUser = userService.findUserRaw(email);
        if (existingUser != null) {
            Long userId = userService.findUserRaw(email).getUserId();
            if (existingUser.getPatient() != null) {
                patientRepository.deleteById(userId);
            }
            userRepository.deleteById(userId);
        }
    }

    public Patient updatePatient(String email, Patient patient) {
        UserDAO existingUser = userService.findUserRaw(email);
        if (existingUser != null) {
            PatientDAO existingPatient = existingUser.getPatient();
            if (existingPatient != null) {
                existingPatient.castPatientModel(patient);
                userRepository.save(existingUser);
                return Patient.castPatientDAO(existingPatient);
            }
            return null;
        } else
            return null;
    }

}
