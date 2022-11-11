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
   <form name="food1" action="/project/food/main">
        <input type='submit' value='맛집'/>
    </form>
   <form name="food2" action="/project/food/cafe">
        <input type='submit' value='카페'/>
    </form>
    <br><br><br>
   <h5 style="text-align:left;">리뷰쓰기</h5>
   <form name="reviewForm" method="post" action="${path }/">
   		<div class="star-rating">
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
</div>
         <table border="0" align="center">
         <tr>
            <td>
               <textarea name="content" rows="10" cols="65" maxlength="4000" style="resize:none;">
               </textarea>
            </td>
         </tr>
         <tr>
            <td align="right"></td>
            <td colspan="2">
               <input type="submit" value="리뷰등록">
               <input type="button" value="돌아가기" onClick="backToList()">
            </td>
      </table>   
   </form>

</body>
</html>