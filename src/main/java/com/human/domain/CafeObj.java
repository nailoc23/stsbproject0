package com.human.domain;

public class CafeObj {
	
	public String name; // 아메카노 등등
	private int price;  // 가격 
	private int inventory; // 재고량
	
	// 초기화하는 생성자
	public CafeObj(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	// 외부 클래스 가격 정보를 수정 및 출력
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

}
