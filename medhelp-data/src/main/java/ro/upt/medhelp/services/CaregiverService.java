package ro.upt.medhelp.services;

import org.springframework.stereotype.Service;
import ro.upt.medhelp.dao.CaregiverDAO;
import ro.upt.medhelp.dao.UserDAO;
import ro.upt.medhelp.model.Caregiver;
import ro.upt.medhelp.repositories.CaregiverRepository;
import ro.upt.medhelp.repositories.UserRepository;

@Service
public class CaregiverService {

    private final CaregiverRepository caregiverRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    public CaregiverService(CaregiverRepository caregiverRepository, UserRepository userRepository, UserService userService) {
        this.caregiverRepository = caregiverRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public Caregiver addCaregiver(String email, Caregiver caregiver) {
        UserDAO existingUser = userService.findUserRaw(email);
        if (existingUser != null) {
            if (existingUser.getCaregiver() == null) {
                CaregiverDAO newCaregiver = new CaregiverDAO(caregiver);
                newCaregiver.setUsers(existingUser);
                existingUser.setCaregiver(newCaregiver);
                userRepository.save(existingUser);
                return Caregiver.castCaregiverDAO(newCaregiver);
            }
        }
        return null;
    }

    public Caregiver findCaregiver(String email) {
        UserDAO existingUser = userService.findUserRaw(email);
        if (existingUser != null) {
            if (existingUser.getCaregiver() != null) {
                return Caregiver.castCaregiverDAO(existingUser.getCaregiver());
            }
            return null;
        } else {
            return null;
        }
    }

    public void deleteCaregiver(String email) {
        UserDAO existingUser = userService.findUserRaw(email);
        if (existingUser != null) {
            Long userId = userService.findUserRaw(email).getUserId();
            if (existingUser.getCaregiver() != null) {
                caregiverRepository.deleteById(userId);
            }
            userRepository.deleteById(userId);
        }
    }

    public Caregiver updateCaregiver(String email, Caregiver caregiver) {
        UserDAO existingUser = userService.findUserRaw(email);
        if (existingUser != null) {
            CaregiverDAO existingCaregiver = existingUser.getCaregiver();
            if (existingCaregiver != null) {
                existingCaregiver.castCaregiverModel(caregiver);
                userRepository.save(existingUser);
                return Caregiver.castCaregiverDAO(existingCaregiver);
            }
            return null;
        } else
            return null;
    }

}
