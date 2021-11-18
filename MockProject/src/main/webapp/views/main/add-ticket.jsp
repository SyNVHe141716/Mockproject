<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/header.css">
<link rel="stylesheet" href="resources/css/style-main.css">
<script src="https://kit.fontawesome.com/9f5e8136b5.js"></script>
</head>
<body>
	<jsp:include page="../header/header.jsp"></jsp:include>
	<div>
		<jsp:include page="../sidebar/sidebar-service-manager.jsp"></jsp:include>
		<form action="AddTicketController" method="POST"
			class="float-left main-content border-top">
			<h2 class="m-4">Add Ticket</h2>
			<hr class="m-4">
			<table class="m-4">
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Customer <label
						class="required">(*)</label></td>
					<td><input class="box form-control pt-2 pb-2 text-sm"
						placeholder="Enter customer name" type="text" name="customer-name"
						id="customer-name" required></td>
				</tr>
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Booking Time <label
						class="required">(*)</label></td>
					<td><input class="box form-control pt-2 pb-2 text-sm"
						type="time" name="booking-time" id="booking-time" required></td>
				</tr>
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Trip <label
						class="required">(*)</label></td>
					<td>
						<select name="trip" class="box form-control pt-2 pb-2 text-sm">
							<c:forEach items="${trip}" var="t">
								<option value="${t.tripId}">${t.destination}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">License plate <label
						class="required">(*)</label></td>
					<td>
						<select name="license-plate" class="box form-control pt-2 pb-2 text-sm">
							<c:forEach items="${car}" var="c">
								<option value="${c.licensePlate}">${c.licensePlate}</option>
							</c:forEach>
						</select>
					</td>
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
				<button class="btn btn-success mr-1 text-btn">
					<i class="fas fa-plus mr-1"></i>Add
				</button>
			</div>
		</form>
	</div>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="resources/js/validate-add-ticket.js"></script>
	<script src="resources/js/validate-delete-parking-lot.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
</body>
</html>