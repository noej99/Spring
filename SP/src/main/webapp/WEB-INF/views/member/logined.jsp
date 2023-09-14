<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="loginTable">
		<tr>
			<td></td>
		</tr>
		<tr>
			<td align="right">
				<table style="width: 90%;">
					<tr>
						<td rowspan="2" class="td1"><img
							src="resources/img/${sessionScope.loginMember.sm_img }"></td>
						<td align="center" style="font-size: 15pt;">${sessionScope.loginMember.sm_id }</td>
					</tr>
					<tr>
						<td align="center" colspan="2">
						<a href="member.info.go"><span class="material-symbols-outlined"> person </span></a>
						<a href="member.logout"><span class="material-symbols-outlined"> logout </span></a></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>