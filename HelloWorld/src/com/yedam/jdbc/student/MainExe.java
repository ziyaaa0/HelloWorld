package com.yedam.jdbc.student;

import java.util.ArrayList;
import java.util.Scanner;

public class MainExe {
//	private static final int escore = 0;
//	private static final int mscore = 0;

	static Scanner scn = new Scanner(System.in);

	// db 처리기능
	static StudentDAO dao = new StudentDAO();

	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			
			//로그인 기능 
			System.out.println("ID 입력>> ");
			String id = scn.nextLine();
			System.out.println("PW 입력>> ");
			String pw = scn.nextLine();
			
			String name = dao.login(id,pw);
			
			if(name != null) {
				System.out.println( name + " 로그인 ");
				break;
			}else {
				System.out.println(" 로그인 실패 ");
			}
			
		}
		
		while (run) {
			System.out.println("1.목록 2.등록 3.점수등록 4.상세조회 9.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {

			case 1: // 목록
				list();
				break;

			case 2: // 등록
				System.out.println("학생번호 입력>> ");
				String no = scn.nextLine();
				System.out.println("학생이름 입력>> ");
				String name = scn.nextLine();
				System.out.println("연락처 입력>> ");
				String phone = scn.nextLine();

				Student std = new Student(no, name, phone);

				if (dao.insertStudent(std)) {
					System.out.println("정상등록.");
				} else {
					System.out.println("등록 실패.");
				}
				break;

			case 3: // 점수 등록
				System.out.println("학생번호 입력>> ");
				no = scn.nextLine();
				System.out.println("영어점수 입력>> ");
				int escore = Integer.parseInt(scn.nextLine());
				System.out.println("수학점수 입력>> ");
				int mscore = Integer.parseInt(scn.nextLine());

				std = new Student(no, escore, mscore);

				if (dao.updateStudent(std)) {
					System.out.println("정상등록.");
				} else {
					System.out.println("등록 실패.");
				}
				break;

			case 4:
				System.out.println("학생번호 입력>> ");
				no = scn.nextLine();

				std = dao.selectStudent(no); // Student 값 반환
				if (std == null) {
					System.out.println("조회된 결과 없습니다.");
					break;
				}
				System.out.println(std.showDetail()); // 상세출력
				break;

			case 9:
				run = false;
				break;
			}
		}
		System.out.println("end of prog.");
	} // end of main

	// 목록기능.
	public static void list() {
		Search search = new Search();
		
		System.out.println("1.학생이름 2.연락처 3.영어");
		System.out.print("선택>> ");
		int menu = Integer.parseInt(scn.nextLine());

		switch (menu) {
		case 1:
			System.out.println("검색할 이름>> ");
			String name = scn.nextLine();
			
			search.setName(name);
			break;
			
		case 2:
			System.out.print("검색할 연락처>> ");
			String phone = scn.nextLine();
			search.setPhone(phone);
						
			break;
			
		case 3:
			System.out.print("검색할 영어점수>> ");
			int escore = Integer.parseInt(scn.nextLine());
			search.setEngScore(escore);
			break;
			
		}// end of switch
		
		System.out.println("1.학생번호정렬 2.학생이름정렬");
		System.out.println("선택>> ");
		
		switch(menu) {
		case 1:
			search.setOrderBy("std_no");
			break;
			
			
		case 2:
			search.setOrderBy("std_name");
			break;
		}

			
		
		
		ArrayList<Student> list = dao.studentList(search);
		for (Student stud : list) { // 학생번호, 이름, 연락처
			System.out.println(stud.showInfo());
		}
		
	} //end of list()

}
