package com.yedam.jdbc.student;

public class Member {
	private String memberId;
	private String password;
	private String memberName;
	
	public Member() {
		
	}
	
	
	public Member (String memberId, String password,String memberName) {
		super();
		this.memberId = memberId;
		this.password = password;
		this.memberName = memberName;
		
	}



	public String getMemberId() {
		return memberId;
	}



	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getMemberName() {
		return memberName;
	}



	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	
	public String showInfo() {
		return " " + memberId + " " + password + " " + memberName ;
	}
	
	
	
	
}
