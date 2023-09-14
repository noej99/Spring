<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="member.login" method="post" onsubmit="return loginCheck(this);">
		<table id="loginTable">
			<tr>
				<td align="center">
					<input name="sm_id" placeholder="아이디" maxlength="12" autocomplete="off"> <br>
					<input name="sm_pw" type="password" placeholder="비밀번호" maxlength="20"> <br>
					<button>로그인</button>
					<a href="member.reg.go">회원가입</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>