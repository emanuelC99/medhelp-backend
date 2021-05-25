package ro.upt.medhelp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ro.upt.medhelp.dao.UserDAO;
import ro.upt.medhelp.model.User;
import ro.upt.medhelp.repositories.UserRepository;

import javax.persistence.EntityManager;
import java.util.Objects;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final EntityManager entityManager;

    @Autowired
    public UserService(UserRepository userRepository, @Qualifier("localEntityManagerFactory") EntityManager entityManager) {
        this.userRepository = userRepository;
        this.entityManager = entityManager;
    }

    public User addUser(User user) {
        UserDAO userDAO = new UserDAO(user);
        return User.castUserDao(userRepository.save(userDAO));
    }

    public User findUser(String email) {
        UserDAO userDAO = findUserRaw(email);
        if (userDAO != null) {
            return User.castUserDao(userDAO);
        } else {
            return null;
        }
    }

    public void deleteUser(String email) {
        try {
            userRepository.deleteById(Objects.requireNonNull(findUserRaw(email)).getUserId());
        } catch (NullPointerException ignored) {
        }
    }

    public User updateUser(String email, User user) {
        UserDAO userDAO = findUserRaw(email);
        if (userDAO != null) {
            userDAO.setEmail(user.getEmail());
            userDAO.setFirstName(user.getFirstName());
            userDAO.setLastName(user.getLastName());
            userDAO.setPassword(user.getPassword());
            userDAO.setUserRole(user.getUserRole());
            userDAO.setActive(user.getActive());
            return User.castUserDao(userRepository.save(userDAO));
        } else
            return null;
    }

    public UserDAO findUserRaw(String email) {
        var users = entityManager.createQuery(
                "SELECT users FROM USERS users WHERE users.email = ?1")
                .setParameter(1, email)
                .setMaxResults(1)
                .getResultList();
        if (!users.isEmpty())
            return (UserDAO) users.get(0);
        else
            return null;
    }


}
