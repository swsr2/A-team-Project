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
<meta charset="EUC-KR">
<title>숙소예약보기</title>
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
		<div id="lodreservation" align="center">
			<h1>숙소예약보기</h1>
		</div>
		<table align="center" border="1">
			<tr>
				<td>예약자아이디</td>
				<td>예약자이름</td>
				<td>예약자번호</td>
				<td>숙소이름</td>
				<td>객실이름</td>
				<td>가는날</td>
				<td>오는날</td>
				<td>체크인 시간</td>
				<td>체크아웃 시간</td>
			</tr>
			<c:forEach var="mypage" items="${mypage }">
			<tr>
				<td>${mypage.id}</td>
				<td>${mypage.res_name}</td>
				<td>${mypage.res_tel}</td>
				<td>${mypage.lod_title}</td>
				<td>${mypage.r_title}</td>
				<td>${mypage.res_from}</td>
				<td>${mypage.res_to}</td>
				<td>${mypage.lod_checkIn}</td>
				<td>${mypage.lod_checkOut}</td>
			</tr>
			</c:forEach>
		</table>
</body>
</html>