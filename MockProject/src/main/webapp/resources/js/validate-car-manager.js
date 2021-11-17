function clickAdd() {
	if (!checkLicensePlate()) {
		alert('License plate is invalid');
	}
	if (!checkCarType()) {
		alert('Car type is invalid');
	}
	if (!checkCarColor()) {
		alert('Car color is invalid');
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
	for (var i = 0; i < test.length; i++) {
		if (test.charCodeAt(i) < 65 || (test.charCodeAt(i) > 90 && test.charCodeAt(i) < 97) || test.charCodeAt(i) > 122) {
			return false;
		}
	}
	return true;
}

function checkCarType() {
	var test = document.getElementById('carType').value;
	if (test == '') {
		return false;
	}
	for (var i = 0; i < test.length; i++) {
		if (test.charCodeAt(i) < 65 || (test.charCodeAt(i) > 90 && test.charCodeAt(i) < 97) || test.charCodeAt(i) > 122) {
			return false;
		}
	}
	return true;
}

function checkCarColor() {
	var test = document.getElementById('carColor').value;
	if (test == '') {
		return false;
	}
	for (var i = 0; i < test.length; i++) {
		if (test.charCodeAt(i) < 65 || (test.charCodeAt(i) > 90 && test.charCodeAt(i) < 97) || test.charCodeAt(i) > 122) {
			return false;
		}
	}
	return true;
}

function clickReset() {
	document.getElementById('licensePlate').value = '';
	document.getElementById('carType').value = '';
	document.getElementById('carColor').value = '';
}

function clickUpdate() {
	if (!checkCarType()) {
		alert('Car type is invalid');
	}
	if (!checkCarColor()) {
		alert('Car color is invalid');
	}
	else {
		document.getElementById('form-edit-delete-car').submit();
	}
}

function clickDetele() {
	var check = confirm('Are you sure want to delete?');
	var id = document.getElementById('licensePlate').value;
	if (check) {
		window.location.href = '#';
	}
}
