package com.project.reply.vo;

public class ReplyVO {
	private int replyno;
	private int memberno;
	private int postno;
	private String rwriter;
	private String rcontent;
	private String pdate;
	
	public int getReplyno() {
		return replyno;
	}
	public ReplyVO setReplyno(int replyno) {
		this.replyno = replyno;
		return this;
	}
	
	public int getMemberno() {
		return memberno;
	}
	public ReplyVO setMemberno(int memberno) {
		this.memberno = memberno;
		return this;
	}
	
	public int getPostno() {
		return postno;
	}
	@Override
	public String toString() {
		return "ReplyVO [replyno=" + replyno + ", memberno=" + memberno + ", postno=" + postno + ", rwriter=" + rwriter
				+ ", rcontent=" + rcontent + ", pdate=" + pdate + "]";
	}
	public ReplyVO setPostno(int postno) {
		this.postno = postno;
		return this;
	}
	
	public String getRwriter() {
		return rwriter;
	}
	public ReplyVO setRwriter(String rwriter) {
		this.rwriter = rwriter;
		return this;
	}
	
	public String getRcontent() {
		return rcontent;
	}
	public ReplyVO setRcontent(String rcontent) {
		this.rcontent = rcontent;
		return this;
	}
	
	public String getPdate() {
		return pdate;
	}
	public ReplyVO setPdate(String pdate) {
		this.pdate = pdate;
		return this;
	}
	
}
