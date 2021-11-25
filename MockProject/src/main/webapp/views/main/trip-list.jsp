<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trip List</title>
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/header.css">
<link rel="stylesheet" href="resources/css/style-main.css">
<script src="https://kit.fontawesome.com/9f5e8136b5.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap4.min.css">
</head>
<body>
<style type="text/css">
		.pagination {
			float: right !important;
	}
	</style>
	<jsp:include page="../header/header.jsp"></jsp:include>
	<div>
		<jsp:include page="../sidebar/sidebar-service-manager.jsp"></jsp:include>
		<div class="float-left main-content border-top">
			<h2 class="m-4">Trip list</h2>
			<hr class="m-4">
			<form id="form-search" class="d-flex mr-4 mb-4 justify-content-end"
				method="POST" action="TripSearchController">
				<i class="fas fa-search p-2 bg-custom border border-icon-search"></i>
				<input id="input-search" name="input-search" type="text"
					placeholder="User Search" class="box-search border-custom p-1 mr-2"
					style="width: 35%;" value="${inputSearch }">
				<div onclick="searchTrip()" class="btn btn-info p-1 pl-2 pr-2"
					id="form-search">Search</div>
				<select id="day" name="day" class="border pt-1 pb-2 ml-2 mr-2 pr-5">
				</select> <select id="month" onchange="selectDate()" name="month"
					class="border pt-1 pb-2 ml-2 mr-2 pr-5">
					<c:forEach begin="1" end="12" step="1" var="m">
						<option value="${m }" <c:if test="${m eq month}">selected</c:if>>${m }</option>
					</c:forEach>
				</select> <select id="year" onchange="selectDate()" name="year"
					class="border pt-1 pb-2 ml-2 mr-2 pr-5">
					<c:forEach begin="1999" end="${maxYear }" var="y">
						<option value="${y }" <c:if test="${y eq year}">selected</c:if>>${y }</option>
					</c:forEach>
				</select>
			</form>
			<div style="width: 95%;">
				<table class="table table-striped ml-4" id="tblTrip">
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
						<c:forEach items="${trips }" var="trip">
							<tr>
								<td scope="col">${trip.tripId }</td>
								<td>${trip.destination }</td>
								<td>${trip.departureTime }</td>
								<td>${trip.driver }</td>
								<td>${trip.carType }</td>
								<td>${trip.bookedTicketNumber }</td>
								<td><a href="TripUpdateController?id=${trip.tripId }"><i
										class="far fa-edit"></i>Edit</a> <a
									href="TripDeleteController?id=${trip.tripId }"><i
										class="far fa-trash-alt"></i>Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('#tblTrip').DataTable({
				bPaginate : true,
				bLengthChange : false,
				bFilter : false,
				bInfo : false,
				bAutoWidth : false
			});
		});
	</script>
	<script>
	var test = ${day};
	if(test != 0){
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
		for (var i = 1; i <= max; i++) {
			var opt = document.createElement('option');
			opt.value = i;
			opt.innerHTML = i;
			if(opt.value == ${day}){
				opt.selected = 'selected';
			}
			day.appendChild(opt);
		}
	}
	else{
		selectDate();
	}
	</script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="resources/js/search-trip.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script
		src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>

	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script
		src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>

	<script
		src="https://cdn.datatables.net/1.11.3/js/dataTables.bootstrap4.min.js"></script>
</body>
</html>