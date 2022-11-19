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
    <br><br><br>
    <table align="center" width="60%">
    	<tr>
 			<td colspan="2" align="center"><img src="${lodging.lod_imgPath }" width="500"/></td>
     	</tr>
     	<tr>
 			<td colspan="2" align="center"><h2>${lodging.lod_title }</h2>
 			</td>
     	</tr>
     	<tr>
 			<td width="100">주소 :</td>
 			<td>${lodging.lod_address }</td> <%-- api로 추후연결하기 --%>
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
 			<td>${lodging.lod_homePage }</td>
     	</tr>
     	<tr>
 			<td width="100">설명 :</td>
 			<td>${lodging.lod_info }</td>
     	</tr>
     	
    </table>
    
    <div id="myMenu">
	<ul id="myMenuList">
		<!-- <li><button type="button" class="myPickBtn">찜하기</button></li>
		<li><button type="button" class="reviewBtn">리뷰쓰기</button></li> -->
		<li><a class="myReview" href="${path }/food/myReview?fd_no=${food.fd_no}">리뷰쓰기</a></li>
		<li>
			<%-- <a class="myPick" href="${path }/food/myPick">찜하기</a> --%>
			<button id="myPick" onclick="myPick()">
				<c:choose>
				<c:when test="${pick }">
					<img id="heart" src="${path }/resources/image/not_empty_heart.png" width="15">&nbsp;찜하기
				</c:when>
				<c:otherwise>
					<img id="heart" src="${path }/resources/image/empty_heart.jpg" width="15">&nbsp;찜하기
				</c:otherwise>
				</c:choose>
			</button>
		</li>
	</ul>
	</div>
	<br><br>
	<hr>
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