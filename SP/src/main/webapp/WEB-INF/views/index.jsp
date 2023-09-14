<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주막</title>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/member.css">
<link rel="stylesheet" href="resources/css/sns.css">
<link rel="stylesheet" href="resources/css/dr.css">
<link rel="stylesheet" href="resources/css/gallery.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<script type="text/javascript" src="resources/js/noejValidChecker.js"></script>
<script type="text/javascript" src="resources/js/spCheck.js"></script>
<script type="text/javascript" src="resources/js/spMove.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/sp_jQuery.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script  type="text/javascript"  charset="utf-8">  
    (function(w,d,t,f){  w[f]=w[f]||function(c,k,n){s=w[f],k=s['k']=(s['k']||(k?('&k='+k):''));s['c']=  
    c=(c  instanceof  Array)?c:[c];s['n']=n=n||0;L=d.createElement(t),e=d.getElementsByTagName(t)[0];  
    L.async=1;L.src='//feed.aqicn.org/feed/'+(c[n].city)+'/'+(c[n].lang||'')+'/feed.v1.js?n='+n+k;  
    e.parentNode.insertBefore(L,e);  };  })(  window,document,'script','_aqiFeed'  );    
</script>
<script  type="text/javascript"  charset="utf-8">  
    _aqiFeed({  container:"city-aqi-container",  city:"seoul", lang:"kr"  });  
</script>
</head>
<body>
<div id="weatherIcon">
	<span  id="city-aqi-container"></span>
</div>
	<table id="siteTitleArea">
		<tr>
			<td align="center">
				<table id="siteTitle">
					<tr>
						<td><a href="index.do">주막</a></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td align="center"><jsp:include page="${loginPage }"></jsp:include>
			</td>
		</tr>
	</table>
	<c:if test="${sessionScope.loginMember != null }">
		<table id="siteMenu">
			<tr>
				<td align="center">
					<a href="gallery.go">갤러리</a>
					<br>
					<br>
					<br>
					<a href="dr.go">자료실</a>
				</td>
			</tr>
		</table>
	</c:if>
	<table id="siteContentArea">
		<tr>
			<td align="center">
				<jsp:include page="${contentPage }"></jsp:include>
			</td>
		</tr>
	</table>
	<table id="siteResult">
		<tr>
			<td align="center">
				${result }
			</td>
		</tr>
	</table>
	<c:if test="${sessionScope.loginMember != null }">
	<div id="menuHandle">
		<img src="resources/img/menu.png">
	</div>
	</c:if>
</body>
</html>