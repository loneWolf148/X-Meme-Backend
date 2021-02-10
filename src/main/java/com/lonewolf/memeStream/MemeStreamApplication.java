package com.lonewolf.memeStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class is the starting point of Spring Boot Application
 * @author Subham Das
 * @version 1.0
 * @see {@link com.lonewolf.memeStream.controller.MemeController}
 */
@SpringBootApplication
public class MemeStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemeStreamApplication.class, args);
	}
}
