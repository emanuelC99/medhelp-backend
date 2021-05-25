package ro.upt.medhelp.dao;

import org.hibernate.annotations.NaturalId;
import ro.upt.medhelp.model.MedicalRecord;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "MEDICAL_RECORDS")
@Table(name = "MEDICAL_RECORDS")
public class MedicalRecordDAO implements Comparable<MedicalRecord> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicalRecordId")
    private Long medicalRecordId;
    @Column(name = "diseaseName")
    @NaturalId
    private String diseaseName;
    @Column(name = "recommendations")
    private String recommendations;
    @Column(name = "medicines")
    private String medicines;
    @Column(name = "dosage")
    private String dosage;
    @ManyToOne(fetch = FetchType.LAZY)
    private PatientDAO patient;
    @ManyToOne(fetch = FetchType.LAZY)
    private DoctorDAO doctor;


    public MedicalRecordDAO() {
    }

    public MedicalRecordDAO(Long medicalRecordId, String diseaseName, String recommendations, String medicines, String dosage) {
        this.medicalRecordId = medicalRecordId;
        this.diseaseName = diseaseName;
        this.recommendations = recommendations;
        this.medicines = medicines;
        this.dosage = dosage;

    }

    public MedicalRecordDAO(MedicalRecord medicalRecord) {
        this.medicines = medicalRecord.getMedicines();
        this.diseaseName = medicalRecord.getDiseaseName();
        this.recommendations = medicalRecord.getRecommendations();
        this.dosage = medicalRecord.getDosage();
    }

    public DoctorDAO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDAO doctor) {
        this.doctor = doctor;
    }

    public PatientDAO getPatient() {
        return patient;
    }

    public void setPatient(PatientDAO patient) {
        this.patient = patient;
    }

    public Long getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(Long medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalRecordDAO that = (MedicalRecordDAO) o;
        return Objects.equals(diseaseName, that.diseaseName) && Objects.equals(recommendations, that.recommendations) && Objects.equals(medicines, that.medicines) && Objects.equals(dosage, that.dosage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diseaseName, recommendations, medicines, dosage);
    }

    @Override
    public int compareTo(MedicalRecord record) {
        return this.getDiseaseName().compareTo(record.getDiseaseName());
    }
}
