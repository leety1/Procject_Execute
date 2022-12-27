package com.example.demo;

import javax.annotation.security.PermitAll;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.dao.UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private UserService userService;
	
	@Override
	public void configure(WebSecurity web) { web.ignoring().antMatchers("/css/**","/js/**","/img/**");}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
				.authorizeRequests()
					.antMatchers("/login","/signup","/user").permitAll()//누구나 들어와라
					.antMatchers("/").hasRole("USER")//USER, ADMIN만 접근
					.antMatchers("/admin").hasRole("ADMIN") // ADMIN 접근 가능
					.anyRequest().authenticated()// 나머지 요청들은 권한의 종류에 상관 없이 권한이 있어야 접근 가능
		.and() //어떤 요청에도 보안검사
				.formLogin()
				.loginPage("/login")
				//.loginProcessingUrl("/index")
				.defaultSuccessUrl("/index") // 로그인 성공 후 리다이렉트 주소
				.failureUrl("/LoginError") // 로그인 안될때 갈 곳
			.and()
				.logout()
				.logoutSuccessUrl("/login") // 로그아웃 성공시 리다이렉트 주소
				.invalidateHttpSession(true); // 세션날리기
				//보안 검증은 formLogin 방식	
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}
}
