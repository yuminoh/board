package com.project.member.vo;

public class MemberVO {
	private int memberno;
	private String id;
	private String pw;
	private String mname;
	
	public int getMemberno() {
		return memberno;
	}
	
	public MemberVO setMemberno(int memberno) {
		this.memberno = memberno;
		return this;
	}
	
	public String getId() {
		return id;
	}
	
	public MemberVO setId(String id) {
		this.id = id;
		return this;
	}
	
	public String getPw() {
		return pw;
	}
	
	public MemberVO setPw(String pw) {
		this.pw = pw;
		return this;
	}
	
	public String getMname() {
		return mname;
	}
	
	public MemberVO setMname(String mname) {
		this.mname = mname;
		return this;
	}

}
