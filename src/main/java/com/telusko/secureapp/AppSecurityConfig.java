package com.telusko.secureapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider()
	{
	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	provider.setUserDetailsService(userDetailsService);
	provider.setPasswordEncoder(new BCryptPasswordEncoder());
	return provider;
	}
	
	//NoOpPasswordEncoder.getInstance()
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
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .authorizeRequests()
         // .antMatchers("/home.jsp").access("hasRole('ROLE_USER')")
          .anyRequest()
          .authenticated()
          .and()
          .formLogin()
          .loginPage("/login")
          .permitAll()
          .defaultSuccessUrl("/")
          .failureUrl("/failure")
          .and()
          .rememberMe()
          .tokenValiditySeconds(365*24*60*60)
          .and().csrf().disable();
    }
}
