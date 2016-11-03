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
										<th>Tên Nhân Viên</th>
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
													href='<c:url value="/notification/detail?notification=${noti.notificationId}"/>'>
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