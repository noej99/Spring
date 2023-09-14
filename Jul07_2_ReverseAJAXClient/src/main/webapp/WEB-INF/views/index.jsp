<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript" src="http://195.168.9.62:1577/socket.io/socket.io.js"></script>
<script type="text/javascript">
	function show() {
		$.getJSON("coffee.get", function(data) {
			$("table").empty();
			$.each(data.coffees, function(i, c){
				var nTd = $("<td></td>").text(c.c_name);
				var pTd = $("<td></td>").text(c.c_price);
				var tr = $("<tr></tr>").append(nTd, pTd);
				$("table").append(tr);
			});
		});
	}	
	$(function() {
		// 실시간
		var socket = io.connect("http://195.168.9.62:1577");
		show();
		$("button").click(function() {
			var n = $("#name").val();
			var p = $("#price").val();
			var	u = "coffee.reg?c_name=" + n + "&c_price=" + p;
			$.getJSON(u, function(data) {
				socket.emit("clientMsg", "등록함");
			});	
			$("#name").val("");
			$("#price").val("");
		});
		socket.on("serverMsg", function(){
			show();
		});
	});

</script>
</head>
<body>
	이름 : <input id="name" autocomplete="off"><p>
	가격 : <input id="price" autocomplete="off"><p>
	<button>등록</button>
	<table border="1"></table>
</body>
</html>