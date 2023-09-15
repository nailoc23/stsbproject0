package com.human.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.human.service.MyDataService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping("/hello") // HTTP GET 요청처리
	@ResponseBody
	public String hello() {
		return "Hello Home Control Another Text Change !";
	}

	@GetMapping("/csstest") // HTTP GET 요청처리
	public String csstest() {
		return "csstest";
	}
	
	@GetMapping("/webview") // HTTP GET 요청처리
	public String webview() {
		return "webview";   // html화면
	}
	
	@Autowired
	MyDataService mydatasv;
		
	@GetMapping("/mydata") // HTTP GET 요청처리
	public String mydata(Model model) {
		
		String testResult = mydatasv.getStringData();
		model.addAttribute("result", testResult);
		return "chap4/mydata";   // html화면
	}

}
