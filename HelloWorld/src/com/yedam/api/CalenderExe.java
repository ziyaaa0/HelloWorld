package com.yedam.api;

import java.util.Calendar;

public class CalenderExe {
	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance(); //인스턴스 생성.
		System.out.println(cal.get(Calendar.DAY_OF_WEEK) + "요일");
		System.out.println(cal.getActualMaximum(Calendar.DATE) + " :마지막날");
		
		
//		createCalendar(6,30);
	}
	
	//1일의 요일?, 막날? => 달력
//	static void createCalendar(int positionOfDay, int lastDate) {
	static void createCalendar(int year, int month) {
		int positionOfDay = 0 ;
		int lastDate = 0 ;
		String[] days = {"Sun","Mon","Tue","Wed","Thr","Fri","Sat"};
		for(String day : days) {
			System.out.printf("%4s", day);
		
		}
		System.out.println(); 
		
		//1일의 위치 지정.
		for(int i =1; i < positionOfDay; i++) {
			System.out.printf("%4s", " ");
		}
		//날짜 출력
		for(int d =1; d <=lastDate; d++) {
			System.out.printf("%4d", d);
			
			if((d + positionOfDay -1 )% 7 == 0) { 
				System.out.println(); //줄바꿈
			}
		}
	}
}
