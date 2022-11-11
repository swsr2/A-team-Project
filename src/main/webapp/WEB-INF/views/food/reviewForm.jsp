<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>맛집 리뷰</title>
<style>
form {
   display: inline;
}

</style>
<script>
   function backToList() {
      let form = document.articleForm;
      form.action = "${path}/board/listArticles.do"
      form.submit();
   }
</script>
</head>
<body>

   <form name="reviewForm" method="post" action="${path }/">
         <table align="center">
         <tr>
         	<td colspan="2">
         		<h3 style="text-align:left">리뷰쓰기</h3>
         	</td>
         </tr>
         <tr>
            <td>
               <textarea name="content" rows="10" cols="50" maxlength="4000" style="resize:none;">
               </textarea>
            </td>
         </tr>
         <tr>
         	<td align="left"><div class="star-rating">
			<input type="radio" id="5-stars" name="rating" value="5" />
			<label for="5-stars" class="star">&#9733;</label>
			<input type="radio" id="4-stars" name="rating" value="4" />
			<label for="4-stars" class="star">&#9733;</label>
			<input type="radio" id="3-stars" name="rating" value="3" />
			<label for="3-stars" class="star">&#9733;</label>
			<input type="radio" id="2-stars" name="rating" value="2" />
			<label for="2-stars" class="star">&#9733;</label>
			<input type="radio" id="1-star" name="rating" value="1" />
			<label for="1-star" class="star">&#9733;</label>
			</div></td>
         </tr>
         <tr>
            <td colspan="2" align="right">
               <input type="submit" value="리뷰등록">
               <input type="button" value="돌아가기" onClick="backToList()">
            </td>
         </tr>
      </table>   
   </form>
   <br><br>
</body>
</html>