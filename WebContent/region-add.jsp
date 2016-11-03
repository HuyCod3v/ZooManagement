<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<jsp:include page="/templates/header.jsp" />
<title>Thêm khu vực</title>
</head>
<body>

	<div id="wrapper">
		<jsp:include page="/templates/menu-sidebar.jsp" />

		<div id="page-wrapper">
			<div class="row">
                <div class="col-lg-12">
                    <h3 class="page-header">Quản lý khu vực</h1>
                </div>
            </div>
            <div class="row">
            	<div class="col-lg-12">
            		<div class="panel panel-default">
            			<div class="panel-heading">
            				<div>Thêm khu vực </div>
            				<c:if test="${requestScope.error != null }">
            					<div class="red-text"><c:out value="${requestScope.error }" /></div>
            				</c:if>        			
            			</div>
            			
            			<div class="panel-body">
            				<div class="col-lg-9">
            					<form role="form" id="addRegionForm" method="post" action='<c:url value="/regions-handle-add"/>'>
            							<div class="form-group">
                                            <label for="regionID">Mã khu vực (*)</label>
                                            <input id="regionID" class="form-control" name="regionID" maxlength="10" required>                                      
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="regionName">Tên khu vực (*)</label>
                                            <input id="regionName" class="form-control" name="regionName" maxlength="30" required>                                      
                                        </div>	
                                        
                                        <div class="form-group">
                                            <label for="regionArea">Diện tích (mét vuông)</label>
                                            <input id="regionArea" class="form-control" name="regionArea" type="number" min="0" max="65535">                                      
                                        </div>	
                                        
                                        <div class="form-group">
                                            <label for="description">Mô tả</label>
                                            <textarea id="description" class="form-control" rows="3" name="description" maxlength="1000"></textarea>
                                        </div>			
            							
            							<div class="form-group">
                                            <label>Tình trạng khu vực</label>
                                            <c:forEach  var="status" items="${requestScope.statusList}">                                                     
                                            	<div class="radio" class="form-control">                                        		
	                                                <input type="radio" name="regionStatusID" checked value="${status.regionStatusID }">${status.regionStatusName}
	                                            </div>
                                            
                                            </c:forEach>
                                        </div>
                                        
                                        <button type="submit" class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i>   Lưu</button>
                                        <button type="reset" class="btn btn-info"><i class="fa fa-eraser" aria-hidden="true"></i>   Xóa hết</button>
                                        <a class="btn btn-danger" href='<c:url value="/regions"/>'"><i class="fa fa-ban" aria-hidden="true"></i>   Hủy</a>
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
		$("#addRegionForm").validate();
	</script>

</body>
</html>
