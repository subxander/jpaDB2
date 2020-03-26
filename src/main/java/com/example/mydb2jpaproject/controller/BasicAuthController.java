package com.example.mydb2jpaproject.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mydb2jpaproject.bean.AuthenticationBean;


@RestController
@CrossOrigin(origins="http://localhost:3000")
public class BasicAuthController {

	@GetMapping(path="/basicAuth")
	public AuthenticationBean helloWorldBean() {
		return new AuthenticationBean("You are authenticated");
	}
}
