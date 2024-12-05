package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExe2 {
	public static void main(String[] args) {
	//	update();
	//	update(300,"zizi","010-1234-1234",10000);
		System.out.println("end of prog.");
	}
	
	//삭제기능.
//	public static void delete(int empId) {
//		Connection conn = getConn();
//
//	}
	
	//수정기능.
	public static void update(Employee emp) {
		Connection conn = getConn();
		String query = "update employees"

				+ "          ?" //last_name
				+ "        , ?" //email
				+ "        , ?" //hire_date
				+ "          ?";
		try {
			PreparedStatement stmt =conn.prepareStatement(query);
			stmt.setString(1, emp.getFirstName());
			stmt.setString(2, emp.getPhoneNumber());
			stmt.setInt(3, emp.getSalary());
			stmt.setInt(4, emp.getEmployeeId());
			int r = stmt.executeUpdate(query);
			System.out.println(r + "건 처리됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 입력기능
	public static void insert(Employee emp) {
		Connection conn = getConn();
		String Query = "insert into employees (employee_id" 
		                       + "           , last_name"
				               + "            , email" 
		                       + "           , hire_date"
				               + "           ,  job_id) "
				+ "values(employees_seq.nextval " //empId
				+ "           , ? " //last_name
				+ "           , ? " //email
				+ "           , ? " //hire_date
				+ "           , ? " ;				
				
		try {
			PreparedStatement stmt = conn.prepareStatement(Query);
			stmt.setString(1, emp.getLastName());
			stmt.setString(2, emp.getEmail());
			stmt.setString(3, emp.getHireDate());
			stmt.setString(4, emp.getJobId());
			
			int r = stmt.executeUpdate(Query);
			System.out.println(r);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 연결.
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// connection 객체
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "hr", "hr");
			return conn;
		} catch (Exception e) {
			System.out.println("연결중 에러");
			e.printStackTrace();
		}
		return conn;
	}

	// 조회기능
	public static void select() {

		Connection conn = getConn();

		// sql 작성 Statement 객체
		Statement stmt;
		try {
			stmt = conn.createStatement(0, 0);
			ResultSet rs = stmt.executeQuery("select * from employees order by employee_id desc"); // 조회하는 쿼리

			while (rs.next()) {
				System.out.println(
						rs.getInt("employee_id") + ", " + rs.getString("first_name") + ", " + rs.getString("email"));
			}
			conn.close(); // 연결 해제

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("== end of data ==");
	}

}
