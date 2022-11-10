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
.header #login {
	margin-left:90%;
}

/* Style the top navigation bar */
.topnav {
  overflow: hidden;
  background-color: #333;
}

/* Style the top navigation login bar */
#loginBar {
	width:100%;
	top:0%;
	padding: 5px;
	margin-left: 45%;
}
.logBtn{
	border: 0;
	background: transparent;
	color: gray;
}
.logBtn:hover{
	color:black;
}
.logBtn:active{
	color:blue;
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
  background-color: transparent;
  padding: 10px;
  height: 450px; 
}

/* Style the footer */
.footer {
  background-color: #f1f1f1;
  padding: 10px;
  text-align:center;
}
.search {
	position: absolute;
	left : 50%;
	transform: translate(-50%, -50%);
	bottom: 82%;
}
.search_btn {
	position: absolute;
	border:0;
	outline: none;
	font-size: 25px;
	width:70px;
	top:8px;
}
#inputSearch {
		width: 100%;
        padding: 12px 24px;

        background-color: transparent;
        transition: transform 250ms ease-in-out;
        font-size: 14px;
        line-height: 18px;
 		background-repeat: no-repeat;
        background-size: 18px 18px;
        background-position: 95% center;
        border-radius: 50px;
        border: 1px solid #575756;
        transition: all 250ms ease-in-out;
        backface-visibility: hidden;
        transform-style: preserve-3d;
        &:placeholder {
            color: color(#575756 a(0.8));
            text-transform: uppercase;
            letter-spacing: 1.5px;
        }
        
        &:hover,
        &:focus {
            padding: 12px 0;
            outline: 0;
            border: 1px solid transparent;
            border-bottom: 1px solid #575756;
            border-radius: 0;
            background-position: 100% center;
        }
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