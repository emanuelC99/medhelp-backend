package ro.upt.medhelp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import ro.upt.medhelp.dao.UserDAO;

public class User {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private UserRole userRole;
    private Boolean isActive;

    public User() {

    }

    public User(String email, String firstName, String lastName, String password, UserRole userRole, Boolean isActive) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userRole = userRole;
        this.isActive = isActive;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Boolean getActive() {
        return isActive;
    }
    @JsonProperty("isActive")
    public void setActive(Boolean active) {
        isActive = active;
    }

    public static User castUserDao(UserDAO userDAO) {
        User user = new User();
        user.email = userDAO.getEmail();
        user.firstName = userDAO.getFirstName();
        user.lastName = userDAO.getLastName();
        user.password = userDAO.getPassword();
        user.userRole = userDAO.getUserRole();
        user.isActive = userDAO.getActive();
        return user;
    }
}
