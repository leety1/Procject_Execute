package com.example.demo.LoginData;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
//import org.hibernate.annotations.CreationTimestamp;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Data
public class UserInfo implements UserDetails {
	
	@Id
	@Column(name = "code")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code; //key
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	private String role;
	
	@Builder(toBuilder = true)
	public UserInfo(String email, String password, String role) {
		this.email = email;
		this.password = password;
		this.role = role;
	}
	//사용자의 권한을 콜렉션 형태로 반환
	//클래스 자료형은 GrantedAuthority를 구현해야함
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> roles = new HashSet();
		
		for(String rol : role.split(",")) roles.add(new SimpleGrantedAuthority(rol));
		
		return roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// 만료되었는지 확인하는 로직
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// 계정 잠금 여부
		return true; // 잠금 안됌  => true
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// 패스워드 만료 확인 로직
		return true; // true -> 만료 x
	}

	@Override
	public boolean isEnabled() {
		// 계정이 사용 가능한지 확인
		return true; // 사용가능
	}
	
}
