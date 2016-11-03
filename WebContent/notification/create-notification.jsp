<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/templates/header.jsp" />
<title>Create Notification</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/templates/menu-sidebar.jsp" />
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">Tạo Mới Thông Báo</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<c:if test="${requestScope.message != null}">
						<div class="alert alert-danger">
							${requestScope.message}
						</div>
					</c:if>
					<form class="form-horizontal" action="<c:url value='/notification/do-create-notification'/>" method="post">
						<div class="form-group">
							<label class="" for="title">Tiêu Đề<span
								class="red-text">**</span>:
							</label>
							<div class="">
								<input type="text" class="form-control" id="title"
									name="title" placeholder="Nhập Tiêu Đề" required">
							</div>
						</div>
						<div class="form-group">
							<label class="" for="content">Nội Dung<span
								class="red-text">**</span>:</label>
							<div class="">
								<textarea class="form-control" name="content" rows="5" id="content"></textarea>
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
				<div class="col-md-2"></div>
			</div>
		</div>
	</div>
	<jsp:include page="/templates/footer.jsp" />
</body>
</html>