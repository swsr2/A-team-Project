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
	<title>마이페이지</title>
</head>
<body>
	<h1 style="text-align:center;">마이페이지</h1>
	<div id="btn_group1" align="center">
		<button type="button" onClick="location.href='${path }/member/memberDetail'">내 정보수정</button>
		<button type="button" onClick="location.href='${path }/mypage/myreview'">내가 쓴리뷰</button>
	</div>
	<div id="btn_group2" align="center">
		<button type="button" onClick="location.href='${path }/mypage/myreservation'">내 예약확인</button>
		<button type="button" onClick="location.href='${path }/mypage/mytravle'">내 여행일정</button>
	</div>
</body>
</html>