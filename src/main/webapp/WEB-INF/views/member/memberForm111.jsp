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

</script>
</head>
<body>
	<form name="frm" method="post" action="${path }/member/addMember.do">
		<h1 style="text-align:center;">회원 가입 등록창</h1>
		<table align="center" >
			<tr>
				<td width="70"><p align="right">아이디</p></td>
				<td><input type="text" id="id" name="id"></td>
				<td align="left"><button class="idChk" type="button" id="idChk" onclick="fn_idChk();">중복확인</button></td>
			</tr>
			<tr>
				<td width="70"><p align="right">비밀번호</p></td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td width="70"><p align="right">이름</p></td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td width="70"><p align="right">나이</p></td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td width="70"><p align="right">성별</p></td>
				<td>
					<input type="radio" name="gender" value="M">남자
					<input type="radio" name="gender" value="W">여자
				</td>
			</tr>
			<tr>
				<td width="70"><p align="right">전화번호</p></td>
				<td><input type="text" name="tel"></td>
			</tr>
			<tr>
				<td width="70"><p align="right">이메일</p></td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td width="70"><p>&nbsp;</td>
				<td>
					<input type="submit" value="가입하기">
					<input type="reset" value="다시입력">
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>