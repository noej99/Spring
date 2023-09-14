<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script type="text/javascript" src="resources/jQuery.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script type="text/javascript">
//5ab3f6c958807e1fa13b50555c88d2c3
		// $.ajax({
		// 		url : "프로토콜://..../주소",
		//		data : { param명 : 값, param명 : 값, ... },
		//		beforeSend : function (요청객체) {
		//			요청객체.setRequestHeader("이름", "값");	
		//		}
		//		success : function (받은거) {
		//			...
		//		}
		// });
	$(function() {
		var s = $(".slider").bxSlider({
			mode: 'vertical',
			captions: true,
			slideWidth: 120,
			auto: true,
			pause: 3000
		});
		$("button").click(function(){
			var search = $("input").val();
			$.ajax({
				url : "https://dapi.kakao.com/v3/search/book?target=title",
				data : {query : search},
				beforeSend : function(s) {
					s.setRequestHeader("Authorization", "KakaoAK 5ab3f6c958807e1fa13b50555c88d2c3");
				},
				success : function(bookData){
					$("table").empty();
					$.each(bookData.documents,function(i, a) {
					var img = $("<img>").attr("src", a.thumbnail);
					var imgTd = $("<td></td>").append(img);
					var td1 = $("<td></td>").text(a.title);
					var td2 = $("<td></td>").text(a.authors);
					var td3 = $("<td></td>").text(a.contents);
					var td4 = $("<td></td>").text(a.price);
					var td5 = $("<td></td>").text(a.sale_price);
					var td6 = $("<td></td>").text(a.publisher);
					var td7 = $("<td></td>").text(a.status);
					var tr = $("<tr></tr>").append(imgTd, td1, td2, td3, td4, td5, td6, td7);
					$("table").append(tr);
					
					var img2 = $("<img>").attr("src", a.thumbnail).attr("title", a.title);
					var div = $("<div></div>").append(img2);
					$(".slider").append(div);
					});
					s.reloadSlider();
				}
			});
		});
		
		$("input").keyup(function(e){
			//if (e.keyCode == 13) {
				$("button").trigger("click");
			//}
		});
		
	});
</script>
</head>
<body>
	<div class="slider">
		<div>1번</div>
		<div>2번</div>
	</div>

	<input><button>검색</button>
	<hr>
	<table border="1">
	</table>
</body>
</html>