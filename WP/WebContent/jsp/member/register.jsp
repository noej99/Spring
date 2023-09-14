<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="RegisterC" method="post" enctype="multipart/form-data" name="registForm" onsubmit="return registerCheck();">
		<table id="registTable">
			<tr>
				<th>회원가입</th>
			</tr>
			<tr>
				<td align="center">
					<input name="id" placeholder="id" maxlength="10" autofocus="autofocus" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="pw" placeholder="pw" type="password" maxlength="30">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="pwCheck" placeholder="pw확인" type="password" maxlength="30">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="name" placeholder="이름" maxlength="10" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center">
				생년월일<br>
					<select name="y">
						<c:forEach var="y" begin="${cy - 100 }" end="${cy }">
							<option>${y }</option>
						</c:forEach>
					</select>년
					<select name="m">
						<c:forEach var="m" begin="1" end="12">
							<option>${m }</option>
						</c:forEach>
					</select>월
					<select name="d">
						<c:forEach var="d" begin="1" end="31">
							<option>${d }</option>
						</c:forEach>
					</select>일
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="addr1" placeholder="우편번호" autocomplete="off"><p>
					<input name="addr2" placeholder="주소" autocomplete="off"><p>
					<input name="addr3" placeholder="상세주소" autocomplete="off" maxlength="30"><br>
				</td>
			</tr>
			<tr>
				<td align="center">
				프사<br>
					<input name="photo" type="file"><br>
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>가입</button>	
				</td>
			</tr>
		</table>
	</form>
</body>
</html>