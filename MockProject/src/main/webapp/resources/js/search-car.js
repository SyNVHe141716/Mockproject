function changeCategory() {
	var category = document.getElementById('category').value;
	if (category == 'licensePlate' || category == 'carType' || category == 'carColor') {
		document.getElementById('input-search').style.display = 'block';
		document.getElementById('input-search').type = 'text';
		document.getElementById('selectCompany').style.display = 'none';
		document.getElementById('selectParkingLot').style.display = 'none';
	}
	else if (category == 'company') {
		document.getElementById('selectCompany').style.display = 'block';
		document.getElementById('input-search').style.display = 'none';
	}
	else if (category == 'parkingLot') {
		document.getElementById('selectParkingLot').style.display = 'block';
		document.getElementById('input-search').style.display = 'none';
	}
}

function searchBookingOffice() {
	document.getElementById('form-search').submit();
}