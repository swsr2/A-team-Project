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
		display:inline;
	}
</style>
</head>
<body>
	<form name="food1" action="/project/food/main" method="post">
        <input type='button' value='맛집'/>
    </form>
	<form name="food2" action="/project/food/cafe" method="post">
        <input type='button' value='카페'/>
    </form>
    <br><br><br>
    <table>
    	<tr>
    		<%-- <c:forEach var="res" items="${resList }">
 			<tr align="center">
 				<td><a href="${path}/food/resDetail?fd_no=${fd_no}"><img src="${path }/resources/image/fd_no.png" width="500"/></a></td>
 			</tr> --%>
 				<td><a href="#"><img src="${path }/resources/image/cafe1.png" width="500"/></a></td>
 				<td><a href="#"><img src="${path }/resources/image/cafe1.png" width="500"/></a></td>
 				<td><a href="#"><img src="${path }/resources/image/cafe1.png" width="500"/></a></td>
    	</tr>
    </table>
</body>
</html>