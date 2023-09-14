<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="member.reg" method="post" enctype="multipart/form-data" onsubmit="return memberRegCheck(this);">
		<table id="memberRegTable">
			<tr>
				<th>회원가입</th>
			</tr>
			<tr>
				<td align="center">
					<input id="memberJoinID" name="sm_id" class="textType" placeholder="id" maxlength="12" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="sm_pw" class="textType" type="password" placeholder="pw" maxlength="20" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="sm_pwChk" class="textType" type="password" placeholder="pw확인" maxlength="20" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="sm_name" class="textType" placeholder="이름" maxlength="10" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td style="padding-left: 35px; height: 55px;">
					주민등록번호&nbsp;
					<input name="sm_jumin1" class="jumin1" placeholder="xxxxxx" maxlength="6" autocomplete="off"> -
					<input name="sm_jumin2" class="jumin2" placeholder="x" maxlength="1" autocomplete="off">XXXXXX
				</td>
			</tr>
			<tr>
				<td align="center">
					<input id="joinAddr1" name="sm_addr1" class="textType" placeholder="우편번호" autocomplete="off" readonly="readonly"> <br>
					<input id="joinAddr2" name="sm_addr2" class="textType" placeholder="주소" autocomplete="off" readonly="readonly"><br>
					<input id="joinAddr3" name="sm_addr3" class="textType" placeholder="상세주소" maxlength="50" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td style="padding-left: 35px; height: 55px;">
					 프사&nbsp;&nbsp;
					<input name="sm_img" type="file">
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