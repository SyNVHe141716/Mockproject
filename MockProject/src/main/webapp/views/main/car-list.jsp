<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car List</title>
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
			<h2 class="m-4">Car list</h2>
			<hr class="m-4">
			<form id="form-search" class="float-right d-flex mr-4 mb-4">
				<i class="fas fa-search p-2 bg-custom border border-icon-search"></i>
				<input id="input-search" name="input-search" type="text"
					placeholder="Car Search" class="box-search border-custom p-1 mr-2"
					style="width: 35%;"> <i
					class="fas fa-filter bg-custom border border-icon-search p-2">
					<p class="d-inline font-weight-normal">Filter by</p>
				</i> <select onchange="changeCategory()" name="category" id="category"
					class="border-custom pt-1 pb-2 mr-2" style="width: 15%;">
					<option value="licensePlate">License plate</option>
					<option value="carType">Car type</option>
					<option value="carColor">Car color</option>
					<option value="company">Company</option>
					<option value="parkingLot">Parking lot</option>
				</select>
				<div onclick="searchCar()" class="btn btn-info p-1 pl-2 pr-2">Search</div>
			</form>
			<table class="table table-striped ml-4" style="width: 95%;">
				<thead class="font-weight-bold" style="background-color: #e7e7e7;">
					<tr>
						<td scope="col">License plate</td>
						<td scope="col">Car type</td>
						<td scope="col">Car color</td>
						<td scope="col">Company</td>
						<td scope="col">Parking lot</td>
						<td scope="col">Action</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td scope="col">28B-1128</td>
						<td>Thuong Hai</td>
						<td>Bac</td>
						<td>Hoang Long</td>
						<td><a href="#">Bai so 2</a></td>
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