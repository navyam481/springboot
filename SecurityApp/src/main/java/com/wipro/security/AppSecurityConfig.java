package com.wipro.security;

import java.util.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig{
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin()
            .and()
            .logout();
        return http.build();
    }
	
	
	 @Bean
	 public UserDetailsService userDetailsService() {
		 List<UserDetails> users = new ArrayList<>();
		 users.add(User.withDefaultPasswordEncoder().username("Smith").password("smi123").roles("USER").build());
		 users.add(User.withDefaultPasswordEncoder().username("Scott").password("sco123").roles("USER").build());		 
		 return new InMemoryUserDetailsManager(users);
	 }
    
}
