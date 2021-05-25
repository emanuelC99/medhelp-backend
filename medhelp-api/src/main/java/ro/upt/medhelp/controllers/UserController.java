package ro.upt.medhelp.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.upt.medhelp.model.User;
import ro.upt.medhelp.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User user) {
        if (user == null) {
            return null;
        } else {
            return userService.addUser(user);
        }
    }

    @GetMapping(path = "/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User findUser(@PathVariable("email") String email) {
        if (email == null) {
            return null;
        } else {
            return userService.findUser(email);

        }
    }

    @DeleteMapping(path = "/{email}")
    public void deleteUser(@PathVariable("email") String email) {
        if (email != null) {
            userService.deleteUser(email);
        }
    }

    @PutMapping(path = "/{email}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@PathVariable("email") String email, @RequestBody User user) {
        if (email != null && user != null) {
            return userService.updateUser(email, user);
        }
        return null;
    }

}
