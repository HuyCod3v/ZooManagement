<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/templates/header.jsp" />
<title>Create Job Assign</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/templates/menu-sidebar.jsp" />
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">Phân Công Công Việc</h3>
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
					<form class="form-horizontal" action='<c:url value="/link-job/do-create-link-job" />' method="post">
						<div class="form-group">
							<label class="" for="employeeId">Nhân Viên<span
								class="red-text">**</span>:
							<select class="form-control" id="employeeId" name="employeeId">
								<c:forEach var="em"  items="${requestScope.listEmployee}">
							    	<option value=${em.employeeId}>${em.employeeName}</option>
								</c:forEach>
							 </select>
						</div>
						<div class="form-group">
							<label class="" for="employeeId">Công Việc<span
								class="red-text">**</span>:
							<select class="form-control" id="jobId" name="jobId">
								<c:forEach var="job"  items="${requestScope.listJob}">
							    	<option value=${job.jobId}>${job.jobName}</option>
								</c:forEach>
							 </select>
						</div>
						<div class="form-group">
							<label class="" for="startTime">Bắt Đầu:<span
								class="red-text">**</span>:
							</label>
							<div class="input-group date datepicker">
								<input type='text' class="form-control" name="startTime" value="${link.startTime}"
									placeholder="Bắt Đầu" required /> <span
									class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
						<div class="form-group">
							<label class="" for="endTime">Kết Thúc<span
								class="red-text">**</span>:
							</label>
							<div class="input-group date datepicker">
								<input type='text' class="form-control" name="endTime" value="${link.endTime}"
									placeholder="Kết Thúc" required /> <span
									class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
						<div class="form-group">
							<label class="" for="endTime">Mô Tả<span
								class="red-text">**</span>:
							</label>
							<div class="">
								<textarea class="form-control" required name="description" rows="10" id="content"></textarea>
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