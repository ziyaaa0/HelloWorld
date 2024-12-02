package com.yedam.classes;

import com.yedam.student.Student;

public class CalculatorExe {
	public static void main(String[] args) {

		Calculator cal1 = new Calculator(); //인스턴스 생성.
		int sum = cal1.sum(10, 20);
		
		
		System.out.println("합계: " + cal1.sum(10, 20));
		System.out.println("합계: " + cal1.sum(10.3, 20));
		System.out.println("최대값: " + cal1.max(10.3, 20));
		cal1.printStar(10);
		
		
		
		
		int[] intAry = {3,6,9,12};
		sum = cal1.sumAry(intAry); //리턴값 int, 매개변수 정수배열;
		System.out.println("intAry 합: "+ sum);
		
		double result = cal1.averageAry(intAry);
		System.out.println("intAry 평균: "+ result);
		
		Student s1 = new Student(001,"홍길동",85,90);
		Student s2 = new Student(002,"최길동",75,96);
		Student s3 = new Student(003,"고길동",80,88);
		
		Student[] stdAry = { s1,s2,s3 };
		Student std = cal1.getMaxScore(stdAry);
		System.out.println("최고영어점수는 " + std.engScore + " 이름: " + std.studentName);
	}
}
