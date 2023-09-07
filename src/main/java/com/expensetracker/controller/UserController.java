//package com.expensetracker.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.expensetracker.model.LogInResponse;
//import com.expensetracker.model.UserRequest;
//import com.expensetracker.service.UserService;
//
//@RestController
//@RequestMapping("/api/user")
//public class UserController {
//
//	@Autowired
//	UserService userService;
//
//	@CrossOrigin
//	@PostMapping("/login")
//	public ResponseEntity<LogInResponse> validate(@RequestBody UserRequest user) {
//		System.out.println("login request : "+user);
//		return new ResponseEntity<>(userService.fetchUserDetails(user)
//				.equals("success") ? new LogInResponse("success") : new LogInResponse("failed"), HttpStatus.OK);
//	}
//
//}
