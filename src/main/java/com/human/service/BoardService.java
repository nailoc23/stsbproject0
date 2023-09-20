package com.human.service;

import java.util.List;

import com.human.domain.Board;

public interface BoardService {
	
	// 게시판 목록 가져오기 (로직)
	public List<Board> getBoardList() throws Exception;
	
	// 게시판 총 갯수 
	public int getTotalBoard() throws Exception;
	
	// 게시판 글읽기
	public Board readBoardOne(int no) throws Exception;

}
