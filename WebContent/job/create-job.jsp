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
					<form class="form-horizontal" action='<c:url value="/job/do-create-job" />' method="post">
						<div class="form-group">
							<label class="" for="jobId">Mã Công Việc<span
								class="red-text">**</span>:
							</label>
							<div class="">
								<input type="text" class="form-control" id="jobId"
									name="jobId" placeholder="Mã Công Việc" required value="${job.jobId}">
							</div>
						</div>
						<div class="form-group">
							<label class="" for="jobName">Tên Công Việc<span
								class="red-text">**</span>:
							</label>
							<div class="">
								<input type="text" class="form-control" id="jobName"
									name="jobName" placeholder="Tên Công Việc" required value="${job.jobName}">
							</div>
						</div>
						<div class="form-group">
							<label class="" for="des">Mô Tả Công Việc<span
								class="red-text">**</span>:
							</label>
							<div class="">
								<input type="text" class="form-control" id="des"
									name="des" placeholder="Mô Tả Sơ Lược"  value="${job.description}">
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