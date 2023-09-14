<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript"
	src="https://cdn.canvasjs.com/canvasjs.min.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5dfd56d23946887bf27c60e115f0d1a3"></script>
<script type="text/javascript">
	// JavaScript 키	: 5dfd56d23946887bf27c60e115f0d1a3
	// REST API 키		: 5ab3f6c958807e1fa13b50555c88d2c3
	var map;
	var marker;
	var roadview; 
	var roadviewClient = new kakao.maps.RoadviewClient();
	function move(lat, lng) {
		// 지도
		var ll = new kakao.maps.LatLng(lat, lng);
		map.panTo(ll);
		// 마커
		marker.setPosition(ll);
		// 로드뷰
		roadviewClient.getNearestPanoId(ll, 200, function(p) {
		    roadview.setPanoId(p);
		});
	}
	
	$(function() {
		// html5 : add-on없이 html자체로 끝내자
		// flash -> canvas
		// alert(navigator.userAgent);
		// GPS있으면 GPS로
		// 없으면 IP주소로
		// 위치정보

		navigator.geolocation.getCurrentPosition(function(l){
			// coordination
			var lat = l.coords.latitude; // 위도
			var lng = l.coords.longitude; // 경도

			var curLoc = new kakao.maps.LatLng(lat, lng); 
				
			// 현재위치 카카오맵
			var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
			var options = { //지도를 생성할 때 필요한 기본 옵션
				center: curLoc, //지도의 중심좌표.
				level: 3, //지도의 레벨(확대, 축소 정도)
				mapTypeId: kakao.maps.MapTypeId.ROADMAP
			};

			map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
			///////////////////////////////////////////
			//로드뷰를 표시할 div
			var roadviewContainer = document.getElementById('roadview'); 
			
		    roadview = new kakao.maps.Roadview(roadviewContainer);
			roadviewClient.getNearestPanoId(curLoc, 50, function(p) {
		    roadview.setPanoId(p);
			});
			///////////////////////////////////////////
			marker = new kakao.maps.Marker({
			    map: map,
			    position: curLoc
			});
			///////////////////////////////////////////
		});
		$("#region").keyup(function(e){
			var region = $(this).val();
		// 지역명 -> 위도/ 경도
		// geocoding
			$.ajax({
				url : "https://dapi.kakao.com/v2/local/search/address.json",	
				beforeSend : function(req){
				req.setRequestHeader("Authorization", "KakaoAK 5ab3f6c958807e1fa13b50555c88d2c3")
			},
				data : {query : region},
				success : function(s) {
					move(s.documents[0].y, s.documents[0].x);
					$("h2").text(s.documents[0].address_name);
				}	
			});
		});
		
		$("#keyword").keyup(function(e){
			var keyword = $(this).val();
			$.ajax({
				url : "https://dapi.kakao.com/v2/local/search/keyword.json",
				beforeSend : function(req){
					req.setRequestHeader("Authorization", "KakaoAK 5ab3f6c958807e1fa13b50555c88d2c3")
				},
				data : {query : keyword, 
					x : map.getCenter().getLng(), 
					y : map.getCenter().getLat(), 
					radius : 5000
				},
				success : function(ss) {
					$("#result").empty();
					$.each(ss.documents, function(i, w){
						var nameTd = $("<td></td>").text(w.place_name);
						var addrTd = $("<td></td>").text(  );
						var phoneTd = $("<td></td>").text(w.phone);
						var disTd = $("<td></td>").text(w.distance);
						var tr = $("<tr></tr>").attr("onclick", "move(" + w.y + ", " + w.x + ");").attr("style", "cursor: pointer").append(nameTd, addrTd, phoneTd, disTd);
						// ajax로 만들어진거에 이벤트 못넣으니까 만들때 같이 넣기 
						$("#result").append(tr);
					});
				}
			});
		});
	});
</script>
</head>
<body>
	지역명 : <input id="region"><br>
	검색어 : <input id="keyword"><hr>
	<h2></h2>
	<table style="width: 100%;">
		<tr>
			<td style="width: 50%;">
				<div id="map" style="width: 500px; height: 400px;"></div>
			</td>
			<td style="width: 50%;">
				<div id="roadview" style="width: 500px; height: 400px;"></div>
			</td>
		</tr>
	</table>
	<table id="result" border="1">
	</table>
</body>
</html>