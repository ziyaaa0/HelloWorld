package com.yedam.reference;

public class TodoExe1 {
	public static void main(String[] args) {
		// 정수를 담는 배열 크기 5개로 선언
		int[] intAry = new int[5];

		for (int i = 0; i < intAry.length; i++) {
			int temp = (int) (Math.random() * 51) + 50;
			// 2번째 => 1번째, 3번째 => 2번째까지, 4번째 => 3번까지 비교
			boolean exists = false; //초기값 false
			for (int j = 0; j <= i - 1; j++) {
				if (intAry[j] == temp) {
					exists = true; //true 면 다시
				}
			}
			//같은 값이 존재하면..i값 증가x
			if(exists) {
				continue;
			}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
			intAry[i] =temp;
			i++;
		}
		for (int temp : intAry) {
			System.out.println(temp);
		}
		System.out.println("end of prog.");
	}
}
