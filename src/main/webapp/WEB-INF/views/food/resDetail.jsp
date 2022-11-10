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
		display:inline;
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
    <table>
    	<tr>
    		<%-- <c:forEach var="res" items="${resList }">
 			<tr align="center">
 				<td><a href="${path}/food/resDetail?fd_no=${fd_no}"><img src="${path }/resources/image/${fd_no}.png" width="500"/></a></td>
 			</tr> --%>
 			<td rowspan="6"><img src="${path }/resources/image/1.png" width="500"/></td>
 			<td width="100">번호 :</td>
 			<td>${food.fd_no }</td>
     	</tr>
     	<tr>
 			<td width="100">가게명 :</td>
 			<td>${food.fd_name }</td>
     	</tr>
     	<tr>
 			<td width="100">주소 :</td>
 			<td>${food.fd_address }</td> <%-- api로 추후연결하기 --%>
     	</tr>
     	<tr>
 			<td width="100">운영시간 :</td>
 			<td>${food.fd_open }~${food.fd_close }</td>
     	</tr>
     	<tr>
 			<td width="100">평점 :</td>
 			<td>${food.fd_score }</td>
     	</tr>
     	<tr>
 			<td>카테고리</td>
 			<td>${food.fd_category}</td>
     	</tr>
    </table>
</body>
</html>