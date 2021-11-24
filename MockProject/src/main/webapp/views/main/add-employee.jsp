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
		
		<form action="AddEmployeeController" method="POST" class="float-left main-content border-top" id="form-add-employee">
            <h2 class="m-4">Add Employee</h2>
            <hr class="m-4">
            <table class="m-4">
                <tr>
                    <td class="font-weight-bold pr-5 pt-2 pb-2">Full name <label class="required">(*)</label></td>
                    <td><input class="box form-control pt-2 pb-2 text-sm" placeholder="Enter full name" type="text"
                            name="fullname" id="fullname" required></td>
                </tr>
                <tr>
                    <td class="font-weight-bold pr-5 pt-2 pb-2">Phone number <label class="required">(*)</label></td>
                    <td><input class="box form-control pt-2 pb-2 text-sm" placeholder="Enter phone number" type="tel"
                            name="phonenumber" id="phonenumber"></td>
                </tr>
                <tr>
                    <td class="font-weight-bold pr-5 pt-2 pb-2">Date of birth <label class="required">(*)</label></td>
                    <td><input name="dateofbirth" type="date" class="box form-control pt-2 pb-2 text-sm"
                            id="dateofbirth"></td>
                </tr>
                <tr>
                    <td class="font-weight-bold pr-5 pt-2 pb-2">Sex <label class="required">(*)</label></td>
                    <td><input name="sex" type="radio" value="true" checked><label
                            class="font-weight-bold text-sm">Male</label> 
                        <input name="sex" type="radio" class="ml-3"
                            value="false"><label class="font-weight-bold text-sm">Female</label></td>
                </tr>
                <tr>
                    <td class="font-weight-bold pr-5 pt-2 pb-2 unrequired">Address</td>
                    <td><input name="address" type="text" placeholder="Enter address"
                            class="box form-control pt-2 pb-2 unrequired text-sm" id="address"></td>
                </tr>
                <tr>
                    <td class="font-weight-bold pr-5 pt-2 pb-2 unrequired">Email</td>
                    <td><input name="email" type="email" placeholder="Enter email"
                            class="box form-control unrequired text-sm" id="email">
                         <p ${checkEmail eq false ? "":"hidden" }>Email exist</p>
                    </td>
                </tr>
                <tr>
                    <td class="font-weight-bold pr-5 pt-2 pb-2">Account <label class="required">(*)</label></td>
                    <td><input class="box form-control pt-2 pb-2 text-sm" placeholder="Enter account" type="text"
                            name="account" id="account">
                        <p ${checkAccount eq false ? "":"hidden" }>Account exist</p>
                    </td>
                </tr>
                <tr>
                    <td class="font-weight-bold pr-5 pt-2 pb-2">Password <label class="required">(*)</label></td>
                    <td><input class="box form-control pt-2 pb-2 text-sm" placeholder="Enter password" type="password"
                            name="password" id="password"></td>
                </tr>
                <tr>
                    <td class="font-weight-bold pr-5 pt-2 pb-2">Department <label class="required">(*)</label></td>
                    <td><select name="department" class="box form-control pt-2 pb-2 text-sm">
                            <c:forEach items="${departments }" var="dep">/
	                    		<option value="${dep.departmentId }">${dep.departmentName }</option>
	                    	</c:forEach>
                        </select></td>
                </tr>
            </table>
            <div class="d-flex list-btn">
                <div  onclick="window.history.back();" class="btn btn-info mr-1 text-btn"><i class="fas fa-backward mr-1"></i>Back</div>
                <div onclick="clickReset()" class="btn btn-warning mr-1 text-btn"><i class="fas fa-redo mr-1" style="transform: scaleX(-1);"></i>Reset</div>
                <div onclick="clickAdd()" class="btn btn-success mr-1 text-btn">
                    <i class="fas fa-plus mr-1"></i>Add
                </div>
            </div>
            <i ${check eq true ?"":"hidden" } style="color: red">Add Successfully!!!</i>
        </form>
	</div>

	<script type="text/javascript">
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1; //January is 0!
	var yyyy = today.getFullYear() - 16;

	if (dd < 10) {
	   dd = '0' + dd;
	}

	if (mm < 10) {
	   mm = '0' + mm;
	} 
	    
	today = yyyy + '-' + mm + '-' + dd;
	document.getElementById("dateofbirth").setAttribute("max", today);
	</script>
	<script src="<c:url value='/resources/js/validate-employee-manager.js'/>"></script>
	<script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js'/>"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
</body>
</html>