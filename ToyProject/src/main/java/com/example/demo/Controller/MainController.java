package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.DTO.OrderItemDTO;
import com.example.demo.DTO.TestVo;
import com.example.demo.Mappers.OrderMapper;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name","Thymeleaf");
		System.out.println(model+"==============");
		return "hello";
	}
	@RequestMapping("/{num}")
	public String index(@PathVariable int num,Model md) {
		int rs = num;
		md.addAttribute("msg","num : " + rs);
		return "index";
	}
	@Autowired
	private OrderMapper orderDao;
	
	@RequestMapping(value = "/test")
	public ModelAndView test() throws Exception{
	    ModelAndView mav = new ModelAndView("test");
	    
	    List<OrderItemDTO> testList = orderDao.selectTest();
	    mav.addObject("list", testList);

	    return mav;
	}
	@GetMapping("user/list")
	public @ResponseBody List<TestVo> getUserList() throws Exception {
		
		return orderDao.selectTest2();
	}
}
