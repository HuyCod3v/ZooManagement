<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<jsp:include page="/templates/header.jsp" />
<title>Thêm loài</title>
</head>
<body>

	<div id="wrapper">
		<jsp:include page="/templates/menu-sidebar.jsp" />

		<div id="page-wrapper">
			<div class="row">
                <div class="col-lg-12">
                    <h3 class="page-header">Quản lý loài</h1>
                </div>
            </div>
            <div class="row">
            	<div class="col-lg-12">
            		<div class="panel panel-default">
            			<div class="panel-heading">
            				<div>Thêm loài</div>
            				<c:if test="${requestScope.error != null }">
            					<div class="red-text"><c:out value="${requestScope.error }" /></div>
            				</c:if>        			
            			</div>
            			
            			<div class="panel-body">
            				<div class="col-lg-9">
            					<form role="form" id="addSpeciesForm" method="post" action='<c:url value="/species-handle-add"/>'>
            							<div class="form-group">
                                            <label for="speciesID">Mã loài (*)</label>
                                            <input id="speciesID" class="form-control" name="speciesID" maxlength="10" required>                                      
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="speciesName">Tên loài (*)</label>
                                            <input id="speciesName" class="form-control" name="speciesName" maxlength="30" required>                                      
                                        </div>	
                                                                                                                  
                                        <div class="form-group">
                                            <label for="description">Mô tả</label>
                                            <textarea id="description" class="form-control" rows="3" name="description" maxlength="1000"></textarea>
                                        </div>			         							
            							                                       
                                        <button type="submit" class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i>   Lưu</button>
                                        <button type="reset" class="btn btn-info"><i class="fa fa-eraser" aria-hidden="true"></i>   Xóa hết</button>
                                        <a class="btn btn-danger" href='<c:url value="/species"/>'"><i class="fa fa-ban" aria-hidden="true"></i>   Hủy</a>
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
		$("#addSpeciesForm").validate();
	</script>

</body>
</html>
