package com.example.demo.dao;
import org.apache.ibatis.annotations.Mapper;

import com.example.demo.DTO.*;

import java.util.*;


public interface OrderQueryBI {
	public List<OrderItemDTO> selectTest() throws Exception;
}
