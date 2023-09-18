package com.human.mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManagerDao {
	
	public static String user = "jsp";
	public static String passwd = "123456";
	public static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	
	public static Connection conn = null;
	public static Statement stmt = null;
	public static PreparedStatement pstmt = null;
	public static PreparedStatement pstmt2 = null;
	public static ResultSet rs = null;
	
	public void getConnect() {		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, passwd);			
		}catch(Exception e) {
			System.out.println("오라클접속에러: " + e.getMessage());
		}
	}
	
	public String getList() {
		
		String sql = "SELECT * FROM manager";
		return null;
	}

}
