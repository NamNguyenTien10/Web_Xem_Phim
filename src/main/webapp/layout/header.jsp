<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<a href="index#home" class="logo"> <i class="bx bxs-movie"></i> Movies
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
						<li class="nav-item"><a class="nav-link nav-link-1" href="changepass"> Welcome,
								${sessionScope.currentUser.username}</a></li>
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

<!-- Modal -->
<div class="modal fade" id="changePassModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalLabel">Change
					Password</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<div class="row mb-4">
					<div class="col-sm-10">
						<input type="password" placeholder="Old Password"
							name="oldPassword" />
					</div>
				</div>
				<input type="password" placeholder="New Password" name="newPassword" />
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-warning"
					data-bs-dismiss="modal">Close</button>
				<button type="button" class="btn btn-warning">Save changes</button>
			</div>
		</div>
	</div>
</div>


