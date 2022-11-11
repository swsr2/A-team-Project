<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>@@로그인@@</title>
<c:set var="result" value="${param.result }" />
<c:choose>
	<c:when test="${result == 'loginFailed' }">
		<script>
			window.onload = function(){
				alert('아이디나 비밀번호가 틀립니다. 다시 로그인 하세요!.');
			}
		</script>
	</c:when>
</c:choose>
 <meta charset="UTF-8">
    <title>Login Form</title>
    	
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap');

        * {
            font-family: 'Noto Sans KR', sans-serif;
        }

        body {
            background-color: white;
        }

        div {
            margin: auto;
            width: auto;
            background-color: #EEEFF1;
            border-radius: 5px;
            text-align: center;
            padding: 20px;
        }

        input {
            width: 20%;
            padding: 10px;
            box-sizing: border-box;
            border-radius: 5px;
            border: none;
        }

        .in {
            margin-bottom: 20px;
        }

        #btn {
            background-color: #FD9F28;
            margin-bottom: 10px;
            color: white;
        }

        a {
            text-decoration: none;
            color: #9B9B9B;
            font-size: 12px;
        }
        
       	h3 { text-align: center; }
    </style>
</head>
<body>
<h3 > 로그인 </h3>
<div>
        <form method="post" action="/member02/member/login.do">
            <input type="text" name="id" placeholder="아이디" class="in"><br>
            <input type="password" name="pwd" placeholder="비밀번호" class="in"><br>
            <input type="submit" id="btn" value="로그인"><br>
            <input type="reset" id="btn" value="다시 입력"><br>
        </form>  
    </div>
</body>
</html>