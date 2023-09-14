<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>

	<h2>교재</h2>
	<table id="drTable">
		<tr>
			<th class="th2" align="center">제목</th>
			<th class="th3" align="center">업로더</th>
			<th class="th4" align="center">파일</th>
			<th class="th5" align="center">날짜</th>
		</tr>
		<c:forEach var="df1" items="${df1}">
			<tr style="color: #${df1.sd_category};">
				<td align="center">${df1.sd_title }</td>
				<td align="center">${df1.sd_uploader }</td>
				<td align="center"><a href="dr.download?sd_file=${df1.sd_file }"><img
						src="resources/img/download.png"></a></td>
				<td align="center"><fmt:formatDate value="${df1.sd_date }"
						type="date" dateStyle="short" /></td>
				<c:if test="${df1.sd_uploader == sessionScope.loginMember.sm_id }">
					<td align="right"><a onclick="drDelete(${df1.sd_no});"><img src="resources/img/delete.png"></a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<h2>프로그램</h2>
	<table id="drTable">
		<tr>
			<th class="th2" align="center">제목</th>
			<th class="th3" align="center">업로더</th>
			<th class="th4" align="center">파일</th>
			<th class="th5" align="center">날짜</th>
		</tr>
		<c:forEach var="df2" items="${df2}">
			<tr style="color: #${df2.sd_category};">
				<td align="center">${df2.sd_title }</td>
				<td align="center">${df2.sd_uploader }</td>
				<td align="center"><a href="resources/file/${df2.sd_file }"><img
						src="resources/img/download.png"></a></td>
				<td align="center"><fmt:formatDate value="${df2.sd_date }"
						type="date" dateStyle="short" /></td>
				<c:if test="${df2.sd_uploader == sessionScope.loginMember.sm_id }">
					<td align="right"><a onclick="drDelete(${df2.sd_no});"><img src="resources/img/delete.png"></a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<h2>파일</h2>
	<table id="drTable">
		<tr>
			<th class="th2" align="center">제목</th>
			<th class="th3" align="center">업로더</th>
			<th class="th4" align="center">파일</th>
			<th class="th5" align="center">날짜</th>
		</tr>
		<c:forEach var="df3" items="${df3}">
			<tr style="color: #${df3.sd_category};">
				<td align="center">${df3.sd_title }</td>
				<td align="center">${df3.sd_uploader }</td>
				<td align="center"><a href="resources/file/${df3.sd_file }"><img
						src="resources/img/download.png"></a></td>
				<td align="center"><fmt:formatDate value="${df3.sd_date }"
						type="date" dateStyle="short" /></td>
				<c:if test="${df3.sd_uploader == sessionScope.loginMember.sm_id }">
					<td align="right"><a onclick="drDelete(${df3.sd_no});"><img src="resources/img/delete.png"></a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<h2>기타</h2>
	<table id="drTable">
		<tr>
			<th class="th2" align="center">제목</th>
			<th class="th3" align="center">업로더</th>
			<th class="th4" align="center">파일</th>
			<th class="th5" align="center">날짜</th>
		</tr>
		<c:forEach var="df4" items="${df4}">
			<tr style="color: #${df4.sd_category};">
				<td align="center">${df4.sd_title }</td>
				<td align="center">${df4.sd_uploader }</td>
				<td align="center"><a href="resources/file/${df4.sd_file }"><img
						src="resources/img/download.png"></a></td>
				<td align="center"><fmt:formatDate value="${df4.sd_date }"
						type="date" dateStyle="short" /></td>
				<c:if test="${df4.sd_uploader == sessionScope.loginMember.sm_id }">
					<td align="right"><a onclick="drDelete(${df4.sd_no});"><img src="resources/img/delete.png"></a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
		<br>
	<br>
	<br>	<br>
	<table id="snsControlTable" style="height: 300px;">
		<tr>
			<td align="center">
				<form action="dr.upload" method="post" enctype="multipart/form-data"
					onsubmit="return drUploadCheck(this);">
					<input name="token" value="${token }" type="hidden">
					<table id="snsWriteTable">
						<tr>
							<td colspan="2" align="center"><img
								src="resources/img/handle.png" id="snsControlHandle">
							</td>
						</tr>
						<tr>
							<td><input name="sd_title" class="textType" placeholder="제목"
								maxlength="40" autocomplete="off" style="padding: 7px;"></td>
							<td rowspan="3"><input type="image"
								src="resources/img/upload.png" style="width: 50px;"></td>
						</tr>
						<tr>
							<td style="padding: 7px;"><input type="radio"
								name="sd_category" checked="checked" value="E57373">교재&nbsp;&nbsp;
								<input type="radio" name="sd_category" value="81C784">프로그램&nbsp;&nbsp;
								<input type="radio" name="sd_category" value="64B5F6">파일&nbsp;&nbsp;
								<input type="radio" name="sd_category" value="E0E0E0">기타
							</td>
						</tr>
						<tr>
							<td style="padding: 7px;"><input type="file" name="sd_file"
								style="font-family: 'chosun';"></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>