package com.yedam.variable;

public class IntExe4 {
	public static void main(String[] args) {
		String msg = new String("Hello, World"); //msg 주소값에 문자객체의 주소.
		int age = 10; //age 주소값에 10의 값.
		
		int myAge = age;
		myAge = 20;
		
		System.out.println("age=>" + age + " myAge =>" + myAge);
		System.out.println(msg.equals("Hello, World")); //문자값을 비교할땐 equals 사용
	}
}
