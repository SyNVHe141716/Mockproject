<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
		<jsp:include page="../sidebar/sidebar-employee-manager.jsp"></jsp:include>
		<div class="float-left main-content border-top">
            <h2 class="m-4">Employee List</h2>
            <hr class="m-4">
            <form id="form-search" class="float-right d-flex mr-lg-5 mb-4 justify-content-end" action="SearchEmployeeController" method="POST">
                <i class="fas fa-search p-2 bg-custom border border-icon-search"></i>
                <input id="input-search" name="input-search" type="text" placeholder="User Search"
                    class="box-search border-custom p-1 mr-2" style="width: 35%; height: 35px;">
                    <select class="box-search border-custom p-1 mr-2 pr-5" id="selectdepartment" name="selectdepartment" style="display: none;">
                        <option>Test 1</option>
                        <option>Test 1</option>
                        <option>Test 1</option>
                    </select>
                <i class="fas fa-filter bg-custom border border-icon-search p-2">
                    <p class="d-inline font-weight-normal">Filter by</p>
                </i>
                <select onchange="changeCategory()" name="category" id="category" class="border-custom pt-1 pb-2 mr-2"
                    style="width: 22%;">
                    <option value="name">Name</option>
                    <option value="dateofbirth">Date of birth</option>
                    <option value="address">Address</option>
                    <option value="phonenumber">Phone number</option>
                    <option value="department">Department</option>
                </select>
                <div onclick="searchEmployee()" class="btn btn-info p-1 pl-2 pr-2">Search</div>
            </form>
            <table class="table table-striped ml-4" style="width: 95%;">
                <thead class="font-weight-bold" style="background-color: #e7e7e7;">
                    <tr>
                        <td scope="col">ID</td>
                        <td scope="col">Name</td>
                        <td scope="col">Date of birth</td>
                        <td scope="col">Address</td>
                        <td scope="col">Phone number</td>
                        <td scope="col">Department</td>
                        <td scope="col">Action</td>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach items="${employees }" var="emp">
                    <tr>
                        <td scope="col">${emp.employeeId }</td>
                        <td>${emp.employeeName }</td>
                        <td>${emp.employeeBirthdate }</td>
                        <td>${emp.employeeAddress }</td>
                        <td>${emp.employeePhone }</td>
                        <c:forEach items="${departments }" var="dep">
                        	<c:if test = "${dep.departmentId eq emp.departmentId }">
					         	<td>${dep.departmentName }</td>
					      	</c:if>
                        <%-- ${dep.departmentId eq emp.departmentId ?"<td>dep.departmentName</td>":""} --%>
                        </c:forEach>
                        <td><a href="ViewEmployeeController?id=${emp.employeeId }"><i class="far fa-eye"></i>View</a></td>
                    </tr>
                    </c:forEach>
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


	<script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>
	<script src="<c:url value='/resources/js/search-employee.js' />"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js'/>"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
</body>
</html>
