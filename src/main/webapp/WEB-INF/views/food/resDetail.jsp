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
				heart.setAttribute("src","${path }/resources/image/not_empty_heart.png");
				if(heart.getAttribute("src")=="${path }/resources/image/not_empty_heart.png") {
					loca
				}
			}
		} else {
			heart.setAttribute("src","${path }/resources/image/empty_heart.jpg");
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

</style>
</head>
<body>
	<form name="food1" action="/project/food/main">
		<input type="hidden" name="page" value="1">
        <input class="category" type='submit' value='맛집'/>
    </form>
	<form name="food2" action="/project/food/cafe">
		<input type="hidden" name="page" value="1">
        <input class="category" type='submit' value='카페'/>
    </form>
    <br><br><br>
    <table align="center">
    	<tr>
 			<td colspan="2" align="center"><img src="${food.fd_imgPath }" width="700"/></td>
     	</tr>
     	<tr>
 			<td colspan="2" align="center"><h2>${food.fd_title }</h2>
 			<c:forEach var="tag" items="${category}">
 					#${tag }
 				</c:forEach>
 			</td>
     	</tr>
     	<tr>
 			<td width="100">설명 :</td>
 			<td>${food.fd_info }</td>
     	</tr>
     	<tr>
 			<td width="100">지번주소 :</td>
 			<td>${food.fd_address }</td> <%-- api로 추후연결하기 --%>
     	</tr>
     	<tr>
 			<td width="100">도로명 주소 :</td>
 			<td>${food.fd_roadAddress }</td>
     	</tr>
     	<tr>
 			<td width="100">전화번호 :</td>
 			<td>${food.fd_phoneNo }</td>
     	</tr>
     	<tr>
 			<td colspan="2">
 				
 			</td>
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
				<img id="heart" src="${path }/resources/image/empty_heart.jpg" width="15">&nbsp;찜하기
			</button>
		</li>
	</ul>
	</div>
	<br>
	<div>
		<hr>
		작성자 : hong<br>
		평점 : ★★★★★<br>
		내용 : 맛있어요!<br>
		
	</div>
</body>
</html>