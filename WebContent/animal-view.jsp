<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<jsp:include page="/templates/header.jsp" />
<title>Thông tin thú</title>
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
						<div class="panel-heading">Thông tin thú</div>

						<div class="panel-body">
							<div class="col-lg-9">
								<form
									action=""
									method="post">
									<div class="form-group">
										<label>Mã Thú</label> <input class="form-control"
											name="id-animal" id="id-animal"
											value="${requestScope.animal.animalID}" disabled="disabled"
											required="required">
									</div>

									<div class="form-group">
										<label>Tên Thú</label> <input class="form-control"
											name="name-animal" id="name-animal"
											value="${requestScope.animal.animalName}" disabled="disabled" required="required">
									</div>
									<div class="form-group">
										<label for="exampleSelect1" class="">Loài</label> <select disabled="disabled"
											class="form-control" id="species-select"
											name="species-select">
											<c:forEach var="species" items="${requestScope.species}">
												<c:choose>
													<c:when
														test="${species.speciesID == requestScope.animal.speciesID }">
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
										<label>Giới tính</label>
										<c:choose>
											<c:when test="${requestScope.animal.gender==1 }">
												<div class="radio">
													<label> <input type="radio" name="gender-animal" disabled="disabled"
														id="optionsRadios1" value="1" checked>Đực
													</label>
												</div>
												<div class="radio">
													<label> <input type="radio" name="gender-animal" disabled="disabled"
														id="optionsRadios2" value="0">Cái
													</label>
												</div>
											</c:when>
											<c:otherwise>
												<div class="radio">
													<label> <input type="radio" name="gender-animal" disabled="disabled"
														id="optionsRadios1" value="1">Đực
													</label>
												</div>
												<div class="radio">
													<label> <input type="radio" name="gender-animal" disabled="disabled"
														id="optionsRadios2" value="0" checked="checked">Cái
													</label>
												</div>
											</c:otherwise>
										</c:choose>
										</div>
									<div class="form-group">
										<label>Cân nặng</label> <input class="form-control"
											name="weight" id="weight" type="number" disabled="disabled"
											value="${requestScope.animal.weight}" required="required">
									</div>
									<div class="form-group">
										<label>Chiều cao</label> <input class="form-control"
											name="height" id="height" type="number" disabled="disabled"
											value="${requestScope.animal.height}" required="required">
									</div>
									<div class="form-group">
										<label>Tình trạng sức khỏe</label> <input class="form-control"
											name="health-status" id="health-status" type="text" disabled="disabled"
											value="${requestScope.animal.healthStatus}"
											required="required">
									</div>
									<div class="form-group">
										<label for="exampleSelect1" class="">Chuồng</label> <select disabled="disabled"
											class="form-control" id="cell-select" name="cell-select">
											<c:forEach var="cell" items="${requestScope.cells}">
												<c:choose>
													<c:when
														test="${cell.cellID == requestScope.animal.cellID }">
														<option value="${cell.cellID}" selected="selected">${cell.cellName}</option>
													</c:when>
													<c:otherwise>
														<option value="${cell.cellID}">${cell.cellName}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select>
									</div>

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
