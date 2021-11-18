<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Login</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/9f5e8136b5.js"></script>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/Login-screen.css">
</head>
<body>
	<div id="login-one" class="login-one">
		<form class="login-one-form" action="${pageContext.servletContext.contextPath}/LoginController" method="POST">
            <div class="col">
                <div class="login-one-ico"><i class="fa fa-unlock-alt" id="lockico"></i></div>
                <div class="form-group">
                    <div>
                        <h3 id="heading">Log in:</h3>
                    </div>
                    <input id='username' class="form-control text-zoom" type="text" placeholder="Username" required="required" name="username" value="${acc }"/>
                    <input id='password' class="form-control text-zoom" type="password" placeholder="Password" required="required" name="password"/>
                    <!-- <label class="m-0" class="remember">
                        <input type="checkbox" name="rememberMe">
                        Remember me
                    </label> -->
                    <button class="btn btn-primary" id="button" style="background-color:#007ac9;" type="submit">Login</button>
                    <i ${acc eq null ? "hidden":"" } style="color: red">Wrong user or password!!!</i>
                </div>
            </div>
        </form>
	</div>
	<script src="${pageContext.servletContext.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.servletContext.contextPath}/resources/js/login.js"></script>
</body>
</html>