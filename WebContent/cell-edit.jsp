<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<jsp:include page="/templates/header.jsp" />
<title>Sửa chuồng thúc</title>
</head>
<body>

	<div id="wrapper">
		<jsp:include page="/templates/menu-sidebar.jsp" />

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">Quản lý chuồng thú</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<c:choose>
						<c:when test="${requestScopr.errorUpdate ==1 }">
							<div class="alert alert-danger">
								<strong>Error!</strong> Đã có lỗi xảy ra trong quá trình cập
								nhật chuồng thú.
							</div>
						</c:when>
					</c:choose>
					<div class="panel panel-default">
						<div class="panel-heading">Cập nhật chuồng thú</div>

						<div class="panel-body">
							<div class="col-lg-9">
								<form
									action="${pageContext.request.contextPath}/cell-edit?id=${requestScope.cell.cellID}"
									method="post" id="form-edit-cell">
									<div class="form-group">
										<label>Mã chuồng</label> <input class="form-control"
											name="id-cell" id="id-cell" type="text"
											value="${requestScope.cell.cellID}" disabled="disabled"
											required="required">
									</div>

									<div class="form-group">
										<label>Tên Chuồng</label> <input class="form-control"
											name="name-cell" id="name-cell" type="text"
											value="${requestScope.cell.cellName}" required="required">
									</div>
									<div class="form-group">
										<label for="exampleSelect1" class="">Region</label> <select
											class="form-control" id="region-select" name="region-select">
											<c:forEach var="region" items="${requestScope.regions}">
												<c:choose>
													<c:when
														test="${requestScope.cell.regionID == region.regionID}">
														<option value="${region.regionID}" selected="selected">${region.regionName}</option>
													</c:when>
													<c:otherwise>
														<option value="${region.regionID}">${region.regionName}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select>
									</div>
									<div class="form-group">
										<label for="exampleSelect2" class="">Loài</label> <select
											class="form-control" id="species-select"
											name="species-select">
											<c:forEach var="species" items="${requestScope.species}">
												<c:choose>
													<c:when
														test="${requestScope.cell.speciesID == species.speciesID}">
														<option value="${species.speciesID}" selected="selected">${species.speciesName}</option>
													</c:when>
													<c:otherwise>
														<option value="${species.speciesID}">${species.speciesName}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select>
									</div>
									<div class="form-group">
										<label>Số lượng tối đa</label> <input class="form-control"
											name="capacity" id="capacity" type="number"
											value="${requestScope.cell.capacity}" required="required">
									</div>

									<div class="form-group">
										<label>Mô tả</label>
										<textarea class="form-control" rows="4" name="description"
											required="required">${requestScope.cell.description}</textarea>
									</div>

									<div class="form-group">
										<label>Tình trạng chuồng thú</label>
										<c:forEach var="status" items="${requestScope.status}">
											<c:choose>
												<c:when
													test="${requestScope.cell.cellStatusID == status.cellStatusID}">
													<div class="radio">
														<label><input type="radio" name="cell-status"
															id="optionsRadios1" value="${status.cellStatusID }"
															checked>${status.cellStatusName}</label>
													</div>
												</c:when>
												<c:otherwise>
													<div class="radio">
														<label><input type="radio" name="cell-status"
															id="optionsRadios1" value="${status.cellStatusID }">${status.cellStatusName}</label>
													</div>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</div>
									<button type="submit" class="btn btn-success" name="submit">
										<i class="fa fa-floppy-o" aria-hidden="true"></i> Lưu
									</button>
									<button type="reset" class="btn btn-info">
										<i class="fa fa-eraser" aria-hidden="true" id="reset"></i> Xóa hết
									</button>
									<button type="reset" class="btn btn-danger">
										<i class="fa fa-ban" aria-hidden="true"></i> Hủy
									</button>
								</form>

							</div>
						</div>
					</div>

				</div>

			</div>


		</div>
	</div>


	<jsp:include page="/templates/footer.jsp" />
	<script>
	function resetForm() {
		$('#form-edit-cell')[0].reset();
	}
	</script>
</body>
</html>
