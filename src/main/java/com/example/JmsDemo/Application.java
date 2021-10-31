package com.example.JmsDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

/*
 * inspired by [ https://aniruthmp.github.io/Spring-JMS-request-response/ ] 
 */
@EnableJms
@Configuration
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
