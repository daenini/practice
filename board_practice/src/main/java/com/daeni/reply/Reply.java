package com.daeni.reply;

import java.sql.Date;

import com.daeni.post.Post;

public class Reply {
	private int r_no; // 댓글 번호
	private String r_name; // 댓글 작성자
	private String r_title; // 댓글 제목
	private String r_content; // 댓글 글
	private Date r_date; // 작성일
	private Post p_no;
	
	public Reply() {
		// TODO Auto-generated constructor stub
	}
	
	public Reply(int r_no, String r_name, String r_title, String r_content, Date r_date, Post p_no) {
		super();
		this.r_no = r_no;
		this.r_name = r_name;
		this.r_title = r_title;
		this.r_content = r_content;
		this.r_date = r_date;
		this.p_no = p_no;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	public String getR_title() {
		return r_title;
	}

	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}

	public Post getP_no() {
		return p_no;
	}

	public void setP_no(Post p_no) {
		this.p_no = p_no;
	}

	@Override
	public String toString() {
		return "Reply [r_no=" + r_no + ", r_name=" + r_name + ", r_title=" + r_title + ", r_content=" + r_content
				+ ", r_date=" + r_date + ", p_no=" + p_no + "]";
	} 
	
	
}
