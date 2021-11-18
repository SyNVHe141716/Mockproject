<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="../../resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../../resources/css/header.css">
<script src="https://kit.fontawesome.com/9f5e8136b5.js"></script>
</head>
<body>
	<header class="navbar bg-light w-100 p-3 border-top border-dark">
		<div style="color: gray;">
			<i id="icon-nav"></i>
			<label id="nav-title" style="font-family: sans-serif; font-weight: normal; margin: 0px; margin-left: 5px;"></label>
		</div>
		<div>
			<label style="color: #007bff;" class="mr-4">Welcome test</label> 
			<a href="LogOutController"> <i class="fas fa-sign-out-alt"></i>Logout</a>
		</div>
	</header>

	<script type="text/javascript">
	var pathName = window.location.pathname;
		if (pathName.includes('add-employee.jsp') || pathName.includes('employee-list.jsp') || pathName.includes('view-employee.jsp')) {
			document.getElementById("icon-nav").classList.add("fas");
			document.getElementById("icon-nav").classList.add("fa-users");
			document.getElementById("nav-title").innerHTML = 'Employee';
		}
		else if(pathName.includes('add-booking-office.jsp') || pathName.includes('booking-office-list.jsp') || pathName.includes('edit-delete-booking-office.jsp')){
			document.getElementById("icon-nav").classList.add("fas");
			document.getElementById("icon-nav").classList.add("fa-cart-plus");
			document.getElementById("nav-title").innerHTML = 'Booking office';
		}
		else if(pathName.includes('add-parking-lot.jsp') || pathName.includes('parking-lot-list.jsp') || pathName.includes('edit-parking-lot.jsp')){
			document.getElementById("icon-nav").classList.add("fas");
			document.getElementById("icon-nav").classList.add("fa-map-marker-alt");
			document.getElementById("nav-title").innerHTML = 'Parking lot';
		}
		else if(pathName.includes('add-car.jsp') || pathName.includes('car-list.jsp') || pathName.includes('edit-delete-car.jsp')){
			document.getElementById("icon-nav").classList.add("fas");
			document.getElementById("icon-nav").classList.add("fa-car");
			document.getElementById("nav-title").innerHTML = 'Car';
		}
		else if(pathName.includes('add-trip.jsp') || pathName.includes('trip-list.jsp') || pathName.includes('edit-delete-trip.jsp')){
			document.getElementById("icon-nav").classList.add("fas");
			document.getElementById("icon-nav").classList.add("fa-plane");
			document.getElementById("icon-nav").style.transform = 'rotate(-45deg)';
			document.getElementById("nav-title").innerHTML = 'Trip';
		}
		else if(pathName.includes('add-ticket.jsp') || pathName.includes('ticket-list.jsp') || pathName.includes('edit-ticket.jsp')){
			document.getElementById("icon-nav").classList.add("fas");
			document.getElementById("icon-nav").classList.add("fa-ticket-alt");
			document.getElementById("icon-nav").style.transform = 'rotate(-45deg)';
			document.getElementById("nav-title").innerHTML = 'Ticket';
		}
	</script>
	
	<script src="../../resources/bootstrap/js/bootstrap.min.js"></script>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
</body>
</html>