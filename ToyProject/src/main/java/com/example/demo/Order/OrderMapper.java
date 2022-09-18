package com.example.demo.Order;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.DTO.OrderItemDTO;

@Repository
@Mapper
public interface OrderMapper {
	List<OrderItemDTO> selectTest();
}
