package com.yedam.api;

import java.util.Date;

public class StringTest {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}

	static void test1() {
		// 현재 시간을 yyyy/MM/dd hh:mm:ss 로 출력.
		Date now = new Date();
		answer1(now);
	}

	static void answer1(Date today) {
		System.out.println((today.getYear() + 1900) + "/" + (today.getMonth() + 1) + "/" + today.getDate() + "  "
				+ today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds());
	}

	static void test2() {
		// 주민번호를 받아서 성별을 구별하는 프로그램.
		String[] numbers = { "9501231234567", "950405 2345678", "980102-1345678" };
						
		for (int i = 0; i < numbers.length; i++) {
			
			System.out.println(numbers[i] + "번호 는 " + answer2(numbers[i]));
		}
	}
	
	static String answer2(String ssn) {
		
		int num = ssn.length() - 7; //6
		
		switch (ssn.charAt(num)) {
		case '1':
			return "남자";
		case '2':
			return "여자";
		default:
		return "알수없음";
		}
	}

	static void test3() {
		// 파일의 이름과 확장자를 구하는 코드.
		String[] files = { "c:/temp/rose.jpg", "d:/download/new.txt", "temp/good.jpeg" };
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i] + " 파일명 확장자 : " + answer3(files[i]));
		}
	}

	static String answer3(String name) {
		int Pos = name.indexOf(".");
//		int endPos = name.indexOf(".");
//		int startPos = name.lastIndexOf("/");
//		String ext = name.substring(startPos + 1, endPos);
		String ext = name.substring(Pos);
		return ext;
	}
}
