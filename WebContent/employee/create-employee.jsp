<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/templates/header.jsp" />
<title>Create Employee</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/templates/menu-sidebar.jsp" />
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">Tạo Mới Nhân Viên</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<c:if test="${requestScope.message != null}">
						<div class="alert alert-danger">
							${requestScope.message}
						</div>
					</c:if>
					<form class="form-horizontal" action="/ZooManagement/do-create-employee" method="post">
						<div class="form-group">
							<label class="" for="employeeId">Mã Nhân Viên<span
								class="red-text">**</span>:
							</label>
							<div class="">
								<input type="text" class="form-control" id="employeeId"
									name="employeeId" placeholder="Mã Nhân Viên" required value="${employee.employeeId}">
							</div>
						</div>
						<div class="form-group">
							<label class="" for="employeeName">Tên Nhân Viên<span
								class="red-text">**</span>:
							</label>
							<div class="">
								<input type="text" class="form-control" id="employeeName"
									name="employeeName" placeholder="Tên Nhân Viên" required value="${employee.employeeName}">
							</div>
						</div>
						<div class="form-group">
							<div class="">
								<label class="" for="gender">Giới Tính<span
									class="red-text">**</span>:
								</label> <input type="radio" checked name="gender" value="1"><label>Nam</label>
								<input type="radio" name="gender" value="0"><label>Nữ</label>
							</div>
						</div>
						<div class="form-group">
							<label class="" for="birthday">Ngày Sinh<span
								class="red-text">**</span>:
							</label>
							<div class="input-group date datepicker">
								<input type='text' class="form-control" name="birthday" value="${employee.birthday}"
									placeholder="Ngày Sinh" required /> <span
									class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
						<div class="form-group">
							<label class="" for="address">Địa Chỉ<span
								class="red-text">**</span>:
							</label>
							<div class="">
								<input type="text" class="form-control" id="address" value="${employee.address}"
									name="address" placeholder="Địa Chỉ" required>
							</div>
						</div>
						<div class="form-group">
							<label class="" for="phone">Điện Thoại:</label>
							<div class="">
								<input type="number" class="form-control" id="phone" value="${employee.phone}"
									name="phone" placeholder="Điện Thoại">
							</div>
						</div>
						<div class="form-group">
							<div class="">
								<button type="submit" class="btn btn-default">Submit</button>
								<button type="reset" class="btn btn-primary">Reset</button>
							</div>
						</div>
					</form>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
	</div>
	<jsp:include page="/templates/footer.jsp" />
</body>
</html>