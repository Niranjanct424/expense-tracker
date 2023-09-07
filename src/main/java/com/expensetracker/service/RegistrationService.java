package com.expensetracker.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensetracker.entity.User;
import com.expensetracker.repository.UserRepository;
import com.expensetracker.request.UserRegistrationRequest;
import com.expensetracker.response.CreateExpenseResponse;

@Service
public class RegistrationService {

    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

//    @Autowired
//    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
    
    @Autowired
    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CreateExpenseResponse registerUser(UserRegistrationRequest registrationRequest) {
        // Check if the username or email is already registered
        if (userRepository.existsByUsername(registrationRequest.getUsername()) ||
            userRepository.existsByEmail(registrationRequest.getEmail())) {
            return CreateExpenseResponse.builder().success(false).message("Username or email already exists.").build();
        }

        // Create a new User entity and set the attributes
        User newUser = new User();
        newUser.setUsername(registrationRequest.getUsername());
//      newUser.setPasswordHash(passwordEncoder.encode(registrationRequest.getPassword()));
        newUser.setPasswordHash(registrationRequest.getPassword());
        newUser.setFullName(registrationRequest.getFullName());
        newUser.setEmail(registrationRequest.getEmail());

        // Save the new user to the database
        userRepository.save(newUser);

        return CreateExpenseResponse.builder().success(true).message("Registration successful!").build();
    }
}
