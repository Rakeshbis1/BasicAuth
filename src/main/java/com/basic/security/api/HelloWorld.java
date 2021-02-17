package com.basic.security.api;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	public HelloWorld() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/hello")
	public String helloWorld()
	{
		
		return "Hello World... ";
	}
}
