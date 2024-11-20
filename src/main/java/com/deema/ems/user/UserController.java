package com.deema.ems.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users); // HTTP 200 OK with user list
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user); // HTTP 200 OK with user data
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found if user doesn't exist
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser); // HTTP 201 Created with new user data
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userService.getUserById(id) != null) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build(); // HTTP 204 No Content on successful deletion
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found if user doesn't exist
        }
    }
}

