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
<title>회원등록창</title>
<script>
	function fn_idChk(){
		$.ajax({
			url: "./idChk",
			type : "post",
			dataType : "json",
			console.log(id);
			data : {"id":$("#id").val()},
			success : function(data){
				if(data == 1){
					alert("중복된 아이디입니다.");
				} else if(data == 0){
					$("#idChk").attr("value", "Y");
					alert("사용가능한 아이디입니다.");					
				}
			}	
		})
		
	}

</script>
</head>
<body>
	<form method="post" action="${path }/member/addMember.do">
		<h1 style="text-align:center;">회원 가입 등록창</h1>
		<table align="center">
			<tr>
				<td width="200"><p align="right">아이디</p></td>
				<td width="400"><input type="text" id="id" name="id"></td>
				<td ><button onclick="fn_idChk()" >중복확인</button></td>
			</tr>
			<tr>
				<td width="200"><p align="right">비밀번호</p></td>
				<td width="400"><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이름</p></td>
				<td width="400"><input type="text" name="name"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">나이</p></td>
				<td width="400"><input type="text" name="age"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">성별</p></td>
				<td width="400">
					<input type="radio" name="gender" value="M">남자
					<input type="radio" name="gender" value="W">여자
				</td>
			</tr>
			<tr>
				<td width="200"><p align="right">전화번호</p></td>
				<td width="400"><input type="text" name="tel"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이메일</p></td>
				<td width="400"><input type="email" name="email"></td>
			</tr>
			<tr>
				<td width="200"><p>&nbsp;</td>
				<td width="400">
					<input type="submit" value="가입하기">
					<input type="reset" value="다시입력">
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>