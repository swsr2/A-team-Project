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
@import url(http://fonts.googleapis.com/earlyaccess/hanna.css);
@import url(https://cdn.jsdelivr.net/gh/moonspam/NanumSquare@1.0/nanumsquare.css);﻿
* {
  box-sizing: border-box;
  font-family: 'Hanna', serif;
}

body {
  margin: 0;
  font-family: 'Hanna', serif;
}
/* Style the header */
.header {
  background-color: #f1f1f1;
  padding:0px;
  text-align: center;
}
.header img {
	position:absolute;
	right:90%;
}
.header #head {
	width: 100%;
	height:160px;
}

.info {
	font-family: 'NanumSquare', sans-serif;
}

/* Style the top navigation bar */
.topnav {
  overflow: auto;
  background-color: #333;
}

/* Style the top navigation login bar */
#loginBar {
	width:100%;
	top:0%;
	padding: 5px;
}
li button{
	border: 0;
	background: transparent;
	color: gray;
}
#loginBarList{
margin: 0px;
}
#loginBarList li{
	list-style-type: none;
	float: right;
	padding-right: 10px;
}

.loginBtn:hover, .addMemBtn:hover {
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
  overflow : auto;
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
	top:13%;
}
.search_btn {
	position:absolute;
	border:0;
	outline: none;
	font-size: 25px;
	width:70px;
	top:3px;
}
#inputSearch {
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