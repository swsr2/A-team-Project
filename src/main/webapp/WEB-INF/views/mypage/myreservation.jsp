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
<title>예약확인</title>
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
		<div id="reservation" align="center">
			<h1>내 예약확인</h1>
		</div>
		<table align="center" border="1">
			<tr>
				<td>예약자아이디</td>
				<td>예약자이름</td>
				<td>출발날짜</td>
				<td>출발시간</td>
				<td>출발장소</td>
				<td>도착시간</td>
				<td>도착장소</td>
			</tr>
			<c:forEach var="mypage" items="${mypage }">
			<tr>
				<td>${mypage.id}</td>
				<td>${mypage.name}</td>
				<td>${mypage.air_date}</td>
				<td>${mypage.air_departTime}</td>
				<td>${mypage.air_departPlace}</td>
				<td>${mypage.air_arrivalTime}</td>
				<td>${mypage.air_arrivalPlace}</td>
			</tr>
			</c:forEach>
		</table>

</body>
</html>