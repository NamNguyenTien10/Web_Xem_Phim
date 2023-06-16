<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
<title>Change Password</title>
<link rel="stylesheet" href="<c:url value='/view/user/css/login.css'/>" />

<!-- Font Awesome Cdn Link -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
</head>
<body>
	<form class="form_change_pass" action="/Web_Xem_Phim/changepass" method="post">
      <div class="wrapper">
        <h1>Change Password</h1>
		<input type="hidden" placeholder="Id" name="id"  value="${sessionScope.currentUser.id}" />
        <input type="password" placeholder="Old Password" name="oldpassword"  />
        <input type="password" placeholder="New Password" name="newpassword"  /><br>
        <span>${message}</span>
        <button>Save Change</button>
      </div>
    </form>
</body>
</html>