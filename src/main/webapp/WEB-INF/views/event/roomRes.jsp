<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
  Date date = new Date();
%>
<c:set var="nowMonth" value="<%= date.getMonth()+1 %>" />
<c:set var="nowDay" value="<%= date.getDay() %>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맛집 상세페이지</title>
<script>
	function myPick(){
		let heart = document.getElementById("heart");
		let imgName = heart.getAttribute("src");
		if(imgName == "${path }/resources/image/empty_heart.jpg"){
			if(confirm('찜 하시겠습니까?')){
				location.href='${path}/food/myPick?fd_no=${food.fd_no}&pick=true';
			}
		} else {
			location.href='${path}/food/myPick?fd_no=${food.fd_no}&pick=false';
		}
	}
</script>
<style>
form {
	display: inline;
}

#myMenu {
	width: 100%;
	bottom: 0%;
	padding: 5px;
}

li button {
	border: 0;
	background: transparent;
	color: black;
}

#myMenuList {
	margin: 0px;
}

#myMenuList li {
	list-style-type: none;
	float: right;
	padding-right: 20px;
}

.myPick:hover, .myReview:hover {
	color: black;
}

td {
	padding-top: 10px;
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
	<br>
	<br>
	<br>
	<table align="center" width="60%">
		<tr>
			<td colspan="2" align="center"><img src="${room.r_imgPath }"
				onerror="this.src='${path }/resources/image/empty_img.png'"
				width="500" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><h2>${room.r_title }</h2></td>
		</tr>
		<tr>
			<td colspan="2" align="center">기준인원 ${room.r_person }명/최대인원 ${room.r_person+2 }명</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><c:choose>
					<c:when test="${nowMonth >= 5  and nowMonth <= 10  }">
						<c:choose>
							<c:when test="${nowDay == 6 or nowDay == 7 }">
										${room.peak_weekend }
							</c:when>
							<c:otherwise>
										${room.peak_weekDay }
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${nowDay == 6 or nowDay == 7 }">
										${room.low_weekend }
							</c:when>
							<c:otherwise>
										${room.low_weekDay }
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose> 원
			</td>
			</tr>
		<tr>
			<td width="100">체크인 시간 :</td>
			<td>${lodging.lod_checkIn }</td>
		</tr>
		<tr>
			<td width="100">체크아웃 시간 :</td>
			<td>${lodging.lod_checkOut }</td>
		</tr>
		<tr>
			<td colspan="2">${room.r_info }</td>
		</tr>
		<tr>
			<td>부대시설 : </td>
			<td>
				<c:if test="${room.r_bathfacility == Y }">
					목욕용품 &nbsp;&nbsp;
				</c:if>
				<c:if test="${room.r_aircon == Y }">
					에어컨 &nbsp;&nbsp;
				</c:if>
				<c:if test="${room.r_tv == Y }">
					TV &nbsp;&nbsp;
				</c:if>
				<c:if test="${room.r_internet == Y }">
					인터넷 &nbsp;&nbsp;
				</c:if>
				<c:if test="${room.r_toiletries == Y }">
					세면도구 &nbsp;&nbsp;
				</c:if>
				<c:if test="${room.r_cook == Y }">
					취사용품 &nbsp;&nbsp;
				</c:if>
				<c:if test="${room.r_hairdryer == Y }">
					헤어드라이기 &nbsp;&nbsp;
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>