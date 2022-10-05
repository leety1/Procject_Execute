package com.example.demo.DTO;


import java.util.Date;
import lombok.Data;
@Data
public class KakaoPayReadyVDTO {
	//response
    private String tid, next_redirect_pc_url;
    private Date created_at;
}
