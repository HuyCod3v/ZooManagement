<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/templates/header.jsp" />
<title>User Account</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/templates/menu-sidebar.jsp" />
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">
						Quản Lý Tài Khoản Nhân Viên
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
										href='<c:url value="/manager/create-user"/>'> <i
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
										<th>Điện Thoại</th>
										<th>Địa Chỉ</th>
										<th>Tên Tài Khoản</th>
										<th>Quyền</th>
										<th>Thao Tác</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="user" items="${requestScope.listUser}">
										<tr>
											<td>${user.employeeID}</td>
											<td>${user.employeeName}</td>
											<td>${user.phone}</td>
											<td>${user.address}</td>
											<td>${user.username}</td>
											<td>${user.userTypeName}</td>
											<td>
												<a class="btn btn-info btn-circle"
													href='<c:url value="/manager/create-user"/>'>
													<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
												</a>
												<a class="btn btn-info btn-circle"
													href='<c:url value="/manager/delete-user?username=${user.username}"/>'>
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
	<jsp:include page="/templates/footer.jsp" />
</body>
</html>