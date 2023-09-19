package com.human.service;

import java.util.List;

import com.human.domain.Manager;

public interface ManagerService {
	
	public List<Manager> getManagerList() throws Exception;
	
	// 관리자 개인 정보 보기
	public Manager getManagerOne(int id) throws Exception;

}
