package com.example.demo.LoginData;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
//@Data 난 그냥 게터 세터가 조아 
@AllArgsConstructor
public class TokenInfo {
	private String grantType;
	private String accessToken;
	private String refreshToken;
	public String getGrantType() {
		return grantType;
	}
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
}
