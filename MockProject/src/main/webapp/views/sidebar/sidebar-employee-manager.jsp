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
<link rel="stylesheet" href="../../resources/css/style-main.css">
<script src="https://kit.fontawesome.com/9f5e8136b5.js"></script>
</head>
<body>
	<div class="float-left sidebar vh-100 border-right bg-light">
            <ul class="list-unstyled">
                <li class="border-bottom p-3"><a href="#"><i class="fas fa-tachometer-alt mr-2"></i>Dashboard</a></li>
                <li class="p-3">
                    <details>
                        <summary style="list-style: none; color: #007bff;"><i class="fas fa-chart-bar mr-2"></i>Employee
                            manager<i class="fas fa-chevron-down float-right" style="line-height: 24px;"></i></summary>
                        <a id="EmployeeList" href="employee-list.jsp" class="d-block ml-1 border-bottom p-3"><i
                                class="fas fa-list-ul mr-2"></i>Employee list</a>
                        <a id="AddEmployee" href="add-employee.jsp" class="d-block ml-1 border-bottom p-3"><i
                                class="fas fa-plus mr-2"></i>Add Employee</a>
                    </details>
                </li>
            </ul>
        </div>

	<script>
		if (window.location.pathname.includes("employee-list.jsp")) {
			document.getElementById("EmployeeList").classList.add("active");
		} else if (window.location.pathname.includes("add-employee.jsp")) {
			document.getElementById("AddEmployee").classList.add("active");
		}
	</script>
</body>
</html>