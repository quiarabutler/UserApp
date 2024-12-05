package controllers;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.UserService;

import java.util.List;

// This will define the REST points
@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "http://localhost:4200") // Allows requests from Angular at localhost 4200


public class UserController {
    @Autowired
    private UserService userService; // injecting user service

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @PostMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
