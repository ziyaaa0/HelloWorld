package com.yedam.methods;

public class StudentExe {
	public static void main(String[] args) {
		Student s1 = new Student(001);
		
		s1.setStudentName("홍길동");
		s1.setEngScore(70);
		s1.setMathScore(75);
		
		System.out.println(s1.showInfo());
		
		
		
		
		s1.setEngScore(1000);
		System.out.println(s1.getStudentNum());
		System.out.println(s1.getEngScore());
	}
}
