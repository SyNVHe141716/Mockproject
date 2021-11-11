<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trip List</title>
<link rel="stylesheet"
	href="../../resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../../resources/css/header.css">
<link rel="stylesheet" href="../../resources/css/style-main.css">
<script src="https://kit.fontawesome.com/9f5e8136b5.js"></script>
</head>
<body>
	<jsp:include page="../header/header.jsp"></jsp:include>
	<div>
		<jsp:include page="../sidebar/sidebar-service-manager.jsp"></jsp:include>
		<div class="float-left main-content border-top">
			<h2 class="m-4">Trip list</h2>
			<hr class="m-4">
			<form id="form-search" class="float-right d-flex mr-4 mb-4">
				<i class="fas fa-search p-2 bg-custom border border-icon-search"></i>
				<input id="input-search" name="input-search" type="text"
					placeholder="User Search" class="box-search border-custom p-1 mr-2"
					style="width: 35%;">
				<div onclick="searchTrip()" class="btn btn-info p-1 pl-2 pr-2">Search</div>
				<select onchange="changeDay()" name="day" id="day"
					class="border-custom pt-1 pb-2 mr-2" style="width: 15%;">
					<option value="01">01</option>
					<option value="02" selected>02</option>
					<option value="03">03</option>
					<option value="04">04</option>
					<option value="05">05</option>
					<option value="06">06</option>
					<option value="07">07</option>
					<option value="08">08</option>
					<option value="09">09</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>
				</select> <select onchange="changeMonth()" name="month" id="month"
					class="border-custom pt-1 pb-2 mr-2" style="width: 15%;">
					<option value="01">01</option>
					<option value="02" selected>02</option>
					<option value="03">03</option>
					<option value="04">04</option>
					<option value="05">05</option>
					<option value="06">06</option>
					<option value="07">07</option>
					<option value="08">08</option>
					<option value="09">09</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
				</select> <select onchange="changeYear()" name="year" id="year"
					class="border-custom pt-1 pb-2 mr-2" style="width: 15%;">
					<option value="2015">2015</option>
					<option value="2016">2016</option>
					<option value="2017">2017</option>
					<option value="2018" selected>2018</option>
					<option value="2019">2019</option>
					<option value="2020">2020</option>
					<option value="2021">2021</option>
					<option value="2022">2022</option>
				</select>
			</form>
			<table class="table table-striped ml-4" style="width: 95%;">
				<thead class="font-weight-bold" style="background-color: #e7e7e7;">
					<tr>
						<td scope="col">No</td>
						<td scope="col">Destination</td>
						<td scope="col">Departure time</td>
						<td scope="col">Driver</td>
						<td scope="col">Car type</td>
						<td scope="col">Booked ticket number</td>
						<td scope="col">Action</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td scope="col">7</td>
						<td>Gia Lai</td>
						<td>10:30</td>
						<td>Tran Van Loc</td>
						<td>Giuong Nam 50 Cho</td>
						<td>0</td>
						<td><a href="#"><i class="far fa-edit"></i>Edit</a> <a
							href="#"><i class="far fa-trash-alt"></i>Delete</a></td>
					</tr>
				</tbody>
			</table>
			<div class="d-flex ml-4">
				<a href="#"
					class="p-2 border text-center rounded-left text-black-50"
					style="width: 6.5%; border-right: 0;">Previous</a> <a href="#"
					class="p-2 border pl-3 pr-3 now-index">1</a> <a href="#"
					class="p-2 border pl-3 pr-3 now-index">2</a> <a href="#"
					class="p-2 border pl-3 pr-3 now-index">3</a> <a href="#"
					class="p-2 border text-center rounded-right text-black-50"
					style="width: 6.5%; border-left: 0;">Next</a>
			</div>
		</div>
	</div>


	<script src="../../resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="../../resources/js/search-employee.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script src="../../resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
</body>
</html>