function clickAdd() {
	if (!checkLicensePlate()) {
		alert('License plate is invalid');
	}
	else {
		document.getElementById('form-add-car').submit();
	} 
}

function checkLicensePlate() {
	var test = document.getElementById('licensePlate').value;
	if (test == '') {
		return false;
	}
	return true;
}

function clickReset() {
	document.getElementById('licensePlate').value = '';
	document.getElementById('carType').value = '';
	document.getElementById('carColor').value = '';
}

function clickUpdate() {
	document.getElementById('form-edit-delete-car').submit();
}

function clickDetele(id) {
	var check = confirm('Are you sure want to delete?');
	if (check) {
		window.location.href = '#' + id;
	}
}
