function memberRegCheck(form) {
	var idInput = form.sm_id;
	var pwInput = form.sm_pw;	var pwChkInput = form.sm_pwChk;
	var nameInput = form.sm_name;
	var jumin1Input = form.sm_jumin1;
	var jumin2Input = form.sm_jumin2;
	var addr1Input = form.sm_addr1;
	var addr2Input = form.sm_addr2;
	var addr3Input = form.sm_addr3;
	var imgInput = form.sm_img;
	
	if (isEmpty(idInput) || containsHS(idInput)
		|| $("#memberJoinID").css("color") == "rgb(255, 0, 0)") {
		alert("ID?");
		idInput.value = "";
		idInput.focus();
		return false;
	}
	if (isEmpty(pwInput)
		|| notEquals(pwInput, pwChkInput)
		|| notContains(pwInput, "1234567890")){
		alert("PW?");
		pwInput.value = "";		pwChkInput.value = "";
		pwInput.focus();
		return false;
	}
	if (isEmpty(nameInput)){
		alert("이름?");		
		nameInput.focus();
		return false;
	}
	if (isEmpty(jumin1Input) 
		|| isNotNum(jumin1Input)
		|| lessThan(jumin1Input, 6)
		|| isEmpty(jumin2Input) 
		|| isNotNum(jumin2Input)
		|| lessThan(jumin2Input, 1)){
		alert("주민번호?");
		jumin1Input.value = "";	jumin2Input.value = "";
		jumin1Input.focus();
		return false;
	}
	if (isEmpty(addr1Input)
		|| isEmpty(addr2Input)
		|| isEmpty(addr3Input)) {
		alert("주소?");
		addr1Input.value = "";
		addr2Input.value = "";
		addr3Input.value = "";
		addr3Input.focus();
		return false;
	}
	if (isEmpty(imgInput)
		|| (isNotType(imgInput, "png") &&
		 isNotType(imgInput, "jpg") &&
		 isNotType(imgInput, "jpeg") &&
		 isNotType(imgInput, "bmp") &&
		 isNotType(imgInput, "gif"))) {
		alert("프사?");
		return false;
	}
	return true;
}

function loginCheck(f) {
	var idInput = f.sm_id;
	var pwInput = f.sm_pw;
	if (isEmpty(idInput) || isEmpty(pwInput)) {
		alert("?");
		idInput.value = "";
		pwInput.value = "";
		idInput.focus();
		return false;
	}
	return true;
}

function memberUpdateCheck(form) {
	var pwInput = form.sm_pw;
	var pwChkInput = form.sm_pwChk;
	var nameInput = form.sm_name;
	var addr1Input = form.sm_addr1;
	var addr2Input = form.sm_addr2;
	var addr3Input = form.sm_addr3;
 	var imgInput = form.sm_img;
 	
	if (isEmpty(pwInput)
	|| notContains(pwInput, "1234567890")
	|| notEquals(pwInput, pwChkInput)) {
		alert("PW?");
		pwInput.value = "";
		pwChkInput.value = "";
		pwInput.focus();
		return false;
	}
	if (isEmpty(nameInput)) {
		alert("이름?");
		nameInput.focus();
		return false;
	}
	if (isEmpty(addr1Input)
		|| isEmpty(addr2Input)
		|| isEmpty(addr3Input)) {
			alert("주소?");
			addr1Input.value = "";
			addr2Input.value = "";
			addr3Input.value = "";
			addr1Input.focus();
			return false;
	}
	if (isEmpty(imgInput)) {
		return true;
	}
	if (isNotType(imgInput, "png") &&
		isNotType(imgInput, "jpg") &&
		isNotType(imgInput, "gif") &&
		isNotType(imgInput, "bmp") &&
		isNotType(imgInput, "jpeg")) {
		alert("프사?");
		return false;
	}
	return true;
}
function snsWriteCheck(ff) {
	var colorInput = ff.ss_color;
	var txtInput = ff.ss_txt;
	
	if (isEmpty(colorInput) 
			|| lessThan(colorInput, 6)
			|| isEmpty(txtInput)) {
		alert("?");
		colorInput.focus();
		return false;
	}
	return true;
}
function snsUpdateCheck(ff) {
	var txtInput = ff.ss_txt;
	
	if (isEmpty(txtInput)) {
		alert("?");
		txtInput.focus();
		return false;
	}
	return true;
}

function snsReplyWriteCheck(ff) {
	var txtInput = ff.ssr_txt;
	
	if (isEmpty(txtInput)){
		alert("?");
		txtInput.value = "";
		colorInput.focus();
		return false;
	}
	return true;
}

function snsReplyUpdateCheck(ff) {
	var txtInput = ff.ssr_txt;
	
	if (isEmpty(txtInput)) {
		alert("?");
		txtInput.focus();
		return false;
	}
	return true;
}

function drUploadCheck(ff) {
	var titleInput = ff.sd_title;
	var fileInput = ff.sd_file;
	
	if (isEmpty(titleInput)
		|| isEmpty(fileInput)){
		alert("?");
		titleInput.value = "";
		titleInput.focus();
		return false;
	}
	return true;
}
function galleryWriteCheck(ff) {
	var txtInput = ff.sg_txt;
	var imgInput = ff.sg_img;
	
	if (isEmpty(txtInput)
		|| isEmpty(imgInput)){
		alert("?");
		txtInput.value = "";
		imgInput.focus();
		return false;
	}
	if (isNotType(imgInput, "png") &&
			isNotType(imgInput, "jpg") &&
			isNotType(imgInput, "gif") &&
			isNotType(imgInput, "bmp") &&
			isNotType(imgInput, "jpeg")) {
			alert("사진?");
			return false;
		}
	return true;
}