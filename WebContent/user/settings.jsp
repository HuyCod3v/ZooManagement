<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/templates/header.jsp" />
<title>Change Password</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/templates/menu-sidebar.jsp" />
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">Thay Đổi Mật Khẩu</h3>
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
					<form class="form-horizontal" action='<c:url value="/do-change-password" />' method="post">
						<div class="form-group">
							<label class="" for="password">Mật Khẩu Cũ:<span
								class="red-text">**</span>:
							</label>
							<div class="">
								<input type="password" class="form-control" id="password"
									name="password" required  placeholder="Nhập mật khẩu cũ">
							</div>
						</div>
						<div class="form-group">
							<label class="" for="password-new">Mật Khẩu Mới:<span
								class="red-text">**</span>:
							</label>
							<div class="">
								<input type="password" class="form-control" id="password-new"
									name="password-new" placeholder="Nhập mới" required>
							</div>
						</div>
						<div class="form-group">
							<label class="" for="password-re">Nhập Lại Mật Khẩu:<span
								class="red-text">**</span>:
							</label>
							<div class="">
								<input type="password" class="form-control" id="password-re"
									name="password-re" placeholder="Nhập lại" required>
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