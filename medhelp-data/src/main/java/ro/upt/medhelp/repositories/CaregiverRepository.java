package ro.upt.medhelp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.upt.medhelp.dao.CaregiverDAO;

@Repository
public interface CaregiverRepository extends JpaRepository<CaregiverDAO, Long> {
}
