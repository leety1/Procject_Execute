package com.example.demo.Controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Base64.Encoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.HttpResponseException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.DTO.OrderItemDTO;
import com.example.demo.DTO.TestVo;
import com.example.demo.Mappers.OrderMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Base64;
@Controller
public class MainController {
	JSONObject jsonData = new JSONObject();
	@Autowired
	private OrderMapper orderDao;
	
	
	@GetMapping("/login")
	public String loginForm() {
		System.out.println("로그인 화면");
		return "login";
	}
	
	@RequestMapping("/index")
	public String index() {
		System.out.println("여긴타냐");
		return "index";
	}
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name","Thymeleaf");
		System.out.println(model+"==============");
		return "hello";
	}
	@GetMapping("/btnToss")
	public String btnToss(Model model) {
		System.out.println(model+"==============");
		return "btnToss";
	}
	@RequestMapping("/{num}")
	public String index(@PathVariable String num,Model md) {
		String rs = num;
		md.addAttribute("msg","num : " + rs);
		return "index";
	}
	Encoder encoder = Base64.getEncoder();
	String Secretkey =  "test_sk_5GePWvyJnrK1JnkYX7O3gLzN97Eo";
	byte[] targetBytes = Secretkey.getBytes();
    byte[] encodedBytes = encoder.encode(targetBytes);
	@RequestMapping(value = "/tossBilling/TOSSindex")
	public ModelAndView TOSS() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/tossBilling/TOSSindex");
	    return mv;
	}
	@RequestMapping(value = "/tossBilling/EnterSucces")
	public ModelAndView BillSuccess(@RequestParam("authKey") String auth,@RequestParam("customerKey") String Key) throws IOException, InterruptedException{
		ModelAndView mv = new ModelAndView();
		try {
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create("https://api.tosspayments.com/v1/billing/authorizations/"+auth))
			    .header("Authorization", "Basic dGVzdF9za181R2VQV3Z5Sm5ySzFKbmtZWDdPM2dMek45N0VvOg==")
			    .header("Content-Type", "application/json")
			    .method("POST", HttpRequest.BodyPublishers.ofString("{\"customerKey\":\"cdDX9vhYcZDc9ow_TiiSy\"}"))
			    .build();
			System.out.println(request.headers()+"=======HEADER=======");
			System.out.println(auth+"=====WEB===="+Key);	
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body()+"\n"+response.statusCode());
			if(response.statusCode()==200) {
				mv.addObject("response",response.body());
				mv.setViewName("/tossBilling/EnterSucces");
				System.out.println(response.body());
				Map<String, Object> param = new ObjectMapper().readValue(response.body(), HashMap.class);
				System.out.println(param+"뿌려지니?");
				param.get("billingKey");
				System.out.println(param.get("billingKey")+"보여주삼");
			}else {
				mv.addObject("code",response.body());
				mv.addObject("message",response.body());
				mv.setViewName("/tossBilling/Fail");
			}
			
		return mv;
		
	}
	
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
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(Model model,HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		TestVo tvo = new TestVo();
		tvo.setId(id);
		tvo.setName(name);
		List<TestVo> list = new ArrayList<TestVo>();
		list.add(tvo);
		System.err.println(tvo.getId()+"WHAT_THE_HOLLY"+tvo.getName());
		//orderDao.create(list);
		orderDao.insert(id,name);
		System.out.println(id+"=====CHECK_THE_STREAM===="+name);
		return "index";	
	}
	
	@PostMapping(value = "/ajaxTest.do")
    public String mapRequest(@RequestBody HashMap<String, Object> param) throws Exception{
        System.out.println("param : " + param);
        return param.toString();
    }
	
}
