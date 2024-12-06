package com.yedam.jdbc.student;

import java.util.ArrayList;

public class TestExe {
	public static void main(String[] args) {
		//검색조건
		Search search = new Search();
		search.setName("박");
		search.setPhone("11");
		search.setEngScore(70);
		search.setOrderBy("std_no");
		
		
		StudentDAO sdao = new StudentDAO();
		ArrayList<Student> list = sdao.studentList(search);
		
		for(Student std : list) {
			System.out.println(std.showInfo());
		}
	
	}
}
