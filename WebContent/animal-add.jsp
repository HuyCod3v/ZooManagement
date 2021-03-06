<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<jsp:include page="/templates/header.jsp" />
<title>Cập nhật thú</title>
</head>
<body>

	<div id="wrapper">
		<jsp:include page="/templates/menu-sidebar.jsp" />

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">Quản lý thú</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<c:choose>
							<c:when test="${requestScope.error ==1 }">
								<div class="alert alert-danger">
									<strong>Error!</strong> Mã thú đã tồn tại.
								</div>
							</c:when>
						</c:choose>

						<div class="panel-heading">Thêm chuồng thú</div>

						<div class="panel-body">
							<div class="col-lg-9">
								<form id="addAnimalForm" action="${pageContext.request.contextPath}/animal-add"
									method="post">
									<div class="form-group">
										<label for="id-animal">Mã động vật</label> <input class="form-control"
											name="id-animal" id="id-animal"
											value="${requestScope.animal.animalID}" required>
									</div>

									<div class="form-group">
										<label>Tên động vật</label> <input class="form-control"
											name="name-animal" id="name-animal"
											value="${requestScope.animal.animalName}" required="required">
									</div>
									<div class="form-group">
										<label for="exampleSelect1" class="">Loài</label> <select
											class="form-control" id="species-select"
											name="species-select">
											<c:forEach var="species" items="${requestScope.species}">
												<option value="${species.speciesID}">${species.speciesName}</option>
											</c:forEach>
										</select>
									</div>
									<div class="form-group">
										<label>Giới tính</label>
										<div class="radio">
											<label> <input type="radio" name="gender-animal"
												id="optionsRadios1" value="1" checked>Đực
											</label>
										</div>
										<div class="radio">
											<label> <input type="radio" name="gender-animal"
												id="optionsRadios2" value="0">Cái
											</label>
										</div>
									</div>
									<div class="weight">
										<label>Cân nặng</label> <input class="form-control"
											name="weight" id="weight" type="number" min="0" max="5000" id="weight"
											value="${requestScope.animal.weight}" required="required">
									</div>
									<div class="height">
										<label>Chiều cao</label> <input class="form-control" id =""
											name="height" id="height" type="number"  min="0" max="100"
											value="${requestScope.animal.height}" required="required">
									</div>
									<div class="form-group">
										<label>Tình trạng sức khỏe</label> <input class="form-control"
											name="health-status" id="health-status" type="text"
											value="${requestScope.animal.healthStatus}"
											required="required">
									</div>
									<div class="form-group">
										<label for="exampleSelect1" class="">Chuồng</label> <select
											class="form-control" id="cell-select" name="cell-select">
											<c:forEach var="cell" items="${requestScope.cells}">
												<option value="${cell.cellID}">${cell.cellName}</option>
											</c:forEach>
										</select>
									</div>

									<div class="form-group">
										<label>Mô tả</label>
										<textarea class="form-control" name="description" rows="4" required="required">${requestScope.animal.description}</textarea>
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
	<script>
		$("#addAnimalForm").validate();
	</script>
</body>
</html>
