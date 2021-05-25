package ro.upt.medhelp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.upt.medhelp.dao.DoctorDAO;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorDAO, Long> {
}
