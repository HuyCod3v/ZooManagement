<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/templates/header.jsp" />
<title>Create Account</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/templates/menu-sidebar.jsp" />
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">Tạo Mới Tài Khoản</h3>
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
					<form class="form-horizontal" action='<c:url value="/manager/do-create-user"/>' method="post">
						<div class="form-group">
							<label class="" for="username">Tên Tài Khoản:<span
								class="red-text">**</span>:
							</label>
							<div class="">
								<input type="text" class="form-control" id="username"
									name="username" placeholder="Tên Nhân Viên" required value="${requestScope.user.username}">
							</div>
						</div>
						<div class="form-group">
							<label class="" for="userTypeId">Loại Nhân Viên<span
								class="red-text">**</span>:
							<select class="form-control" id="userTypeId" name="userTypeId">
								<c:forEach var="type" items="${requestScope.listUserType}">
							    	<option <c:if test="${type.userTypeId == requestScope.user.userTypeID }">selected</c:if> value=${type.userTypeId }>${type.userTypeName}</option>
								</c:forEach>
							 </select>
						</div>
						<div class="form-group">
							<label class="" for="employeeId">Nhân Viên<span
								class="red-text">**</span>:
							<select class="form-control" id="employeeId" name="employeeId">
								<c:forEach var="user"  items="${requestScope.listUser}">
							    	<option <c:if test="${user.employeeID == requestScope.user.employeeID }">selected</c:if> value=${user.employeeID}>${user.employeeName}</option>
								</c:forEach>
							 </select>
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