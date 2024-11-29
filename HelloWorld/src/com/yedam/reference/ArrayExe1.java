package com.yedam.reference;

public class ArrayExe1 {
	public static void main(String[] args) {
		int[] intAry = new int[5]; // 데이터 타입 맞워야함. 5개의 정수를 담을 수 있는 배열
		// 위치 => 인덱스
		intAry[0] = 10; // intAry = 10 <= 불가능함(타입이 달라서)
		intAry[1] = 20;

		// 크기(length)
		System.out.println(intAry.length);
		for (int i = 0; i < intAry.length; i++) {
			System.out.println("i의 값:" + i + ", 변수값:" + intAry[i]);
		}
		//배열의 크기를 초과해서 값을 지정하면 에러남
		
		double[] dblAry = {2.5, 1.2, 4, 5.6}; //초기값 지정 선언.
		dblAry[2] = 9.9;
		
		dblAry = new double[] {2.3, 6.7}; //새로운 배열 값 넣을때 new 붙임.
		for (int i = 0; i < dblAry.length; i++) {
			System.out.println("i의 값:" + i + ", 변수값:" + dblAry[i]);
		}
		
		//문자열 배열
		String[] strAry = {"홍길동", "김민섭", "박창규"};
		// enhanced for.
		for(String str : strAry) {
			System.out.println(str);
		}
	}
}
