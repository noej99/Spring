<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<table id="loginedTable">
		<tr>
			<td rowspan="2" align="center" class="imgTd"><img
				src="img/${sessionScope.loginMember.wm_photo }"></td>
			<td align="center">
				<%
				// ${sessionScope.어트리뷰트명.멤버변수명 }
				%> 
				${sessionScope.loginMember.wm_name }님<br>어서오세요
			</td>
		</tr>
		<tr>
			<td></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<a href="MemberInfoC"><span class="material-symbols-outlined"> person </span></a> 
				<a href="LoginC"><span class="material-symbols-outlined"> logout </span></a>
			</td>
		</tr>
	</table>
</body>
</html>