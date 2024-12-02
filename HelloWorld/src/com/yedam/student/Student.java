package com.yedam.student;

public class Student { //필드
	public int studentNum; // 학생번호
	public String studentName; // 학생이름
	public int engScore; // 영어점수
	public int mathScore; // 수학점수

	//컴파일러가 기본 생성자를 만들어준다.
	public Student() {};
	
	public Student (int studentNum) {
		this.studentNum = studentNum;
	}
	public Student (int studentNum, String studentName ) {
		this.studentNum = studentNum;
		this.studentName = studentName;
	}
	
	public Student(int studentNum, String studentName, int engScore, int mathScore) {
		this.studentNum = studentNum;
		this.studentName = studentName;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}
	
	
	
	//메소드
	public void smile() {
		System.out.println("학생이 웃습니다.");
	}
	
	public void introduce() {
		System.out.println("이름은 " + studentName + "학번은" + studentNum );
	}
	
	public int sumScore() {
		return engScore + mathScore;
	}
	public double avgScore() {
		return (engScore + mathScore)/2.0;
	}

}