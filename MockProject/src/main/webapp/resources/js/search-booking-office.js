

function changeCategory() {
    var category = document.getElementById('category').value;
    if(category == 'bookingOffice' || category == 'trip'){
        document.getElementById('input-search').type = 'text';
    }  
	var category = document.getElementById('category').value;
	if (category == 'bookingOffice') {
		document.getElementById('input-search').style.display = 'block';
		document.getElementById('input-search').type = 'text';
		document.getElementById('selectTrip').style.display = 'none';
	} else {
		document.getElementById('selectTrip').style.display = 'block';
		document.getElementById('input-search').style.display = 'none';
	}
}

function searchBookingOffice() {
	document.getElementById('form-search').submit();
}
