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
	<form name="event1" action="/project/event/main">
		<input class="category" type='submit' value='항공' />
	</form>
	<form name="event2" action="/project/event/lodmain">
		<input class="category" type='submit' value='숙박' />
	</form>
    <br><br><br>
    <h3>${from } ~ ${to }</h3>
    <table align="center">
    <tr align="center" >
    		<c:forEach var="lod" items="${lodList }" varStatus="status">
	 			<td><a href="${path}/event/lodInfo?lod_id=${lod.lod_id}" style="padding:10px;">
	 				<img class="imgSize" src="${lod.lod_imgPath }" 
	 						onerror="this.src='${path }/resources/image/empty_img.png'" width="350"/></a>
	 				<p>${lod.lod_title }</p></td>
	 			<c:if test="${(status.count%3) == 0 }">
	 				</tr>
	 				<tr align="center">
	 			</c:if>
 			</c:forEach>
 				</tr>
    </table>
 <div class="page">
 <h3>
    <c:if test="${prev}">
 <span>[ <a href="${path }/event/lodDetail?page=${startPageNum - 1}">이전</a> ]</span>
</c:if>

<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
  <span>
   <a href="${path }/event/lodDetail?page=${num}">${num}</a> 
 </span>
</c:forEach>

<c:if test="${next}">
 <span>[ <a href="${path }/event/lodDetail?page=${endPageNum+1}">다음</a> ]</span>
</c:if>
</h3>
</div>
</body>
</html>

<%-- <td><a href="${path}/food/resDetail?fd_no=1"><img src="${path }/resources/image/1.png" width="450"/></a></td>
 				<td><a href="#"><img src="${path }/resources/image/1.png" width="450"/></a></td>
 				<td><a href="#"><img src="${path }/resources/image/1.png" width="450"/></a></td> --%>
    	<!-- </tr> -->