<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/templates/header.jsp" />
<title>Job</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/templates/menu-sidebar.jsp" />
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">
						Quản Lý Công Việc
					</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="row">
								<div class="col-lg-11">Danh sách</div>
								<div class="col-lg-1">
									<a class="btn btn-success btn-circle"
										href='<c:url value="/job/create-job"/>'> <i
										class="fa fa-plus" aria-hidden="true"></i>
									</a>
								</div>
							</div>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table width="100%"
								class="table table-striped table-bordered table-hover" id="dataTables-example">
								<thead>
									<tr>
										<th>Mã Công Việc</th>
										<th>Tên Công Việc</th>
										<th>Mô Tả</th>
										<th>Thao Tác</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="job" items="${requestScope.list}">
										<tr>
											<td>${job.jobId}</td>
											<td>${job.jobName}</td>
											<td>${job.description}</td>
											<td>
											<a class="btn btn-info btn-circle"
													href='<c:url value="/job/edit?jobId=${job.jobId}"/>'>
														<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
												</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="delete-user-modal" role="dialog">
	    <div class="modal-dialog">
	      <!-- Modal content-->
	      <div class="modal-content">    
		      <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <div>Xác nhận</div>
		        </div>   
	        <div class="modal-body" style="padding:10px 10px;">
	          <form role="form">
	          	  <div>Bạn có muốn xóa tài khoản <label id="user-id"></label> không ?</div>                                         
	          </form>
	        </div>     
	        <div class="modal-footer">
	        	<form method="get" role="form" action='<c:url value="/manager/delete-user"/>'>
	        		<input type="hidden" name="username" id="user-id-submit"/>
	        		<button type="submit" class="btn btn-info btn-default pull-left"><span class="fa fa-check"></span> Có</button>
	          		<button type="button" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="fa fa-ban"></span> Không</button>
	        	</form>
	        </div>
	      </div>
	    </div>
  </div>
	<jsp:include page="/templates/footer.jsp" />
	<script type="text/javascript">
		$(document).on("click", "#delete-user-action", function () {
		     var userId = $(this).data('user-id');
		     $(".modal-body #user-id").html(userId);
		     $("#user-id-submit").val(userId);		
		});
	</script>
</body>
</html>