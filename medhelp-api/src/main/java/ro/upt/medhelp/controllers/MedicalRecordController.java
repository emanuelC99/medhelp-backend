package ro.upt.medhelp.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.upt.medhelp.model.MedicalRecord;
import ro.upt.medhelp.services.MedicalRecordService;

import java.util.List;

@RestController
@RequestMapping(value = "/records")
public class MedicalRecordController {

    private MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @PostMapping(path = "/{email}",  consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public MedicalRecord createRecord(@PathVariable("email") String email, @RequestBody MedicalRecord medicalRecord) {
        if (email == null || medicalRecord == null) {
            return null;
        } else {
            return medicalRecordService.addRecord(email, medicalRecord);
        }
    }

    @GetMapping(path = "/{email}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<MedicalRecord> findRecord(@PathVariable("email") String email) {
        if (email == null) {
            return null;
        } else {
            return medicalRecordService.findRecord(email);
        }
    }

    @DeleteMapping(path = "/{email}")
    public void deleteRecord(@PathVariable("email") String email, @RequestBody MedicalRecord medicalRecord) {
        if (email != null && medicalRecord != null) {
            medicalRecordService.deleteRecord(email, medicalRecord);
        }
    }

    @PutMapping(path = "/{email}",  consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public MedicalRecord updateRecord(@PathVariable("email") String email, @RequestBody MedicalRecord medicalRecord) {
        if (email != null && medicalRecord != null) {
            return medicalRecordService.updateRecord(email, medicalRecord);
        }
        return null;
    }
}
