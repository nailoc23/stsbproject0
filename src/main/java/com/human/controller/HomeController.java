package com.human.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping("/hello") // HTTP GET 요청처리
	@ResponseBody
	public String hello() {
		return "Hello Home Control Sample Text";
	}

	@GetMapping("/csstest") // HTTP GET 요청처리
	public String csstest() {
		return "csstest";
	}
	
	@GetMapping("/webview") // HTTP GET 요청처리
	public String webview() {
		return "webview";   // html화면
	}
	
	

}
