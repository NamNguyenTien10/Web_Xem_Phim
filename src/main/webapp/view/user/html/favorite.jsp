<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
<title>My Favorite</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous" />
<link rel="stylesheet" href="<c:url value='/view/user/css/style.css'/>" />
<link rel="stylesheet" href="<c:url value='/template/user/css/templatemo-style.css'/>" />
<!-- Box icon -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
</head>
<body>
	<header>
		<jsp:include page="/layout/header.jsp"/>
	</header>

	
	<!-- Movies -->
	<section class="movies" id="movies">
		<h2 class="heading">My Favorite</h2>
		<!-- Movies Container -->
		<div class="movies-container">
			 <c:forEach items="${video}" var="vid">
				<div class="box">
				<div class="box-img">
					<a href="<c:url value='/video?action=watch&id=${vid.href}'/>" >
						<img src="<c:url value='${vid.poster}'/>">
					</a>
				</div>
				<h3>${vid.title}</h3>
				<span>120 min | Action</span>
				<div class="d-flex justify-content-between tm-text-gray">
            		<span class="tm-text-gray-light">${vid.shares} share</span>
            		<span>${vid.views} views</span>
          		</div>
			</div>
			</c:forEach> 
			
			
		</div>
		</section>
		    
        

	<!-- Newsletter -->
	<section class="newsletter" id="newsletter">
		<h2>
			Subcribe To Get <br /> Newsletter
			<form action="">
				<input type="email" class="email" placeholder="Enter Email..."
					required /> <input type="submit" value="Subcribe"
					class="btn" />
			</form>
		</h2>
	</section>

	<footer>
		<jsp:include page="/layout/footer.jsp"/>
	</footer>
	
	
	<script
		src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
	<!-- Link to Custom JS -->
	<script src="main.js"></script>
		<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
		integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
		crossorigin="anonymous"></script>
</body>
</html>