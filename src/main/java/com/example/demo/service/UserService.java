package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.dto.UserJoinDto;
import com.example.demo.repository.UserRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UserService {
	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	public UserService(PasswordEncoder passwordEncoder , UserRepository userRepository) {
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
	}
	
	public ResponseEntity<?> join(UserJoinDto userJoinDto) {
		User user = new User();
//		user.setId(userJoinDto.getId());
//		user.setPw(passwordEncoder.encode(userJoinDto.getPw()));
//		user.setName(userJoinDto.getName());
//		user.setPhone(userJoinDto.getPhone());
//		user.setAddress(userJoinDto.getAddress());
		try {
			log.info(userRepository.save(userJoinDto.getId(), passwordEncoder.encode(userJoinDto.getPw()), userJoinDto.getName(), userJoinDto.getPhone(), userJoinDto.getAddress(), "GUEST"));
		} catch(Exception e) {
			log.info(e.getMessage());
		}
		return ResponseEntity.ok().build();
	}

}
