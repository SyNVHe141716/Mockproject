<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Add Trip</title>
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

		<form action="#" method="get"
			class="float-left main-content border-top" id="form-add-trip">
			<h2 class="m-4">Add Trip</h2>
			<hr class="m-4">
			<table class="m-4">
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Destination <label
						class="required">(*)</label>
					</td>
					<td><input class="box form-control pt-2 pb-2 text-sm"
						placeholder="Enter destination" type="text" name="destination"
						id="destination" required></td>
				</tr>
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Departure time<label
						class="required">(*)</label></td>
					<td><input class="box form-control pt-2 pb-2 text-sm"
						placeholder="--:-- --" type="text" name="departureTime"
						id="departureTime" required></td>
				</tr>
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Driver<label
						class="required">(*)</label></td>
					<td><input class="box form-control pt-2 pb-2 text-sm"
						placeholder="Enter driver" type="text" name="driver" id="driver"
						required></td>
				</tr>
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Car type<label
						class="required">(*)</label></td>
					<td><input class="box form-control pt-2 pb-2 text-sm"
						placeholder="Enter car type" type="text" name="carType"
						id="carType" required></td>
				</tr>
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Maximum online
						ticket number<label class="required">(*)</label>
					</td>
					<td><input class="box form-control pt-2 pb-2 text-sm"
						placeholder="0" type="text" name="maximum" id="maximum" required></td>
				</tr>
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Departure date<label
						class="required">(*)</label></td>
					<td><input class="box form-control pt-2 pb-2 text-sm"
						placeholder="dd//mm//yyyy" type="date" name="departureDate"
						id="departureDate" required></td>
				</tr>
			</table>
			<div class="d-flex list-btn">
				<div onclick="clickReset()" class="btn btn-warning mr-1 text-btn">
					<i class="fas fa-redo mr-1" style="transform: scaleX(-1);"></i>Reset
				</div>
				<div onclick="clickAdd()" class="btn btn-success mr-1 text-btn">
					<i class="fas fa-plus mr-1"></i>Add
				</div>
			</div>
		</form>
	</div>

	<script src="../../resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
</body>
</html>