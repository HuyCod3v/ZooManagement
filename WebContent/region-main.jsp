<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<jsp:include page="/templates/header.jsp" />
<title>Quản lý khu vực</title>
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
                        	<div class="row">
                        		<div class="col-lg-11">                      	
	                    			Danh sách các khu vực
	                    		</div>
	                    		<div class="col-lg-1">
	                    			<a class="btn btn-success btn-circle" href='<c:url value="/regions-add"/>'>
	                                        		<i class="fa fa-plus" aria-hidden="true"></i>
                           						 </a>
	                    		</div>    
                        	</div>
                        	                    
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>Mã khu vực</th>
                                        <th>Tên khu vực</th>
                                        <th>Diện tích khu vực</th>
                                        <th>Mô tả</th>
                                        <th>Tình trạng khu vực</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
	                                                                     
	                                
                                <c:forEach var="region" items="${requestScope.regions}">
	                                        <td>${region.regionID}</td>
	                                        <td>${region.regionName}</td>
	                                        <td>${region.regionArea}</td>
	                                        <td>${region.description}</td>
	                                        <td>${region.regionStatus.regionStatusName}</td>
	                                        <td>
	                                        	<a class="btn btn-info btn-circle" href='<c:url value="/regions-edit?id=${region.regionID }"/>'>
	                                        		<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                           						 </a>
	                                        	
	                                        	<button type="button" id="delete-region-action" class="btn btn-danger btn-circle" data-region-id="${region.regionID}" data-toggle="modal" data-target="#delete-region-modal">
	                                        		<i class="fa fa-trash" aria-hidden="true"></i>
                           						 </button>
	                                        </td>
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
	
	<div class="modal fade" id="delete-region-modal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">    
	      <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <div>Xác nhận</div>
	        </div>   
        <div class="modal-body" style="padding:10px 10px;">
          <form role="form">
          	  <div>Bạn có muốn xóa khu vực <label id="region-id"></label> không ?</div>                                         
          </form>
        </div>     
        
        <div class="modal-footer">
        
        	<form method="get" role="form" action='<c:url value="/regions-handle-delete"/>'>
        		<input type="hidden" name="regionID" id="region-id-submit"/>
        		<button type="submit" class="btn btn-info btn-default pull-left" data-dismiss="modal"><span class="fa fa-check"></span> Có</button>
          		<button type="button" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="fa fa-ban"></span> Không</button>
        	</form>
        
        	    
        </div>
      </div>
      
    </div>
  </div>
  
  
	<jsp:include page="/templates/footer.jsp" />
	
	<script type="text/javascript">
		$(document).on("click", "#delete-region-action", function () {
		     var regionId = $(this).data('region-id');
		     $(".modal-body #region-id").html(regionId);
		     $("#region-id-submit").val(regionId);		
		});
	</script>
</body>
</html>
