<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="bd" items="${bmsgs }">
		<table id="bbsDetailTitle">
			<tr>
				<td class="title">${bd.title }</td>
			</tr>
		</table>
		<table id="bbsDetailWriter">
			<tr>
				<td class="writer">작성자 : ${bd.writer }</td>
			</tr>
			<tr>
				<td class="date"><fmt:formatDate value="${bd.date }"
						type="both" dateStyle="long" timeStyle="short" /></td>
			</tr>
			<tr>
				<c:choose>
					<c:when test="${sessionScope.loginMember.id == bd.writer }">
						<td align="right">
							<button
								onclick="updateBBSMsg(${bd.no }, '${bd.title }', '${bd.txt }');">수정</button>
							<button onclick="deleteBBSMsg(${bd.no });">삭제</button>
						</td>
					</c:when>
				</c:choose>
			</tr>
		</table>
		<table id="bbsDetailTxt">
			<tr>
				<td class="txt">${bd.txt }</td>
			</tr>
		</table>
		<table id="bbsDetailReply">
			<tr>
				<td>댓글</td>
				<td align="right"><c:if
						test="${sessionScope.loginMember != null }">
						<button onclick="writeReply(${bd.no }, '${bd.writer }');">쓰기</button>
					</c:if></td>
			</tr>
			<tr>
				<td><c:forEach var="br" items="${bd.replys }">
						<span class="bbsReplyWriter">${br.writer }</span>
				${br.txt } - 
				<fmt:formatDate value="${br.date }" type="both" dateStyle="short"
							timeStyle="short" />
					</c:forEach></td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>