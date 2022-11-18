<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>이벤트 숙박페이지</title>
<style>
form {
	display: inline;
}
</style>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
  $( function() {
    var dateFormat = "mm/dd/yy",
      from = $( "#from" )
        .datepicker({
          defaultDate: "+1w",
          changeMonth: true,
          numberOfMonths: 1
        })
        .on( "change", function() {
          to.datepicker( "option", "minDate", getDate( this ) );
        }),
      to = $( "#to" ).datepicker({
        defaultDate: "+1w",
        changeMonth: true,
        numberOfMonths: 1
      })
      .on( "change", function() {
        from.datepicker( "option", "maxDate", getDate( this ) );
      });
 
    function getDate( element ) {
      var date;
      try {
        date = $.datepicker.parseDate( dateFormat, element.value );
      } catch( error ) {
        date = null;
      }
 
      return date;
    }
  } );
  
  </script>
</head>
<body>
	<form name="event1" action="/project/event/main">
		<input class="category" type='submit' value='항공' />
	</form>
	<form name="event2" action="/project/event/lodmain">
		<input class="category" type='submit' value='숙박' />
	</form>
	<br>
	<br>
	<br>
	<h3>일정선택</h3>
	<form name="selectDate" action="project/event/lodDetail">
	<label for="from">From</label>
	<input type="text" id="from" name="from">
	<label for="to">to</label>
	<input type="text" id="to" name="to">
	<input type="submit" value="선택완료">
	<input type="reset" value="다시선택">
	</form>
</body>
</html>