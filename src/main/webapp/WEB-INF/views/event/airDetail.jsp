<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>항공 상세페이지</title>
<script>
	
</script>
<style>
form {
	display: inline;
}

#myReserv {
	bottom: 0%;
	padding: 5px;
	margin-left:90%
}
</style>
</head>
<body>
	<form name="event1" action="/project/event/main">
		<input class="category" type='submit' value='항공' />
	</form>
	<form name="event2" action="/project/event/main">
		<input class="category" type='submit' value='숙박' />
	</form>
	<br>
	<br>
	<br>
	<table>
		<tr>
			<%-- <c:forEach var="res" items="${resList }">
 			<tr align="center">
 				<td><a href="${path}/food/resDetail?fd_no=${fd_no}"><img src="${path }/resources/image/${fd_no}.png" width="500"/></a></td>
 			</tr> --%>
			<td rowspan="8"><img src="${path }/resources/image/3.jpg"
				width="450" /></td>
			<td width="100">번호 :</td>
			<td>${airplane.air_no }</td>
		</tr>
		<tr>
			<td width="100">항공사 :</td>
			<td>${airplane.air_airline }</td>
		</tr>
		<tr>
			<td width="100">출발시간 :</td>
			<td>${airplane.air_departTime }</td>
		</tr>
		<tr>
			<td width="100">도착시간 :</td>
			<td>${airplane.air_arrivalTime }</td>
		</tr>
		<tr>
			<td width="100">출발장소 :</td>
			<td>${airplane.air_departPlace }</td>
		</tr>
		<tr>
			<td width="100">도착장소 :</td>
			<td>${airplane.air_arrivalPlace }</td>
		</tr>
		<tr>
			<td width="100">좌석번호 :</td>
			<td>${airplane.air_seat }</td>
		</tr>
		<tr>
			<td width="100">금액 :</td>
			<td>${airplane.air_price }</td>
		</tr>
	</table>

	<div>
		<a class="myReserv" href="${path }/event/air_resv">예약하기</a>
	</div>
</body>
</html>