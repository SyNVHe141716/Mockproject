<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />">
<link rel="stylesheet" href="<c:url value='/resources/css/header.css'/>">
<link rel="stylesheet" href="<c:url value='/resources/css/style-main.css' />">
<script src="https://kit.fontawesome.com/9f5e8136b5.js"></script>
</head>
<body>
	<jsp:include page="../header/header.jsp"></jsp:include>
	<div>
		<jsp:include page="../sidebar/sidebar-employee-manager.jsp"></jsp:include>
		
		<form action="ViewEmployeeController" method="POST" class="float-left main-content border-top" id="form-update-employee">
            <h2 class="m-4">View Employee</h2>
            <hr class="m-4">
            
			<c:forEach items="${employees }" var="emp">
				<input type="hidden" name="id" value="${emp.employeeId }" id="id">
				<table class="m-4">
                <tr>
                    <td class="font-weight-bold pr-5 pt-2 pb-2">Full name <label class="required">(*)</label></td>
                    <td><input class="box form-control pt-2 pb-2 text-sm" placeholder="Enter full name" type="text"
                            name="fullname" id="fullname" required value="${emp.employeeName }"></td>
                </tr>
                <tr>
                    <td class="font-weight-bold pr-5 pt-2 pb-2">Phone number <label class="required">(*)</label></td>
                    <td><input class="box form-control pt-2 pb-2 text-sm" placeholder="Enter phone number" type="tel"
                            name="phonenumber" id="phonenumber" value="${emp.employeePhone }"></td>
                </tr>
                <tr>
                    <td class="font-weight-bold pr-5 pt-2 pb-2">Date of birth <label class="required">(*)</label></td>
                    <td><input name="dateofbirth" type="date" class="box form-control pt-2 pb-2 text-sm"
                            id="dateofbirth" value="${emp.employeeBirthdate }"></td>
                </tr>
                <tr>
                    <td class="font-weight-bold pr-5 pt-2 pb-2">Sex <label class="required">(*)</label></td>
                    <td>
                    	<!-- male --> <input name="sex" type="radio" value="true" ${emp.sex eq true ?"checked":"" }><label
                            class="font-weight-bold text-sm">Male</label> 
                            
                       <!-- female --> <input name="sex" type="radio" class="ml-3"
                            value="false" ${emp.sex eq true ?"":"checked" }><label class="font-weight-bold text-sm">Female</label></td>
                </tr>
                <tr>
                    <td class="font-weight-bold pr-5 pt-2 pb-2 unrequired">Address</td>
                    <td><input name="address" type="text" placeholder="Enter address"
                            class="box form-control pt-2 pb-2 unrequired text-sm" id="address" value="${emp.employeeAddress }"></td>
                </tr>
                <tr>
                    <td class="font-weight-bold pr-5 pt-2 pb-2 unrequired">Email</td>
                    <td><input name="email" type="email" placeholder="Enter email"
                            class="box form-control unrequired text-sm" id="email" value="${emp.employeeEmail }">
                        <p ${checkEmail eq false ? "":"hidden" }>Email exist</p>
                    </td>
                </tr>
                <tr>
                    <td class="font-weight-bold pr-5 pt-2 pb-2">Account <label class="required">(*)</label></td>
                    <td>
                    	<input class="box form-control pt-2 pb-2 text-sm" placeholder="Enter account" type="text"
                            name="account" id="account" value="${emp.account }">
                        <p ${checkAccount eq false ? "":"hidden" }>Account exist</p>
                    </td>
                </tr>
                <tr>
                    <td class="font-weight-bold pr-5 pt-2 pb-2">Password <label class="required">(*)</label></td>
                    <td><input class="box form-control pt-2 pb-2 text-sm" placeholder="Enter password" type="password"
                            name="password" id="password" value="${emp.password }"></td>
                </tr>
                <tr>
                    <td class="font-weight-bold pr-5 pt-2 pb-2">Department <label class="required">(*)</label></td>
                    <td><select name="department" class="box form-control pt-2 pb-2 text-sm">
	                    <c:forEach items="${departments }" var="dep">/
	                    	<option value="${dep.departmentId }" ${emp.departmentId eq dep.departmentId ?"selected":""} >${dep.departmentName }</option>
	                    </c:forEach>
                        </select></td>
                </tr>
            </table>
			</c:forEach>
            
            <div class="d-flex list-btn">
                <div  onclick="window.history.back();" class="btn btn-info mr-1 text-btn"><i class="fas fa-backward mr-1"></i>Back</div>
                <div onclick="clickReset()" class="btn btn-warning mr-1 text-btn"><i class="fas fa-redo mr-1" style="transform: scaleX(-1);"></i>Reset</div>
                <div onclick="clickUpdate()" class="btn btn-success mr-1 text-btn">
                    <i class="fas fa-plus mr-1"></i>Update
                </div>
                <div onclick="clickDetele()" class="btn btn-danger text-btn"><i class="fas fa-trash mr-1"></i>Delete</div>
            </div>
            <i ${check eq true ?"":"hidden" } style="color: red">Update Successfully!!!</i>
        </form>
	</div>

	<script src="<c:url value='/resources/js/validate-employee-manager.js' />"></script>
	<script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
</body>
</html>