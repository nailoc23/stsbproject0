package com.human.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {
	
	@GetMapping("/form")
	public String form() {
		
		return "chap2/form";  // form.html 파일명 .html 생략가능
	}
	
	@PostMapping("/formresult")
	public String formresult(HttpServletRequest req, Model model) {
		//폼에서 넘어온 값을 변수 저장 (로직처리 위해)
		String name = req.getParameter("name");
		String mail = req.getParameter("email");
		
		//System.out.println(name + ", " + mail);
		model.addAttribute("memname", name);
		model.addAttribute("memmail", mail);
		
		//폼에서 가져온 데이터를 화면에 출력
		return "chap2/formresult";
	}

}
