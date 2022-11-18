<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 항공페이지 </title>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
  <script>
  $(function () {
      $('#date').daterangepicker({
          "locale": {
              "format": "YYYY-MM-DD",
              "separator": " ~ ",
              "applyLabel": "확인",
              "cancelLabel": "취소",
              "fromLabel": "From",
              "toLabel": "To",
              "customRangeLabel": "Custom",
              "weekLabel": "W",
              "daysOfWeek": ["월", "화", "수", "목", "금", "토", "일"],
              "monthNames": ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
              "firstDay": 1
          },
          "startDate": new Date(),
          "endDate": new Date(),
          "drops": "auto"
      }, function (start, end, label) {
          console.log('New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')');
      	  var date1 = start.format('YYYY-MM-DD');
      	  var date2 = end.format('YYYY-MM-DD');
      });
  });
  
  $('input[name="date"]').daterangepicker();
</script>
<style>
form {
	display: inline;
}
</style>
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
	<div align="center" id="airSearch">
		<h1>일정선택</h1>
		<form name="form" action="/project/event/airDetail">
		<table>
		<tr>
			<td><label>출발지</label></td>
			<td><label>도착지</label></td>
		</tr>
		<tr>
			<td><select name="air_departPlace">
				<option value="none" selected disabled>=== 선택 ===</option>
				<option value="GMP">김포</option>
				<option value="CJU">제주</option>
				<option value="PUS">부산/김해</option>
				<option value="KWJ">광주</option>
				<option value="TAE">대구</option>
				<option value="RSU">여수</option>
				<option value="USN">울산</option>
				<option value="WJU">원주/횡성</option>
				<option value="CJJ">청주</option>
				<option value="KPO">포항</option>
				<option value="YNY">양양</option>
			</select></td>
			
			<td ><select name="air_arrivalPlace">
				<option value="none" selected disabled>=== 선택 ===</option>
				<option value="GMP">김포</option>
				<option value="CJU">제주</option>
				<option value="PUS">부산/김해</option>
				<option value="KWJ">광주</option>
				<option value="TAE">대구</option>
				<option value="RSU">여수</option>
				<option value="USN">울산</option>
				<option value="WJU">원주/횡성</option>
				<option value="CJJ">청주</option>
				<option value="KPO">포항</option>
				<option value="YNY">양양</option>
			</select></td>
		</tr>
		<tr>
			<td colspan="4"><label for="From">일정</label>
			<input type="text" id="date" name="date" value="" /></td>
		</tr>
		<tr>
			<td colspan="4"><input type="submit" value="선택완료"></td>
		</tr>
		</table>
		</form>
	</div>
</body>
</html>