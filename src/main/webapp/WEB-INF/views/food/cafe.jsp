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
        <input class="category" type='submit' value='맛집'/>
    </form>
	<form name="food2" action="/project/food/cafe" method="post">
        <input class="category" type='submit' value='카페'/>
    </form>
    <br><br><br>
        <table align="center">
    <tr align="center">
    		<c:forEach var="cf" items="${cafeList }" varStatus="status">
	 			<td><a href="${path}/food/resDetail?fd_no=${cf.fd_no}" style="padding:10px;">
	 				<img src="${cf.fd_thumbnailPath }" width="350"/></a>
	 				<p>${cf.fd_title }</p></td>
	 			<c:if test="${(status.count%3) == 0 }">
	 				</tr>
	 				<tr align="center">
	 			</c:if>
 			</c:forEach>
 				</tr>
    </table>
 		
</body>
</html>


	<%-- 	<td><a href="#"><img src="${path }/resources/image/cafe1.png" width="450"/></a></td>
 				<td><a href="#"><img src="${path }/resources/image/cafe1.png" width="450"/></a></td>
 				<td><a href="#"><img src="${path }/resources/image/cafe1.png" width="450"/></a></td> --%>