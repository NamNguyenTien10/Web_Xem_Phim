<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
<title>${video.title}</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous" />
<link rel="stylesheet" href="<c:url value='/view/user/css/style.css'/>" />
     <!-- Box icon -->
     <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css"
    /> 
</head>
<body>

<header>
		<jsp:include page="/layout/header.jsp"/>
</header>
	
 <!-- Detail video  -->
    <section>
      <div class="title">
        <div class="row mb-4">
          <h2 style="margin-left: 110px" class="col-12 tm-text-primary">${video.title}</h2>
        </div>
      </div>

      <div class="video-detail">
     	<iframe src="https://www.youtube.com/embed/${video.href}"></iframe>
      </div>
      <c:if test="${not empty sessionScope.currentUser}">
      	<button id="likeOrUnlikeBtn" class="btn btnLike">
      		<c:choose>
      			<c:when test="${LikedBtn == true}">Unlike</c:when>
      			<c:otherwise>Like</c:otherwise>
      		</c:choose>
      	</button>
      	<a class="btn btnShare">Share</a>
      </c:if>
      <div>
     	<p style="margin-top: 20px; margin-left: 250px;">
     	Description: ${video.description}
     	</p>
      </div>
	  <input id="videoHidden" type="hidden" value="${video.href}"/>
      
      <div class="row mb-4">
        <h2 class="heading heading-detail">Related Videos</h2>
      </div>

      <div class="movies-container">
       <!-- Box 1 -->
			<div class="box">
				<div class="box-img">
					<a href="<c:url value='/video?action=watch&id=${video.href}'/>"><img src="<c:url value='/img/m1.webp'/>"></a>
				</div>
				<h3>Tranformers: Age of extinction</h3>
				<span>120 min | Action</span>
			</div>

			<!-- Box2 -->
			<div class="box">
				<div class="box-img">
					<a href="<c:url value="/video?action=watch&id=${video.href}"/>"><img src="<c:url value='/img/m2.jpg'/>"></a>
				</div>
				<h3>Iron man 3</h3>
				<span>120 min | Action</span>
			</div>

			<!-- Box 3 -->
			<div class="box">
				<div class="box-img">
					<img src="<c:url value='/img/m3.jpg'/>">
				</div>
				<h3>Wakanda Forever</h3>
				<span>120 min | Action</span>
			</div>

			<!-- Box 4 -->
			<div class="box">
				<div class="box-img">
					<img src="<c:url value='/img/m4.jpg'/>">
				</div>
				<h3>Batman 2</h3>
				<span>120 min | Action</span>
			</div>

			<!-- Box 5 -->
			<div class="box">
				<div class="box-img">
					<img src="<c:url value='/img/m5.jpg'/>">
				</div>
				<h3>Spider-man: No way home</h3>
				<span>120 min | Action</span>
			</div>

			<!-- Box 6 -->
			<div class="box">
				<div class="box-img">
					<img src="<c:url value='/img/m6.jpg'/>">
				</div>
				<h3>Avenger: Endgame</h3>
				<span>120 min | Action</span>
			</div>

			<!-- Box 7 -->
			<div class="box">
				<div class="box-img">
					<img src="<c:url value='/img/m7.jpg'/>">
				</div>
				<h3>Avenger: Infinitywar</h3>
				<span>120 min | Action</span>
			</div>

			<!-- Box 8 -->
			<div class="box">
				<div class="box-img">
					<img src="<c:url value='/img/m8.webp'/>">
				</div>
				<h3>Tranformers</h3>
				<span>120 min | Action</span>
			</div>

			<!-- Box 9 -->
			<div class="box">
				<div class="box-img">
					<img src="<c:url value='/img/m9.jpg'/>">
				</div>
				<h3>Captain America</h3>
				<span>120 min | Action</span>
			</div>

			<!-- Box 10 -->
			<div class="box">
				<div class="box-img">
					<img src="<c:url value='/img/m10.jpg'/>">
				</div>
				<h3>Captain Marvel</h3>
				<span>120 min | Action</span>
			</div> 
		</div>
      
    </section>
    
    <footer>
		<jsp:include page="/layout/footer.jsp"/>
	</footer>
	
	<script>
	$('#likeOrUnlikeBtn').click(function() {
		var videoId = $('#videoHidden').val();
		$.ajax({
			url: 'video?action=like&id=' + videoId
		}).then(function(data){
			var text = $('#likeOrUnlikeBtn').text();
			if (text.indexOf('Like') != -1) {
				$('#likeOrUnlikeBtn').text('Unlike');
			}else{
				$('#likeOrUnlikeBtn').text('Like');
			}
		}).fail(function(error){
			alert('Oops!!! Loi roi code lai di');
		});
	});
	</script>
	
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