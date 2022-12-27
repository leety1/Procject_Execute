package com.example.demo.dao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.LoginData.UserInfo;
import com.example.demo.LoginData.UserRepository;
import com.example.demo.LoginData.signUp.UserDTO;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
	private UserRepository userRepository;
	private UserInfo userInfo;
	/*
	 * Spring Security 필수 메소드 구현
	 * 
	 * @param email 이메일
	 * 
	 * @return UserDetails
	 * 
	 * @throws UsernameNotFoundException 유저가 없을 때 예외 발생
	 */
	@Override // 기본적인 반환 타입은 UserDetails, UserDetails를 상속받은 UserInfo 반환 타입 지정 (자동으로 다운 캐스팅됨)
	public UserInfo loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
	}
	
	/*
	 * 회원정보 저장
	 * 
	 * @param infoDTO 회원정보 들어있는 DTO
	 * 
	 * @return 저장 PK
	 * 
	 */
	public Long save(UserDTO infoDTO) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		infoDTO.setPassword(encoder.encode(infoDTO.getPassword()));
		Long e_CODE = (long) 500;
		//음 빌더 안떠서 걍 원래 하던데로 해야게따
		return e_CODE;
	 }
}
