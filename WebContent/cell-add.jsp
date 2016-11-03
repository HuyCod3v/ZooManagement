<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<jsp:include page="/templates/header.jsp" />
<title>Thêm chuồng thú</title>
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
					<div class="panel panel-default">
						<c:choose>
							<c:when test="${requestScope.error ==1 }">
								<div class="alert alert-danger">
									<strong>Error!</strong> Mã chuồng thú đã tồn tại.
								</div>
							</c:when>
						</c:choose>

						<div class="panel-heading">Thêm chuồng thú</div>

						<div class="panel-body">
							<div class="col-lg-9">
								<form action="${pageContext.request.contextPath}/cell-add"
									method="post">
									<div class="form-group">
										<label>Mã chuồng</label> <input class="form-control"
											name="id-cell" id="id-cell" value="${requestScope.cell.cellID}" required="required">
									</div>

									<div class="form-group">
										<label>Tên Chuồng</label> <input class="form-control"
											name="name-cell" id="name-cell" value="${requestScope.cell.cellName}" required="required">
									</div>
									<div class="form-group">
										<label for="exampleSelect1" class="">Region</label> <select
											class="form-control" id="region-select" name="region-select">
											<c:forEach var="region" items="${requestScope.regions}">
												<option value="${region.regionID}">${region.regionName}</option>
											</c:forEach>
										</select>
									</div>
									<div class="form-group">
										<label for="exampleSelect2" class="">Loài</label> <select
											class="form-control" id="species-select"
											name="species-select">
											<c:forEach var="species" items="${requestScope.species}">
												<option value="${species.speciesID}">${species.speciesName}</option>
											</c:forEach>
										</select>
									</div>
									<div class="form-group">
										<label>Số lượng tối đa</label> <input class="form-control"
											name="capacity" id="capacity" type="number" value="${requestScope.cell.capacity}"
											required="required">
									</div>

									<div class="form-group">
										<label>Mô tả</label>
										<textarea class="form-control" name="description" rows="4" required="required">${requestScope.cell.description}</textarea>
									</div>

									<div class="form-group">
										<label>Tình trạng chuồng thú</label>
										<div class="radio">
											<label> <input type="radio" name="cell-status"
												id="optionsRadios1" value="0" checked>Còn chỗ
											</label>
										</div>
										<div class="radio">
											<label> <input type="radio" name="cell-status"
												id="optionsRadios2" value="1">Đã đầy
											</label>
										</div>
									</div>
									<button type="submit" class="btn btn-success">
										<i class="fa fa-floppy-o" aria-hidden="true"></i> Lưu
									</button>
									<button type="reset" class="btn btn-info">
										<i class="fa fa-eraser" aria-hidden="true"></i> Xóa hết
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

</body>
</html>
