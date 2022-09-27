package com.example.demo.dao;
import java.util.ArrayList;
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
	public List<TestVo> createTest() throws Exception{
		List<TestVo> l = new ArrayList<TestVo>();	
		System.err.println(l.get(0)+"WHAT_THE_HELL"+l.get(1));
		return mapper.create(l);
	}
	
	public void insert() throws Exception{
		TestVo tvo = new TestVo();
		System.out.println(tvo.getId()+"===="+tvo.getName());
		mapper.insert(tvo.getId(), tvo.getName());
	}

}
