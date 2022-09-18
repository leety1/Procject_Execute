package com.example.demo.Order;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.*;
import com.example.demo.DTO.OrderItemDTO;
import com.example.demo.dao.OrderQueryBI;
import com.example.demo.dao.orderDAOImpl;

import java.util.*;

import javax.annotation.Resource;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.OrderItemDTO;
import com.example.demo.Order.OrderMapper;

@RestController
public class OrderWorkflow {
	
	@ResponseBody
    @RequestMapping("/valueTest")
    public String valueTest(){
        String value = "테스트 String";
        return value;
    }
	
	@Autowired
	orderDAOImpl orderService;
	@RequestMapping(value = "/test")
	public ModelAndView test() throws Exception{
	    ModelAndView mv = new ModelAndView("test");

	    List<OrderItemDTO> testList = orderService.selectTest();
	    mv.addObject("list", testList);

	    return mv;
	}
}
