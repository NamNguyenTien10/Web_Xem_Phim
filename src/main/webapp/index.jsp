<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
<title>Movie Website</title>
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
		<jsp:include page="/layout/header.jsp" />
	</header>

	<!-- Home -->
	<section class="home swiper" id="home">
		<!-- Box 1 -->
		<div class="swiper-wrapper">
			<div class="swiper-slide containerr">
				<img src="<c:url value='/img/home1.jpg' />">
				<div class="home-text">
					<span>Marvel Universe</span>
					<h1>
						Avengers:<br /> Infinity War
					</h1>
					<a href="detail" class="play"> <i class="bx bx-play"></i>
					</a>
				</div>
			</div>

			<!-- Box 2 -->
			<div class="swiper-slide containerr">
				<img src="<c:url value='/img/home2.jpg'/>" alt="" />
				<div class="home-text">
					<span>Marvel Universe</span>
					<h1>
						Avengers:<br /> Endgame
					</h1>
					<a href="" class="play"> <i class="bx bx-play"></i>
					</a>
				</div>
			</div>

			<!-- Box 3 -->
			<div class="swiper-slide containerr">
				<img src="<c:url value='/img/home3.jpg'/>">
				<div class="home-text">
					<span>Marvel Universe</span>
					<h1>
						Spider-Man:<br /> No Way Home
					</h1>
					<a href="" class="play"> <i class="bx bx-play"></i>
					</a>
				</div>
			</div>
		</div>

		<div class="swiper-pagination"></div>
	</section>

	<!-- Movies -->
	<section class="movies" id="movies">
		<h2 class="heading">Opening This Week</h2>
		<!-- Movies Container -->
		<div class="movies-container">
			<c:forEach items="${video}" var="vid">
				<div class="box">
					<div class="box-img">
						<a href="<c:url value='/video?action=watch&id=${vid.href}'/>">
							<img src="<c:url value='${vid.poster}'/>">
						</a>
					</div>
					<h3>${vid.title}</h3>
					<span>120 min | Action</span>
					<div class="d-flex justify-content-between tm-text-gray">
						<span class="tm-text-gray-light">${vid.shares} share</span> <span>${vid.views}
							views</span>
					</div>
				</div>
			</c:forEach>
		</div>

		<div class="row tm-mb-90">
            <div class="col-12 d-flex justify-content-between align-items-center tm-paging-col">
                <c:if test="${currentPage == 1}">
                	<a href="javascript:void(0);" class="btn btn-primary tm-btn-prev mb-2 disabled">Previous</a>
                </c:if>
                <c:if test="${currentPage > 1}">
                	<a href="index?page=${currentPage - 1}" class="btn btn-primary tm-btn-prev mb-2">Previous</a>
                </c:if>
                <div class="tm-paging d-flex">
	                <c:forEach varStatus="i" begin="1" end="${maxPage}">
					<a href="index?page=${i.index}"
						class="tm-paging-link ${currentPage == i.index ? 'active' : ''}">${i.index}</a>
				</c:forEach>
                </div>
                <c:if test="${currentPage == maxPage}">
                	<a href="javascript:void(0);" class="btn btn-primary tm-btn-prev disabled">Next Page</a>
                </c:if>
                <c:if test="${currentPage < maxPage}">
                	<a href="index?page=${currentPage + 1}" class="btn btn-primary tm-btn-prev ">Next Page</a>
                </c:if>
                
            </div>            
        </div>
	</section>

	<!-- Coming -->
	<section class="coming" id="coming">
		<h2 class="heading">Coming Soon</h2>
		<!-- Coming Container -->
		<div class="coming-container swiper">
			<div class="swiper-wrapper">
				<!-- Box 1 -->
				<div class="swiper-slide box">
					<div class="box-img">
						<a href="<c:url value='/video?action=watch&id=${vid.href}'/>"><img
							src="<c:url value='/img/coming1.jpg'/>"></a>
					</div>
					<h3>Ant man 3</h3>
					<span>120 min | Action</span>
				</div>

				<!-- Box2 -->
				<div class="swiper-slide box">
					<div class="box-img">
						<a href="<c:url value='/video?action=watch&id=${vid.href}'/>"><img
							src="<c:url value='/img/coming2.jpg'/>"></a>
					</div>
					<h3>Godzilla vs Kong</h3>
					<span>120 min | Action</span>
				</div>

				<!-- Box 3 -->
				<div class="swiper-slide box">
					<div class="box-img">
						<img src="<c:url value='/img/coming3.jpg'/>">
					</div>
					<h3>John Wick 4</h3>
					<span>120 min | Action</span>
				</div>

				<!-- Box 4 -->
				<div class="swiper-slide box">
					<div class="box-img">
						<img src="<c:url value='/img/coming4.jpg'/>">
					</div>
					<h3>Aquaman</h3>
					<span>120 min | Action</span>
				</div>

				<!-- Box 5 -->
				<div class="swiper-slide box">
					<div class="box-img">
						<img src="<c:url value='/img/coming5.jpg'/>">
					</div>
					<h3>Wonder Woman</h3>
					<span>120 min | Action</span>
				</div>

				<!-- Box 6 -->
				<div class="swiper-slide box">
					<div class="box-img">
						<img src="<c:url value='/img/coming6.jpg'/>">
					</div>
					<h3>Spider-man: Far from home</h3>
					<span>120 min | Action</span>
				</div>

				<!-- Box 7 -->
				<div class="swiper-slide box">
					<div class="box-img">
						<img src="<c:url value='/img/coming7.jpg'/>">
					</div>
					<h3>Thor 2</h3>
					<span>120 min | Action</span>
				</div>

				<!-- Box 8 -->
				<div class="swiper-slide box">
					<div class="box-img">
						<img src="<c:url value='/img/coming8.jpg'/>">
					</div>
					<h3>Kong: Đảo đầu lâu</h3>
					<span>120 min | Action</span>
				</div>

				<!-- Box 9 -->
				<div class="swiper-slide box">
					<div class="box-img">
						<img src="<c:url value='/img/coming9.jpg'/>">
					</div>
					<h3>Captain America</h3>
					<span>120 min | Action</span>
				</div>

				<!-- Box 10 -->
				<div class="swiper-slide box">
					<div class="box-img">
						<img src="<c:url value='/img/coming11.jpg'/>">
					</div>
					<h3>Captain Marvel</h3>
					<span>120 min | Action</span>
				</div>
			</div>
		</div>
	</section>

	<!-- Newsletter -->
	<section class="newsletter" id="newsletter">
		<h2>
			Subcribe To Get <br /> Newsletter
			<form action="">
				<input type="email" class="email" placeholder="Enter Email..."
					required /> <input type="submit" value="Subcribe" class="btn" />
			</form>
		</h2>
	</section>

	<footer>
		<jsp:include page="/layout/footer.jsp" />
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