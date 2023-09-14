<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
		<table id="registTable">
	<form action="MemberInfoC" method="post" enctype="multipart/form-data" name="memberUpdateForm" onsubmit="return memberUpdateCheck();">
			<tr>
				<th>회원정보</th>
			</tr>
			<tr>
				<td align="center">
					<input name="id" placeholder="${sessionScope.loginMember.wm_id }" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="pw" value="${sessionScope.loginMember.wm_pw }" type="password" maxlength="30" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="pwCheck" value="${sessionScope.loginMember.wm_pw }" type="password" maxlength="30" autocomplete="off">
					
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="name" value="${sessionScope.loginMember.wm_name }" maxlength="10" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center">
				생년월일 : 
				<span id="memberInfoBD"><fmt:formatDate value="${sessionScope.loginMember.wm_birth }" type="date" dateStyle="long"/></span>
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="addr1" value="${addr1}" placeholder="우편번호" autocomplete="off"><p>
					<input name="addr2" value="${addr2}" placeholder="주소" autocomplete="off"><p>
					<input name="addr3" value="${addr3}" placeholder="상세주소" autocomplete="off" maxlength="30"><br>
				</td>
			</tr>
			<tr>
				<td align="center">
				프사<br>
					<img id="memberInfoImg" src="img/${sessionScope.loginMember.wm_photo }">
					<input name="photo" type="file"><br>
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>수정</button>	
	</form>
					<button onclick="bye();">탈퇴</button>	
				</td>
			</tr>
		</table>
</body>
</html>