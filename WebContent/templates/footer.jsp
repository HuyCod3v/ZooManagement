<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script
	src="//cdnjs.cloudflare.com/ajax/libs/metisMenu/2.5.2/metisMenu.min.js"></script>

<script
	src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
	
<script
	src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
	
<script
	src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>
	
<script
	src="//cdn.datatables.net/responsive/2.1.0/js/dataTables.responsive.min.js"></script>

<script src="<c:url value="/resources/js/sb-admin-2.js"/>"></script>


<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>