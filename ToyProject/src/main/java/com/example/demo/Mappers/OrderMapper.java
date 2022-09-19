package com.example.demo.Mappers;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.demo.DTO.OrderItemDTO;

@Repository(value="Mappers")
@Mapper
public interface OrderMapper{
	List<OrderItemDTO> selectTest() throws Exception;
}
