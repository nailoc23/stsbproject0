package com.human.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.human.domain.CafeObj;

@Service
public class MyDataServiceImpl implements MyDataService {

	@Override
	public String getStringData() {
		// TODO Auto-generated method stub
		String rst = "My First Service String Data";
		return rst;
	}

	@Override
	public List<String> getStringList() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("이디야");
		list.add("빽다방");
		list.add("메가커피");
		list.add("플라워카페");
		return list;
	}

	@Override
	public List<CafeObj> getCafeObjList(String[] selmenu) {
		// TODO Auto-generated method stub
		List<CafeObj> list = new ArrayList<CafeObj>();
		
		// 가상으로 카페메뉴를 만들어보자
		List<CafeObj> menus = new ArrayList<CafeObj>();
		menus.add(new CafeObj("아메리카노", 2000));
		menus.add(new CafeObj("카페라떼", 2500));
		menus.add(new CafeObj("콜드블루", 3500));
		menus.add(new CafeObj("큐브라떼", 4200));
		
		for(int i=0; i<selmenu.length; i++) {
			
			//System.out.println(selmenu[i]);
			//넘겨온 메뉴들을 검색어
			String searchData = selmenu[i];
			//검색해서 나오는 값을 임시저장
			CafeObj foundData = null;
			
			for(CafeObj menu : menus) {
				if(menu.name.equals(searchData) ) {
					foundData = menu;
					break;  // 검색되면 반복 중지
				}
			}			
			//list에 담아서 목록을 만듬
			list.add(foundData);
		}
		
		return list;
	}

}

// 부모클래스에서 자식클래스 상속을 하려면 Child extend Parent
