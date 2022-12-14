<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Add Parking Lot</title>
<link
	href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />"
	rel="stylesheet">
<link href="<c:url value='/resources/css/header.css' />"
	rel="stylesheet">
<link href="<c:url value='/resources/css/style-main.css' />"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/9f5e8136b5.js"></script>
</head>
<body>
	<jsp:include page="../header/header.jsp"></jsp:include>
	<div>
		<jsp:include page="../sidebar/sidebar-service-manager.jsp"></jsp:include>
		<form action="<%=request.getContextPath()%>/add-parking-lot" method="post"
			class="float-left main-content border-top" id="form-update-employee">
			<h2 class="m-4">Add Parking lot</h2>
			<hr class="m-4">

			<table class="m-4">
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Parking name <label
						class="required">(*)</label></td>
					<td><input class="box form-control pt-2 pb-2 text-sm"
						placeholder="Enter parking name" type="text" name="name"
						id="parkingname" required></td>
				</tr>
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Place <label
						class="required">(*)</label></td>
					<td><select name="placeId"
						class="box form-control pt-2 pb-2 text-sm">
							<c:forEach items="${parkingPlaces}" var="place">
								<option value="${place.id}">${place.name}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Area <label
						class="required">(*)</label></td>
					<td><input class="box form-control pt-2 pb-2 text-sm"
						placeholder="Enter area" type="number" name="area" id="area"
						min="1" required></td>
					<td class="font-weight-bold pl-4">(m2)</td>
				</tr>
				<tr>
					<td class="font-weight-bold pr-5 pt-2 pb-2">Price <label
						class="required">(*)</label></td>
					<td><input class="box form-control pt-2 pb-2 text-sm"
						placeholder="Enter price" type="number" name="price" id="price"
						min="1" required></td>
					<td class="font-weight-bold pl-4">(VN??)</td>
				</tr>

			</table>
			<div class="d-flex list-btn">
				<div onclick="window.history.back();"
					class="btn btn-info mr-1 text-btn">
					<i class="fas fa-backward mr-1"></i>Back
				</div>
				<div onclick="clickReset()" class="btn btn-warning mr-1 text-btn">
					<i class="fas fa-redo mr-1" style="transform: scaleX(-1);"></i>Reset
				</div>
				<button class="btn btn-success mr-1 text-btn">
					<i class="fas fa-plus mr-1"></i>Add
				</button>
			</div>
		</form>
		<p class="text-danger text-center mt-3">${mess}</p>
	</div>
	<script
		src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>
	<script
		src="<c:url value='/resources/js/validate-add-parking-lot.js' />"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script
		src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
</body>
</html>