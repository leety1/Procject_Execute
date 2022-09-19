package com.example.demo.Mappers;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.DTO.OrderItemDTO;
import com.example.demo.DTO.TestVo;

@Mapper
public interface OrderMapper{
	@Select("SELECT TO_CHAR(SYSDATE, 'yyyy-mm-dd') FROM DUAL")
	public String selectNow();
	
	public List<OrderItemDTO> selectTest() throws Exception;
	public List<TestVo> selectTest2() throws Exception;
}
