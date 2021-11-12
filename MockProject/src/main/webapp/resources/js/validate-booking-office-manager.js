function clickAdd() {
	if (!checkBookingOfficeName()) {
		alert('Booking office name is invalid');
	}
	else if (!checkPhoneNumber()) {
		alert('Phone number is invalid');
	}
	else if (!checkPrice()) {
		alert('Price is invalid');
	}
	else if (document.getElementById('fromDate').value == '') {
		alert('Contract deadline cannot be blank');
	}
	else if (document.getElementById('toDate').value == '') {
		alert('Contract deadline cannot be blank');
	}
	else {
		document.getElementById('form-add-booking-office').submit();
	}
}

function checkPhoneNumber() {
	var test = document.getElementById('phonenumber').value;
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

function checkPrice() {
	var test = document.getElementById('price').value;
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

function checkBookingOfficeName() {
	var test = document.getElementById('bookingOfficeName').value;
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
	document.getElementById('bookingOfficeName').value = '';
	document.getElementById('phonenumber').value = '';
	document.getElementById('price').value = '';
	document.getElementById('fromDate').value = '';
	document.getElementById('phonenumber').value = '';
}

function clickUpdate() {
	if (!checkBookingOfficeName()) {
		alert('Booking office name is invalid');
	}
	else if (!checkPhoneNumber()) {
		alert('Phone number is invalid');
	}
	else if (!checkPrice()) {
		alert('Price is invalid');
	}
	else if (document.getElementById('fromDate').value == '') {
		alert('Contract deadline cannot be blank');
	}
	else if (document.getElementById('toDate').value == '') {
		alert('Contract deadline cannot be blank');
	}
	else {
		document.getElementById('form-edit-delete-booking-office').submit();
	}
}

function clickDetele() {
	var check = confirm('Are you sure want to delete?');
	var id = document.getElementById('bookingOfficeName').value;
	if (check) {
		window.location.href = '#';
	}
}
