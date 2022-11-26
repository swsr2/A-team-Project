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
<title>로그인</title>
<!-- 카카오 스크립트 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
Kakao.init('19304f7b1ee5a07ed9d039dba756e0bb'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단
//카카오로그인
function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	  console.log(response)
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
  }
//카카오로그아웃  
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	console.log(response)
        },
        fail: function (error) {
          console.log(error)
        },
      })
      Kakao.Auth.setAccessToken(undefined)
    }
  }  
</script>
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
		<h3>로그인</h3>
		<form method="post" action="/project/member/login.do">
			<input type="text" name="id" placeholder="아이디" class="in"><br>
			<input type="password" name="pwd" placeholder="비밀번호" class="in"><br>
			<input type="submit" id="btn" value="로그인"><br>
			<input type="reset" id="btn" value="다시입력"><br>
			
		<ul>
			<li onclick="kakaoLogin();">
		      <a href="javascript:void(0)">
		          <span>카카오 로그인</span>
		      </a>
			</li>
			<li onclick="kakaoLogout();">
		      <a href="javascript:void(0)">
		          <span>카카오 로그아웃</span>
		      </a>
			</li>
		</ul>
			
			<br><br>
			<a href="${contextPath}/project/member/findIdForm.do" style="text-decoration: none;">아이디 찾기</a>  | 
			<a href="${contextPath}/project/member/findPwdForm.do" style="text-decoration: none;">비밀번호 찾기</a> | 
			<a href="${contextPath}/project/member/memberForm.do" style="text-decoration: none;">회원가입</a> 
		</form>
	</div>
	<div style="margin: 120px;"></div>
</body>
</html>