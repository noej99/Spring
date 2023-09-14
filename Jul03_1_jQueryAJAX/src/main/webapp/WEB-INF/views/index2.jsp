<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript" src="https://cdn.canvasjs.com/canvasjs.min.js"></script>
<script type="text/javascript">
// AJAX (Asynchronous Javascript And Xml)
//		자바스크립트로 비동기식 통신을 해서 XML파싱
//		브라우저의 동일 출처 정책 -> 외부 데이터 사용 불가
//
// Cross-Domain AJAX
//		외부데이터 가져오는 AJAX
//		1) 서버측에서 응답헤더 설정 해놨으면
//		2) 안해놨으면 -> Proxy서버
// $.ajax({
// 		url : "프로토콜://..../주소",
//		data : { param명 : 값, param명 : 값, ... },
//		success : function (받은거) {
//			...
//		}
// });


	$(function() {
		$("button").click(function() {

			$.ajax({
				url : "weather.get",
				data : {
					zone : 111061500
				},
				success : function(abc) {
					$("table").empty();
					var ar = [];
					$(abc).find("data").each(function(i, w){
						if ($(w).find("day").text() == "0") {
							// str -> int  *1
							ar[i] = {x : $(w).find("hour").text() * 1, y : $(w).find("temp").text() * 1};
							var hourTd = $("<td></td>").text($(w).find("hour").text());
							var tempTd = $("<td></td>").text($(w).find("temp").text());
							var wfKorTd = $("<td></td>").text($(w).find("wfKor").text());
							var tr = $("<tr></tr>").append(hourTd, tempTd, wfKorTd);
							$("table").append(tr);
						}
					});
					
					window.onload = function () {
			    		var chart = new CanvasJS.Chart("chartContainer", {
			      			title:{
			      			text: "weather"
			      			},
			       		data: [
			      			{
			        			type: "line",
			        			dataPoints: [
			        				{ x: new Date(2012, 00, 1), y: 450 },
			        		        { x: new Date(2012, 01, 1), y: 414 },
			        		        { x: new Date(2012, 02, 1), y: 520 },
			        		        { x: new Date(2012, 03, 1), y: 460 },
			        		        { x: new Date(2012, 04, 1), y: 450 },
			        		        { x: new Date(2012, 05, 1), y: 500 },
			        		        { x: new Date(2012, 06, 1), y: 480 },
			        		        { x: new Date(2012, 07, 1), y: 480 },
			        		        { x: new Date(2012, 08, 1), y: 410 },
			        		        { x: new Date(2012, 09, 1), y: 500 },
			        		        { x: new Date(2012, 10, 1), y: 480 },
			        		        { x: new Date(2012, 11, 1), y: 510 }
			        			]
			      			}
			      		]
			    	});
			    	chart.render();
			 		}
				}
			});
		});
	});
</script>
</head>
<body>
	<button>버튼</button>
	<hr>
	 <div id="chartContainer" style="height: 300px; width: 100%;">
  </div>
  <hr>
	<table border="1"></table>

</body>
</html>