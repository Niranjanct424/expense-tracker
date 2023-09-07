package com.expensetracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensetracker.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

//	public String fetchUserDetails(UserRequest userInfo) {
//		UserEntity entity = userRepository.findByUsername(userInfo.getUsername());
//		if (entity.getUsername().equalsIgnoreCase(userInfo.getUsername())) {
//			return "success";
//		}
//		return "failed";
//	}
	
	
}
