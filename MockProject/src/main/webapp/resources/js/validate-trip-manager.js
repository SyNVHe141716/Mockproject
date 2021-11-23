function clickAdd() {
	if (!checkDestination()) {
		alert('Destination is invalid');
	}
	if (!checkDriver()) {
		alert('Driver is invalid');
	}
	if (!checkCarType()) {
		alert('Car type is invalid');
	}
	if (!checkMaximum()) {
		alert('Maximum online ticket number is invalid');
	}
	else if (document.getElementById('departureDate').value == '') {
		alert('Departure Date cannot be blank');
	}
	else {
		document.getElementById('form-add-trip').submit();
	}
}

function checkDestination() {
	var test = document.getElementById('destination').value;
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

function checkDriver() {
	var test = document.getElementById('driver').value;
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

function checkMaximum() {
	var test = document.getElementById('maximum').value;
	if (test == '') {
		return false;
	}
	for (var i = 0; i < test.length; i++) {
		if (test.charCodeAt(i) < 48 || test.charCodeAt(i) > 57) {
			return false;
		}
	}
	return true;
}

function clickReset() {
	document.getElementById('destination').value = '';
	document.getElementById('departureTime').value = '';
	document.getElementById('driver').value = '';
	document.getElementById('carType').value = '';
	document.getElementById('maximum').value = '';
	document.getElementById('departureDate').value = '';
}

function clickUpdate() {
	if (document.getElementById('destination').value == '') {
		alert('Destination cannot be blank');
	}
	else if (document.getElementById('departureTime').value == '') {
		alert('Departure time cannot be blank');
	}
	else if (document.getElementById('driver').value == '') {
		alert('Driver cannot be blank');
	}
	else if  (document.getElementById('carType').value == '')  {
		alert('Car type cannot be blank');
	}
	else if (document.getElementById('maximum').value == '') {
		alert('Maximum online ticket number cannot be blank');
	}
	else if (document.getElementById('departureDate').value == '') {
		alert('Departure date cannot be blank');
	}
	else {
		document.getElementById('form-edit-delete-trip').submit();
	}
}

function clickDetele() {
	var check = confirm('Are you sure want to delete?');
	var id = document.getElementById('destination').value;
	if (check) {
		window.location.href = 'TripDeleteController?id='+id;
	}
}