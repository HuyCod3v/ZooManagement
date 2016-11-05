<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/templates/header.jsp" />
<title>Detail Notification</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/templates/menu-sidebar.jsp" />
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">Chi Tiết Thông Báo</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<c:if test="${requestScope.message != null}">
						<div class="alert alert-danger">
							${requestScope.message}
						</div>
					</c:if>
					<div class="form-group">
						<div class="">
							<h2 style="color: green">${requestScope.noti.title}</h2>
							<small style="color: #FF6611">at ${requestScope.noti.date} by ${requestScope.noti.employeeId}</small>
						</div>
					</div>
					<div class="form-group">
						<div class="" style="padding:10px 5px; border: 1px solid silver">
							${requestScope.noti.content}
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/templates/footer.jsp" />
</body>
</html>