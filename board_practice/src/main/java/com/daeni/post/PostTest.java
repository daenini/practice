package com.daeni.post;

public class PostTest {

	public static void main(String[] args) throws Exception {
		PostService postService = new PostService();
		
		//System.out.println(postService.insert(new Post(0, "곽두사", "test", "test", null)));
		//System.out.println(postService.findPost());
		//System.out.println(postService.findPostNo(1));
		//System.out.println(postService.delect(4));
		//System.out.println(postService.update(new Post(6,"곽업뎃","update","update",null)));
		
		for(int i = 0; i< 100; i++) {
			postService.insert(new Post(0, "곽두"+i, "테스트로 넣는 글"+i, "테스트를 통해 넣는 글입니다 정말 빨리 취업하고싶은데 맘처럼 안된다..", null));
		}
	}
	
}
