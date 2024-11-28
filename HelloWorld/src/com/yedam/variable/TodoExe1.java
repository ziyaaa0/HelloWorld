package com.yedam.variable;

public class TodoExe1 {
	public static void main(String[] args) {
		// Math.random() : 0~1 임의의 실수.
		// 1~100 까지의 임의의 정수 5번
		double n1 = Math.random();
		double n2 = Math.random();
		double n3 = Math.random();
		
//		double sum = n1 + n2 + n3;
//		
//		
//		System.out.println(sum);
		
		int sum = 0;
		
		for(int i=0; i<3; i++) {
			int randomValue = (int) (Math.random() * 100) + 1;
			sum += randomValue;
			
		}System.out.println(sum);
	}
}
