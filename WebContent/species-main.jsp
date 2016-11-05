<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<jsp:include page="/templates/header.jsp" />
<title>Quản lý loài</title>
</head>
<body>

	<div id="wrapper">
		<jsp:include page="/templates/menu-sidebar.jsp" />
		
		<div id="page-wrapper">
			<div class="row">
                <div class="col-lg-12">
                    <h3 class="page-header">Quản lý loài</h3>
                    <c:if test="${requestScope.error != null}">
                    	<div class="red-text"><c:out value="${requestScope.error }"/></div>
                    </c:if>
                    
                    <c:if test="${requestScope.success != null}">
                    	<div class="green-text"><c:out value="${requestScope.success }"/></div>
                    </c:if>
                </div>
            </div>
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                    	
                        <div class="panel-heading">
                        	<div class="row">
                        		<div class="col-lg-11">                      	
	                    			Danh sách các loài
	                    		</div>
	                    		<div class="col-lg-1">
	                    			<a class="btn btn-success btn-circle" href='<c:url value="/species-add"/>'>
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
                                        <th>Mã loài</th>
                                        <th>Tên loài</th>
                                        <th>Mô tả</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
	                                                                     
	                                
                                <c:forEach var="theSpecies" items="${requestScope.species}">
	                                        <td>${theSpecies.speciesID}</td>
	                                        <td>${theSpecies.speciesName}</td>
	                                        <td>${theSpecies.description}</td>
	                                        <td>
	                                        	<a class="btn btn-info btn-circle" href='<c:url value="/species-edit?id=${theSpecies.speciesID }"/>'>
	                                        		<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                           						 </a>
	                                        	
	                                        	<button type="button" id="delete-species-action" class="btn btn-danger btn-circle" data-species-id="${theSpecies.speciesID}" data-toggle="modal" data-target="#delete-species-modal">
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
	
	<div class="modal fade" id="delete-species-modal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">    
	      <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <div>Xác nhận</div>
	        </div>   
        <div class="modal-body" style="padding:10px 10px;">
          <form role="form">
          	  <div>Bạn có muốn xóa khu vực <label id="species-id"></label> không ?</div>                                         
          </form>
        </div>     
        
        <div class="modal-footer">
        
        	<form method="get" role="form" action='<c:url value="/species-handle-delete"/>'>
        		<input type="hidden" name="speciesID" id="species-id-submit"/>
        		<button type="submit" class="btn btn-info btn-default pull-left"><span class="fa fa-check"></span> Có</button>
          		<button type="button" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="fa fa-ban"></span> Không</button>
        	</form>
        
        	    
        </div>
      </div>
      
    </div>
  </div>
  
  
	<jsp:include page="/templates/footer.jsp" />
	
	<script type="text/javascript">
		$(document).on("click", "#delete-species-action", function () {
		     var speciesID = $(this).data('species-id');
		     $(".modal-body #species-id").html(speciesID);
		     $("#species-id-submit").val(speciesID);		
		});
	</script>
</body>
</html>
