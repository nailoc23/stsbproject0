package com.human.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.human.domain.Board;
import com.human.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardsv;
	
	@GetMapping("/list")
	public String list(Model model) throws Exception {
		
		List<Board> resultList = boardsv.getBoardList();
		int result = boardsv.getTotalBoard();
		
		//System.out.println("총 목록갯수: " + resultList.size());
		
		model.addAttribute("list", resultList);
		model.addAttribute("total", result);
		
		return "chap5/list";
	}
	
	@GetMapping(path="/read", params="no")
	public String read(Model model, int no) throws Exception {
		
		//System.out.println("글번호: " + no);
		Board result = boardsv.readBoardOne(no);
		
		model.addAttribute("board", result);
		
		return "chap5/read";
	}
}
