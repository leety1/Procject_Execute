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
				.anyRequest().authenticated()
			.and() //어떤 요청에도 보안검사
				.formLogin() //보안 검증은 formLogin 방식
				.permitAll() // 사용자 정의 로그인 페이지 접근 권한 승인
			.and()
				.logout();
	}
}
