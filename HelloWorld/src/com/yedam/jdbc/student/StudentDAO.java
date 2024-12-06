package com.yedam.jdbc.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * DAO: Date Access Object
 * 입력, 수정, 삭제, 조회(목록, 단건)
 * 
 */
public class StudentDAO extends DAO {

	// login() => 반환 불린, 매개값: string id pw

	public String login(String id, String pw) {
		getConn();

		String sql = "select * from tbl_member where member_id = ? AND password = ?";
		try {
			psmt = conn.prepareStatement(sql); // 쿼리 실행, 결과 반환.

			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();

			while (rs.next()) {
				return rs.getString("member_name");				

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return null;
	}

	// 상세조회
	// 반환 : Student 클래스, 매개:학생번호, 메소드: selectStudent
	public Student selectStudent(String sno) {
		getConn();
		String sql = "select * from tbl_student where std_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sno); // 파라메타
			rs = psmt.executeQuery();
			while (rs.next()) {
				Student std = new Student(); // 반환할 타입
				std.setStdNo(rs.getString("std_no"));
				std.setStdName(rs.getString("std_name"));
				return std;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	// 점수등록
	public boolean updateStudent(Student std) {

		getConn();

		String sql = "update tbl_student" + "        set eng_score = ?," // last_name
				+ "         math_score = ?" // email

				+ " where std_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, std.getEngScore());
			psmt.setInt(2, std.getMathScore());
			psmt.setString(3, std.getStdNo());

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}

	// 등록. 반환:boolean, 매개:Student, 메소드:insertStudent.
	public boolean insertStudent(Student std) {
		getConn();
		String sql = "insert into tbl_student (std_no" + "                           ,std_name"
				+ "                            ,std_phone)" + " values(?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStdNo());
			psmt.setString(2, std.getStdName());
			psmt.setString(3, std.getStdPhone());
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return false;
	}

	// 학생목록.
	public ArrayList<Student> studentList(Search search) {
		getConn();
		// 조회결과를 반환.
		ArrayList<Student> studList = new ArrayList<Student>();

		String sql = "SELECT std_no, std_name, std_phone, eng_score, math_score,"
		//		+ " TO_CHAR (creation_date, 'yyyy-mm-dd')"
				+ "  creation_date "
				+ " From tbl_student "
				+ " WHERE std_name LIKE '%'||?||'%' "
				+ " AND std_phone LIKE '%'||?||'%' "
				+ " AND eng_score >= ? ";
		// + "ORDER BY std_no";
		if (search.getOrderBy().equals("std_no")) {
			sql += "ORDER BY std_no";
		} else if (search.getOrderBy().equals("std_name")) {
			sql += "ORDER BY std_name";
		}

		try {
			psmt = conn.prepareStatement(sql); // 쿼리 실행, 결과 반환.
			psmt.setString(1, search.getName());
			psmt.setString(2, search.getPhone());
			psmt.setInt(3, search.getEngScore());
			rs = psmt.executeQuery();

			while (rs.next()) {
				Student stud = new Student();
				stud.setStdNo(rs.getString("std_no"));
				stud.setStdName(rs.getString("std_name"));
				stud.setStdPhone(rs.getString("std_phone"));
				stud.setEngScore(rs.getInt("eng_score"));
				stud.setMathScore(rs.getInt("math_score"));
				stud.setCreationDate(rs.getDate("creation_date"));

				studList.add(stud); // ArrayList에 추가.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			disConnect();
		}

		return studList;
	}
}
