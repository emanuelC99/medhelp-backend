package ro.upt.medhelp.model;

import ro.upt.medhelp.dao.MedicalRecordDAO;

public class MedicalRecord implements Comparable<MedicalRecordDAO> {

    private String diseaseName;
    private String recommendations;
    private String medicines;
    private String dosage;

    public MedicalRecord() {
    }

    public MedicalRecord(String diseaseName, String recommendations, String medicines, String dosage) {
        this.diseaseName = diseaseName;
        this.recommendations = recommendations;
        this.medicines = medicines;
        this.dosage = dosage;
    }

    public MedicalRecord(MedicalRecordDAO medicalRecordDAO) {
        if (medicalRecordDAO != null) {
            this.dosage = medicalRecordDAO.getDosage();
            this.diseaseName = medicalRecordDAO.getDiseaseName();
            this.medicines = medicalRecordDAO.getMedicines();
            this.recommendations = medicalRecordDAO.getRecommendations();
        }
    }


    public static MedicalRecord castMedicalRecordDAO(MedicalRecordDAO medicalRecordDAO) {
        if (medicalRecordDAO != null) {
            MedicalRecord medicalRecord = new MedicalRecord();
            medicalRecord.setMedicines(medicalRecordDAO.getMedicines());
            medicalRecord.setDosage(medicalRecordDAO.getDosage());
            medicalRecord.setRecommendations(medicalRecordDAO.getRecommendations());
            medicalRecord.setDiseaseName(medicalRecordDAO.getDiseaseName());
            return medicalRecord;
        }
        return null;
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
    public int compareTo(MedicalRecordDAO recordDAO) {
//        int value1 = this.getDosage().compareTo(recordDAO.getDiseaseName());
//        int value2 = this.getMedicines().compareTo(recordDAO.getMedicines());
//        int value3 = this.getRecommendations().compareTo(recordDAO.getRecommendations());
//        int value4 = this.getDiseaseName().compareTo(recordDAO.getDiseaseName());
//        int retValue = ((value1 + value2 + value3) == 0) ? 0 : -1;
//        return retValue;
        return this.getDiseaseName().compareTo(recordDAO.getDiseaseName());
    }
}
