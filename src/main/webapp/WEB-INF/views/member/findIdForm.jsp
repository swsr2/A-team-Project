<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>아이디 찾기</title>
<%-- <c:set var="result" value="${param.result }" />
<c:choose>
	<c:when test="${result == 'loginFailed' }">
		<script>
			window.onload = function(){
				alert('아이디나 비밀번호가 틀립니다. 다시 로그인 하세요!.');
			}
		</script>
	</c:when>
</c:choose> --%>
<style>
input {
	width: 20%;
	padding: 10px;
	box-sizing: border-box;
	border-radius: 5px;
	border: none;
}

.in {
	margin-bottom: 20px;
	border: 1px solid black;
}

#btn {
	background-color: #FD9F28;
	margin-bottom: 10px;
	color: white;
}

a {
	color: black;
}
</style>
</head>
<body>

	<div align="center">
		<h3>아이디 찾기</h3>
		<form method="post" action="/project/member/aaa.do">
			<input type="text" name="id" placeholder="이름" class="in"><br>
			<input type="text" name="pwd" placeholder="전화번호" class="in"><br>
			<input type="submit" id="btn" value="아이디 찾기"><br>
			<input type="reset" id="btn" value="다시입력"><br>
			
			<br><br>
			<a href="#" style="text-decoration: none;">비밀번호 찾기</a> | 
			<a href="${contextPath}/project/member/memberForm.do" style="text-decoration: none;">회원가입</a> 
		</form>
	</div>
	<div style="margin: 120px;"></div>
</body>
</html>