package com.human.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.human.domain.Files;

@Mapper
public interface FilesMapper {
	
	public int insertFiles(Files upfiles) throws Exception;
	
	public Files selectFilesList(int bno) throws Exception;

}
