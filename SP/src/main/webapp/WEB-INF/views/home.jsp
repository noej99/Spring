<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주막</title>
</head>
<body>
	<c:forEach var="sm" items="${msgs }">
		<table class="aSNSMsg" style="border: #${sm.ss_color} solid 2px;">
			<tr>
				<td align="center" class="imgTd" rowspan="4"><img
					src="resources/img/${sm.sm_img }"></td>
				<td class="writerTd">${sm.ss_writer }</td>
				<td align="right" class="dateTd"><fmt:formatDate
						value="${sm.ss_date }" type="both" dateStyle="long"
						timeStyle="short" /></td>
			</tr>
			<c:if test="${sm.ss_writer == sessionScope.loginMember.sm_id }">
				<tr>
					<td align="right" colspan="2">
						<button
							onclick="snsUpdate(${sm.ss_no}, '${sm.ss_txt }', ${page });">수정</button>
						<button onclick="snsDelete(${sm.ss_no });">삭제</button>
					</td>
				</tr>
			</c:if>
			<tr>
				<td class="txtTd" rowspan="1">${sm.ss_txt }</td>
			</tr>
			<tr>
				<td class="replyTd">댓글<br>
					<c:forEach var="sr" items="${sm.ss_reply }">
					<c:choose>
						<c:when test="${sr.ssr_writer == sessionScope.loginMember.sm_id }">
							<div class="sSNSReply">
								<span class="Writer" style="margin-left: 20px; text-shadow: 2px 2px 2px #${sm.ss_color};">${sr.ssr_writer }&nbsp;&nbsp;&nbsp;</span>
								${sr.ssr_txt } - 
								<span class="date">
									<fmt:formatDate value="${sr.ssr_date }" type="both" dateStyle="short" timeStyle="short"/></span>
									<button onclick="snsReplyUpdate(${sr.ssr_no}, '${sr.ssr_txt }', ${page });">수정</button>
									<button onclick="snsReplyDelete(${sr.ssr_no}, ${page });">삭제</button>
							</div>
						</c:when>
						<c:otherwise>
							<div class="sSNSReply">
								<span class="Writer" style="margin-left: 20px; text-shadow: 2px 2px 2px #${sm.ss_color};">${sr.ssr_writer }&nbsp;&nbsp;&nbsp;</span>
								${sr.ssr_txt } - 
								<span class="date">
									<fmt:formatDate value="${sr.ssr_date }" type="both" dateStyle="short" timeStyle="short"/></span>
							</div>
						</c:otherwise>
					</c:choose>
					</c:forEach>
					<c:if test="${sessionScope.loginMember != null }">
						<form action="sns.reply.write" onsubmit="return snsReplyWriteCheck(this);">
							<input name="ssr_ss_no" value="${sm.ss_no }" type="hidden">
							<input name="page" value="${page }" type="hidden">
							<input name="token" value="${token }" type="hidden">
							<span class="writer" style="text-shadow: 2px 2px 2px #${sm.ss_color};">${sessionScope.loginMember.sm_id }</span>
							<input name="ssr_txt" style="border-bottom: #${sm.ss_color} solid 2px;" placeholder="내용" maxlength="150" autocomplete="off"><button>쓰기</button>
						</form>
					</c:if>
				</td>
			</tr>
		</table>
	</c:forEach>
	<table id="snsControlTable">
		<tr>
			<td align="center">
				<form action="sns.search">
					<table id="snsSearchTable">
						<c:if test="${sessionScope.loginMember != null }">
							<tr>
								<td colspan="2" align="center"><img
									src="resources/img/handle.png" id="snsControlHandle"></td>
							</tr>
						</c:if>
						<tr>
							<td align="center"><input name="search" class="textType"
								placeholder="검색" autocomplete="off"> <input type="image"
								src="resources/img/search.png" style="width: 23px;"></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
		<c:if test="${sessionScope.loginMember != null }">
			<tr>
				<td align="center">
					<form action="sns.write" onsubmit="return snsWriteCheck(this);">
						<input name="token" value="${token }" type="hidden">
						<table id="snsWriteTable">
							<tr>
								<td>#<input class="textType" name="ss_color"
									placeholder="FFFFFF" maxlength="6" autocomplete="off"></td>
								<td rowspan="2"><input type="image"
									src="resources/img/brush.png" style="width: 40px;"
									autocomplete="off"></td>
							</tr>
							<tr>
								<td><textarea name="ss_txt" placeholder="내용" maxlength="450"></textarea></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</c:if>
	</table>
					page ${page }
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<c:if test="${page != 1 }">
		<a id="snsL" onclick="snsPageChange(${page - 1});">&lt;</a>
	</c:if>
	<c:if test="${page != pageCount }">
		<a id="snsR" onclick="snsPageChange(${page + 1});">&gt;</a>
	</c:if>
	<table id="blackArea">
		<tr>
			<td align="center">
				<form action="sns.update" onsubmit="return snsUpdateCheck(this);">
				<input name="ss_no" id="snsUpdateNo" type="hidden">
				<input name="page" id="snsUpdatePage" type="hidden">
					<table id="snsWriteTable">
						<tr>
							<td align="right" colspan="2">
								<span id="x" style="cursor: pointer;">X</span>
							</td>
						</tr>
						<tr>
							<td><textarea name="ss_txt" id="snsUpdateTxt" placeholder="내용" maxlength="420"></textarea></td>
							<td rowspan="2" align="right"><input type="image"
								src="resources/img/brush.png" style="width: 40px;"
								autocomplete="off"></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
	<table id="blackArea2">
		<tr>
			<td align="center">
				<form action="sns.reply.update" onsubmit="return snsReplyUpdateCheck(this);">
				<input name="ssr_no" id="snsReplyUpdateNo" type="hidden">
				<input name="page" id="snsReplyUpdatePage" type="hidden">
					<table id="snsWriteTable">
						<tr>
							<td align="right" colspan="2">
								<span id="x2" style="cursor: pointer;">X</span>
							</td>
						</tr>
						<tr>
							<td><textarea name="ssr_txt" id="snsReplyUpdateTxt" placeholder="내용" maxlength="420"></textarea></td>
							<td rowspan="2" align="right"><input type="image"
								src="resources/img/brush.png" style="width: 40px;"
								autocomplete="off"></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>