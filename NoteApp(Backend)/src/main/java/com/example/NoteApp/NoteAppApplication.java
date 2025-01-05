package com.example.NoteApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NoteAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteAppApplication.class, args);
		System.out.println("hello");
	}

}
