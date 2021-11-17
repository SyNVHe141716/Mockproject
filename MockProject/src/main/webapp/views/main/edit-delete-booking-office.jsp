<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Edit-Delete Booking Office</title>
<link rel="stylesheet"
	href="resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/header.css">
<link rel="stylesheet" href="resources/css/style-main.css">
<script src="https://kit.fontawesome.com/9f5e8136b5.js"></script>
</head>

<body>
	<jsp:include page="../header/header.jsp"></jsp:include>
	<div>
		<jsp:include page="../sidebar/sidebar-service-manager.jsp"></jsp:include>

		<form action="<%=request.getContextPath() %>/update" method="post"
			class="float-left main-content border-top"
			id="form-edit-delete-booking-office">
			<h2 class="m-4">Edit Booking Office</h2>
			<hr class="m-4">
			<p style="color: red; margin-left: 40px">
			<%=request.getAttribute("mess")!=null?request.getAttribute("mess"):"" %></p>
			<table class="m-4">
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Booking office
						name <label class="required">(*)</label>
					</td>
					<td><input class="box form-control pt-2 pb-2 text-sm"
						placeholder="Enter booking office name" type="text"
						name="bookingOfficeName" id="bookingOfficeName" value="${bk.officeName }" required></td>
				</tr>
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Trip <label
						class="required">(*)</label></td>
					<td><select name="trip"
						class="box form-control pt-2 pb-2 text-sm">
							<c:forEach items="${ lstrip}" var="o">
							<option ${tripid == o.tripId ? "selected":"" } value="${o. tripId}"  >${o.destination }</option>
							
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Phone number <label
						class="required">(*)</label>
					</td>
					<td><input class="box form-control pt-2 pb-2 text-sm"
						placeholder="Enter phone number" type="tel" name="phonenumber"
						id="phonenumber"  value="${bk.officePhone }"></td>
				</tr>
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Place <label
						class="required">(*)</label></td>
					<td><select name="place"
						class="box form-control pt-2 pb-2 text-sm">
							<c:forEach items="${lsBk}" var="i">
							<option ${place == i.officePlace ? "selected":"" } >${i.officePlace }</option>
							
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Price <label
						class="required">(*)</label></td>
					<td class="d-flex align-items-center justify-content-center"><input
						name="price" type="number"
						class="box form-control pt-2 pb-2 text-sm" id="price" value="${bk.officePrice }">(VND)</td>
				</tr>
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Contract deadline
						<label class="required">(*)</label>
					</td>
					<td>
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text" id="basic-addon1">From
									date</span>
							</div>
							<input name="fromDate" type="date" placeholder="dd/mm/yyyy"
								class="box form-control pt-2 pb-2 text-sm" id="fromDate" value="${bk.startContractDeadline }">
						</div>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text" id="basic-addon1">To date</span>
							</div>
							<input name="toDate" type="date" placeholder="dd/mm/yyyy"
								class="box form-control pt-2 pb-2 text-sm" id="toDate" value="${bk.endContractDeadline }">
						</div>
					</td>
				</tr>
			</table>
			<div class="d-flex list-btn">
				<button  onclick="return clickAdd()" class="btn btn-success mr-1 text-btn">
					<i class="fas fa-plus mr-1"></i>Update
				</button>
				
			</div>
		</form>
	</div>

	<script src="resources/js/validate-booking-office-manager.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
</body>
</html>