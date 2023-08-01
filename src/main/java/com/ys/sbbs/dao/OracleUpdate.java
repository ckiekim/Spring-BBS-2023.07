package com.ys.sbbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class OracleUpdate {

	public static void main(String[] args) throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";		// XEPDB1
		String username = "ysuser";
		String password = "yspass";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement stmt = conn.createStatement();
		
		String sql = "update board set modTime=CURRENT_TIMESTAMP where bid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 1006);
		pstmt.executeUpdate();
//		conn.commit();		// 자동 커밋이 설정되어 있지 않을 경우
		
		pstmt.close(); conn.close();
	}

}
