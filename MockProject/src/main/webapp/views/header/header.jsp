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
		<div id="icon-nav" class="" style="color: gray;">
			<label id="nav-title" style="font-family: sans-serif; font-weight: normal; margin: 0px; margin-left: 5px;"></label>
		</div>
		<div>
			<label style="color: #007bff;" class="mr-4">Welcome test</label> 
			<a href="LogoutController"> <i class="fas fa-sign-out-alt"></i>Logout</a>
		</div>
	</header>

	<script type="text/javascript">
		if (window.location.pathname.includes('add-employee.jsp')) {
			document.getElementById("icon-nav").classList.add("fas");
			document.getElementById("icon-nav").classList.add("fa-users");
			document.getElementById("nav-title").innerHTML = 'Employee';
		}
	</script>
	
	<script src="../../resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="../../resources/js/validate-add-employee.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
</body>
</html>