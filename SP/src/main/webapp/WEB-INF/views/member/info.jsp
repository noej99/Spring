<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table id="memberRegTable">
	<form action="member.info.update" method="post" enctype="multipart/form-data" onsubmit="return memberUpdateCheck(this);">
			<tr>
				<th>회원가입</th>
			</tr>
			<tr>
				<td align="center">
					<input name="sm_id" class="textType" value="${sessionScope.loginMember.sm_id }" maxlength="12" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="sm_pw" class="textType" value="${sessionScope.loginMember.sm_pw }" type="password" placeholder="pw" maxlength="20" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="sm_pwChk" class="textType" value="${sessionScope.loginMember.sm_pw }" type="password" placeholder="pw확인" maxlength="20" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="sm_name" value="${sessionScope.loginMember.sm_name }" class="textType" placeholder="이름" maxlength="10">
				</td>
			</tr>
			<tr>
				<td style="padding-left: 35px; height: 55px;">
					생년월일 : <fmt:formatDate value="${sessionScope.loginMember.sm_birthday }" type="date" dateStyle="long"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					<input id="joinAddr1" name="sm_addr1" value="${addr1 }" class="textType" placeholder="우편번호" readonly="readonly"> <br>
					<input id="joinAddr2" name="sm_addr2" value="${addr2 }" class="textType" placeholder="주소" readonly="readonly"><br>
					<input id="joinAddr3" name="sm_addr3" value="${addr3 }" class="textType" placeholder="상세주소" maxlength="50">
				</td>
			</tr>
			<tr>
				<td style="padding-left: 35px; height: 55px;">
					<img src="resources/img/${sessionScope.loginMember.sm_img }">
					<input name="sm_img" type="file">
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>수정</button>
	</form>
					<button onclick="memberDelete();">탈퇴</button>
				</td>
			</tr>
		</table>
</body>
</html>