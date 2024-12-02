package com.yedam.methods;

public class Student { // 필드
	private int studentNum; // 학생번호
	private String studentName; // 학생이름
	private int engScore; // 영어점수
	private int mathScore; // 수학점수
	
	// 생성자.
	public Student(int studentNum) {
		this.studentNum = studentNum;
	}
	public Student(int studentNum, String studentName, int engScore, int mathScore) {

		this.studentNum = studentNum;
		this.studentName = studentName;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}

	
	//getter  setter  메소드
	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	// showInfo()
	public String showInfo() {
		return "학번: " + studentNum + ", 이름: " + studentName + ", 영어: " + engScore + ", 수학: " + mathScore;
	}

	
}