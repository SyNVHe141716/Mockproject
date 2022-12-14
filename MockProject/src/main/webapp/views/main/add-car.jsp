<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Add Car</title>
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/header.css">
<link rel="stylesheet" href="resources/css/style-main.css">
<script src="https://kit.fontawesome.com/9f5e8136b5.js"></script>
</head>
<body>
	<jsp:include page="../header/header.jsp"></jsp:include>
	<div>
		<jsp:include page="../sidebar/sidebar-service-manager.jsp"></jsp:include>

		<form action="AddCarController" method="post"
			class="float-left main-content border-top" id="form-add-car">
			<h2 class="m-4">Add Car</h2>
			<hr class="m-4">
			<table class="m-4">
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">License plate <label
						class="required">(*)</label>
					</td>
					<td><input class="box form-control pt-2 pb-2 text-sm"
						placeholder="Enter license plate" type="text" name="licensePlate"
						id="licensePlate" required></td>
				</tr>
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Car type</td>
					<td><input class="box form-control pt-2 pb-2 text-sm"
						placeholder="Enter car type" type="text" name="carType"
						id="carType" required></td>
				</tr>
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Car color</td>
					<td><input class="box form-control pt-2 pb-2 text-sm"
						placeholder="Enter car color" type="text" name="carColor"
						id="carColor" required></td>
				</tr>
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Company <label
						class="required">(*)</label></td>
					<td><select name="company"
						class="box form-control pt-2 pb-2 text-sm">
							<c:forEach items="${listcom}" var="c">
								<option value="${c.companyId}" selected>${c.companyName}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Parking lot <label
						class="required">(*)</label></td>
					<td><select name="parkingLot"
						class="box form-control pt-2 pb-2 text-sm">
							<c:forEach items="${listp}" var="p">
								<option value="${p.id}">${p.name}</option>
							</c:forEach>
					</select></td>
				</tr>
			</table>
			<div class="d-flex list-btn">
				<div onclick="window.history.back();"
					class="btn btn-info mr-1 text-btn">
					<i class="fas fa-backward mr-1"></i>Back
				</div>
					<div onclick="clickReset()" class="btn btn-warning mr-1 text-btn">
						<i class="fas fa-redo mr-1" style="transform: scaleX(-1);"></i>Reset
					</div>
					<div onclick="clickAdd()" class="btn btn-success mr-1 text-btn">
						<i class="fas fa-plus mr-1"></i>Add
					</div>
				</div>			
		</form>
		<p class="text-danger text-center mt-3">${errorSQL}</p>
	</div>

	<script src="resources/js/validate-car-manager.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
</body>
</html>