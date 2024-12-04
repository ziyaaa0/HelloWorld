package com.yedam.api;

public class StringExe {
	public static void main(String[] args) {
		String str = "Hello, World";

		str = "9501231234567";
		char c1 = str.charAt(6);

		switch (c1) {
		case '1':
			System.out.println("남");
			break;
		case '2':
			System.out.println("여");
			break;
		default:
			System.out.println("알수없음");
			break;

		}

		System.out.println(c1 + ", " + (int) c1);
	}
}
