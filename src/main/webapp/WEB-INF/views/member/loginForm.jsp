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
<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.0.1/kakao.min.js" integrity="sha384-eKjgHJ9+vwU/FCSUG3nV1RKFolUXLsc6nLQ2R1tD0t4YFPCvRmkcF8saIfOZNWf/" crossorigin="anonymous"></script>
<script>
	//SDK를 초기화 합니다. 사용할 앱의 JavaScript 키를 설정해야 합니다.
	window.Kakao.init('19304f7b1ee5a07ed9d039dba756e0bb');
	// SDK 초기화 여부를 판단합니다.
    console.log(Kakao.isInitialized());
	
    function loginWithKakao() {
        window.Kakao.Auth.authorize({
        	scope:'profile,account_email',
        	success: function(authObj){
        		//console.log(authObj);
        		window.Kakao.API.request({
        			uri: '/v2/user/me',
        			success: res => {
        				const email = res.kakao_account.email;
        				const name = res.properties.nickname;
        				
        				console.log(email);
        				console.log(name);
        				
        				$('#kakaoemail').val(email);
        				$('#kakaoname').val(name);
        				document.login_frm.submit();
        			}
        		});
        		
        	}
        	        		
        });
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
			
			
			<div class="form-group row" id="kakaologin">
					<div class="kakaobtn">
						<input type="hidden" name="kakaoemail" id="kakaoemail" />
						<input type="hidden" name="kakaoname" id="kakaoname" />
						<a href="javascript:loginWithKakao();">
							<img src='../resources/image/kakao_login_medium_narrow.png' />
						</a>
					</div>
            </div>
			
			<br><br>
			<a href="${contextPath}/project/member/findIdForm.do" style="text-decoration: none;">아이디 찾기</a>  | 
			<a href="${contextPath}/project/member/findPwdForm.do" style="text-decoration: none;">비밀번호 찾기</a> | 
			<a href="${contextPath}/project/member/memberForm.do" style="text-decoration: none;">회원가입</a> 
		</form>
		
		<%-- kakaoemail을 넘기기 위한 숨겨진  form --%>
		<form action="./kakaologin.do" method="post" name="lfrm" hidden>
			<input type="text" name="kakaoemail" id="kakaoemail" value="" />
		</form>
	</div>
	<div style="margin: 120px;"></div>
</body>
</html>