package com.example.demo.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.OrderItemDTO;
import com.example.demo.DTO.TestVo;
import com.example.demo.Mappers.OrderMapper;

@Service
public class orderDAOImpl {
	
	@Autowired
    public OrderMapper mapper;
	
	public List<OrderItemDTO> selectTest() throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectTest();
	}
	
	public List<TestVo> selectTest2() throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectTest2();
	}


}
