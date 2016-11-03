<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<jsp:include page="/templates/header.jsp" />
<title>Quản lý chuồng thú</title>
</head>
<body>

	<div id="wrapper">
		<jsp:include page="/templates/menu-sidebar.jsp" />

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">Quản lý chuồng</h3>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">

						<c:choose>
							<c:when test="${requestScope.msgUpdate ==1}">
								<div class="alert alert-success">
									<strong>Success!</strong> Bạn đã cập nhật thành công chuồng
									thú.
								</div>
							</c:when>
							<c:when test="${requestScope.msgAdd ==1}">
								<div class="alert alert-success">
									<strong>Success!</strong> Bạn đã tạo mới thành công chuồng thú.
								</div>
							</c:when>
							<c:when test="${requestScope.msgDel ==1}">
								<div class="alert alert-success">
									<strong>Success!</strong> Bạn đã xóa thành công chuồng thú.
								</div>
							</c:when>
						</c:choose>
						<div class="panel-heading">
							<div class="input-group">
								Danh sách các chuồng thú
								<div class="input-group-btn">
									<div class="col-lg-1">
										<a class="btn btn-success btn-circle"
											href='<c:url value="/cell-add-view"/>'> <i
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
										<th>Mã chuồng</th>
										<th>Tên chuồng</th>
										<th>Khu vực</th>
										<th>Loài</th>
										<th>Số lượng tối đa</th>
										<th>Trạng thái</th>
										<th>Mô tả</th>
										<th>Tùy chọn</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach var="cell" items="${requestScope.cells}">
										<tr>
											<td>${cell.cellID}</td>
											<td>${cell.cellName}</td>
											<td>${cell.region.regionName}</td>
											<td>${cell.species.speciesName}</td>
											<td>${cell.capacity}</td>
											<td>${cell.cellStatus.cellStatusName}</td>
											<td>${cell.description}</td>
											<td align="center"><a class="btn btn-info btn-circle"
												href='${pageContext.request.contextPath}/cell-edit?id=${cell.cellID}'>
													<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
											</a>
												<button type="button" id="delete-cell-action"
													class="btn btn-danger btn-circle"
													data-cell-id="${cell.cellID}" data-toggle="modal"
													data-target="#delete-cell-modal">
													<i class="fa fa-trash" aria-hidden="true"></i>
												</button></td>
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

	<div class="modal fade" id="delete-cell-modal" role="dialog">
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
							Bạn có muốn xóa chuồng<label id="cell-id"></label> không ?
						</div>
					</form>
				</div>

				<div class="modal-footer">
					<form method="get" role="form"
						action='<c:url value="/cell-del"/>'>
						<input type="hidden" name="cellID" id="cell-id-submit"/>
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
		$(document).on("click", "#delete-cell-action", function() {
			var cellId = $(this).data('cell-id');
			$(".modal-body #cell-id").html(cellId);
			 $("#cell-id-submit").val(cellId);	
		});
	</script>
</body>
</html>
