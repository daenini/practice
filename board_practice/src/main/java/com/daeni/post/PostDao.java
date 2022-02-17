package com.daeni.post;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class PostDao {
	private DataSource dataSource;
	public PostDao() throws Exception {
		Properties properties = new Properties();
		properties.load(this.getClass().getResourceAsStream("/com/daeni/jdbc.properties"));
		/*** Apache DataSource ***/
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(properties.getProperty("driverClassName"));
		basicDataSource.setUrl(properties.getProperty("url"));
		basicDataSource.setUsername(properties.getProperty("user"));
		basicDataSource.setPassword(properties.getProperty("password"));
		dataSource = basicDataSource;
	}
	
	/*
	 게시물 추가 메소드
	 */
	public int insert(Post post) throws Exception {
		int insetRowCount= 0; 
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(PostSQL.P_INSERT);
			//INSERT INTO post (p_no, p_name, p_title, p_content, p_date) VALUES (post_p_no_SEQ.nextval,?,?,?, sysdate)
			pstmt.setString(1, post.getP_name());
			pstmt.setString(2, post.getP_title());
			pstmt.setString(3, post.getP_content());
			insetRowCount = pstmt.executeUpdate();
		}catch(Exception e){	
			e.printStackTrace();
		}finally {
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();	
		}

		return insetRowCount;
	}
	
	/* 게시물 전체 */
	public ArrayList<Post> findPostList () throws Exception{
		Connection con = null; // db 연결
		PreparedStatement pstmt = null; // sql문 전송 
		ResultSet rs = null; // pstmt 결과값 저장
		ArrayList<Post> postList = null;
		try {
			con = dataSource.getConnection();
			pstmt =  con.prepareStatement(PostSQL.P_SELECT);
			//SELECT * FORM post
			rs= pstmt.executeQuery();
			postList = new ArrayList<Post>();
			Post post = null;
			while (rs.next()) {
				post = new Post();
				post.setP_no(rs.getInt("p_no"));
				post.setP_name(rs.getString("p_name"));
				post.setP_title(rs.getString("p_title"));
				post.setP_content(rs.getString("p_content"));
				post.setP_date(rs.getDate("p_date"));
				postList.add(post);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
		}
		
		return postList ;
	}
	
	public Post findPostNo(int no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Post post = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(PostSQL.P_SELECT_NO);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				post = new Post();
				post.setP_no(rs.getInt("p_no"));
				post.setP_name(rs.getString("p_name"));
				post.setP_title(rs.getString("p_title"));
				post.setP_content(rs.getString("p_content"));
				post.setP_date(rs.getDate("p_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
		}
		return post;
	}
	/*게시물 삭제*/
	
	public int delete (int no) throws Exception {
		int deleteRowCount = 0; // 삭제된지 확인을 위해
		Connection con =null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(PostSQL.P_DELETE);
			pstmt.setInt(1, no);
			deleteRowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}
		return deleteRowCount;
	}
	
	public int update (Post post) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int updateRC = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(PostSQL.P_UPDATE);
			//update post set p_name = ?, p_title = ?, p_content = ?, p_date = sysdate where p_no =? 
			pstmt.setString(1, post.getP_name());
			pstmt.setString(2, post.getP_title());
			pstmt.setString(3, post.getP_content());
			pstmt.setInt(4, post.getP_no());
			updateRC = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
		}
		
		return updateRC;
	}
	
}
