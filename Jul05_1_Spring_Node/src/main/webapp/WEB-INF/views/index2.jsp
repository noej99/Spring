<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
	function showSnack() {
		$.get("http://localhost:8888/snack.get", function(abc){
			$("table").empty();
			$.each(abc, function(i, s) {
				var nameTd = $("<td></td>").text(s.s_name);
				var priceTd = $("<td></td>").text(s.s_price);
				var tr = $("<tr></tr>").append(nameTd, priceTd);
				$("table").append(tr);
			});
		});
	$(function(){
		showSnack();
		
		$("button").click(function(){
			var name = $("#i1").val();
			var price = $("#i2").val();
			var u = "http://localhost:8888/snack.reg?n=" + name + "&p=" + price;
			
			// JSON만, 요청헤더는 표현불가
			$.getJSON(u, function(abc){
				alert("등록성공");
				showSnack();
			});		
			/* $.ajax({
				url : "http://localhost:8888/snack.reg",
				data : { n : name, p : price },
				success : function(abc){
					alert(JSON.stringify(abc));
				}
			}); */
		});
	});
</script>
</head>
<body>
	이름 : <input id="i1"><p>
	가격 : <input id="i2"><p>
	<button>등록</button>
	<hr>
	<table border="1"></table>
</body>
</html>