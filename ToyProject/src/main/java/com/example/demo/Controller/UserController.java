package com.example.demo.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.LoginData.signUp.UserDTO;
import com.example.demo.dao.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {
	
	private UserService service;
	
	@PostMapping("/user")
	public String signup(UserDTO infoDTO) {
		service.save(infoDTO);
		return "redirect:/login";
	}
	
	@GetMapping(value = "/logout")
	public String logoutPage(HttpServletRequest rqst, HttpServletResponse res) {
		new SecurityContextLogoutHandler().logout(rqst, res, SecurityContextHolder.getContext().getAuthentication());
		return "redirect:/login";
	}
}
