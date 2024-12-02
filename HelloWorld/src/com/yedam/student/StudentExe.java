package com.yedam.student;

public class StudentExe {
	public static void main(String[] args) {
		Student s1 = new Student(001); 
		//변수 생성   =  new class(); 실체생성(인스턴스 생성)
		s1.studentName = "홍길동";
		s1.engScore = 80;
		s1.mathScore = 70;
		System.out.println(s1.studentNum + ", " + s1.studentName+"의 합계: "+ s1.sumScore() + "의 평균: "+ s1.avgScore());
		
		Student s2 = new Student(002,"홍길동");
		s2.engScore = 90;
		s2.mathScore = 40;
		System.out.println(s2.studentNum + ", " + s2.studentName+"의 합계: "+ s2.sumScore() + "의 평균: "+ s2.avgScore());
		
		Student s3 = new Student(003, "최길동", 80,90);
		System.out.println(s3.studentNum + ", " + s3.studentName  + ", " + s3.engScore + ", " + s3.mathScore);
		
		
		System.out.println(s1 == s2);	
		
		
		
		
		
		int num = 100;
	}
}
