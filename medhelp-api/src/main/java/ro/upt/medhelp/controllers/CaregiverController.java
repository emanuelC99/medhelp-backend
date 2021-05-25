package ro.upt.medhelp.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.upt.medhelp.model.Caregiver;
import ro.upt.medhelp.services.CaregiverService;

@RestController
@RequestMapping(value = "/caregivers")
public class CaregiverController {

    private CaregiverService caregiverService;

    public CaregiverController(CaregiverService caregiverService) {
        this.caregiverService = caregiverService;
    }


    @PostMapping(path = "/{email}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Caregiver createPatient(@PathVariable("email") String email, @RequestBody Caregiver caregiver) {
        if (email == null || caregiver == null) {
            return null;
        } else {
            return caregiverService.addCaregiver(email, caregiver);
        }
    }

    @GetMapping(path = "/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Caregiver findPatient(@PathVariable("email") String email) {
        if (email == null) {
            return null;
        } else {
            return caregiverService.findCaregiver(email);

        }
    }

    @DeleteMapping(path = "/{email}")
    public void deletePatient(@PathVariable("email") String email) {
        if (email != null) {
            caregiverService.deleteCaregiver(email);
        }
    }

    @PutMapping(path = "/{email}", consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE)
    public Caregiver updatePatient(@PathVariable("email") String email, @RequestBody Caregiver caregiver) {
        if (email != null && caregiver != null) {
            return caregiverService.updateCaregiver(email, caregiver);
        }
        return null;
    }

}
