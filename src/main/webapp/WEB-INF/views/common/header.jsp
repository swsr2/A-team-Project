<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<div id="loginBar">
	<c:choose>
		
		<c:when test="${isLogOn == true && member != null }">	
		<ul>
			<h4>${member.id }님 <a href="${path }/member/logout.do"> 로그아웃
			<a href="${path}/member/memberDetail.do?id=${member.id}">마이페이지</a>
			<a href="${path}/main/main.do">메인으로</a></h4><br>
		</ul>
		</c:when>
		
	<c:otherwise>
	<ul id="loginBarList">
		<li><button type="button" class="addMemBtn"><a href="${path }/member/loginForm.do">로그인</button></li>
		<li><button type="button" class="loginBtn"><a href="${path }/member/memberForm.do">회원가입</button></li>
	</ul>
	</c:otherwise>
	</c:choose>
</div> 
<div id="head">
<img src="${path }/resources/image/logo.png" width="150" height="150" >
	<div class="search">
     	<input type="text" id="inputSearch" placeholder="검색어를 입력해주세요." style="width:500px;">
      	<button class="search_btn">검색</button>
</div>
</div>
