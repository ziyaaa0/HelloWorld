package com.yedam.variable;

import java.util.Scanner; //단축키 ctrl + shift + o

public class TodoExe2 {
	public static void main(String[] args) {
		
		String name = "박지희";
		
		
		Scanner scn = new Scanner(System.in);
		System.out.println("이름을 입력.");
		String inputValue = scn.nextLine();
		
		System.out.println("입력한 값은 " + inputValue);
		
		if(name.equals(inputValue)) {
			System.out.println("맞음");
		}else {System.out.println("다름");
		}
		
		System.out.println("end of prog.");
	}
}
