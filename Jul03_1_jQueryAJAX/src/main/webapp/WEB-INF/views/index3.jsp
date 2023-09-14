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

	function getShopping(start) {
			var search = $("input").val();
			search = encodeURIComponent(search);
			
			$.ajax({
				url : "shopping.get",
				data : { query : search, s : start },
				beforeSend : function(req){
					req.setRequestHeader("ni", "9pGRIgSzGoO7DAmYlto8");
					req.setRequestHeader("ns", "PJ03AwUn2q");
				},
				success : function(data) {
					if (start == 1) {
						$("table").empty();
					}
					 $(data).find("item").each(function(i, w){
						var img = $("<img>").attr("src", $(w).find("image").text());
						var imgTd = $("<td></td>").append(img);
						var titleTd = $("<td></td>").html($(w).find("title").text());
						// 화면에 다 떠있고, 버튼 눌렀을때
						// 톰캣과는 무관
						// $("<fmt:formatNumber/>").attr("value", $(w).find("lprice").text()); 안됨
						var priceTd = $("<td></td>").text($(w).find("lprice").text());
						var brandTd = $("<td></td>").text($(w).find("brand").text());
						var tr = $("<tr></tr>").append(imgTd, titleTd, priceTd, brandTd);
						$("table").append(tr);
					}); 
				}
			});
		
	}

	$(function() {
		var start = 1;
		$("button").click(function() {
			getShopping(start);
		});
		
		var get = true;
		$(window).scroll(function(){
			var htmlHeight = $(document).height();
			var browserHeight = $(window).height();
			var browserOffset = $(window).scrollTop();
			
			if (browserHeight + browserOffset >= htmlHeight - 10 && get) {
				start += 10;
				getShopping(start);
				get = false;
			} else {
				get = true;
			}
		});
		
		$("input").keyup(function(e){
			if (e.keyCode == 13) {
				$("button").trigger("click");
			}
		});
		
	});
	
	// html
	// jsp : 사실은 서블릿 : 실행때 서블릿으로 바뀌어서 실행
	// EL/JSTL : 실행때 자바소스로 바뀌어서 실행
</script>
<style type="text/css">
	img{
		width: 100px;
	}
</style>
</head>
<body>
	<input><button>검색</button>
	<table border="1"></table>
</body>
</html>