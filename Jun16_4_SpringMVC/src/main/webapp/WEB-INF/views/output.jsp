<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/uc.css">
</head>
<body>
	<table id="${ucr.what }">
		<tr>
			<th>변환결과</th>
		</tr>
		<tr>
			<td align="center">
				<fmt:formatNumber value="${ucr.from }" pattern="#.0"/> ${ucr.fromUnit }
			</td>
		</tr>
		<tr>
			<td align="center">
				↓
			</td>
		</tr>
		<tr>
			<td align="center">
				<fmt:formatNumber value="${ucr.to }" pattern="#.0"/> ${ucr.toUnit }
			</td>
		</tr>
	</table>
</body>
</html>











