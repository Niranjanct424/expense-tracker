package com.expensetracker.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.entity.User;
import com.expensetracker.repository.UserRepository;
import com.expensetracker.request.UserRegistrationRequest;

@RestController
@RequestMapping("/api/user/")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationRequest registrationRequest) {
        // Check if the username or email is already registered
        if (userRepository.existsByUsername(registrationRequest.getUsername()) ||
            userRepository.existsByEmail(registrationRequest.getEmail())) {
            return ResponseEntity.badRequest().body("Username or email already exists.");
        }

        // Create a new User entity and set the attributes
        User newUser = new User();
        newUser.setUsername(registrationRequest.getUsername());
//        newUser.setPasswordHash(passwordEncoder.encode(registrationRequest.getPassword()));
        newUser.setPasswordHash(registrationRequest.getPassword());
        newUser.setFullName(registrationRequest.getFullName());
        newUser.setEmail(registrationRequest.getEmail());

        // Save the new user to the database
        userRepository.save(newUser);

        return ResponseEntity.ok("Registration successful!");
    }
}
