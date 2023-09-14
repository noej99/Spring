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
	<c:forEach var="im" items="${images }">
		<table id="galleryTable">
			<c:if test="${im.sg_writer == sessionScope.loginMember.sm_id }">
			<tr>
				<td align="right"><a onclick="galleryDelete(${im.sg_no});"><img src="resources/img/delete.png" style="width: 25px;"></a></td>
			</tr>
			</c:if>
			<tr>
				<td align="right"><fmt:formatDate value="${im.sg_date }"
						type="both" dateStyle="long" timeStyle="short" /></td>
			</tr>
			<tr>
				<td align="left">작성자 : ${im.sg_writer }</td>
			</tr>
			<tr>
				<td align="center" colspan="2"
					style="padding-top: 10px; border-top: black solid 2px; border-bottom: black solid 2px;"><img
					src="resources/img/${im.sg_img }"></td>
			</tr>
			<tr>
				<td align="left" colspan="2"
					style="padding-top: 15px; padding-left: 30px;">${im.sg_txt }</td>
			</tr>
		</table>
	</c:forEach>
	<br>
	<br>
	<br>

	<table id="snsControlTable">
		<tr>
			<td align="center">
				<form action="gallery.write" method="post"
					enctype="multipart/form-data"
					onsubmit="return galleryWriteCheck(this);">
					<input name="token" value="${token }" type="hidden">
					<table id="snsWriteTable">
						<tr>
							<td colspan="2" align="center"><img
								src="resources/img/handle.png" id="snsControlHandle">
							</td>
						</tr>
						<tr>
							<td style="padding: 7px;"><input type="file" name="sg_img"
								style="font-family: 'chosun';"></td>
						</tr>
						<tr>
							<td><textarea name="sg_txt" class="textType"
									placeholder="내용" maxlength="420" autocomplete="off"
									style="padding: 7px; height: 120px;"></textarea></td>
							<td rowspan="3"><input type="image"
								src="resources/img/photo.png" style="width: 40px;"></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>