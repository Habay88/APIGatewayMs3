package com.habay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableFeignClients
@SpringBootApplication

public class Apigatewaymicroservice3Application {

	public static void main(String[] args) {
		SpringApplication.run(Apigatewaymicroservice3Application.class, args);
	}


}
