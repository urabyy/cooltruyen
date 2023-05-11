package com.uraby.cooltruyen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { ReactiveSecurityAutoConfiguration.class, SecurityAutoConfiguration.class }, scanBasePackages = "com.uraby.cooltruyen")

public class CooltruyenApplication {

	public static void main(String[] args) {
		SpringApplication.run(CooltruyenApplication.class, args);
	}

}
