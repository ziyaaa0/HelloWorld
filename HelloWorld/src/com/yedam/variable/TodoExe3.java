package com.yedam.variable;

import java.util.Scanner;

public class TodoExe3 {
	public static void main(String[] args) {
		String[] names = { "박창석", "홍영민", "김익수", "이화영" };
		
		Scanner scn = new Scanner(System.in);
		System.out.println("친구이름을 입력하세요>>>");
		String search = scn.nextLine();
		
		boolean isExists = false;
		for(int i=0; i<names.length; i++) {			
			
			if(isExists=names[i].equals(search)) {
				break;
			}
		}					
			if(isExists){
				System.out.printf("입력한 이름 %10s이 존재합니다.\t나이는 %2d입니다.\n", search, 10);
			}else {
				System.out.println("입력한 이름이 없습니다.");
			}
		//print ln <- 줄바꿈 포함 프린트
		//입력한 이름이 존재합니다. 입력한 이름이 없습니다.
		//end of prog.
		System.out.println("end of prog");
	}
}
