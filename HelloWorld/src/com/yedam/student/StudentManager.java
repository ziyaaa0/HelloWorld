package com.yedam.student;

import java.util.Scanner;

/*
 * 
 * CRUD 처리.
 * 1.추가 2.목록 3.수정(영어,수학) 4.삭제 9.종료
 */
public class StudentManager {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);

		Student[] storage = new Student[10];

		while (run) {
			System.out.println("1.추가 2.목록 3.수정 4.삭제 5.상세조회(합계,평균) 6. 점수기준 오름차순 9.종료");
			System.out.print("선택>> ");

			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {

			case 1:
				System.out.println("학생 번호 입력>>>>>>>");
				int num = Integer.parseInt(scn.nextLine());
				System.out.println("학생 이름 입력>>>>>>>");
				String name = scn.nextLine();
				System.out.println("영어 점수 입력>>>>>>>");
				int engscore = Integer.parseInt(scn.nextLine());
				System.out.println("수학 점수 입력>>>>>>>");
				int mathscore = Integer.parseInt(scn.nextLine());

				for (int i = 0; i < storage.length; i++) {

					if (storage[i] == null) {
						storage[i] = new Student(num,name,engscore,mathscore);//인스턴스 생성: 실체를 만들어서 담음
						storage[i].studentNum = num;
						storage[i].studentName = name;
						storage[i].engScore = engscore;
						storage[i].mathScore = mathscore;
						System.out.println("정보가 추가되었습니다.");
						break;
					}
				}
				break; // 종료

			case 2:
				System.out.printf("%6s %6s %6s %6s \n","학생번호","학생이름","영어","수학");
				System.out.println("================================");
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						System.out.printf("%6d %6s %6d %6d \n", storage[i].studentNum, storage[i].studentName,
								storage[i].engScore, storage[i].mathScore);
						System.out.println("메뉴를 다시 선택하세요");
						
					}
				}
				break;

			case 3:
				System.out.print("학생 번호를 입력하세요>>>>>>");
				num = Integer.parseInt(scn.nextLine());
				System.out.print("영어 점수를 입력하세요>>>>>>");
				engscore = Integer.parseInt(scn.nextLine());
				System.out.print("수학 점수를 입력하세요>>>>>>");
				mathscore = Integer.parseInt(scn.nextLine());

				// 10개 중에서 6개 저장, 4개 null
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) { // null 값이 아닌 요소 대상.
						if (storage[i].studentNum == num) {
							storage[i].engScore = engscore;
							storage[i].mathScore = mathscore;
							break;
						}
					}
				}
				break;

			case 4:
				System.out.print("학생 번호를 검색하세요>>>>>>");
				num = Integer.parseInt(scn.nextLine());

				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) { // null 값이 아닌 요소 대상.
						if (storage[i].studentNum == num) {
							storage[i] = null;
							break;
						}
					}
				}
				break;

			case 5:				
				

				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						
						double a = storage[i].engScore;
						double b = storage[i].mathScore;
						
						double sum = a + b; 
						double avg = (a + b)/2;
						System.out.printf("%6d %6s %4d %4d \n", storage[i].studentNum, storage[i].studentName,
								sum, avg );
						System.out.println("메뉴를 다시 선택하세요");
					}
				}
				break;
				
				
			case 6:
				
				  Student[] storage2 = {new Student(), new Student()};
				  
				  for(int j = 0; j <storage2.length -1; j++){
				    for(int i = 0; i < storage2.length -1; i++) {
					  if(storage2[0].engScore + storage2[0].mathScore > storage2[1].engScore + storage2[1].mathScore){
					  
					   Student temp = storage2[0];
					   storage2[0] = storage2[1];
					   storage2[1] = temp;
					 } 
					}
				  }break;

			case 9: // 종료
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요");
			}

		}
		System.out.println("종료");
	}
}

/* int[] intAry = {50, 70, 80, 90, 60, 65};
 * System.out.println(intAry);
 
 for(int j = 0; j <intAry.length -1; j++{
  for(int i = 0; i < intAry.length -1; i++) {
	  if(intAry[i] > intAry[i+1]){
	  //i위치 -> i+1위치, i+1위치
	   int temp = intAry[i];
	   intAry[i] = intAry[i + 1];
	   intAry[i+1] = temp;
	 } 
   }
  }
  for (int num : intAry)
  System.out.println(num);
  
  
  Student[] storage = {new Student(), new Student()};
    for(int i = 0; i < intAry.length -1; i++) {
	  if(storage[0].engScore + storage[0].mathScore > storage[1].engScore + storage[1].mathScore){
	  
	   Student temp = storage[0];
	   storage[0] = storage[1];
	   storage[1] = temp;
	 } 
	}
*/
