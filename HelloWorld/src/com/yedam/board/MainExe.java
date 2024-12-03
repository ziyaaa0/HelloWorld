package com.yedam.board;

import java.util.Date;
import java.util.Scanner;

/*
 * control하는 역할: 입력 출력 기능
 * 
 */
public class MainExe {
	
	static Scanner scn = new Scanner(System.in); //필드
	static BoardExe bexe = new BoardExe(); //필드
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		
		MemberExe mexe = new MemberExe(); // 인스턴스.
		
		while(run) {
			System.out.println("1.회원등록 2.목록 3.게시판 9.종료");
			System.out.print("선택>>>>>>>");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			
			case 1: //추가
				System.out.print("회원 아이디>> ");
				String id = scn.nextLine();
				System.out.print("회원 비밀번호>> ");
				String pw = scn.nextLine();
				System.out.print("회원 이름>> ");
				String name = scn.nextLine();
				System.out.print("회원 연락처>> ");
				String phone = scn.nextLine();
				
				boolean result = mexe.addMember(new Member(id, pw, name, phone));
				if(result) {
					System.out.println("정상 등록되었습니다");
				}else {
					System.out.println("등록이 처리되지 않았습니다");
				}
				break;
			//목록	
			case 2:
				Board[] list = bexe.boardList();
				for (Board brd : list) {
					if(brd != null) {
						System.out.println(brd.showInfo());
					}
				}
				break;
				
			case 3:
				//게시판 관련.
				System.out.print("회원아이디>> ");
				id = scn.nextLine();
				System.out.print("회원비밀번호>> ");
				pw = scn.nextLine();
				
				if(mexe.login(id, pw)) { //id pw 체크
					boardMethod(id); //로그인한 사용자 아이디를 활용
				}else {
					System.out.println("id와 pw를 확인하세요");
				}
				
				break;
				
			case 9:
				run = false;
				
			}
		}// end while
		System.out.println("프로그램 끝.");
	} // end of main
	public static void boardMethod(String id) {
		//1.추가 2.목록 3.수정 4.삭제 9.상위메뉴 이동
		boolean run = true;
		BoardExe bexe = new BoardExe();		
		Scanner scn = new Scanner(System.in);
		
		while(run) {
			System.out.println("1.글등록 2.목록 3.수정 4.삭제 9.상위메뉴 이동");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
			case 1:
//				System.out.print("글번호 입력>> ");
				int bno = bexe.getNextNo();
				System.out.print("글제목 입력>> ");
				String title = scn.nextLine();
				System.out.print("글내용 입력>> ");
				String content = scn.nextLine();
//				System.out.print("작성자 입력>> ");
				String writer = id;
				System.out.print("작성일시 입력>> ");
				java.util.Date ddd = new java.util.Date();
				
				
				Board board = new Board(bno, title, content, writer, ddd);
				if(bexe.insertBoard(board)) {
					System.out.println("게시글 등록 완료");
				}else {
					System.out.println("게시글 등록 실패");
				}
				break;
			case 2:
				Board[] list = bexe.boardList();
				for(Board brd : list) {
					if(brd != null) {
						System.out.println(brd.showInfo());						
					}
				} 
				break;
			case 3: //수정(제목, 내용) => bno, title, content : Board 타입.
				System.out.print("수정할 글번호를 입력하세요>>>>>>");
				bno = Integer.parseInt(scn.nextLine());	
				System.out.print("제목을 입력하세요>>>>>>");
				title = scn.nextLine();	
				System.out.print("내용을 입력하세요>>>>>>");
				content = scn.nextLine();	
				
				
				//글에 대한 권한 체크
				if(!bexe.checkResponsibility(bno, id)) {
					System.out.println("해당글의 권한을 확인하세요");
					break;
				}
				//사용자의 입력값을 updateBoard의 매개값으로 전달.
				board = new Board(bno, title, content, null, null);
				if(bexe.updateBoard(board)) {
					System.out.println("정상적으로 수정되었습니다");
				}else {
					System.out.println("수정할 글 번호를 다시 확인하세요.");
				}
				break;
				
			case 4: //삭제
				System.out.print("삭제할 번호를 입력하세요>>>>>>");
				bno = Integer.parseInt(scn.nextLine());	
				
				if(!bexe.checkResponsibility(bno, id)) {
					System.out.println("해당글의 권한을 확인하세요");
					break;
				}
				if(bexe.deleteBoard(bno)) {
					System.out.println("정상적으로 삭제되었습니다");
				}else {
					System.out.println("삭제할 글 번호를 다시 확인하세요.");
				}				
				
				break;
				
			case 9:
				return;
			}
		}
	}//end of boardMethod
}//end of class 
