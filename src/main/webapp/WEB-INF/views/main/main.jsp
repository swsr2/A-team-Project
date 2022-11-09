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
</head>
<body>

<div class="header">
	<img src="${path }/resources/image/logo.png" width="150" height="150" >
	<button type="button">로그인</button>
</div>
<div class="topnav">
  <a href="${path }/main/introduce">제주가고싶조</a>
  <a href="#">먹으멍</a>
  <a href="#">보멍</a>
  <a href="#">즐기멍</a>
  <a href="#">이벤트</a>
</div>


<div class="content">
	<img src="${path }/resources/image/jejumain.jpg" style="width:auto;">
</div>


</body>
</html>


