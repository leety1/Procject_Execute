package com.example.demo;

import javax.annotation.security.PermitAll;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests() // 요청에 의한 보안검사
				.antMatchers("/", "/login","/service","/resources/**").permitAll()
	            .antMatchers("/admin").hasRole("ADMIN")
	            .anyRequest().authenticated()
	            .antMatchers("/**").permitAll()
			.and() //어떤 요청에도 보안검사
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/index")
				.permitAll()
			.and()
				.logout();
			
				//보안 검증은 formLogin 방식
		
	}
}
