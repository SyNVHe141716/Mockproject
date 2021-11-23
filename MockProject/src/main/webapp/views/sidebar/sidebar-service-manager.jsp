<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking office manager</title>
<link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />">
<link rel="stylesheet" href="<c:url value='/resources/css/header.css'/>">
<link rel="stylesheet" href="<c:url value='/resources/css/style-main.css' />">
<script src="https://kit.fontawesome.com/9f5e8136b5.js"></script>
</head>
<body>
	<div class="float-left sidebar vh-100 border-right bg-light">
		<ul class="list-unstyled">
			<li class="p-3 border-bottom"><details id="car">
					<summary style="list-style: none; color: #007bff;">
						<i class="fas fa-car mr-2"></i>Car manager<i
							class="fas fa-chevron-down float-right"
							style="line-height: 24px;"></i>
					</summary>
					<a id="carList" href="car-list.jsp"
						class="d-block ml-1 border-bottom p-3"><i
						class="fas fa-list-ul mr-2"></i>Car list</a>
					<a id="addCar" href="add-car.jsp" class="d-block ml-1 p-3"><i
						class="fas fa-plus mr-2"></i>Add Car</a>
				</details></li>
			<li class="p-3 border-bottom"><details id="bookingOffice">
					<summary style="list-style: none; color: #007bff;">
						<i class="fas fa-cart-plus mr-2"></i>Booking office manager<i
							class="fas fa-chevron-down float-right"
							style="line-height: 24px;"></i>
					</summary>
					<a id="bookingOfficeList"
						href="<%=request.getContextPath()%>/booking"
						class="d-block ml-1 border-bottom p-3"><i
						class="fas fa-list-ul mr-2"></i>Booking office list</a>
					<a id="addBookingOffice" href="<%=request.getContextPath()%>/add"
						class="d-block ml-1 p-3"><i class="fas fa-plus mr-2"></i>Add
						Booking office</a>
				</details></li>
			<li class="p-3 border-bottom"><details id="parkingLotMenu">
					<summary style="list-style: none; color: #007bff;">
						<i class="fas fa-map-marker-alt mr-2"></i>Parking lot manager<i
							class="fas fa-chevron-down float-right"
							style="line-height: 24px;"></i>
					</summary>
					<a id="parkingLotList"
						href="<%=request.getContextPath()%>/parking-lot-list"
						class="d-block ml-1 border-bottom p-3"><i
						class="fas fa-list-ul mr-2"></i>Parking lot list</a>
					<a id="addParkingLot"
						href="<%=request.getContextPath()%>/add-parking-lot"
						class="d-block ml-1 p-3"><i class="fas fa-plus mr-2"></i>Add
						Parking lot</a>
				</details></li>
			<li class="p-3 border-bottom"><details id="trip">
					<summary style="list-style: none; color: #007bff;">
						<i class="fas fa-plane mr-2" style="transform: rotate(-45deg);"></i>Trip
						manager<i class="fas fa-chevron-down float-right"
							style="line-height: 24px;"></i>
					</summary>
					<a id="tripList" href="<%=request.getContextPath()%>/TripListController"
						class="d-block ml-1 border-bottom p-3"><i
						class="fas fa-list-ul mr-2"></i>Trip list</a>
					<a id="addTrip" href="<%=request.getContextPath()%>/TripAddController" class="d-block ml-1 p-3"><i
						class="fas fa-plus mr-2"></i>Add trip</a>
				</details></li>
			<li class="p-3 border-bottom"><details id="ticket">
					<summary style="list-style: none; color: #007bff;">
						<i class="fas fa-ticket-alt mr-2"
							style="transform: rotate(-45deg);"></i>Ticket manager<i
							class="fas fa-chevron-down float-right"
							style="line-height: 24px;"></i>
					</summary>
					<a id="ticketList" href="TicketListController"
						class="d-block ml-1 border-bottom p-3"><i
						class="fas fa-list-ul mr-2"></i>Ticket list</a>
					<a id="addTicket" href="AddTicketController" class="d-block ml-1 p-3"><i
						class="fas fa-plus mr-2"></i>Add ticket</a>
				</details></li>
		</ul>
	</div>

	<script>
		var pathName = window.location.pathname;
		if (pathName.includes('add-booking-office.jsp')) {
			document.getElementById('addBookingOffice').classList.add("active");
			document.getElementById('bookingOffice').open = true;
		} else if (pathName.includes('booking-office-list.jsp')) {
			document.getElementById('bookingOfficeList').classList
					.add("active");
			document.getElementById('bookingOffice').open = true;
		} else if (pathName.includes('add-parking-lot')) {
			document.getElementById('addParkingLot').classList.add("active");
			document.getElementById('parkingLotMenu').open = true;
		} else if (pathName.includes('parking-lot-list')) {
			document.getElementById('parkingLotList').classList.add("active");
			document.getElementById('parkingLotMenu').open = true;
		} else if (pathName.includes('car-list.jsp')) {
			document.getElementById('carList').classList.add("active");
			document.getElementById('car').open = true;
		} else if (pathName.includes('add-car.jsp')) {
			document.getElementById('addCar').classList.add("active");
			document.getElementById('car').open = true;
		} else if (pathName.includes('add-trip.jsp')) {
			document.getElementById('addTrip').classList.add("active");
			document.getElementById('trip').open = true;
		} else if (pathName.includes('trip-list.jsp')) {
			document.getElementById('tripList').classList.add("active");
			document.getElementById('trip').open = true;
		} else if (pathName.includes('AddTicketController')) {
			document.getElementById('addTicket').classList.add("active");
			document.getElementById('ticket').open = true;
		} else if (pathName.includes('TicketListController')) {
			document.getElementById('ticketList').classList.add("active");
			document.getElementById('ticket').open = true;
		}
	</script>

	<c:if test="${activeParkingLotList == true }">
		<script type="text/javascript">
			document.getElementById('parkingLotMenu').setAttribute("open",
					"true");
			document.getElementById('parkingLotList').classList.add("active");
		</script>
	</c:if>
	<c:if test="${activeParkingLotAdd == true }">
		<script type="text/javascript">
			document.getElementById('parkingLotMenu').setAttribute("open",
					"true");
			document.getElementById('addParkingLot').classList.add("active");
		</script>
	</c:if>
</body>
</html>