package com.chen.java_task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JavaTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaTaskApplication.class, args);
	}

}
