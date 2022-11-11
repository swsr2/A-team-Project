<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맛집 상세페이지</title>
<style>
form {
	display: inline;
}

</style>
</head>
<body>
	<form name="food1" action="/project/food/main">
        <input type='submit' value='맛집'/>
    </form>
	<form name="food2" action="/project/food/cafe">
        <input type='submit' value='카페'/>
    </form>
    <br><br><br>
	<textarea rows="" cols=""></textarea>
</body>
</html>