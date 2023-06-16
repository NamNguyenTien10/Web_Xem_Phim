<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
<title>Insert title here</title>
<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback" />
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/plugins/fontawesome-free/css/all.min.css'/>">

<!-- Ionicons -->
<link rel="stylesheet"
	href="<c:url value='https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css'/>">

<!-- Tempusdominus Bootstrap 4 -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css'/>">

<!-- iCheck -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/plugins/icheck-bootstrap/icheck-bootstrap.min.css'/>">

<!-- JQVMap -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/plugins/jqvmap/jqvmap.min.css'/>">

<!-- Theme style -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/dist/css/adminlte.min.css'/>">

<!-- overlayScrollbars -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/plugins/overlayScrollbars/css/OverlayScrollbars.min.css'/>">

<!-- Daterange picker -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/plugins/daterangepicker/daterangepicker.css'/>">

<!-- summernote -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/plugins/summernote/summernote-bs4.min.css'/>">
</head>
<body>

	<jsp:include page="menu.jsp"/>
	<section>
		<jsp:include page="${view}"/>
	</section>
	
	<footer>
		<jsp:include page="footer.jsp"/>
	</footer>
	
	
	<!-- jQuery -->
	<script
		src="<c:url value='/template/admin/plugins/jquery/jquery.min.js'/>"></script>
	<!-- jQuery UI 1.11.4 -->
	<script
		src="<c:url value='/template/admin/plugins/jquery-ui/jquery-ui.min.js'/>"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
      $.widget.bridge("uibutton", $.ui.button);
    </script>
	<!-- Bootstrap 4 -->
	<script
		src="<c:url value='/template/admin/plugins/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
	<!-- ChartJS -->
	<script
		src="<c:url value='/template/admin/plugins/chart.js/Chart.min.js'/>"></script>
	<!-- Sparkline -->
	<script
		src="<c:url value='/template/admin/plugins/sparklines/sparkline.js'/>"></script>
	<!-- JQVMap -->
	<script
		src="<c:url value='/template/admin/plugins/jqvmap/jquery.vmap.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/plugins/jqvmap/maps/jquery.vmap.usa.js'/>"></script>
	<!-- jQuery Knob Chart -->
	<script
		src="<c:url value='/template/admin/plugins/jquery-knob/jquery.knob.min.js'/>"></script>
	<!-- daterangepicker -->
	<script
		src="<c:url value='/template/admin/plugins/moment/moment.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/plugins/daterangepicker/daterangepicker.js'/>"></script>
	<!-- Tempusdominus Bootstrap 4 -->
	<script
		src="<c:url value='/template/admin/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js'/>"></script>
	<!-- Summernote -->
	<script
		src="<c:url value='/template/admin/plugins/summernote/summernote-bs4.min.js'/>"></script>
	<!-- overlayScrollbars -->
	<script
		src="<c:url value='/template/admin/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js'/>"></script>
	<!-- AdminLTE App -->
	<script src="<c:url value='/template/admin/dist/js/adminlte.js'/>"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="<c:url value='/template/admin/dist/js/demo.js'/>"></script>
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script
		src="<c:url value='/template/admin/dist/js/pages/dashboard.js'/>"></script>
	<!-- DataTables  & Plugins -->
	<script
		src="<c:url value='/template/admin/plugins/datatables/jquery.dataTables.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/plugins/datatables-responsive/js/dataTables.responsive.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/plugins/datatables-responsive/js/responsive.bootstrap4.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/plugins/datatables-buttons/js/dataTables.buttons.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/plugins/datatables-buttons/js/buttons.bootstrap4.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/plugins/jszip/jszip.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/plugins/pdfmake/pdfmake.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/plugins/pdfmake/vfs_fonts.js'/>"></script>
	<script
		src="<c:url value='/template/admin/plugins/datatables-buttons/js/buttons.html5.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/plugins/datatables-buttons/js/buttons.print.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/plugins/datatables-buttons/js/buttons.colVis.min.js'/>"></script>
	<script src="<c:url value='/template/user/js/plugins.js'/>"></script>
	<script>
      $(function () {
        $("#example1")
          .DataTable({
            responsive: true,
            lengthChange: false,
            autoWidth: false,
            buttons: ["copy", "csv", "excel", "pdf", "print", "colvis"],
          })
          .buttons()
          .container()
          .appendTo("#example1_wrapper .col-md-6:eq(0)");
        $("#example2").DataTable({
          paging: true,
          lengthChange: false,
          searching: false,
          ordering: true,
          info: true,
          autoWidth: false,
          responsive: true,
        });
      });
    </script>
	<script>
    	$('#selectVideo').change(function){
    		var videoId = $(this).val();
    		$ajax({
    			url: 'admin/favorite?href=' +videoHref,
    			type: 'GET',
    			contentType: 'application/json'
    		}).done(function(data){
    			destroy: true,
    			"paging": true,
    	        "lengthChange": false,
    	        "searching": false,
    	        "ordering": true,
    	        "info:: true,
    	        "autoWidth": false,
    	        "responsive": true,
    	        "aaData": data,
    	        "colums": [{"data":"username"}, {"data":"email"}]
    		})
    	});
    </script>
</body>
</html>