package com.project.post.vo;

public class PostVO {
	private int postno;
	private int memberno;
	private String writer;
	private String title;
	private String content;
	private String rdate;
	
	public int getPostno() {
		return postno;
	}
	
	public PostVO setPostno(int postno) {
		this.postno = postno;
		return this;
	}
	
	public int getMemberno() {
		return memberno;
	}
	
	public PostVO setMemberno(int memberno) {
		this.memberno = memberno;
		return this;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public PostVO setWriter(String writer) {
		this.writer = writer;
		return this;
	}
	
	public String getTitle() {
		return title;
	}
	
	public PostVO setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public String getContent() {
		return content;
	}
	
	public PostVO setContent(String content) {
		this.content = content;
		return this;
	}
	
	public String getRdate() {
		return rdate;
	}
	
	public PostVO setRdate(String rdate) {
		this.rdate = rdate;
		return this;
	}
	
}
