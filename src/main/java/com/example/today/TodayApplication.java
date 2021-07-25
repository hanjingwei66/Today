package com.example.today;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class TodayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodayApplication.class, args);
	}

}
