package com.yedam.reference;

import java.util.Scanner;

/*
 * 은행 프로그램 v1.0 p183
 * 24.11.29
 * 
 */
public class ArrayExe2 {
	public static void main(String[] args) {
		// 변수 초기화. 10만원 초과불가
		boolean run = true;
		int balance = 0;
		int maxBalance = 100000;
		Scanner scn = new Scanner(System.in);

		while (run) {
			System.out.println("------------------------");
			System.out.println("1.예금 2.출금 3.잔고 4.종료  ");
			System.out.println("------------------------");
			System.out.print("선택> ");
			int menu = Integer.parseInt(scn.nextLine()); // 1, 2

			switch (menu) {
			case 1:
				System.out.print("예금액> ");
				
				int inBalance = Integer.parseInt(scn.nextLine());
				if (balance + inBalance <= maxBalance) {					
					balance = balance + inBalance;
				} else if(balance + inBalance > maxBalance) {
					System.out.println("100000이 초과되어 입금할 수 없습니다.");
				} break;
			case 2:
				System.out.print("출금액> ");
				inBalance = Integer.parseInt(scn.nextLine());
				if(balance - inBalance > 0) {
					balance = balance - inBalance;
				} else {
					System.out.println("잔액부족으로 출금할 수 없습니다.");
				}
				
			case 3:
				System.out.println("잔고> " + balance + "원");
			case 4:
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}
}
