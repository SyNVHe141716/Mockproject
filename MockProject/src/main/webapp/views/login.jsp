<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Login</title>
<link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/fonts/font-awesome.min.css">
<link rel="stylesheet" href="../resources/css/Login-screen.css">
</head>
<body>
	<div id="login-one" class="login-one">
		<form class="login-one-form">
			<div class="col">
				<div class="login-one-ico">
					<i class="fa fa-unlock-alt" id="lockico"></i>
				</div>
				<div class="form-group">
					<div>
						<h3 id="heading">Log in:</h3>
					</div>
					<input id='username' oninput="checkNull()"
						class="form-control text-zoom" type="text" placeholder="Username" />
					<input id='password' oninput="checkNull()"
						class="form-control text-zoom" type="password"
						placeholder="Password" /> <label class="m-0" class="remember">
						<input type="checkbox" class="d-inline" /> <span class="d-inline"><i></i></span>
						<div class="d-inline">Remember me</div>
					</label>
					<button class="btn btn-primary" disabled id="button"
						style="background-color: #007ac9;" type="submit">Login</button>
				</div>
			</div>
		</form>
	</div>
	<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="../resources/js/login.js"></script>
</body>
</html>