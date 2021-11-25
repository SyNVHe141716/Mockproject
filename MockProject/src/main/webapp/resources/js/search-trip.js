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

function searchTrip() {
	document.getElementById('form-search').submit();
}
