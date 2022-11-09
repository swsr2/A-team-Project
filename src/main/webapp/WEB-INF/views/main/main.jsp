<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"	isELIgnored="false"
	%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>CSS Template</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
  font-family: Arial, Helvetica, sans-serif;
}

body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}
/* Style the header */
.header {
  background-color: #f1f1f1;
  padding:0px;
  text-align: center;
}
.header img {
	margin-right:90%;
}
.header button {
	margin-left:90%;
}

/* Style the top navigation bar */
.topnav {
  overflow: hidden;
  background-color: #333;
}

/* Style the topnav links */
.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

/* Change color on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Style the content */
.content {
  background-color: #ddd;
  padding: 10px;
  height: 450px; 
}

/* Style the footer */
.footer {
  background-color: #f1f1f1;
  padding: 10px;
  text-align:center;
}
</style>
</head>
<body>
<div class="header">
	<img src="${path }/resources/image/logo.png" width="150" height="150" >
	<button type="button">로그인</button>
</div>
<div class="topnav">
  <a href="#">제주가고싶조</a>
  <a href="#">먹으멍</a>
  <a href="#">보멍</a>
  <a href="#">즐기멍</a>
  <a href="#">이벤트</a>
</div>

<div class="content">
	<img src="${path }/resources/image//jejumain.jpg" style="width:auto;">
</div>

<div class="footer">
 	<p>e-mail : jejukj@test.com</p>
	<p>회사주소 : 서울 마포구 양화로 122 3층, 4층</p>
	<p><a href="#">1:1문의하기</a></p>
</div>

</body>
</html>


