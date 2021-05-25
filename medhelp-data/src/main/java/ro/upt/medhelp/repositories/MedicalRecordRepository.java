package ro.upt.medhelp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.upt.medhelp.dao.MedicalRecordDAO;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecordDAO, Long> {
}
