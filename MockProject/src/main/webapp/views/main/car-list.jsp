<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car List</title>
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/header.css">
<link rel="stylesheet" href="resources/css/style-main.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap4.min.css">
<script src="https://kit.fontawesome.com/9f5e8136b5.js"></script>
</head>
<body>
	<jsp:include page="../header/header.jsp"></jsp:include>
	<div>
		<jsp:include page="../sidebar/sidebar-service-manager.jsp"></jsp:include>
		<div class="float-left main-content border-top">
			<h2 class="m-4">Car list</h2>
			<hr class="m-4">
			<form action="<%=request.getContextPath()%>/SearchCartController"
				id="form-search" class="d-flex mr-lg-5 mb-4 justify-content-end" method="get">
				<i class="fas fa-search p-2 bg-custom border border-icon-search"></i>
				<input id="input-search" name="input-search" type="text"
					placeholder="Car Search" class="box-search border-custom p-1 mr-2"
					style="width: 35%;"> <select
					class="box-search border-custom p-1 mr-2 pr-5" id="selectCompany"
					name="selectCompany" style="display: none;">
					<c:forEach items="${companies}" var="ca">
						<option value="${ca.companyName}" ${com==ca.companyName?"selected":""}>${ca.companyName}</option>
						
					</c:forEach>
				</select> <select class="box-search border-custom p-1 mr-2 pr-5"
					id="selectParkingLot" name="selectParkingLot"
					style="display: none;">
					<c:forEach items="${parkingLots}" var="p">
						<option value="${p.name}" ${pa==p.name?"selected":""}>${p.name}</option>
					</c:forEach>
				</select> <i class="fas fa-filter bg-custom border border-icon-search p-2">
					<p class="d-inline font-weight-normal">Filter by</p>
				</i> <select onchange="changeCategory()" name="category" id="category"
					class="border-custom pt-1 pb-2 mr-2" style="width: 15%;">
					<option value="licensePlate"
						${category == "licensePlate"?"selected":""}>License plate</option>
					<option value="carType" ${category == "carType"?"selected":""}>Car
						type</option>
					<option value="carColor" ${category == "carColor"?"selected":""}>Car
						color</option>
					<option value="company" ${category == "company"?"selected":""}>Company</option>
					<option value="parkingLot"
						${category == "parkingLot"?"selected":""}>Parking lot</option>
				</select>
				<div onclick="searchCar()" class="btn btn-info p-1 pl-2 pr-2">Search</div>
			</form>
			<div style="width: 95%">
				<table
					class="table table-striped ml-4 table-bordered dt-responsive nowrap hover"
					id="tblCar">
					<thead class="font-weight-bold" style="background-color: #e7e7e7;">
						<tr>
							<td scope="col">License plate</td>
							<td scope="col">Car type</td>
							<td scope="col">Car color</td>
							<td scope="col">Company</td>
							<td scope="col">Parking lot</td>
							<td scope="col">Action</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cars}" var="c">
							<tr>
								<td scope="col">${c.licensePlate}</td>
								<td>${c.carType}</td>
								<td>${c.carColor}</td>
								<td>${c.company.companyName}</td>
								<td><a href="parking-lot-list?packId=${c.parkingLot.id}">${c.parkingLot.name}</a></td>
								<td><a href="UpdateCarController?uid=${c.licensePlate}"><i
										class="far fa-edit"></i>Edit</a> <a
									onclick="if (!(confirm('Are you sure to delete'))) return false"
									href="DeleteCarController?cid=${c.licensePlate}"><i
										class="far fa-trash-alt"></i>Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<p class="text-danger text-center mt-3">${errorSQL}</p>
		</div>
	</div>
	<script type="text/javascript">
		changeCategory();
		function changeCategory() {
			var category = document.getElementById('category').value;
			if (category == 'licensePlate' || category == 'carType'
					|| category == 'carColor') {
				document.getElementById('input-search').style.display = 'block';
				document.getElementById('input-search').type = 'text';
				document.getElementById('selectCompany').style.display = 'none';
				document.getElementById('selectParkingLot').style.display = 'none';
			}

			else if (category == 'parkingLot') {
				document.getElementById('selectParkingLot').style.display = 'block';
				document.getElementById('input-search').style.display = 'none';
				document.getElementById('selectCompany').style.display = 'none';
			} else if (category == 'company') {
				document.getElementById('selectCompany').style.display = 'block';
				document.getElementById('input-search').style.display = 'none';
				document.getElementById('selectParkingLot').style.display = 'none';
			}

		}

		function searchCar() {
			document.getElementById('form-search').submit();
		}
	</script>
	<script>
		$(document).ready(function() {
			$('#tblCar').DataTable({
				bPaginate : true,
				bLengthChange : false,
				bFilter : false,
				bInfo : false,
				bAutoWidth : false
			});

		});
	</script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="resources/js/search-car.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
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