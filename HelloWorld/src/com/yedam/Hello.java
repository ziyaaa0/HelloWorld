package com.yedam;

//대소문자 구분함
//객체지향언어 (Object Oriented Language)
public class Hello {
	
	//메소드 여러개 선언. start(), main();
	
	//main 안에 호출해야 화면에 나타남
	public static void start() {
		System.out.println("시작");
	}
	//메인 메소드.함수(function)
	//main: 가장먼저 시작되게 하는 메소드
	public static void main(String[] args) {
		//콘솔에 Hello,World 출력
		System.out.println("Hello, World");
		start();
		
		//let result = "Hello";
		OperationExe exe = new OperationExe();
		exe.sum(10, 20);
		
		//Hello.java -> Hello.class(실행파일)
		//컴파일: 실행파일로 만드는것 (저장하면 eclipse 컴파일)
		//HelloWorld 프로젝 - HelloWorld repository (두개 연결 시키는거	
 }
} //end of class
