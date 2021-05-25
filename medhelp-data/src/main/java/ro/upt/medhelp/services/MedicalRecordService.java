package ro.upt.medhelp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.upt.medhelp.dao.DoctorDAO;
import ro.upt.medhelp.dao.MedicalRecordDAO;
import ro.upt.medhelp.dao.PatientDAO;
import ro.upt.medhelp.dao.UserDAO;
import ro.upt.medhelp.model.MedicalRecord;
import ro.upt.medhelp.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalRecordService {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public MedicalRecordService(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public MedicalRecord addRecord(String email, MedicalRecord medicalRecord) {
        UserDAO existingUser = userService.findUserRaw(email);
        if (existingUser != null) {
            DoctorDAO existingDoctor = existingUser.getDoctor();
            if (existingDoctor != null) {
                MedicalRecordDAO newRecord = new MedicalRecordDAO(medicalRecord);
                newRecord.setDoctor(existingDoctor);
                existingDoctor.addMedicalRecord(newRecord);
                userRepository.save(existingUser);
                return MedicalRecord.castMedicalRecordDAO(newRecord);
            }
        }
        return null;
    }

    public List<MedicalRecord> findRecord(String email) {
        UserDAO existingUser = userService.findUserRaw(email);
        if (existingUser != null) {
            DoctorDAO existingDoctor = existingUser.getDoctor();
            if (existingDoctor != null) {
                List<MedicalRecordDAO> records = existingDoctor.getMedicalRecords();
                List<MedicalRecord> recordsModels = records.stream().map(MedicalRecord::new).collect(Collectors.toList());
                return recordsModels;
            } else {
                PatientDAO existingPatient = existingUser.getPatient();
                if (existingPatient != null) {
                    List<MedicalRecordDAO> records = existingPatient.getMedicalRecords();
                    List<MedicalRecord> recordsModels = records.stream().map(MedicalRecord::new).collect(Collectors.toList());
                    return recordsModels;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public MedicalRecord updateRecord(String email, MedicalRecord medicalRecord) {
        UserDAO existingUser = userService.findUserRaw(email);
        if (existingUser != null) {
            DoctorDAO existingDoctor = existingUser.getDoctor();
            if (existingDoctor != null) {
                List<MedicalRecordDAO> records = existingDoctor.getMedicalRecords();
                for (MedicalRecordDAO record : records) {
                    if (record.compareTo(medicalRecord) == 0) {
                        record.setDiseaseName(medicalRecord.getDiseaseName());
                        record.setDosage(medicalRecord.getDosage());
                        record.setRecommendations(medicalRecord.getRecommendations());
                        record.setMedicines(medicalRecord.getMedicines());
                    }
                }
                userRepository.save(existingUser);
                return records.size() == 0 ? null : MedicalRecord.castMedicalRecordDAO(records.get(records.size() - 1));
            } else {
//                PatientDAO existingPatient = existingUser.getPatient();
//                if (existingPatient != null) {
//                    List<MedicalRecordDAO> records = existingPatient.getMedicalRecords();
//                    for (MedicalRecordDAO record : records) {
//                        if (record.compareTo(medicalRecord) == 0) {
//                            record.setDiseaseName(medicalRecord.getDiseaseName());
//                            record.setDosage(medicalRecord.getDosage());
//                            record.setRecommendations(medicalRecord.getRecommendations());
//                            record.setMedicines(medicalRecord.getMedicines());
//                        }
//                    }
//                    userRepository.save(existingUser);
//                    return MedicalRecord.castMedicalRecordDAO(existingPatient.getMedicalRecords().get(existingPatient.getMedicalRecords().size() - 1));
//                }
                return null;
            }
        } else
            return null;
    }

    public void deleteRecord(String email, MedicalRecord medicalRecord) {
        UserDAO existingUser = userService.findUserRaw(email);
        if (existingUser != null) {
            DoctorDAO existingDoctor = existingUser.getDoctor();
            if (existingDoctor != null) {
                List<MedicalRecordDAO> records = existingDoctor.getMedicalRecords();
                records.removeIf(record -> record.compareTo(medicalRecord) == 0);
                userRepository.save(existingUser);
            }
        }
    }
}