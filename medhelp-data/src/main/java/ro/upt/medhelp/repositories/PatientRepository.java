package ro.upt.medhelp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.upt.medhelp.dao.PatientDAO;

@Repository
public interface PatientRepository extends JpaRepository<PatientDAO, Long> {
}
