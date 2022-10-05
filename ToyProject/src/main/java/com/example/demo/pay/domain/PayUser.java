package com.example.demo.pay.domain;

import lombok.*;
import java.util.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayUser {
	public enum ChargeMethod{
		CARD, BANK_ACCOUNT
	}
	private String userId;
	private String email;
	private Set<ChargeMethod> chargeMethods;
	private Set<String> cardCompanyNames;
	private Set<String> bankCompanyNames;
	private long payMoney;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<ChargeMethod> getChargeMethods() {
		return chargeMethods;
	}
	public void setChargeMethods(Set<ChargeMethod> chargeMethods) {
		this.chargeMethods = chargeMethods;
	}
	public Set<String> getCardCompanyNames() {
		return cardCompanyNames;
	}
	public void setCardCompanyNames(Set<String> cardCompanyNames) {
		this.cardCompanyNames = cardCompanyNames;
	}
	public Set<String> getBankCompanyNames() {
		return bankCompanyNames;
	}
	public void setBankCompanyNames(Set<String> bankCompanyNames) {
		this.bankCompanyNames = bankCompanyNames;
	}
	public long getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(long payMoney) {
		this.payMoney = payMoney;
	}
	
}
