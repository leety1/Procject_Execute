package com.example.demo.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.OrderItemDTO;
import com.example.demo.Order.OrderMapper;

@Service
public class orderDAOImpl {
	
	@Autowired
    public OrderMapper mapper;
	
	public List<OrderItemDTO> selectTest() throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectTest();
	}


}
