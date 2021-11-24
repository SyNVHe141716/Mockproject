<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Office List</title>
<link rel="stylesheet"
	href="resources/bootstrap/css/bootstrap.min.css">
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
			<h2 class="m-4">Booking office list</h2>
			<hr class="m-4">
			<form id="form-search" class="d-flex mr-lg-5 mb-4 justify-content-end" action="<%=request.getContextPath() %>/search?index=1" method="get">
				<i class="fas fa-search p-2 bg-custom border border-icon-search"></i>
				<input id="input-search" name="txtSearch" value="${txt }" type="text"
					placeholder="Booking Office Search"
					class="box-search border-custom p-1 mr-2"
					style="width: 35%; height: 35px;"> <select
					class="box-search border-custom p-1 mr-2 pr-5" id="selectTrip"
					name="selectTrip" style="display: none;">
					<c:forEach items="${ lsTrip}" var="o">
							<option ${id == o.tripId ? "selected":"" } value="${o. tripId}" name="abc" >${o.destination }</option>
					</c:forEach>
				</select> <i class="fas fa-filter bg-custom border border-icon-search p-2">
					<p class="d-inline font-weight-normal">Filter by</p>
				</i> <select onchange="changeCategory()" name="category" id="category"
					class="border-custom pt-1 pb-2 mr-2" style="width: 15%;">
					<option value="bookingOffice"${category == "bookingOffice"?"selected":""}>Bookingoffice</option>
					<option value="trip" ${category == "trip"?"selected":""}>Trip</option>
				</select>
				<div onclick="searchBookingOffice()"
					class="btn btn-info p-1 pl-2 pr-2">Search</div><br>
					
			</form>
			<p style="color: red; margin-left: 40px">
			<%=request.getAttribute("mess")!=null?request.getAttribute("mess"):"" %></p>
			<div style="width: 95%">
			<table class="table table-striped ml-4 table-bordered dt-responsive nowrap table-hover"
					id="tblBooking">
				<thead class="font-weight-bold" style="background-color: #e7e7e7;">
					<tr>
						<td scope="col">ID</td>
						<td scope="col">Booking office</td>
						<td scope="col">Trip</td>
						<td scope="col">Action</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list }" var="x">
					<tr>
						<td scope="col">${x.stt }</td>
						<td>${x.officeName }</td>
						<td>${x. destination}</td>
						<td>
						<a href="<%=request.getContextPath() %>/delete?id=${x.officeId}" onclick="return testConfirmDialog()"><i class="far fa-trash-alt"></i>Delete</a>
						<a href="<%=request.getContextPath() %>/update?id=${x.officeId}" ><i class="far fa-edit"></i>Edit</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<script>
		$(document).ready(function() {
			$('#tblBooking').DataTable({
				bPaginate : true,
				bLengthChange : false,
				bFilter : false,
				bInfo : false,
				bAutoWidth : false
			});

		});
	</script>
		<script src="resources/bootstrap/js/bootstrap.min.js"></script>
		<script src="resources/js/search-booking-office.js"></script>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
		<script src="resources/bootstrap/js/bootstrap.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
				<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script
		src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>

	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script
		src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>

	<script
		src="https://cdn.datatables.net/1.11.3/js/dataTables.bootstrap4.min.js"></script>		
		 <script type="text/javascript">
     function testConfirmDialog()  {

              var result = confirm("Do you want to continue?");

              if(result)  {
                 return true;
              } else {
                 return false;
              }
         }

      </script>
      <c:if test="${category == 'bookingOffice'}">
		<script type="text/javascript">
		document.getElementById('input-search').style.display = 'block';
		document.getElementById('selectTrip').style.display = 'none';
		</script>
	</c:if>
	<c:if test="${category == 'trip'}">
		<script type="text/javascript">
		document.getElementById('selectTrip').style.display = 'block';
		document.getElementById('selectTrip').style.display = 'block';
		document.getElementById('input-search').style.display = 'none';
		</script>
	</c:if>
</body>
</html>