<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상세창</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	function fn_selected(obj){
		obj.style.color= "black";
	}

	window.onload = function(){
		$("#pwdChk").text("변경할 비밀번호를 입력하세요.");
		$("#pwdpwdChk").text("변경할 비밀번호를 한번 더 입력하세요.");
		$("#nameChk").text("변경할 이름을 입력하세요.");
		$("#ageChk").text("변경할 나이를 입력하세요.");
		$("#telChk").text("변경할 전화번호를 입력하세요.");
		$("#emailChk").text("변경할 이메일을 입력하세요.");
		
		
		let val = /^[a-z|A-Z|0-9]{3,15}$/
		
		// 이메일형식 적합여부 검사
		let email_val = /^[a-zA-Z0-9]([-_\.]?[a-zA-Z0-9])*@[a-zA-Z0-9]([-_\.]?[a-zA-Z0-9])*\.[a-zA-Z0-9]{2,3}$/i
		
		// 폰번호 적합여부 검사
		let tel_val = /^010\d{8}$/
		
		// 형식검사 메서드
		function check(val,target){
			if(val.test(target)){
				return true;
			}
		}
		
		// pwd 형식 검사
		$("#pwd").blur(function(){
			var pwd = $("#pwd").val();
			if(pwd != '') {
				if(check(val, pwd)){
					$("#pwdChk").text("사용할 수 있는 패스워드입니다.");
					$("#pwdChk").css("color", "blue");
					$("#submit1").attr("disabled", false);
				} else {
					$("#pwdChk").text("패스워드가 형식에 맞지않습니다.");
					$("#pwdChk").css("color", "red");
					$("#pwd").val("");
					$("#submit1").attr("disabled", true);
				}
			} else {
				$("#pwdChk").text("");
			}
		})
		
		// pwd , pwd확인 검사
		$("#pwdpwd").blur(function(){
			var pwd = $("#pwd").val();
			var pwdpwd = $("#pwdpwd").val();
			if(pwdpwd != '') {
				if(pwdpwd == pwd){
					$("#pwdpwdChk").text("패스워드가 일치 합니다.");
					$("#pwdpwdChk").css("color", "blue");
					$("#submit1").attr("disabled", false);
				} else {
					$("#pwdpwdChk").text("패스워드가 일치하지 않습니다.");
					$("#pwdpwdChk").css("color", "red");
					$("#pwdpwdChk").val("");
					$("#submit1").attr("disabled", true);
				}
			} else {
				$("#pwdpwdChk").text("");
			}
		})
		
		// 이름 형식 검사
		$("#name").blur(function(){
			var name = $("#name").val();
			if(name != ''){
					$("#nameChk").text("이름이 변경되었습니다.");
					$("#nameChk").css("color", "blue");
					$("#submit1").attr("disabled", false);
			}else {
				$("#nameChk").text("변경할 이름을 입력하세요.");
			}
		})
		
			// 나이 형식 검사
		$("#age").blur(function(){
			var age = $("#age").val();
			if(age != ''){
					$("#ageChk").text("나이가 변경되었습니다.");
					$("#ageChk").css("color", "blue");
					$("#submit1").attr("disabled", false);
			}else {
				$("#ageChk").text("변경할 나이를 입력하세요.");
			}
		})
		

		
		// 전화번호 형식 검사
		$("#tel").blur(function(){
			var tel = $("#tel").val();
			if(tel != '') {
				if(check(tel_val, tel)){
					$("#telChk").text("전화번호가 변경되었습니다.");
					$("#telChk").css("color", "blue");
					$("#submit1").attr("disabled", false);
				} else {
					$("#telChk").text("전화번호가 형식에 맞지않습니다. ex) 01012345678");
					$("#telChk").css("color", "red");
					$("#tel").val("");
					$("#submit1").attr("disabled", true);
				}
			} else {
				$("#telChk").text("ex) 01012345678");
			}
		})
		
		// 이메일 형식 검사
		$("#email").blur(function(){
			var email = $("#email").val();
			if(email != '') {
				if(check(email_val, email)){
					$("#emailChk").text("이메일이 변경되었습니다.");
					$("#emailChk").css("color", "blue");
					$("#submit1").attr("disabled", false);
				} else {
					$("#emailChk").text("이메일이 형식에 맞지않습니다. ex) test@test.com");
					$("#emailChk").css("color", "red");
					$("#email").val("");
					$("#submit1").attr("disabled", true);
				}
			} else {
				$("#emailChk").text("ex) test@test.com");
			}
		})
	}
	
	function deleteMember(id){
		if(window.confirm('탈퇴하시겠습니까?')){
			location.href="/project/member/delMember.do?id="+id;
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

/* input type number 일 때 우측에 화살표 없애기 */
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
}

.in {
	border: 1px solid black;
}

#btn {
	background-color: #FD9F28;
	margin-bottom: 10px;
	color: white;
}

select {
	width: 20%;
	padding: 10px;
	box-sizing: border-box;
	border-radius: 5px;
	margin-bottom: 20px;
	border: 1px solid black;
	color: black;
}

.check{
	width: 20%;
	font-size: 10px;
	margin-left: 15px;
	display: inline-flex;
	margin-top: 10px;
	margin-bottom: 10px;
}
</style>

</head>
<body>
<div align="center">
	<form method="post" action="/project/member/modMember.do">
		<h1 style="text-align:center;">회원 정보 상세창</h1>
		<input type="text" id="id" name="id" class="in" value="${member.id }" readonly="readonly"><br>
			<span id="idChk" class="check"></span><br>
		<input type="password" id="pwd" name="pwd" value="${member.pwd }" class="in"><br>
			<span id="pwdChk" class="check"></span><br>
		<input type="password" id="pwdpwd" name="pwdpwd" placeholder="비밀번호 확인" class="in"><br>
			<p id="pwdpwdChk" class="check"></p><br>
		<input type="text" id="name" name="name" value="${member.name }" class="in"><br>
			<p id="nameChk" class="check"></p><br>
		<input type="number" id="age" name="age" value="${member.age}" class="in"><br>
			<p id="ageChk" class="check"></p><br>
		<input type="text" id="tel" name="tel" value="${member.tel }" class="in"><br>
			<p id="telChk" class="check"></p><br>
		<input type="email" id="email" name="email" value="${member.email }" class="in"><br>
			<p id="emailChk" class="check"></p><br>
		<select class="select" name="gender" onclick="fn_selected(this)">
				<option selected disabled hidden>
					<c:set var="gender" value="${member.gender }" />
					<c:if test="${gender eq 'M' }">
						<a>남성</a>
					</c:if>
					<c:if test="${gender eq 'W' }">
						<a>여성</a>
					</c:if>
				</option>
				<option value="M">남성</option>
				<option value="W">여성</option>
			</select>
			<br>
				<td width="400">
					<input type="submit" id="btn" value="수정하기"><br>
					<input type="button" id="btn" value="뒤로가기" onclick="location.href='${path }/mypage/mypagemain'"><br>
					<input type="button" id="${member.id }" value="회원탈퇴" onclick="deleteMember(id);"><br>
				</td>
	</form>
	</div>
		<div style="margin: 120px;"></div>	
</body>
</html>