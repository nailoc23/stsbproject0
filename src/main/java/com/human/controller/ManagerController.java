package com.human.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.human.domain.Manager;
import com.human.service.ManagerService;

@Controller
public class ManagerController {
	
	@Autowired
	ManagerService managersv;
	
	@GetMapping("/mnglist")
	public String mnglist(Model model) throws Exception {
		
		List<Manager> listResult = managersv.getManagerList();
		
		System.out.println("총갯수는: " + listResult.size());
		
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

}
