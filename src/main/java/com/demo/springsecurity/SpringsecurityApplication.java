package com.demo.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class SpringsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

	//인메모리 사용자 추가
	@Bean
	public UserDetailsService users(){
		UserDetails user = User.builder()
				.username("user")
				.password("{noop}password")
				.roles("USER")
				.build();

		UserDetails admin = User.builder()
				.username("admin")
				.password("{noop}password")
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user, admin);

	}
}
