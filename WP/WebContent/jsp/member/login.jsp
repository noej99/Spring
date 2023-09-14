<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginC" method="post" name="loginForm" onsubmit="return loginCheck();">
		<table id="loginTable">
			<tr>
				<td align="center">
					<input name="id" placeholder="id" maxlength="10" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="pw" type="password" placeholder="pw" maxlength="30" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>로그인</button>
					<a href="RegisterC">회원가입</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>