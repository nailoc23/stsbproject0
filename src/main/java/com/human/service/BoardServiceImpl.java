package com.human.service;

import java.util.Date;
import java.util.List;
import java.io.File;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.human.domain.Board;
import com.human.domain.Files;
import com.human.mapper.BoardMapper;
import com.human.mapper.FilesMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	// application.properties
	@Value("${upload.path}")
	private String uploadPath;
	
	@Autowired
	BoardMapper boardmapper;
	
	@Autowired
	FilesMapper filesmapper;

	@Override
	public List<Board> getBoardList(int page) throws Exception {
		// TODO Auto-generated method stub
		List<Board> list = boardmapper.selectBoardList(page);
		
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
		int rst = boardmapper.insertBoard(board);  // 게시판 글등록
		
		if(rst == 0) return rst; // 게시판 등록 실패라면 아래 코드는 실행하지 않음
		
		// 파일업로드 
		MultipartFile[] files = board.getFiles();
		
		// 동시접속자 수가 많아서 게시판이 거의 동시에 올라올 수 있다면
		// 게시판 번호를 다시 가져올 수도 있음
		
		if(files.length > 0) {
			
			for( MultipartFile file : files ) {
				
				if(file.getSize() > 0 ) {
				
					byte[] fileData = file.getBytes();   // 첨부파일 데이터
					
					// 오리지널 파일명
					String originFileName = file.getOriginalFilename();
					// 새로운 파일명으로 저장 : 날짜명_파일명으로 새파일 생성 20201023123010_파일명
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
					long currentTime = System.currentTimeMillis();
					String newFileName = sdf.format(new Date(currentTime)) + "_" + originFileName;
					
					// 파일업로드
					File uploadFile = new File(uploadPath, newFileName);
					FileCopyUtils.copy(fileData, uploadFile);     
					
					// bo_notice_file 테이블에 파일정보를 저장
					Files upfiles = new Files();  // DTO
					upfiles.setFilename(originFileName);
					upfiles.setFilepath(uploadPath + "/" + newFileName);
					
					filesmapper.insertFiles(upfiles);
				}
								
			}
		}
		
		
		
		return rst;
	}

	@Override
	public Files getFilesList(int bno) throws Exception {
		// TODO Auto-generated method stub
		Files downFiles = filesmapper.selectFilesList(bno);
		return downFiles;
	}

}
