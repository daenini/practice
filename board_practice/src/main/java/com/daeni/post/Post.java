package com.daeni.post;

import java.sql.Date;

public class Post {
	private int p_no; // 게시물 번호
	private String p_name; // 게시물 작성자
	private String p_title; // 게시물 제목
	private String p_content; // 게시물 글
	private Date p_date; // 작성일
	
	public Post() {
		// TODO Auto-generated constructor stub
	}

	public Post(int p_no, String p_name, String p_title, String p_content, Date p_date) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_title = p_title;
		this.p_content = p_content;
		this.p_date = p_date;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_title() {
		return p_title;
	}

	public void setP_title(String p_title) {
		this.p_title = p_title;
	}

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public Date getP_date() {
		return p_date;
	}

	public void setP_date(Date p_date) {
		this.p_date = p_date;
	}

	@Override
	public String toString() {
		return "Post [p_no=" + p_no + ", p_name=" + p_name + ", p_title=" + p_title + ", p_content=" + p_content
				+ ", p_date=" + p_date + "]";
	}
	
	
}
