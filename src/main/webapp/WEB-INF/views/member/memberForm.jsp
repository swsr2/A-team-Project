<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
/* function fn_idChk(){
	$.ajax({
		url : "${path}/idChk",
		type : "get",
		dataType : "json",
		data : {"id" : $("#id").val()},
		success : function(result){
			console.log(result);
			if(result == 1){
				alert("중복된 아이디입니다.");
			}else if(result == 0){
				$("#idChk").attr("value", "Y");
				alert("사용가능한 아이디입니다.");
			}
			
		},
		error:function(result){
			console.log(result);
		}
	});
} */

function fn_selected(obj){
	obj.style.color= "black";
}

window.onload = function() {
	// id 와 pw 적합여부 검사(4~12자리, 영어대소문자, 숫자만 가능)
	/* let val = /^[a-zA-Z0-9]{4,15}$/ */
	let val = /^[a-z]{3,15}$/
	
	// 이메일형식 적합여부 검사
	let mail_val = /^[a-zA-Z0-9]([-_\.]?[a-zA-Z0-9])*@[a-zA-Z0-9]([-_\.]?[a-zA-Z0-9])*\.[a-zA-Z0-9]{2,3}$/i
	
	// 폰번호 적합여부 검사
	let phone_val = /^010-(?:\d{4})-\d{4}$/
	
	// 이름 유효성 검사
	let name_val = /^[a-zA-Zㄱ-ㅎ|ㅏ-ㅣ|가-힣]{1,15}$/
	
	// 나이 유효성 검사
	let age_val = /^(?:\d{1}|\d{2}|\d{3})$/
	
	// 형식검사 메서드
	function check(val,target){
		if(val.test(target)){
			return true;
		}
	}
	
	// id 중복 검사
	$("#id").blur(function(){
		var id = $("#id").val();
		if(id != '') {
			if(check(val, id)){
				$.ajax({
					url: '${path}/idChk',
					type: 'GET',
					dataType : "json",
					data : {"id" : $("#id").val()},
					success: function(data){
						if(data == "0") {
							$("#idChk").text("사용할 수 있는 ID입니다.");
							$("#idChk").css("color", "blue");
							$("#submit1").attr("disabled", false);
						} else if(data == "1") {
							$("#idChk").text("사용중인 ID입니다.");
							$("#idChk").css("color", "red");
							$("#submit1").attr("disabled", true);
						}
					},
					error: function(){
						console.log("id 중복확인의 ajax 에러");
					}
				})
			} else {
				$("#idChk").text("ID가 형식에 맞지않습니다.");
				$("#idChk").css("color", "red");
				$("#id").val("");
				$("#submit1").attr("disabled", true);
			}
		} else {
			$("#idChk").text("");
		}
	})
	
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

select {
	width: 20%;
	padding: 10px;
	box-sizing: border-box;
	border-radius: 5px;
	margin-bottom: 20px;
	border: 1px solid black;
	color: gray;
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
		<h3>회원가입</h3>
		<form method="post" action="/project/member/addMember.do">
			<!-- <div style="width: 20%;">
			    <input type="text" onchange="idChk;" id="id" name="id" placeholder="아이디" class="in" style="width: 70%; margin-bottom: 0px;">
			<button class="idChk" type="button" id="idChk" onchange="fn_idChk();" style="width: 28%; margin-bottom: 0px;">중복확인</button>
			</div> -->
			<input type="text" id="id" name="id" placeholder="아이디" class="in"><br>
			<span id="idChk" class="check"></span><br>
			<input type="password" id="pwd" name="pwd" placeholder="비밀번호" class="in"><br>
			<span id="pwdChk" class="check"></span><br>
			<input type="password" name="pwdChk" placeholder="비밀번호 확인" class="in"><br>
			<p id="idChk" class="check"></p><br>
			<input type="text" name="name" placeholder="이름" class="in"><br>
			<p id="idChk" class="check"></p><br>
			<input type="number" name="age" placeholder="나이" class="in"><br>
			<p id="idChk" class="check"></p><br>
			<input type="text" name="tel" placeholder="전화번호" class="in"><br>
			<p id="idChk" class="check"></p><br>
			<input type="email" name="email" placeholder="이메일" class="in"><br>
			<p id="idChk" class="check"></p><br>
			<select class="select" name="gender" onclick="fn_selected(this)">
				<option selected disabled hidden>성별</option>
				<option value="M">남성</option>
				<option value="W">여성</option>
			</select>
			<br>
			<input type="submit" id="btn" value="회원가입"><br>
			<input type="reset" id="btn" value="다시입력"><br>
		</form>
	</div>
	<div style="margin: 120px;"></div>	
</body>
</html>