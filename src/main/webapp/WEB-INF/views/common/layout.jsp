<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title" /></title>
<style>
* {
  box-sizing: border-box;
  font-family: Arial, Helvetica, sans-serif;
}

body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}
/* Style the header */
.header {
  background-color: #f1f1f1;
  padding:0px;
  text-align: center;
}
.header img {
	margin-right:90%;
}
.header button {
	margin-left:90%;
}

/* Style the top navigation bar */
.topnav {
  overflow: hidden;
  background-color: #333;
}

/* Style the topnav links */
.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

/* Change color on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Style the content */
.content {
  background-color: #ddd;
  padding: 10px;
  height: 450px; 
}

/* Style the footer */
.footer {
  background-color: #f1f1f1;
  padding: 10px;
  text-align:center;
}
</style>
</head>
<body>
	<div id="container">
		<div class="header">
			<tiles:insertAttribute name="header" />
		</div>
		<div class="topnav">
			<tiles:insertAttribute name="side" />
		</div>
		<div class="content">
			<tiles:insertAttribute name="body" />
		</div>
		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>