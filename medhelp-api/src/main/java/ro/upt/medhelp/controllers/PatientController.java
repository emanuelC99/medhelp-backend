package ro.upt.medhelp.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.upt.medhelp.model.Patient;
import ro.upt.medhelp.services.PatientService;

@RestController
@RequestMapping(value = "/patients")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @PostMapping(path = "/{email}", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Patient createPatient(@PathVariable("email") String email, @RequestBody Patient patient) {
        if (email == null || patient == null) {
            return null;
        } else {
            return patientService.addPatient(email, patient);
        }
    }

    @GetMapping(path = "/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Patient findPatient(@PathVariable("email") String email) {
        if (email == null) {
            return null;
        } else {
            return patientService.findPatient(email);

        }
    }

    @DeleteMapping(path = "/{email}")
    public void deletePatient(@PathVariable("email") String email) {
        if (email != null) {
            patientService.deletePatient(email);
        }
    }

    @PutMapping(path = "/{email}",  consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Patient updatePatient(@PathVariable("email") String email, @RequestBody Patient patient) {
        if (email != null && patient != null) {
            return patientService.updatePatient(email, patient);
        }
        return null;
    }

}
