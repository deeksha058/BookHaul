package com.BookHaul.bookHaul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
public class BookHaulApplication {

	@GetMapping
	public String welcome(){

		return "hello Welcome !!";
	}

	@GetMapping("/user")
	public Principal user(Principal principal){

		System.out.println("UserName" + principal.getName());
		return principal;
	}
	public static void main(String[] args) {

		SpringApplication.run(BookHaulApplication.class, args);
	}

}
