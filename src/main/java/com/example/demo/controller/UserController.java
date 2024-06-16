package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;



@Log4j2
@Controller
@RequestMapping("/api")
public class UserController {

	@PostMapping("/join")
	public ResponseEntity<?> join() {
		log.info("Test");

		return ResponseEntity.ok().body("JOIN TEST");
	}

}
