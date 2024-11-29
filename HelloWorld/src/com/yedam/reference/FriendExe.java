package com.yedam.reference;

import java.util.Scanner;

public class FriendExe {
	public static void main(String[] args) {
		String name = new String("홍길동"); // "홍길동";
		int age = 20;

		Friend f1 = new Friend();
		f1.friendName = "홍길동";
		f1.friendPhone = "010-1111-1234";
		f1.friendBirth = "1999-04-05";

		Friend f2 = new Friend();
		f2.friendName = "김민수";
		f2.friendPhone = "010-2222-1234";
		f2.friendBirth = "2000-04-05";

		Friend f3 = new Friend();
		f3.friendName = "최두식";
		f3.friendPhone = "010-3333-1234";
		f3.friendBirth = "2000-10-10";

		Friend[] myFriends = { f1, f2, f3 };

//		System.out.println(myFriends[0].friendName);
//		System.out.println(myFriends[0].friendPhone);
//		System.out.println(myFriends[0].friendBirth);

		// 이름 => 이름 연락처 생년월일 출력

		boolean run = true;
		Scanner scn = new Scanner(System.in);
		String searchName = "";

		while (run) {
			//1.사용자의 입력값을 searchName에 저장
			System.out.print("사용자의 이름은>>>>>>");
			searchName = scn.nextLine();
			
			//5.입력값이 quit면 while 반복문 종료
			if (searchName.equals("quit")) {

				System.out.println("프로그램 종료");
				
				break;
			}
			boolean isExists = false;
			int idx = 0;			
			
			//찾는 이름이 있으면 정보 출력			
			
			for(int i = 0; i <myFriends.length; i++) {
				isExists = searchName.equals(myFriends[i].friendName);
				
				if(isExists) {
					idx = i;
					break;
				}
			}
			//입력값 없을 시 "찾는 이름 없음"
			if (isExists) {

				System.out.println(myFriends[idx].friendName + ", " + myFriends[idx].friendPhone + ", " + myFriends[idx].friendBirth );

			} else {
				System.out.println("찾는 이름 없음");
			} //end
			System.out.println("프로그램 종료");

		}System.out.println("프로그램 종료");
	}
}
