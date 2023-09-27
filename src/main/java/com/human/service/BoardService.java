package com.human.service;

import java.util.List;

import com.human.domain.Board;
import com.human.domain.Files;

public interface BoardService {
	
	// 게시판 목록 가져오기 (로직)
	public List<Board> getBoardList(int page) throws Exception;
	
	// 게시판 총 갯수 
	public int getTotalBoard() throws Exception;
	
	// 게시판 글읽기
	public Board readBoardOne(int no) throws Exception;	
	// 첨부파일 목록 가져오기 
	public Files getFilesList(int bno) throws Exception;
	
	// 게시판 조회수 증가
	public int incBoardHit(int no) throws Exception;
	
	// 게시글 삭제
	public int removeBoard(int no) throws Exception;
	
	// 게시글 등록하기
	public int regBoard(Board board) throws Exception;

}
