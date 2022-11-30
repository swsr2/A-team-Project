<%@page import="com.spring.project.mypage.dto.ReviewDTO"%>
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

table, td, th {
	border: 1px solid;
	text-align:left;
}
table {
	border-collapse: collapse;
	width: 30%;
}
tr:hover {background-color: #ddd;}

.button {
  background-color: #EEEEEE;
  border: none;
  color: black;
  padding: 7px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 12px;
  margin-left:90%;
  cursor: pointer;
}
.button4 {border-radius: 8px;}

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
		<table align="center">
			<c:forEach var="mypage" items="${mypage }">
			<tr>
				<th height="30px" bgcolor="#EEEEEE">${mypage.re_writeDate }</th>
				<th height="30px" bgcolor="#EEEEEE"><div class="star-ratings">
					<div 
				    class="star-ratings-fill space-x-2 text-lg"
				    style=" width: ${mypage.re_score * 20}%">
						<span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
					</div>
					<div class="star-ratings-base space-x-2 text-lg">
						<span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
					</div>
				</div></th>
			</tr>
			<tr>
				<td colspan="2">
					<span>${mypage.re_content }</span>
					<span><button class="button button4">삭제</button></span>
				</td>
			</tr>
			</c:forEach>
		</table>
		<br>
		<br>
</body>
</html>