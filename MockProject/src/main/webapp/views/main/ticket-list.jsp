<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
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
            <h2 class="m-4">Ticket list</h2>
            <hr class="m-4">

            <form id="form-search" class="float-right d-flex mr-lg-5 mb-4 justify-content-end">
                <i class="fas fa-search p-2 bg-custom border border-icon-search"></i>
                <input id="input-search" name="name-search" type="text" placeholder="Ticket Search"
                    class="box-search border-custom mr-2" style="display: none;">
                <input id="from" name="from" type="time" placeholder="From" class="box-search border-custom mr-2"
                    style="display: none;">
                <div style="display: none; margin: auto 0px;" id="text-to">-</div>
                <input id="to" name="to" type="time" placeholder="To" class="box-search border rounded mr-2 ml-2"
                    style="display: none;">
                <select id="trip-search" name="trip-search" class="box-search border-custom p-1 mr-2 pr-5" name="">
                    <option value="1">Gia Lai</option>
                    <option value="1">Ba ria vung tau</option>
                </select>
                <select id="license-plate-search" name="license-plate-search" style="display: none;"
                    class="box-search border-custom p-1 mr-2 pr-5" name="">
                    <option value="1">123abc</option>
                    <option value="1">xyz</option>
                </select>

                <i class="fas fa-filter bg-custom border border-icon-search p-2">
                    <p class="d-inline font-weight-normal">Filter by</p>
                </i>
                <select onchange="changeCategory()" name="category" id="category"
                    class="border-custom pt-1 pb-2 mr-2 pr-3">
                    <option value="trip">Trip</option>
                    <option value="license-plate">License plate</option>
                    <option value="customer">Customer</option>
                    <option value="booking-time">Booking time</option>
                </select>
                <button class="btn btn-info p-1 pl-2 pr-2 float-right">Search</button>
                <select name="day" class="border pt-1 pb-2 ml-2 mr-2 pr-5">
                    <option>1</option>
                    <option>2</option>
                </select>
                <select name="month" class="border pt-1 pb-2 ml-2 mr-2 pr-5">
                    <option>1</option>
                    <option>2</option>
                </select>
                <select name="year" class="border pt-1 pb-2 ml-2 mr-2 pr-5">
                    <option>1990</option>
                    <option>2021</option>
                </select>
            </form>
            <table class="table table-striped ml-4" style="width: 95%;">
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
                    <tr>
                        <td scope="col">1</td>
                        <td>Gia Lai</td>
                        <td>123abc</td>
                        <td>Nguyen Van A</td>
                        <td>11:00</td>
                        <td class="d-flex"><a href="#" class="mr-2"><i class="fas fa-edit"></i>Edit</a>
                            <div onclick="clickDelete(1)" style="cursor: pointer; color: #007bff;"><i
                                    class="fas fa-trash mr-1"></i>Delete</div>
                        </td>
                    </tr>
                </tbody>
            </table>
            <div class="d-flex ml-4">
                <a href="#" class="p-2 border text-center rounded-left text-black-50"
                    style="width: 6.5%; border-right: 0; overflow: hidden;">Previous</a>
                <a href="#" class="p-2 border pl-3 pr-3 now-index">1</a>
                <a href="#" class="p-2 border text-center rounded-right text-black-50"
                    style="width: 6.5%; border-left: 0;overflow: hidden;">Next</a>
            </div>
        </div>
</div>
	<script src="../../resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="../../resources/js/search-ticket.js"></script>
	<script src="../../resources/js/validate-delete-parking-lot.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script src="../../resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
</body>
</html>