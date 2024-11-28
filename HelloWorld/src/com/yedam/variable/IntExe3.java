package com.yedam.variable;

public class IntExe3 {
	public static void main(String[] args) {
		boolean b1 = true;
		b1 = 10 > 20;
		
		char c1 = 0; //unicode 코드값을 매핑.
		c1 = 65; //'A'; 같은 의미 'Z' = 90
		for(int i =1; i<= 100; i++) {
			System.out.println(c1++);
		}
		char c2 = '가'; //"Hello"
		System.out.println((int) c2);
		
		int n1 =1;
		int n2 =2;
		double result4 = n1 * 1.0 / n2; //자동형변환(promotion) 0.5 => 0 컴파일러가 함
		
		System.out.println("n1 / n2의 결과: " + result4);
		// byte < short < int < long < float < double
	}
}
