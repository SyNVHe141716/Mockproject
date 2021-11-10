<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Office List</title>
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
            <h2 class="m-4">Booking office list</h2>
            <hr class="m-4">
            <form id="form-search" class="float-right d-flex mr-4 mb-4">
                <i class="fas fa-search p-2 bg-custom border border-icon-search"></i>
                <input id="input-search" name="input-search" type="text" placeholder="Booking office Search"
                    class="box-search border-custom p-1 mr-2" style="width: 35%;">
                <i class="fas fa-filter bg-custom border border-icon-search p-2">
                    <p class="d-inline font-weight-normal">Filter by</p>
                </i>
                <select onchange="changeCategory()" name="category" id="category" class="border-custom pt-1 pb-2 mr-2"
                    style="width: 15%;">
                    <option value="bookingOffice">Booking office </option>
                    <option value="trip">Trip </option>
                </select>
                <div onclick="searchBookingOffice()" class="btn btn-info p-1 pl-2 pr-2">Search</div>
            </form>
            <table class="table table-striped ml-4" style="width: 95%;">
                <thead class="font-weight-bold" style="background-color: #e7e7e7;">
                    <tr>
                        <td scope="col">ID</td>
                        <td scope="col">Booking office</td>
                        <td scope="col">Trip</td>
                        <td scope="col">Action</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td scope="col">1</td>
                        <td>Phuong Tang</td>
                        <td>Gia Lai</td>
                        <td><a href="#"><i class="far fa-eye"></i>View</a></td>
                    </tr>
                </tbody>
            </table>
            <div class="d-flex ml-4">
                <a href="#" class="p-2 border text-center rounded-left text-black-50"
                    style="width: 6.5%; border-right: 0;">Previous</a>
                <a href="#" class="p-2 border pl-3 pr-3 now-index">1</a>
                <a href="#" class="p-2 border text-center rounded-right text-black-50"
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
	
</body>
</html>