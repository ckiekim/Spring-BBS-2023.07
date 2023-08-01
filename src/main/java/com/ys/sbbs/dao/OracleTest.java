package com.ys.sbbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleTest {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "ysuser";
		String password = "yspass";

		Connection conn = null;
		try {
			Class.forName(driver);
			System.out.println("jdbc driver 로딩 성공");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("오라클 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패");
		}
		
		/*접속 해제 처리*/
		try {
			conn.close();
			System.out.println("연결 해제");
		} catch (Exception e) {
			System.out.println("해제 오류");
		}
		conn=null;
	}

}
