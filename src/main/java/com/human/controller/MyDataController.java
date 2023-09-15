package com.human.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.human.domain.CafeObj;
import com.human.service.MyDataService;

@Controller
public class MyDataController {
	
	@Autowired
	MyDataService mydatasv;
	
	@GetMapping("/mycafelist")
	public String mycafelist(Model model) {
		
		List<String> result = mydatasv.getStringList();
		
		model.addAttribute("cafelist", result);
		return "chap4/mycafelist";
	}
	
	@GetMapping("/formcafe")
	public String formcafe(Model model) {
		return "chap4/formcafe";		
	}
	
	@PostMapping("/cafepro")
	public String cafepro(@RequestParam(value="mycafe") String[] selmenu, 
			Model model) {
		
		int size = selmenu.length;
		List<CafeObj> result = mydatasv.getCafeObjList(selmenu);
		
		model.addAttribute("selcnt", size);
		model.addAttribute("sellist", result);
		
		return "chap4/cafepro";		
	}

}
