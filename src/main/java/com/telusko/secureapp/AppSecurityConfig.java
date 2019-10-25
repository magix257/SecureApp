package com.telusko.secureapp;

import java.util.List;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public AuthenticationProvider authProvider()
	{
	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	
	return provider;
	}
//	@SuppressWarnings("deprecation")
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//	
//		
//		List<UserDetails> users = new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder().username("navin").password("1234").roles("USER").build());
//		
//		return new InMemoryUserDetailsManager(users);
//	}
}
