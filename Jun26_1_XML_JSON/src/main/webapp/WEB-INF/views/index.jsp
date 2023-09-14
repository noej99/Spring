<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
	$(function(){
		$("button").click(function(){
			$.ajax({
				url : "coffee.get",
				success : function(abc) {
					$(abc).find("coffee").each(function(i, c){
						alert($(c).find("jc_name").text());
						alert($(c).find("jc_price").text());
					});
				}
			});
			// 비동기식이라 alert("ㅋ");이 먼저 돔
			// alert("ㅋ");
		});
		$("input").click(function(){
			$.ajax({
				url : "snack.get",
				data : {page : 1},
				success : function(zxc){
					$.each(zxc.snack, function(i, s) {
						alert(s.s_name);
						alert(s.s_price);
					});
				}
			});
		});
	});
</script>
</head>
<body>
	<input>
	<button>버튼</button>
</body>
</html>