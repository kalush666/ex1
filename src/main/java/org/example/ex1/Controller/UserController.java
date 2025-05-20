package org.example.ex1.Controller;

import org.example.ex1.Entity.User;
import org.example.ex1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestParam String userName, @RequestParam String password) {
        User user = service.findUserByUserName(userName);
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }
}
