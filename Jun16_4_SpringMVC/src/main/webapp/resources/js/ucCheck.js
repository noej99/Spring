function check() {
	var noBox = document.ucForm.no;
	if (isEmpty(noBox) || isNotNum(noBox)) {
		alert("?");	noBox.value = "";	noBox.focus();
		return false;
	}
	return true;
}