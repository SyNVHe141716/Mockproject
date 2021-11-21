changeCategory();
function changeCategory() {
	var category = document.getElementById('category').value;
	if (category == 'tripId') {
		document.getElementById('trip-search').style.display = 'block';
		document.getElementById('input-search').style.display = 'none';
		document.getElementById('license-plate-search').style.display = 'none';
		document.getElementById('from').style.display = 'none';
		document.getElementById('text-to').style.display = 'none';
		document.getElementById('to').style.display = 'none';
	}
	else if (category == 'licensePlate') {
		document.getElementById('license-plate-search').style.display = 'block';
		document.getElementById('input-search').style.display = 'none';
		document.getElementById('trip-search').style.display = 'none';
		document.getElementById('from').style.display = 'none';
		document.getElementById('text-to').style.display = 'none';
		document.getElementById('to').style.display = 'none';
	}
	else if (category == 'customerName') {
		document.getElementById('input-search').style.display = 'block';
		document.getElementById('license-plate-search').style.display = 'none';
		document.getElementById('trip-search').style.display = 'none';
		document.getElementById('from').style.display = 'none';
		document.getElementById('text-to').style.display = 'none';
		document.getElementById('to').style.display = 'none';
	}
	else {
		document.getElementById('from').style.display = 'block';
		document.getElementById('text-to').style.display = 'block';
		document.getElementById('to').style.display = 'block';
		document.getElementById('input-search').style.display = 'none';
		document.getElementById('license-plate-search').style.display = 'none';
		document.getElementById('trip-search').style.display = 'none';
	}
}

function selectDate() {
	var month = document.getElementById('month').value;
	var year = document.getElementById('year').value;
	var max = 30;
	var day = document.getElementById('day');
	if ((month < 8 && month % 2 != 0) || (month >= 8 && month % 2 == 0)) {
		max = 31;
	}
	else if (month == 2) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 4 == 0 && year % 100 == 0 && year % 400 == 0)) {
			max = 29;
		}
		else {
			max = 28;
		}
	}
	var l = day.options.length - 1;
	for (var i = l; i >= 0; i--) {
		day.remove(i);
	}
	for (var i = 1; i <= max; i++) {
		var opt = document.createElement('option');
		opt.value = i;
		opt.innerHTML = i;
		if (day > max) {
			opt.selected = 'selected';
		}
		day.appendChild(opt);
	}
}