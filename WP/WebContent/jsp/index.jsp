<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>WP</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/member.css">
<link rel="stylesheet" href="css/sns.css">
<link rel="stylesheet" href="css/bbs.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<script type="text/javascript" src="js/noejValidChecker.js"></script>
<script type="text/javascript" src="js/wpCheck.js"></script>
<script type="text/javascript" src="js/wpMove.js"></script>
</head>
<body>
	<table id="titleArea">
		<tr>
			<td align="center" id="title">
				<a href="HC">Sample</a>
			</td>
		</tr>
		<tr>
			<td align="center" id="menuArea">
				<a href="SNSC">sns게시판</a>
				<a href="BBSC">자유게시판</a>
				<a href="">갤러리</a>
				<a href="">자료실</a>
			</td>
		</tr>
	</table>
	<table id="loginArea">
		<tr>
			<td align="center">
				<jsp:include page="${loginPage }"></jsp:include>
			</td>
		</tr>
	</table>
	<table id="contentArea">
		<tr>
			<td align="center">
				<jsp:include page="${contentPage }"></jsp:include>
			</td>
		</tr>
	</table>
	<div id="resultDiv">${result }</div>
</body>
</html>