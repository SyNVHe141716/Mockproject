<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<style type="text/css">
		.pagination {
			float: right !important;
	}
	</style>

	<jsp:include page="../header/header.jsp"></jsp:include>
	<div>
		<jsp:include page="../sidebar/sidebar-service-manager.jsp"></jsp:include>
		<div class="float-left main-content border-top">
			<h2 class="m-4">Ticket list</h2>
			<hr class="m-4">

			<form id="form-search"
				class="d-flex mr-lg-5 mb-4 justify-content-end"
				action="TicketListController" method="post">
				<i class="fas fa-search p-2 bg-custom border border-icon-search"></i>
				<input id="input-search" name="name-search" type="text"
					placeholder="Ticket Search" class="box-search border-custom mr-2"
					style="display: none;" value="${customerName }"> <input
					id="from" name="from" type="time" placeholder="From"
					value="${from }" class="box-search border-custom mr-2"
					style="display: none;">
				<div style="display: none; margin: auto 0px;" id="text-to">-</div>
				<input id="to" name="to" type="time" placeholder="To" value="${to }"
					class="box-search border rounded mr-2 ml-2" style="display: none;">
				<select id="trip-search" name="trip-search"
					class="box-search border-custom p-1 mr-2 pr-5" name="">
					<c:forEach items="${trip }" var="t">
						<option value="${t.tripId }"
							<c:if test="${t.tripId eq tripId }">selected</c:if>>${t.destination }</option>
					</c:forEach>
				</select> <select id="license-plate-search" name="license-plate-search"
					style="display: none;"
					class="box-search border-custom p-1 mr-2 pr-5" name="">
					<c:forEach items="${car }" var="c">
						<option value="${c.licensePlate }"
							<c:if test="${c.licensePlate eq licensePlate }">selected</c:if>>${c.licensePlate }</option>
					</c:forEach>
				</select> <i class="fas fa-filter bg-custom border border-icon-search p-2">
					<p class="d-inline font-weight-normal">Filter by</p>
				</i> <select onchange="changeCategory()" name="category" id="category"
					class="border-custom pt-1 pb-2 mr-2 pr-3">
					<option value="tripId"
						<c:if test="${category eq 'tripId' }">selected</c:if>>Trip</option>
					<option value="licensePlate"
						<c:if test="${category eq 'licensePlate' }">selected</c:if>>License
						plate</option>
					<option value="customerName"
						<c:if test="${category eq 'customerName' }">selected</c:if>>Customer</option>
					<option value="bookingTime"
						<c:if test="${category eq 'bookingTime' }">selected</c:if>>Booking
						time</option>
				</select>
				<button class="btn btn-info p-1 pl-2 pr-2 float-right">Search</button>
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
			<div style="width: 95%">
				<table class="table table-striped ml-4" id="tblTicket">
					<thead class="font-weight-bold" style="background-color: #e7e7e7;">
						<tr>
							<td scope="col">No</td>
							<td scope="col">Trip</td>
							<td scope="col">License plate</td>
							<td scope="col">Customer</td>
							<td scope="col">Booking time</td>
							<td scope="col">Action</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ticket }" var="t" varStatus="tIndex">
							<tr>
								<td>${tIndex.index + 1}</td>
								<td>${t.tripName }</td>
								<td>${t.licensePlate}</td>
								<td>${t.customerName }</td>
								<td>${t.bookingTime }</td>
								<td class="d-flex"><a
									href="EditTicketController?id=${t.ticketId }" class="mr-2">
										<i class="fas fa-edit"></i>Edit
								</a>
									<div onclick="clickDelete(${t.ticketId})"
										style="cursor: pointer; color: #007bff;">
										<i class="fas fa-trash mr-1"></i>Delete
									</div></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('#tblTicket').DataTable({
				bPaginate : true,
				bLengthChange : false,
				bFilter : false,
				bInfo : false,
				bAutoWidth : false
			});
		});
		</script>

	<script src="resources/js/search-ticket.js"></script>
	<script src="resources/js/validate-delete-ticket.js"></script>

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

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script
		src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>

	<script
		src="https://cdn.datatables.net/1.11.3/js/dataTables.bootstrap4.min.js"></script>
</body>
</html>