package com.example.demo.LoginData;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.LoginData.signUp.UserDTO;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
	Optional<UserInfo> findByEmail(String email);
	UserDTO save(UserDTO infoDTO);
}
