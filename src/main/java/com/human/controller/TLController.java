package com.human.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.human.domain.DataObj;

@Controller
public class TLController {
	
	@GetMapping("/timeleaf")
	public String timeleaf(Model model) {
		
		String message = "안녕하세요 방가방가";
		
		model.addAttribute("msg", message);
		
		return "chap3/timeleaf";   // .html은 생략가능
	}
	
	@GetMapping("/exp1")            // method="GET" URL뒤에 파라미터 추가
	public String exp1(Model model) {          // 여러개 파라미터는  & 로 구분해서 추가
		
		String result = "처리된 수";
		
		model.addAttribute("localdttm", LocalDateTime.now());
		model.addAttribute("rst", result);
		return "chap3/exp1"; 		// .html은 생략가능
	}
	
	@GetMapping("/exp2")            // method="GET" URL뒤에 파라미터 추가
	public String exp2(Model model) {          // 여러개 파라미터는  & 로 구분해서 추가
	
		
		return "chap3/exp2";
	}
	
	@GetMapping("/exp3")
	public String exp3(Model model) {
		
		
		return "chap3/exp3";
	}
	
	@GetMapping("/exp4")
	public String exp4(Model model) {
		
		
		DataObj friend = new DataObj(1000, "박대용");
		
		System.out.println(friend);
		
		model.addAttribute("object", friend);
		
		return "chap3/exp4";
	}

}
