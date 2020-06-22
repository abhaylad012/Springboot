package com.demo1.demo1.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter{

	/*
	 * @Bean
	 * 
	 * @Override protected UserDetailsService userDetailsService() { // TODO
	 * Auto-generated method stub
	 * 
	 * List<UserDetails> user = new ArrayList<>();
	 * user.add(User.withDefaultPasswordEncoder().username("chaya").password("1234")
	 * .roles("USER").build());
	 * user.add(User.withDefaultPasswordEncoder().username("ciya").password("789").
	 * roles("ADMIN").build()); return new InMemoryUserDetailsManager(user); }
	 */

	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
	auth.inMemoryAuthentication()
		.withUser("chaya")
		.password("1234")
		.roles("USER")
		.and()
		.withUser("Ciya")
		.password("789")
		.roles("ADMIN");
		
	}


	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
	http.authorizeRequests()
		.antMatchers("/**").hasRole("USER")
		.and().formLogin();
	}

	
	

	
}
