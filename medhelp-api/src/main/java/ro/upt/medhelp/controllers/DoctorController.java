package ro.upt.medhelp.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.upt.medhelp.model.Doctor;
import ro.upt.medhelp.services.DoctorService;

@RestController
@RequestMapping(value = "/doctors")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @PostMapping(path = "/{email}", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Doctor createDoctor(@PathVariable("email") String email, @RequestBody Doctor doctor) {
        if (email == null || doctor == null) {
            return null;
        } else {
            return doctorService.addDoctor(email, doctor);
        }
    }

    @GetMapping(path = "/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Doctor findDoctor(@PathVariable("email") String email) {
        if (email == null) {
            return null;
        } else {
            return doctorService.findDoctor(email);

        }
    }

    @DeleteMapping(path = "/{email}")
    public void deleteDoctor(@PathVariable("email") String email) {
        if (email != null) {
            doctorService.deleteDoctor(email);
        }
    }

    @PutMapping(path = "/{email}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Doctor updateUser(@PathVariable("email") String email, @RequestBody Doctor doctor) {
        if (email != null && doctor != null) {
            return doctorService.updateDoctor(email, doctor);
        }
        return null;
    }
}
