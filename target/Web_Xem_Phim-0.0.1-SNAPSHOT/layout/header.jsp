<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<a href="" class="logo"> <i class="bx bxs-movie"></i> Movies
</a>
<div class="bx bx-menu" id="menu-icon"></div>
<ul class="menu">
	<li><a href="index#home" class="home-active">Home</a></li>
	<li><a href="index#movies">Movies</a></li>
	<li><a href="index#coming">Coming</a></li>
	<li><a href="index#newsletter">Newsletter</a></li>
</ul>
<nav class="navbar navbar-expand-lg">
	<div class="container-fluid">
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto mb-2 mb-lg-0">
				<c:choose>
					<c:when test="${not empty sessionScope.currentUser}">
						<li class="nav-item"><a class="nav-link nav-link-2"
							href="videos.html">Welcome, ${sessionScope.currentUser}</a></li>
						<li class="nav-item"><a class="nav-link nav-link-4"
							href="favorite">My Favorite</a></li>
						<li class="nav-item"><a class="nav-link nav-link-4"
							href="history">History</a></li>
						<li class="nav-item"><a class="nav-link nav-link-4"
							href="logout">Log out</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link nav-link-3"
							href="login">Login</a></li>
						<li class="nav-item"><a class="nav-link nav-link-4"
							href="register">Register</a></li>
						<li class="nav-item"><a class="nav-link nav-link-4"
							href="contact.html">Forgot Password</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>


