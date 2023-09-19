package com.human.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.human.domain.Manager;
import com.human.service.ManagerService;

@Controller
public class ManagerController {
	
	@Autowired
	ManagerService managersv;
	
	@GetMapping("/mnglist")
	public String mnglist(Model model) throws Exception {
		
		List<Manager> listResult = managersv.getManagerList();
		
		//System.out.println("총갯수는: " + listResult.size());
		
		model.addAttribute("list", listResult);
		
		return "chap4/mnglist";
	}
	
	@GetMapping(path="/mngview", params="id")
	public String mngview(Model model, int id) throws Exception {
		
		Manager result = managersv.getManagerOne(id);
		model.addAttribute("mid", id);
		model.addAttribute("manager", result);
		
		return "chap4/mngview";
	}
	
	@GetMapping("/mngreg")
	public String mngregForm() {
		
		return "chap4/mngregForm";
	}
	
	@PostMapping(path="/mngreg") 
	public String mngreg(Manager manager) { // 등록한 후에 화면 대신 페이지 이동 mnglist 
		
		System.out.println("입력한아이디: " + manager.getId());
		System.out.println("입력한비밀번호: " + manager.getPwd());
		System.out.println("입력한이름: " + manager.getName());
		System.out.println("입력한폰번호: " + manager.getPhone());
		
		return "redirect:/mnglist";
	}
	
	

}
