function connectSummonSNSControlAreaEvent() {
	var visible = false;
	// .css("opacity", "1"); .css("opacity", "0");
	/*
	 * var snsControlTableHeight = $("snsControlTable").css("height");
	 * snsControlTableHeight = snsControllerHeight.replace("px","");
	 */
	$("#snsControlTable").mouseenter(function() {
		$("#snsControlTable").css("bottom", "0px");
	});

	$("#snsControlTable").mouseleave(function() {
		$("#snsControlTable").css("bottom", "-204px");
	});
	// $("#snsControlHandle").click(function() {
	// if (visible) {
	// $("#snsControlTable").css("bottom", "0px");
	// } else {
	// $("#snsControlTable").css("bottom", "-204px");
	// }
	// visible = !visible;
	// });
}

function connectSummonMenuEvent() {
	var visible = false;

	$("#menuHandle").click(function() {
		if (visible) {
			$("#siteMenu").css("left", "-150px");
			$("#menuHandle").css("left", "-2px");
		} else {
			$("#siteMenu").css("left", "0px");
			$("#menuHandle").css("left", "147px");
		}
		visible = !visible;
	});
}

function connectSummonSnsUpdateAreaEvent() {
	$("#x").click(function() {
		$("#blackArea").css("opacity", "0");
		setTimeout(function() {
			$("#blackArea").css("left", "-100%");
			$("#blackArea").css("top", "-100%");
		}, 300);
	});
}

function connectSummonSnsUpdateAreaEvent2() {
	$("#x2").click(function() {
		$("#blackArea2").css("opacity", "0");
		setTimeout(function() {
			$("#blackArea2").css("left", "-100%");
			$("#blackArea2").css("top", "-100%");
		}, 300);
	});
}

function connectSummonAddressSearchAreaEvent() {
	$("#joinAddr1, #joinAddr2").click(function() {
		new daum.Postcode({
			oncomplete : function(data) {
				// alert(data);
				// JS객체 -> 글자
				// alert(JSON.stringify(data));
				$("#joinAddr1").val(data.zonecode);
				$("#joinAddr2").val(data.roadAddress);
			}
		}).open();
	});
}

function connectMemberIDCheckEvent() {
	$("#memberJoinID").keyup(function(e) {
		var id = $(this).val();
		$.ajax({
			url : "member.get",
			data : {
				sm_id : id
			},
			success : function(memberData) {
				if (memberData.member[0] == null) {
					$("#memberJoinID").css("color", "black");
				} else {
					$("#memberJoinID").css("color", "red");
				}
			}
		});
	});
}

$(function() {
	connectMemberIDCheckEvent();
	connectSummonSNSControlAreaEvent();
	connectSummonMenuEvent();
	connectSummonSnsUpdateAreaEvent();
	connectSummonSnsUpdateAreaEvent2();
	connectSummonAddressSearchAreaEvent();
});