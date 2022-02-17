package com.daeni.post;

import java.util.ArrayList;

public class PostService {
	private PostDao postDao;
	
	public PostService() throws Exception {
		postDao = new PostDao();
	}
	
	public int insert(Post post) throws Exception {
		return postDao.insert(post);
	}
	
	public ArrayList<Post> findPost() throws Exception{
		return postDao.findPostList();
	}
	
	public Post findPostNo(int no) throws Exception{
		return postDao.findPostNo(no);
	}
	
	public int delect(int no) throws Exception{
		return postDao.delete(no);
	}
	
	public int update(Post post) throws Exception{
		
		return postDao.update(post);
	}
}
