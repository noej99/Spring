<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	img {width: 70%;}
	table {width:100%;}
</style>
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css" />
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="https://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
<script type="text/javascript">
	function deleteMemo(txt) {
		$.getJSON("http://localhost:7777/memo.delete?txt=" + txt , function(result){
			showMemo;
		});
	}
	
	function showMemo() {
		$.get("http://localhost:7777/memo.get", function(abc){
			$("ul").empty();
			$.each(abc, function(i, m) {
				var d = m.m_date;	// "2023-07-05T08:01:18.028Z"
				var d2 = Date.parse(d);	// 1900-01-01부터 몇 밀리초 지났나
				var d3 = new Date(d2);	// 완성된 날짜객체
				// alert(d3.getFullYear());	// 2023
				// alert(d3.getMonth() + 1);	// 7
				// alert(d3.getDate());		// 5
				var d4 = d3.getFullYear() + "/" + (d3.getMonth() + 1) + "/" + d3.getDate();
				d4 += "	" + d3.getHours() + ":" + d3.getMinutes();
				var br = $("<br>");
				var li = $("<li></li>").attr("onclick", "deleteMemo('"+m.m_txt+"');").append(m.m_txt, br, d4);
				$("ul").append(li);
			});
			// jQuery로 동적으로 listview에 넣은것들 디자인 적용
			$("ul").listview("refresh");
		});
	}
	
	$(function(){
		showMemo();
		$("input").keyup(function(e){
			if (e.keyCode == 13) {
				var txt = $(this).val();
				var u = "http://localhost:7777/memo.reg?txt="+ txt;
				$.getJSON(u, function(result){
					alert("등록성공");
					showMemo();
				});
				$(this).val("");
			} 
		});
	});
</script>
</head>
<body>
	<div data-role="page" id="coverPage">
		<div data-role="header" data-theme="a" data-position="fixed">
			<h1>메모</h1>
		</div>
		<div data-role="content" align="center">
			<a href="#mainPage" data-transition="flow"><img src="resources/got.gif"></a>
		</div>
	</div>
	<!-- ---------------------- -->
	<div data-role="page" id="mainPage">
		<div data-role="header" data-theme="a" data-position="fixed">
			<a href="#coverPage" data-transition="flow" data-icon="arrow-l">back</a>
			<h1>메모</h1>
		</div>
		<div data-role="content" align="center">
			<ul data-role="listview" data-filter="true">
			</ul>
		</div>
		<div data-role="footer" data-position="fixed">
			<input>
		</div>
	</div>
	
</body>
</html>