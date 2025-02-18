package com.sujet.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{ 

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService).passwordEncoder(encoderPWD());
	}
	
	@Override  
	protected void configure(HttpSecurity http) throws Exception {
		
		http.cors();//
		http.csrf().disable()
					.authorizeRequests().antMatchers("*/***")
				//.authorizeRequests().antMatchers("/secure/***").authenticated().anyRequest().hasAnyRole("ROLE_ADMIN").and()
				.fullyAuthenticated().and().httpBasic();//type d'auuthentification HTTP basic
			
		http.authorizeRequests().antMatchers("* /***").hasAnyRole()
							.and().formLogin();
	}

	@Bean
	public BCryptPasswordEncoder encoderPWD() {
		return new BCryptPasswordEncoder();
	}
}
