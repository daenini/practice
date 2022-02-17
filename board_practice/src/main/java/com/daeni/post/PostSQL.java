package com.daeni.post;

public class PostSQL {
	// 게시물 등록
	public static final String P_INSERT = "INSERT INTO post (p_no, p_name, p_title, p_content, p_date) VALUES (post_p_no_SEQ.nextval,?,?,?,sysdate)";
	// 게시물 출력
	public static final String P_SELECT = "SELECT * FROM post";
	// 게시물 한개 출력
	public static final String P_SELECT_NO = "SELECT * FROM post where p_no = ?";
	// 게시물 업데이트
	public static final String P_UPDATE = "update post set p_name = ?, p_title = ?, p_content = ?, p_date = sysdate where p_no =? ";
	// 게시물 삭제
	public static final String P_DELETE = "delete post where p_no = ?";
	
}
