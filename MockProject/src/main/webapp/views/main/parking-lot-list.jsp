<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Parking Lot List</title>
<link
	href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />"
	rel="stylesheet">
<link href="<c:url value='/resources/css/header.css' />"
	rel="stylesheet">
<link href="<c:url value='/resources/css/style-main.css' />"
	rel="stylesheet">
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
			<h2 class="m-4">Parking lot list</h2>
			<hr class="m-4">
			<form id="form-search"
				action="<%=request.getContextPath()%>/parking-lot-search"
				method="post"
				class="d-flex mr-lg-5 mb-4 justify-content-end">
				<i class="fas fa-search p-2 bg-custom border border-icon-search"></i>

				<input id="name-search" name="name-search" type="text"
					value="${txtSearch}" placeholder="Name Search"
					class="box-search border-custom p-1 mr-2"> <input id="from"
					name="from" type="number" placeholder="From" value="${from}"
					class="box-search border-custom p-1 mr-2"
					style="width: 17%; display: none;" min="0">
				<div style="margin: auto 0px; display: none;" id="text-to">-</div>
				<input id="to" name="to" type="number" placeholder="To"
					class="box-search border rounded p-1 mr-2 ml-2"
					style="width: 17%; display: none;" min="1" value="${to}"> <select
					id="select-place" name="select-place"
					class="box-search border-custom p-1 mr-2 pr-lg-5"
					style="display: none;">
					<c:forEach items="${parkingPlaces}" var="place">
						<option value="${place.id}" ${placeId==place.id?"selected":""}>${place.name}</option>
					</c:forEach>
				</select> <i class="fas fa-filter bg-custom border border-icon-search p-2">
					<p class="d-inline font-weight-normal">Filter by</p>
				</i> <select onchange="changeCategory()" name="category" id="category"
					class="border-custom pt-1 pb-2 mr-2 pr-3">
					<option value="name" ${category == "name"?"selected":""}>Name</option>
					<option value="area" ${category =="area"?"selected":""}>Area</option>
					<option value="price" ${category == "price"?"selected":""}>Price</option>
					<option value="place" ${category =="place"?"selected":""}>Place</option>
				</select>
				<button type="submit" class="btn btn-info p-1 pl-2 pr-2 float-right">Search</button>
			</form>
			<div style="width: 95%">
				<table
					class="table table-striped ml-4 table-bordered dt-responsive nowrap table-hover"
					id="tblParking">
					<thead class="font-weight-bold" style="background-color: #e7e7e7;">
						<tr>
							<td scope="col">ID</td>
							<td scope="col">Parking lot</td>
							<td scope="col">Place</td>
							<td scope="col">Area</td>
							<td scope="col">Price</td>
							<td scope="col">Status</td>
							<td scope="col">Action</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${parkingLots}" var="p">
							<tr>
								<td scope="col">${p.id}</td>
								<td>${p.name}</td>
								<td><c:forEach items="${parkingPlaces}" var="place">${p.placeId==place.id?place.name:""}</c:forEach>
								</td>
								<td>${p.area}</td>
								<td>${p.price}</td>
								<td>${p.status==false?"Blank":"Full"}</td>
								<td class="d-flex"><a
									href="<%=request.getContextPath()%>/parking-lot-edit?id=${p.id}"
									class="mr-2"><i class="fas fa-edit"></i>Edit</a> <a
									onclick="if (!(confirm('Are you sure to delete'))) return false"
									href="<%=request.getContextPath()%>/parking-lot-delete?id=${p.id}"
									style="cursor: pointer; color: #007bff;"> <i
										class="fas fa-trash mr-1"></i>Delete
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<p class="text-danger text-center mt-3">${mess}</p>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('#tblParking').DataTable({
				bPaginate : true,
				bLengthChange : false,
				bFilter : false,
				bInfo : false,
				bAutoWidth : false
			});

		});
	</script>
	<script
		src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>
	<script src="<c:url value='/resources/js/search-parking-lot.js' />"></script>
	<script
		src="<c:url value='/resources/js/validate-delete-parking-lot.js' />"></script>
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

	<c:if test="${category == 'name'}">
		<script type="text/javascript">
			document.getElementById('name-search').style.display = 'block';
			document.getElementById('from').style.display = 'none';
			document.getElementById('text-to').style.display = 'none';
			document.getElementById('to').style.display = 'none';
			document.getElementById('select-place').style.display = 'none';
		</script>
	</c:if>
	<c:if test="${category == 'area'||category == 'price'}">
		<script type="text/javascript">
			document.getElementById('name-search').style.display = 'none';
			document.getElementById('from').style.display = 'block';
			document.getElementById('text-to').style.display = 'block';
			document.getElementById('to').style.display = 'block';
			document.getElementById('select-place').style.display = 'none';
		</script>
	</c:if>
	<c:if test="${category == 'place'}">
		<script type="text/javascript">
			document.getElementById('select-place').style.display = 'block';
			document.getElementById('name-search').style.display = 'none';
			document.getElementById('from').style.display = 'none';
			document.getElementById('text-to').style.display = 'none';
			document.getElementById('to').style.display = 'none';
		</script>
	</c:if>
</body>
</html>