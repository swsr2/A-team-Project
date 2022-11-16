<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
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
<title>Insert title here</title>
<style>
form {
	display: inline;
}
th {
	width:100px;
	text-align:center;
}
td {
	width:100px;
	text-align:center;
	font-weight:lighter; 
}

</style>
</head>
<body>
	<form name="event1" action="/project/event/airmain">
		<input class="category" type='submit' value='항공' />
	</form>
	<form name="event2" action="/project/event/lodmain">
		<input class="category" type='submit' value='숙박' />
	</form>
	<br>
	<br>
	<br>
	<table align="center" border="1">
		<tr>
			<th align="center">번호</th>
			<th align="center">항공사</th>
			<th align="center">출발일자</th>
			<th align="center">출발장소</th>
			<th align="center">출발시간</th>
			<th align="center">도착장소</th>
			<th align="center">도착시간</th>
			<th align="center">가격</th>
			<th align="center">예약하기</th>
		</tr>
		<c:forEach var="airplane" items="${airplaneList }">
		<tr>
			<td>${airplane.air_no }</td>
			<td>${airplane.air_airline }</td>
			<td>${airplane.air_date }</td>
			<td>${airplane.air_departPlace }</td>
			<td>${airplane.air_departTime }</td>
			<td>${airplane.air_arrivalPlace }</td>
			<td>${airplane.air_arrivalTime }</td>
			<td>${airplane.air_price }</td>
			<td><a href="${path }/event/air_resv?air_no=${airplane.air_no}">예약하기</a></td>
		</tr>
		</c:forEach>
	</table>
	<br><br><br>
</body>
</html>