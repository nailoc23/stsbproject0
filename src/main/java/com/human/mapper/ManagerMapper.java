package com.human.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.human.domain.Manager;

@Mapper
public interface ManagerMapper {
	
	//관리자 인원수 쿼리 함수
	public int totalManager() throws Exception;

	//관리지 정보 목록 함수
	public List<Manager> managerList() throws Exception;
	
	//관리자 개인 정보 보기 함수
	public Manager managerSelect(int id) throws Exception;
	
	//관리자 정보 등록 
	public int insertManagerOne(Manager manager) throws Exception;

}
