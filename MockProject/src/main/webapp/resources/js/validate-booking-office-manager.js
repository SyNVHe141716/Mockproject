function clickAdd() {
	var test1 = document.getElementById('bookingOfficeName').value;
	if (test1 == '') {
		alert('Booking office name is invalid');
		return false;
	}
	
	if (document.getElementById('fromDate').value == '') {
		alert('Contract deadline cannot be blank');
		return false;
	}
	 if (document.getElementById('toDate').value == '') {
		alert('Contract deadline cannot be blank');
		return false
	}
	var regex = /[0-9]|\./;
	var test2 = document.getElementById('phonenumber').value;
	if (test2 == '') {
		alert('Phone number is invalid');
		return false;
	}else if(isNaN(test2)){
		 alert("Phone must be number");
        return false;
	}else if (!regex.test(test2)) {
        alert("Phone must be number");
        return false;
    }
	var test3 = document.getElementById('price').value;
	if (test3 == '') {
		alert('Price is invalid');
		return false;
	}else if(isNaN(test4)){
		 alert("price must be number");
        return false;
	}
	
	return true;
}

function checkPhoneNumber() {
	var test = document.getElementById('phonenumber').value;
	if (test == '') {
		return false;
	}
	for (var i = 0; i < test.length; i++) {
		if ( test.charCodeAt(i) > 57) {
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
