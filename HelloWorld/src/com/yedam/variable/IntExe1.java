package com.yedam.variable;
// 파일이름.java => 클래스의 이름은 같아야 됨.

public class IntExe1 {
	public static void main(String[] args) {
		int myAge = 20;
		int yourAge = 23;
		
		int ageSum = myAge + yourAge; // int + int => int
		System.out.println("ageSum의 값: "+ ageSum);
		
		//{10,20,30,} 배열 중괄호
		int[] intAry = {10,20,30}; //배열에 담고
		int sum = intAry[0] + intAry[1] + intAry[2]; //메소드 지정
		System.out.println("intAry의 합: "+ sum); //출력
	}
}
