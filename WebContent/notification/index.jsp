<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/templates/header.jsp" />
<title>Notification</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/templates/menu-sidebar.jsp" />
		<div id="page-wrapper">
			<div style="padding-top:20px">
			<c:if test="${requestScope.message != null}">
				<div class="alert alert-danger">
					${requestScope.message}
				</div>
			</c:if>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">
						Quản Lý Thông Báo
					</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="row">
								<div class="col-lg-11">Danh sách </div>
								<div class="col-lg-1">
									<a class="btn btn-success btn-circle"
										href='<c:url value="notification/create-notification"/>'> <i
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
										<th>Mã Nhân Viên</th>
										<th>Tiêu Đề</th>
										<th>Ngày Đăng</th>
										<th>Chi Tiết</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="noti" items="${requestScope.list}">
										<tr>
											<td>${noti.employeeId}</td>
											<td>${noti.title}</td>
											<td>${noti.date}</td>
											<td>
												<a class="btn btn-info btn-circle"
													href='<c:url value="/notification/update?notification=${noti.notificationId}"/>'>
													<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
												</a>
												<button type="button" id="delete-noti-action"
													class="btn btn-danger btn-circle"
													data-noti-id="${noti.notificationId}" data-toggle="modal"
													data-target="#delete-noti-modal">
													<i class="fa fa-trash" aria-hidden="true"></i>
												</button>
												<a class="btn btn-info btn-circle"
													href='<c:url value="/notification/detail?notification=${noti.notificationId}"/>'>
													<i class="fa fa-eye" aria-hidden="true"></i>
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
	<div class="modal fade" id="delete-noti-modal" role="dialog">
	    <div class="modal-dialog">
	      <!-- Modal content-->
	      <div class="modal-content">    
		      <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <div>Xác nhận</div>
		        </div>   
	        <div class="modal-body" style="padding:10px 10px;">
	          <form role="form">
	          	  <div>Bạn có muốn xóa thông báo <label id="noti-id"></label> không ?</div>                                         
	          </form>
	        </div>     
	        <div class="modal-footer">
	        	<form method="get" role="form" action='<c:url value="/delete-noti"/>'>
	        		<input type="hidden" name="notiId" id="noti-id-submit"/>
	        		<button type="submit" class="btn btn-info btn-default pull-left"><span class="fa fa-check"></span> Có</button>
	          		<button type="button" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="fa fa-ban"></span> Không</button>
	        	</form>
	        </div>
	      </div>
	    </div>
  </div>
	<jsp:include page="/templates/footer.jsp" />
	<script type="text/javascript">
		$(document).on("click", "#delete-noti-action", function () {
		     var notiId = $(this).data('noti-id');
		     $(".modal-body #noti-id").html(notiId);
		     $("#noti-id-submit").val(notiId);		
		});
	</script>
</body>
</html>