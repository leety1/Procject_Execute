package com.example.demo.pay.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Exchange {
    public enum EXCHANGE_TYPE{
        PAYMENT, SEND
    }

    private long paymentId; 		 // 자동으로 생성할 id
    private EXCHANGE_TYPE exchangeType;  // 결제인지 송금인지
    private String myId;    		 // 나의 id
    private String otherId; 		 // PAYMENT이면 가게 id, SEND이면 유저 id
    private long money;     		 // 음수이면 송금, 양수이면 받음
    private LocalDateTime exchangeDate;	 // 거래일자
    private boolean isComplete;		 // 상대방이 송금을 받았는지
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public EXCHANGE_TYPE getExchangeType() {
		return exchangeType;
	}
	public void setExchangeType(EXCHANGE_TYPE exchangeType) {
		this.exchangeType = exchangeType;
	}
	public String getMyId() {
		return myId;
	}
	public void setMyId(String myId) {
		this.myId = myId;
	}
	public String getOtherId() {
		return otherId;
	}
	public void setOtherId(String otherId) {
		this.otherId = otherId;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	public LocalDateTime getExchangeDate() {
		return exchangeDate;
	}
	public void setExchangeDate(LocalDateTime exchangeDate) {
		this.exchangeDate = exchangeDate;
	}
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
    
    
}
