package com.yedam.reference;

import java.util.Scanner;

/*
 * 
 *  친구정보 저장 기능.
 *  1.친구정보 추가 2.목록 3.조회(숙제) 9.종료
 * 
 */
public class FriendManager {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		
		Friend[] storage = new Friend[10];
//		storage[0] = new Friend(); // !!!!!!!!!사용법
//		storage[0].friendName = "홍길동";
//		storage[0].friendPhone = "010-1111-1111";
//		storage[0].friendBirth = "1999-01-01";
		while (run) {
			System.out.println("1.추가 2.목록 3.조회(숙제) 9.종료");
			System.out.print("선택>> ");
			
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: //추가
				System.out.println("친구 이름 입력>>>>>>>>>>");
				String name = scn.nextLine();
				System.out.println("친구 연락처 입력>>>>>>>>>>");
				String phone = scn.nextLine();
				System.out.println("친구 생일 입력>>>>>>>>>>");
				String birth = scn.nextLine();
				
				for(int i =0; i < storage.length; i++) {
					//System.out.println(storage[i]);
					if(storage[i] == null) { //비어있는 위치에 저장.
						storage[i] = new Friend();
						storage[i].friendName = name;
						storage[i].friendPhone = phone;
						storage[i].friendBirth = birth;
						System.out.println("정보가 추가되었습니다.");
						break; //for 종료.
					}
				}
				break; //switch 종료
			case 2: //목록
				for(int i = 0; i < storage.length; i++) {
					if(storage[i] != null ) {
						System.out.printf("%4s %14s %14s \n" , storage[i].friendName, storage[i].friendPhone, storage[i].friendBirth);
						System.out.println("메뉴를 다시 선택하세요");
					}
					
				}
				break; //switch 종료
				
				
				
			case 3: //조회
				
				String searchName = "";

				while (run) {
					//1.사용자의 입력값을 searchName에 저장
					System.out.print("이름을 검색하세요>>>>>>");
					searchName = scn.nextLine();
					
					//5.입력값이 quit면 while 반복문 종료
					if (searchName.equals("quit")) {

						System.out.println("프로그램 종료");
						
						break;
					}
					boolean isExists = false;
					int idx = 0;			
					
					//찾는 이름이 있으면 정보 출력			
					
					for(int i = 0; i <storage.length; i++) {
						isExists = searchName.equals(storage[i].friendName);
						
						if(isExists) {
							idx = i;
							break;
						}
					}
					//입력값 없을 시 "찾는 이름 없음"
					if (isExists) {
						System.out.println(storage[idx].friendName + ", " + storage[idx].friendPhone + ", " + storage[idx].friendBirth );

					} else {
						System.out.println("찾는 이름 없음");
						break;
					} //end
					System.out.println("프로그램 종료");
				}
			System.out.println("프로그램 종료");
			System.out.println("1.추가 2.목록 3.조회(숙제) 9.종료");
			System.out.print("선택>> ");
						
				
				
				
				
			case 9: //종료.
				run = false;
				break; //switch 종료
			default:
				System.out.println("메뉴를 다시 선택하세요");
			}//end of switch
			
			
		}//end of while
		System.out.println("종료");
	
	}
}
