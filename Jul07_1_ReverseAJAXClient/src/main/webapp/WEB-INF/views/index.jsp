<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript" src="http://195.168.9.62:8888/socket.io/socket.io.js"></script>
<script type="text/javascript">
	function show(){
		var u = "http://195.168.9.62:7777/coffee.get";
		$.getJSON(u, function(data){
			$("table").empty();
			$.each(data, function(i, c){
				var nTd = $("<td></td>").text(c.c_name);
				var pTd = $("<td></td>").text(c.c_price);
				var tr = $("<tr></tr>").append(nTd, pTd);
				$("table").append(tr);
			});
		});
	}
	
	$(function() {
		var socket = io.connect("http://195.168.9.62:8888");
		// polling : 주기적으로 요청해서
		//			ReverseAJAX스럽게 보이기는 하는...
		//setInterval(function() {
		//	show();
		//}, 1000);
			show();
		$("button").click(function() {
			var n = $("#name").val();
			var p = $("#price").val();
			var u = "http://195.168.9.62:7777/coffee.reg?n=" + n + "&p=" + p;
			$.getJSON(u, function(){
				alert("ok");
			});
			$("#name").val("");
			$("#price").val("");
		});
		
		socket.on("coffees", function(data){
			$("table").empty();
			$.each(data, function(i, c){
				var nTd = $("<td></td>").text(c.c_name);
				var pTd = $("<td></td>").text(c.c_price);
				var tr = $("<tr></tr>").append(nTd, pTd);
				$("table").append(tr);
			});
		});
	});
</script>
</head>
<body>
	이름 : <input id="name"><p>
	가격 : <input id="price"><p>
	<button>등록</button>
	<table border="1">
	</table>
</body>
</html>