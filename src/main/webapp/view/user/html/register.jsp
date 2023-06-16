<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="<c:url value='/view/user/css/register.css'/>" />
<!-- Font Awesome Cdn Link -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
</head>
<body>
	<form action="" method="post">
		<div class="wrapper">
			<h1>Register</h1>
				<input type="text" placeholder="Username" name="username" /> 
				<span style="color: red">${error_username}</span>
				<input type="password" placeholder="Password" name="password" /> 
				<span style="color: red">${error_password}</span>
				<input type="password" placeholder="Confirm Password" name="confirmpassword" />
				<span style="color: red">${message_confirm}</span>
				<input type="email" placeholder="Email" name="email" /><br>
				<span style="color: red">${error_email}</span> 
				<span style="color: red">${message}</span>
			<button>Sign up</button>
			<div class="not-member">
				Already a member <a href="login"> Login Here</a>
			</div>
		</div>
	</form>
</body>
</html>