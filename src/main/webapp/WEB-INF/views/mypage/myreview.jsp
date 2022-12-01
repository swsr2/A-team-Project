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
td {
	text-align:left;
	height:50px;
}
th {
	height:30px;
	background-color:#EEEEEE;
}
table {
	vertical-align : middle;
	width: 30%;
	border-spacing: 0px;
  	padding: 10px;
  	border-collapse:collapse;
  	border-radius:25px;
  	margin-left:auto;
  	margin-right:auto;
}

tr{
 border: 1px solid #ddd;
}

.button4:hover {background-color: #ddd;}

.button {
  background-color: #EEEEEE;
  border: none;
  color: black;
  padding: 5px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 12px;
  margin-left:60%;
  cursor: pointer;
}
.button4 {border-radius: 8px;}
/* 클릭전 */
a:link {
  color: black;
  text-decoration: none;
}
/* 클릭후 */
a:visited {
  color: gray;
  font-size:12px;
  text-decoration: none;
}
/* 마우스오버 */
a:hover {
  color: orange;
  text-decoration: underline;
}
/* 클릭시 */
a:active {
  color: blue;
  text-decoration: none;
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
		<table>
			<c:forEach var="mypage" items="${mypage }">
			<tr>
				<th width="80%" align="left" >&nbsp;#업체명&nbsp;<a href="${path }/food/resDetail?fd_no=${mypage.fd_no }">>></a></th>
				<th align="right"><div class="star-ratings">
					<div 
				    class="star-ratings-fill space-x-2 text-lg"
				    style=" width:${mypage.re_score * 20}%">
						<span>&nbsp;★</span><span>★</span><span>★</span><span>★</span><span>★</span>
					</div>
					<div class="star-ratings-base space-x-2 text-lg">
						<span>&nbsp;★</span><span>★</span><span>★</span><span>★</span><span>★</span>
					</div>
				</div></th>
			</tr>
			<tr>
				<td>&nbsp;${mypage.re_writeDate }일 리뷰<br>&nbsp;"${mypage.re_content }"</td>
				<td><button class="button button4">삭제</button></td>
			</tr>
			</c:forEach>
		</table>
		<br>
		<br>
</body>
</html>