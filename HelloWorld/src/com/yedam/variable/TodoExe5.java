package com.yedam.variable;

public class TodoExe5 {
	public static void main(String[] args) {
		// 1에서 100까지의 정수 중 3의 배수의 합을 구하고 출력.

//		int sum = 0;
//		int i = 0;
//		for (i = 1; i < 101; i++) {
//			if (i % 3 == 0) {
//				sum = sum + i;
//			}
//		}
//		System.out.println(sum);

		// *
		// **
		// ***
		for (int i = 5; i >= 1; i--) {
			for (int j = 1; j <= 5; j++) {

				if (j >= i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println("end of prog.");
	}

}
