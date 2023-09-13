package com.human.domain;

public class DataObj { // 사용자 정보 객체 가정
	
	public int id;
	//public String name;
	private String name;
	
	// 객체 생성시 초기값 설정 Constructor(생성자)
	public DataObj(int id, String name) {
		super(); 		// 클래스 최고상위클래스
		this.id = id;
		this.name = name;
	}
	
	// name 멤버변수가 접근안됨으로 getter setter 이용
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
