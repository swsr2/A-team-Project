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
<title>main페이지</title>
<meta charset="utf-8">
<script>
var index = 0;   //이미지에 접근하는 인덱스
window.onload = function(){
    slideShow();
}

function slideShow() {
var i;
var x = document.getElementsByClassName("slide1");  //slide1에 대한 dom 참조
for (i = 0; i < x.length; i++) {
   x[i].style.display = "none";   //처음에 전부 display를 none으로 한다.
}
index++;
if (index > x.length) {
    index = 1;  //인덱스가 초과되면 1로 변경
}   
x[index-1].style.display = "block";  //해당 인덱스는 block으로
setTimeout(slideShow, 3000);   //함수를 4초마다 호출

}
</script>
<style>

#slide{
   	display: flex;
    justify-content: center;
    padding-left:25%; /* 15%가 중앙 */
 }


</style>
</head>
<body>
	<div id="slide">
		<a href="${path }"><img class="slide1" src="${path }/resources/image/004.png" width="70%"></a>
		<a href="${path }/tour/orumm?page=2"><img class="slide1" src="${path }/resources/image/002.png" width="70%"></a>
		<a href="${path }/tour/beach?page=3"><img class="slide1" src="${path }/resources/image/003.png" width="70%"></a>
		<a href="${path }/food/main?page=1"><img class="slide1" src="${path }/resources/image/005.png" width="70%"></a>
		<a href="${path }/event/lodmain"><img class="slide1" src="${path }/resources/image/001.png" width="70%"></a>
		<a href="${path }/event/main"><img class="slide1" src="${path }/resources/image/006.png" width="70%"></a>
	</div>
	
</body>
</html>
