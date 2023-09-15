package com.human.service;

import java.util.List;

import com.human.domain.CafeObj;

public interface MyDataService {
	
	public String getStringData(); // { } 없음
	public List<String> getStringList(); // { } 없음
	public List<CafeObj> getCafeObjList(String[] selmenu); // { } 없음

}
