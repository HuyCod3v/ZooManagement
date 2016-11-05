<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<jsp:include page="/templates/header.jsp" />
<title>Quản lý thú</title>
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
							<c:when test="${requestScope.msgUpdate ==1}">
								<div class="alert alert-success">
									<strong>Success!</strong> Bạn đã cập nhật thành công thú.
								</div>
							</c:when>
							<c:when test="${requestScope.msgAdd ==1}">
								<div class="alert alert-success">
									<strong>Success!</strong> Bạn đã tạo mới thành công thú.
								</div>
							</c:when>
							<c:when test="${requestScope.msgDel ==1}">
								<div class="alert alert-success">
									<strong>Success!</strong> Bạn đã xóa thành công thú.
								</div>
							</c:when>
						</c:choose>
						<div class="panel-heading">
							<div class="input-group">
								Danh sách các thú
								<div class="input-group-btn">
									<div class="col-lg-1">
										<a class="btn btn-success btn-circle"
											href='<c:url value="/animal-add-view"/>'> <i
											class="fa fa-plus" aria-hidden="true"></i>
										</a>
									</div>
								</div>
							</div>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Mã thú</th>
										<th>Tên thú</th>
										<th>Loài</th>
										<th>Giới tính</th>
										<th>Cân nặng</th>
										<th>Chiều cao</th>
										<th>Tình trạng sức khỏe</th>
										<th>Tên chuồng</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach var="animal" items="${requestScope.animals}">
										<tr>
											<td>${animal.animalID}</td>
											<td>${animal.animalName}</td>
											<td>${animal.species.speciesName }</td>
											<td>${animal.gender ==1? "Đực": "Cái" }</td>
											<td>${animal.weight}</td>
											<td>${animal.height}</td>
											<td>${animal.healthStatus}</td>
											<td>${animal.cell.cellName}</td>
											<td align="center"><a class="btn btn-info btn-circle"
												href='${pageContext.request.contextPath}/animal-edit?id=${animal.animalID}'>
													<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
											</a>
												<button type="button" id="delete-animal-action"
													class="btn btn-danger btn-circle"
													data-animal-id="${animal.animalID}" data-toggle="modal"
													data-target="#delete-animal-modal">
													<i class="fa fa-trash" aria-hidden="true"></i>
												</button> <a class="btn btn-primary btn-circle"
												href='${pageContext.request.contextPath}/animal-view?id=${animal.animalID}'>
													<i class="fa fa-eye" aria-hidden="true"></i>
											</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="delete-animal-modal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<div>Xác nhận</div>
				</div>
				<div class="modal-body" style="padding: 10px 10px;">
					<form role="form">
						<div>
							Bạn có muốn xóa thú &nbsp;<label id="animal-id"></label>
							&nbsp;không ?
						</div>
					</form>
				</div>

				<div class="modal-footer">
					<form method="get" role="form"
						action='<c:url value="/animal-del"/>'>
						<input type="hidden" name="animalID" id="animal-id-submit" />
						<button type="submit" class="btn btn-info btn-default pull-left">
							<span class="fa fa-check"></span> Có
						</button>
						<button type="submit" class="btn btn-danger btn-default pull-left"
							data-dismiss="modal">
							<span class="fa fa-ban"></span> Không
						</button>
					</form>
				</div>
			</div>

		</div>
	</div>

	<jsp:include page="/templates/footer.jsp" />
	<script type="text/javascript">
		$(document).on("click", "#delete-animal-action", function() {
			var animalId = $(this).data('animal-id');
			$(".modal-body #animal-id").html(animalId);
			$("#animal-id-submit").val(animalId);
		});
	</script>
</body>
</html>
