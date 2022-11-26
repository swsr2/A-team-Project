<%@page import="com.spring.project.mypage.dto.MyReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"   isELIgnored="false"
   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 쓴 리뷰</title>
<style>
form {
   display: inline;
}

</style>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
</head>
<body>
		<div id="review" align="center">
			<h1>내가 쓴 리뷰</h1>
		</div>
		<table align="center" border="1">
			<tr>
				<td>작성자</td>
				<td>작성일</td>
				<td>리뷰번호</td>
				<td>평점</td>
				<td>코멘트</td>
			</tr>
			<tr>
				<td>${mypage.id}</td>
				<td>${mypage.re_writeDate}</td>
				<td>${mypage.re_no}</td>
				<td>${mypage.re_score}</td>
				<td>${mypage.re_content}</td>
			</tr>
		</table>
		

</body>
</html>