package ro.upt.medhelp.dao;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

public class CaregiverPatient {
    @ManyToOne(fetch = FetchType.LAZY)
    private PatientDAO patient;
    @ManyToOne(fetch = FetchType.LAZY)
    private CaregiverDAO caregiverDAO;
}
