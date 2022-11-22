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
	function encoder(r_title,lod_id){
		r_title = encodeURIComponent(r_title);
		location.href='${path}/event/roomRes?lod_id='+lod_id+'&r_title='+r_title;
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
    <br><br><br>
    <table align="center" >
    	<tr>
 			<td colspan="2" align="center"><img src="${lodging.lod_imgPath }"
 				onerror="this.src='${path }/resources/image/empty_img.png'" width="700"/></td>
     	</tr>
     	<tr>
 			<td colspan="2" align="center"><h2>${lodging.lod_title }</h2>
 			</td>
     	</tr>
     	<tr>
 			<td width="100">주소 :</td>
 			<td>${lodging.lod_address }</td> 
     	</tr>
     	<tr>
 			<td width="100">전화번호 :</td>
 			<td>${lodging.lod_tel }</td>
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
 			<td width="100">객실 수 :</td>
 			<td>${lodging.lod_roomCnt }</td>
     	</tr>
     	<tr>
 			<td width="100">홈페이지 :</td>
 			<td>${lodging.lod_homePage } </td>
     	</tr>
     	<tr>
 			<td width="100">설명 :</td>
 			<td width="600">${lodging.lod_info } </td>
     	</tr>
    </table>
  
	<br><br>
	<hr>
	<div id="roomInfo">
	<h4 align="center">${from } ~ ${to }</h4>
	<c:forEach var="room" items="${roomList }">
		<a href="javascript:encoder('${room.r_title}',${room.lod_id })" 
					style="color:black; text-decoration: none;">
		<table align="center" width="40%" style="border-bottom: 1px solid gray;">
				<tr>
					<td rowspan="3" width="200">
						<img src="${room.r_imgPath }"
 						onerror="this.src='${path }/resources/image/empty_img.png'" width="200"/>
					</td>
					<td colspan="2"><b style="font-size: 25px;">${room.r_title }</b></td>
				</tr>
				<tr>
					<td colspan="2">${room.r_info }</td>
				</tr>
				<tr>
					<td>기준인원 ${room.r_person }명/최대인원 ${room.r_person+2 }명 </td>
					<td>
						<c:choose>
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
						</c:choose>
						원
					</td>
				</tr>
		</table>
		</a>
		</c:forEach>	
	</div>
	<div>
		<table align="center" style="width: 60%;">
			<c:forEach var="review" items="${reviewList }">
			<tr>
				<td>${review.id }</td>
				<td>${review.re_writeDate }</td>
				<td><div class="star-ratings">
					<div 
				    class="star-ratings-fill space-x-2 text-lg"
				    style=" width: ${review.re_score * 20}%">
						<span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
					</div>
					<div class="star-ratings-base space-x-2 text-lg">
						<span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
					</div>
				</div></td>
			</tr>
			<tr>
				<td colspan="3">
					<p>${review.re_content }</p>
				</td>
			</tr>
			<tr><td colspan="3"><hr></td></tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>