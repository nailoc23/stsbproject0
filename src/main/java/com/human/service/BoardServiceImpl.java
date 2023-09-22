package com.human.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.domain.Board;
import com.human.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardMapper boardmapper;

	@Override
	public List<Board> getBoardList() throws Exception {
		// TODO Auto-generated method stub
		List<Board> list = boardmapper.selectBoardList();
		
		return list;
	}

	@Override
	public int getTotalBoard() throws Exception {
		// TODO Auto-generated method stub
		int rst = boardmapper.selectTotalBoard();
		return rst;
	}

	@Override
	public Board readBoardOne(int no) throws Exception {
		// TODO Auto-generated method stub		
		Board rst = boardmapper.selectBoardOne(no);
		return rst;
	}

	@Override
	public int incBoardHit(int no) throws Exception {
		// TODO Auto-generated method stub\
		int rst = boardmapper.updateBoardHit(no);
		return rst;
	}

	@Override
	public int removeBoard(int no) throws Exception {
		// TODO Auto-generated method stub
		int rst = boardmapper.deleteBoardOne(no);
		return rst;
	}

	@Override
	public int regBoard(Board board) throws Exception {
		// TODO Auto-generated method stub
		int rst = boardmapper.insertBoard(board);
		return rst;
	}

}
