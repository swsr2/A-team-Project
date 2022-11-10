<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<div id="loginBar">
	<button type="button" class="logBtn">로그인</button>
	<button type="button" class="logBtn">회원가입</button>
</div> 
<img src="${path }/resources/image/logo.png" width="150" height="150" >
<div class="search">
     <input type="text" id="inputSearch" placeholder="검색어를 입력해주세요." style="width:1000px;font-size:25px;">
      <button class="search_btn">검색</button>
</div>
