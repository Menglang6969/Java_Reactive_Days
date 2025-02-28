package com.java.reactive;

import com.java.reactive.day1.Day1;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveApplication.class, args);
	}

	@PostConstruct
	public void init() {
		Day1 mono=new Day1();
		mono.demoMono();
	}
}
