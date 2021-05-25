package ro.upt.medhelp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.upt.medhelp.dao.UserDAO;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, Long> {
}
