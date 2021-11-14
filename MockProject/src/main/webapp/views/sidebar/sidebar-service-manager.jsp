<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking office manager</title>
<link rel="stylesheet"
	href="../../resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../../resources/css/header.css">
<link rel="stylesheet" href="../../resources/css/style-main.css">
<script src="https://kit.fontawesome.com/9f5e8136b5.js"></script>
</head>
<body>
	<div class="float-left sidebar vh-100 border-right bg-light">
		<ul class="list-unstyled">
			<li class="border-bottom p-3"><a href="#"><i
					class="fas fa-tachometer-alt mr-2"></i>Car park manager</a></li>
			<li class="p-3 border-bottom"><details>
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
			<li class="p-3 border-bottom"><details>
					<summary style="list-style: none; color: #007bff;">
						<i class="fas fa-cart-plus mr-2"></i>Booking office manager<i
							class="fas fa-chevron-down float-right"
							style="line-height: 24px;"></i>
					</summary>
					<a id="bookingOfficeList" href="booking-office-list.jsp"
						class="d-block ml-1 border-bottom p-3"><i
						class="fas fa-list-ul mr-2"></i>Booking office list</a>
					<a id="addBookingOffice" href="add-booking-office.jsp"
						class="d-block ml-1 p-3"><i class="fas fa-plus mr-2"></i>Add
						Booking office</a>
				</details></li>
			<li class="p-3 border-bottom"><details>
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
			<li class="p-3 border-bottom"><details>
					<summary style="list-style: none; color: #007bff;">
						<i class="fas fa-plane mr-2" style="transform: rotate(-45deg);"></i>Trip
						manager<i class="fas fa-chevron-down float-right"
							style="line-height: 24px;"></i>
					</summary>
					<a id="tripList" href="trip-list.jsp"
						class="d-block ml-1 border-bottom p-3"><i
						class="fas fa-list-ul mr-2"></i>Trip list</a>
					<a id="addTrip" href="add-trip.jsp" class="d-block ml-1 p-3"><i
						class="fas fa-plus mr-2"></i>Add trip</a>
				</details></li>
			<li class="p-3 border-bottom"><details>
					<summary style="list-style: none; color: #007bff;">
						<i class="fas fa-ticket-alt mr-2"
							style="transform: rotate(-45deg);"></i>Ticket manager<i
							class="fas fa-chevron-down float-right"
							style="line-height: 24px;"></i>
					</summary>
					<a id="bookingOfficeList" href="ticket-list.jsp"
						class="d-block ml-1 border-bottom p-3"><i
						class="fas fa-list-ul mr-2"></i>Ticket list</a>
					<a id="addBookingOffice" href="add-ticket.jsp"
						class="d-block ml-1 p-3"><i class="fas fa-plus mr-2"></i>Add
						ticket</a>
				</details></li>
		</ul>
	</div>

	<script>
		var listBookingOffice = document.getElementById("bookingOfficeList");
		var addBookingOffice = document.getElementById("addBookingOffice");

		if (window.location.pathname.includes("booking-office-list.jsp")) {
			listBookingOffice.classList.add("active");
		} else if (window.location.pathname.includes("add-booking-office.jsp")) {
			addBookingOffice.classList.add("active");
		}
	</script>
</body>
</html>