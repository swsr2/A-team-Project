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
<html lang="en">
<head>
<title>main</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<h1 style="padding:5px;">소개글</h1>
	<hr color="lightblue">
	<table align="center" class="info">
		<tr>
			<td><img src="${path }/resources/image/jejuemo4.jpg" width="100"></td>
			<td><h3><p>'제주가고싶조'는 제주도를 여행하고자 하는 여행자들에게 맛집, 관광지, 액티비티 등 제주도와 <br>
					관련된 정보를 제공함으로써 편리하게 여행을 할 수 있도록 돕고자 만들어 졌습니다.</p></h3></td>
		</tr>
		<tr>
				<td><img src="${path }/resources/image/jejuemo2.jpg" width="100"></td>
				<td><h3><p>여행 일정짜기 어려울땐 육지사람부터 제주도민까지 모두가 좋아할만한 코스들로 준비했으니 <br>
				찜하기를 하여 내 일정짜기에 추가할 수 있어요.</p></h3></td>
		</tr>		
		<tr>
				<td><img src="${path }/resources/image/jejuemo3.jpg" width="100"></td>
				<td><h3><p>제주여행을 최저가로? '제주가고싶조' 회원이라면 제주도 항공권과 숙박업체를 온라인 단독<br>
						최저가로 만나실 수 있어요. 오직 제주가고싶조에서!</p></h3></td>
		</tr>
		</table>
</body>
</html>
