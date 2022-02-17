<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.daeni.post.*"  %>

<% 
	PostService postService = new PostService();
	ArrayList<Post> postList = postService.findPost();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" bordercolor="blue" width ="500" height="300" align = "center">
		<tr>
			<td>번 호</td>
			<td>이 름</td>
			<td>제 목</td>
			<td>  글 </td>
			<td>작 성 일</td>
		</tr>
<%
	for (Post post : postList){
%>
	<tr>
		<td>
			<a href='post_view.jsp?postno=<%=post.getP_no()%>'><%=post.getP_no()%></a>
		</td>
		<td><%=post.getP_name() %></td>
		<td><%=post.getP_title() %></td>
		<td><%=post.getP_content() %></td>
		<td><%=post.getP_date() %></td>
	</tr>
<%} %>
	</table>
</body>
</html>