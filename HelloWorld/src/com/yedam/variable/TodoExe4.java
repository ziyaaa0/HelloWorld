package com.yedam.variable;

public class TodoExe4 {
	public static void main(String[] args) {
//		Scanner scn = new Scanner(System.in);
//		System.out.println("출력할 단을 입력하세요>>");
//		int dan = scn.nextInt(); // 사용자 입력값을 int 변환

//입력한 값 구구단 출력
//		for (int j = 2; j <= dan; j++) {
//			System.out.printf("%d 단입니다. \n", j);
//			for (int i = 1; i <= 9; i++) {
////			System.out.println("3 * " + i + "=" + 3 * i);
//				System.out.printf("%d * %d =  %2d \n", j, i, j * i);
//			}
//		} System.out.println("end of prog.");

		
//구구단 가로		
//		for (int num = 1; num < 10; num++) {			
//			
//			for (int i = 2; i <= dan; i++) {
//			System.out.printf("%d * %d = %2d ",i,num,i*num);
//			
//			}System.out.println();
//		} 
//		
		
//별찍기
		for(int j = 5; j >= 1; j--) {
			
			for (int i =1; i <= j; i++) {
				System.out.printf("*");				
			}
			System.out.println(); //줄바꿈				
		}	
		System.out.println("end of prog.");
	} 
		
}
