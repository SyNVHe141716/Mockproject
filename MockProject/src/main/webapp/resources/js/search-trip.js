function changeDay() {
	var day = document.getElementById('day').value;
	if (day == '01' || day == '02' || day == '03' || day == '04' || day == '05' || day == '06' || day == '07' || day == '08' || day == '09 ' || day == '10'
		|| day == '11' || day == '12' || day == '13' || day == '14' || day == '15' || day == '16' || day == '17' || day == '18' || day == '19' || day == '20'
		|| day == '21' || day == '22' || day == '23' || day == '24' || day == '25' || day == '26' || day == '27' || day == '28' || day == '29' || day == '30'
		|| day == '31') {
		document.getElementById('input-search').type = 'text';
	}
}

function changeMonth() {
	var month = document.getElementById('month').value;
	if (month == '01' || month == '02' || month == '03' || month == '04' || month == '05' || month == '06'
		|| month == '07' || month == '08' || month == '09 ' || month == '10' || month == '11' || month == '12') {
		document.getElementById('input-search').type = 'text';
	}
}

function changeYear() {
	var year = document.getElementById('year').value;
	if (year == '2015' || year == '2016' || year == '2017' || year == '2018'
		|| year == '2019' || year == '2020' || year == '2021' || year == '2022') {
		document.getElementById('input-search').type = 'text';
	}
}

function searchTrip() {
	document.getElementById('form-search').submit();
}
