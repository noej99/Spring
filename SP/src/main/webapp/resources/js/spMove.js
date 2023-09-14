function memberDelete() {
	if (confirm("탈퇴?")) {
		location.href = "member.delete";
	}
}
function snsPageChange(page) {
	location.href = "sns.page.change?page=" + page;
}
function snsDelete(no) {
	if (confirm("삭제?")) {
		location.href = "sns.delete?ss_no=" + no;
	}
}
function snsUpdate(no, txt, page) {
	// replace
	//	java : 다 바꾸게
	//	js : 첫번째것만 바꾸게 -> 정규식
	//	txt = txt.replace("<br>", "\r\n");
	txt = txt.replace(/<br>/g, "\r\n");
	$("#snsUpdateNo").val(no);
	$("#snsUpdateTxt").val(txt);
	$("#snsUpdatePage").val(page);
	
	$("#blackArea").css("left", "0px");
	$("#blackArea").css("top", "0px");
	$("#blackArea").css("opacity", "1");
//	location.href = "sns.update?ss_no=" + no + "&ss_txt=" + txt + "&page=" + page;
}

function snsReplyDelete(no, page) {
	if (confirm("삭제?")) {
		location.href = "sns.reply.delete?ssr_no=" + no + "&page=" + page;
	}
}
function snsReplyUpdate(no, txt, page) {
	$("#snsReplyUpdateNo").val(no);
	$("#snsReplyUpdateTxt").val(txt);
	$("#snsReplyUpdatePage").val(page);
	
	$("#blackArea2").css("left", "0px");
	$("#blackArea2").css("top", "0px");
	$("#blackArea2").css("opacity", "1");
//	txt = prompt("수정할 내용", txt);
//	if (txt != null && txt.length < 150) {
//		location.href = "sns.reply.update?ssr_no=" + no + "&ssr_txt=" + txt + "&page=" + page;
//	}
}
function drDelete(no) {
	if (confirm("삭제?")) {
		location.href = "dr.delete?sd_no=" + no;
	}
}
function galleryDelete(no) {
	if (confirm("삭제?")) {
		location.href = "gallery.delete?sg_no=" + no;
	}
}
