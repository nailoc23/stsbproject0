package com.human.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.human.domain.CafeObj;
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
	
	
	@GetMapping("/exp5")
	public String exp5(Model model) {
		
		String name = "박대용";
		int age = 30;
		
		model.addAttribute("memname", name);
		model.addAttribute("memage", age);
		
		return "chap3/exp5";
	}
	
	@GetMapping("/control1")
	public String control1(Model model) {
		
		int result = 124;
		boolean check = (result%2==0);  // 논리값 true
		
		model.addAttribute("num", result);
		model.addAttribute("chk", check);
		
		return "chap3/control1";
	}
	
	@GetMapping("/control2")
	public String control2(Model model) {
		
		String result = "여자"; // 여자
		boolean check = (result=="남자");  // 남자면 true
		
		model.addAttribute("gender", result);
		model.addAttribute("chk", check);
		
		return "chap3/control2";
	}
	
	@GetMapping("/switch1")
	public String switch1(Model model) {
				
		String grade = "A"; // A, B, C, D
		
		model.addAttribute("gd", grade);
		
		return "chap3/switch1";
	}
	
	@GetMapping("/switch2")
	public String switch2(Model model) {
	// 구슬놀이 어치1 니2 삼0 (10)
	// 숫자를 3으로 나눠서 나머지 0, 나머지 1, 나머지 2
		return "chap3/switch2";
	}
	
	@GetMapping("/foreach1")
	public String foreach1(Model model) {
		
		List<String> list = new ArrayList<String>();
		list.add("아메리카노");
		list.add("카페라떼");
		list.add("콜드블루");
		list.add("큐브라떼");
		
		// 재고량 100 50 0 10 재고량 컬럼에 : 0 이면 품절 출력
		List<CafeObj> myCafe = new ArrayList<CafeObj>();
		myCafe.add( new CafeObj("아메리카노", 2500) );
		myCafe.add( new CafeObj("카페라떼", 3000) );
		myCafe.add( new CafeObj("콜드블루", 3500) );
		myCafe.add( new CafeObj("큐브라떼", 4200) );
	
		model.addAttribute("coffees", list);
		model.addAttribute("cafes", myCafe);
		
		return "chap3/foreach1";
	}
}
