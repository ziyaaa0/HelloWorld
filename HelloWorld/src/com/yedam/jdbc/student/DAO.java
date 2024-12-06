package com.yedam.jdbc.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * db connect, db close.
 * DAO 상속
 */
public class DAO {

	// 쿼리실행을 위한 필드선언.
	Connection conn = null;
	PreparedStatement psmt;
	ResultSet rs;

	// 연결해제
	public void disConnect() {
		try {
			if (conn != null)
				conn.close();
			if (psmt != null)
				psmt.close();
			if (rs != null)
				rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	// 연결
	public Connection getConn() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// connection 객체
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "proj", "proj");

		} catch (Exception e) {
			System.out.println("연결중 에러");
			e.printStackTrace();
		}
		return conn;
	}
}
