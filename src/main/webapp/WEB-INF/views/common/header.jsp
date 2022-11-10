<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<div id="loginBar">
	<ul id="loginBarList">
		<li><button type="button" class="addMemBtn">회원가입</button></li>
		<li><button type="button" class="loginBtn">로그인</button></li>
	</ul>
</div>
<div id="head">
<img src="${path }/resources/image/logo.png" width="150" height="150" >
	<div class="search">
     	<input type="text" id="inputSearch" placeholder="검색어를 입력해주세요." style="width:500px;">
      	<button class="search_btn">검색</button>
</div>
</div>
