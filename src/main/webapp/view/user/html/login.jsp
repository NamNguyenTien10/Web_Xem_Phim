<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="<c:url value='/view/user/css/login.css'/>" />

<!-- Font Awesome Cdn Link -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
</head>
<body>
	<form action="" method="post">
		<div class="wrapper">
			<h1>Login</h1>
			
				<input type="text" placeholder="Username" name="username" /> 
				<span style="color: red">${error_username}</span>
				<input type="password" placeholder="Password" name="password" />
				<span style="color: red">${error_password}</span>
				<span style="color: red">${message}</span>
				<p class="recover">
					<a href="#">Remember Password</a>
				</p>
			
			<button>Sign in</button>

			<div class="not-member">
				Not a member? <a href="register">Register Now</a>
			</div>
		</div>
	</form>	
	
</body>
</html>