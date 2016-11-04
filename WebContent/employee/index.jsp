<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/templates/header.jsp" />
<title>Employee</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/templates/menu-sidebar.jsp" />
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">
						Quản lý Nhân Viên
					</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="row">
								<div class="col-lg-11">Danh sách Nhân Viên</div>
								<div class="col-lg-1">
									<a class="btn btn-success btn-circle"
										href='<c:url value="/create-employee"/>'> <i
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
										<th>Tên Nhân Viên</th>
										<th>Giới Tính</th>
										<th>Ngày Sinh</th>
										<th>Điện Thoại</th>
										<th>Địa Chỉ</th>
										<th>Thao Tác</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="employee" items="${requestScope.employeeList}">
										<tr>
											<td>${employee.employeeId}</td>
											<td>${employee.employeeName}</td>
											<c:if test="${employee.gender == 1 }"><td>Nam</td></c:if>
											<c:if test="${employee.gender == 0 }"><td>Nữ</td></c:if>
											<td>${employee.birthday}</td>
											<td>${employee.phone}</td>
											<td>${employee.address}</td>
											<td>
												<a class="btn btn-info btn-circle"
													href='<c:url value="/edit-employee?employeeId=${employee.employeeId}"/>'>
														<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
												</a>
												<button type="button" id="delete-employee-action"
													class="btn btn-danger btn-circle"
													data-employee-id="${employee.employeeId}" data-toggle="modal"
													data-target="#delete-employee-modal">
													<i class="fa fa-trash" aria-hidden="true"></i>
												</button>
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
	
	<div class="modal fade" id="delete-employee-modal" role="dialog">
	    <div class="modal-dialog">
	      <!-- Modal content-->
	      <div class="modal-content">    
		      <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <div>Xác nhận</div>
		        </div>   
	        <div class="modal-body" style="padding:10px 10px;">
	          <form role="form">
	          	  <div>Bạn có muốn xóa nhân viên <label id="employee-id"></label> không ?</div>                                         
	          </form>
	        </div>     
	        <div class="modal-footer">
	        	<form method="get" role="form" action='<c:url value="/do-delete-employee"/>'>
	        		<input type="hidden" name="employeeId" id="employee-id-submit"/>
	        		<button type="submit" class="btn btn-info btn-default pull-left"><span class="fa fa-check"></span> Có</button>
	          		<button type="button" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="fa fa-ban"></span> Không</button>
	        	</form>
	        </div>
	      </div>
	    </div>
  </div>
	<jsp:include page="/templates/footer.jsp" />
	
	<script type="text/javascript">
		$(document).on("click", "#delete-employee-action", function () {
		     var employeeId = $(this).data('employee-id');
		     $(".modal-body #employee-id").html(employeeId);
		     $("#employee-id-submit").val(employeeId);		
		});
	</script>
</body>
</html>