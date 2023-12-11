package com.firtsappspring.tutospring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TutospringApplication {

	private static Logger logger = LoggerFactory.getLogger(TutospringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TutospringApplication.class, args);
		logger.debug("Mi mensaje debug");
	}

}
