package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
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
}
