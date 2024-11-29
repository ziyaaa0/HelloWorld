package com.yedam.reference;

import java.util.Scanner;

/*
 * 
 * 수정일        수정자          수정내용
 * ------------------------------------
 * 2024.11.29  홍길동          신규작업
 */
public class ArrayExe3 {
	// 배열의 인덱스 활용(같은 순번에 있는 값들은 동일한 사람의 값)
	public static void main(String[] args) {
		String[] names = { "홍길동", "김민수", "최두식" };
		int[] scores = { 80, 90, 70 };

//		for (int i = 0; i < names.length; i++) {
//			System.out.println(names[i] + "의 점수는" + scores[i]);

		// quit 입력하면 프로그램 종료
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		String searchName = ""; // 사용자 입력값.

		while (run) {
			// names 배열에서 사용자 입력한 이름.
			
			//1.searchName 에 사용자 입력값 저장.
			System.out.println("사용자의 이름은?");
			searchName = scn.nextLine();
			
			//2.quit 입력시 프로그램 종료
			if (searchName.equals("quit")) {
				System.out.println("프로그램 종료");
				break;
			}
			// 입력값과 이름과 같을시 점수 출력
			boolean isExists = false;
			int idx = 0;
			for (int i = 0; i < names.length; i++) {
				isExists = names[i].equals(searchName);

				if (isExists) {
					idx = i;
					break;
				}
			}
			//입력값 없을 시 "찾는 이름 없음"
			if (isExists) {

				System.out.println(names[idx] + "점수: " + scores[idx]);

			} else {
				System.out.println("찾는 이름 없음");
			} //end
			System.out.println("프로그램 종료");
		}
	}
}
