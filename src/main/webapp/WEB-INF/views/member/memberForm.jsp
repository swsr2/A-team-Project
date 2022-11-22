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
function fn_idChk(){
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
}

function fn_selected(obj){
	obj.style.color= "black";
	obj[0].setAttribute("disabled", "disabled");
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

#idChk {
 	padding: 10px;
	box-sizing: border-box;
	border-radius: 5px;
	border: 1px solid black;
}

select {
	width: 20%;
	padding: 10px;
	box-sizing: border-box;
	border-radius: 5px;
	margin-bottom: 20px;
	border: 1px solid black;
	color:gray;
}

</style>
</head>
<body>
	<div align="center">
		<h3>회원가입</h3>
		<form method="post" action="/project/member/addMember.do">
			<div style="width: 20%;">
			    <input type="text" id="id" name="id" placeholder="아이디" class="in" style="width: 70%; margin-bottom: 0px;">
			    <button class="idChk" type="button" id="idChk" onchange="fn_idChk();" style="width: 28%; margin-bottom: 0px;">중복확인</button>
			</div>
			<br>
			<input type="password" name="pwd" placeholder="비밀번호" class="in"><br>
			<input type="text" name="name" placeholder="이름" class="in"><br>
			<input type="text" name="age" placeholder="나이" class="in"><br>
			<input type="text" name="tel" placeholder="전화번호" class="in"><br>
			<input type="email" name="email" placeholder="이메일" class="in"><br>
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