package com.human.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.human.domain.Board;
import com.human.domain.Files;
import com.human.domain.Page;
import com.human.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardsv;
	
	@GetMapping(path="/list", params="page")
	public String list(Model model, int page) throws Exception {
		
		List<Board> resultList = boardsv.getBoardList(page);
		int result = boardsv.getTotalBoard();
		Page pageObj = new Page();      // 기본값 설정됨
		pageObj.setTotalCount(result);  // 전체 갯수 설정
		pageObj.paging();               // 변수 계산 처리
		//int pagetotal = result / 10;
		//if(result%10!=0) pagetotal++;
		
		//System.out.println("총 목록갯수: " + resultList.size());
		
		model.addAttribute("list", resultList);
		//model.addAttribute("total", result);
		//model.addAttribute("pagecnt", pagetotal);
		model.addAttribute("pageObj", pageObj);
		model.addAttribute("page", page);
		
		return "chap5/list";
	}
	
	@GetMapping(path="/read", params="no")
	public String read(Model model, int no) throws Exception {
		
		//System.out.println("글번호: " + no);
		Board result = boardsv.readBoardOne(no);
		
		int bno = no;
		Files downFiles = boardsv.getFilesList(bno);  // 첨부파일 한개
				
		int upHit = boardsv.incBoardHit(no); // upHit 특별히 사용하지 않아도 됨
		model.addAttribute("board", result);
		model.addAttribute("hit", upHit);    // 출력하지 않음
		model.addAttribute("down", downFiles);
		
		return "chap5/read";
	}
	
	@GetMapping(path="/delete", params="no")
	public String delete(int no) throws Exception {
		
		//System.out.println("삭제할 게시물번호: " + no);
		
		int result = boardsv.removeBoard(no);
		System.out.println("삭제결과: " + result);
		return "redirect:/list";
	}
	
	@GetMapping("/write")
	public String writeForm(Model model) throws Exception {
		
		
		return "chap5/write";
	}
	
	@PostMapping("/write")
	public String write(Board board) throws Exception {
		
		
		System.out.println("작성자: " + board.getWriter()); 
		System.out.println("제목: " + board.getSubject()); 
		System.out.println("글내용: " + board.getContent());
		
		MultipartFile[] files = board.getFiles();   // 배열저장
		
		if(files != null ) {
			
			for(MultipartFile file : files) {
				
				System.out.println("파일명: " + file.getOriginalFilename());
				
			}
		}
		 
		int result = boardsv.regBoard(board);
		
		return "redirect:/list";
	}
	
	// 첨부파일 링크 다운로드
	@GetMapping("/download/{fno}")
	@ResponseBody
	public String fileDownload(@PathVariable("fno") int fno) throws Exception {
		
		System.out.println("파일번호: " + fno);
		
		return "파일다운로드";
				
	}
	
}
