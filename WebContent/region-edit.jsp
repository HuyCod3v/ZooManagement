<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<jsp:include page="/templates/header.jsp" />
<title>Cập nhật khu vực</title>
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
            				Cập nhật khu vực     			
            			</div>
            			
            			<div class="panel-body">
            				<div class="col-lg-9">
            					<form role="form">
            							<div class="form-group">
                                            <label>Mã khu vực</label>
                                            <input class="form-control" disabled value="${region.regionID }">                                      
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Tên khu vực</label>
                                            <input class="form-control" value="${region.regionName }">                                      
                                        </div>	
                                        
                                        <div class="form-group">
                                            <label>Diện tích</label>
                                            <input class="form-control" value="${region.regionArea }">                                      
                                        </div>	
                                        
                                        <div class="form-group">
                                            <label>Mô tả</label>
                                            <textarea class="form-control" rows="3" >${region.description }</textarea>
                                        </div>			
            							
            							<div class="form-group">
                                            <label>Tình trạng khu vực</label>
                                            
                                            <c:forEach var="status" items="${requestScope.statusList}">
                                            	<div class="radio">                                        		
	                                                <label>
	                                                    <input type="radio" name="regionStatusID" value="${status.regionStatusID }">${status.regionStatusName}
	                                                </label>
	                                            </div>
                                            
                                            </c:forEach>
                                                                                                                                                                         
                                        </div>
                                        
                                        <button type="submit" class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i>   Lưu</button>
                                        <button type="reset" class="btn btn-info"><i class="fa fa-eraser" aria-hidden="true"></i>   Xóa hết</button>
                                        <button type="reset" class="btn btn-danger"><i class="fa fa-ban" aria-hidden="true"></i>   Hủy</button>
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
