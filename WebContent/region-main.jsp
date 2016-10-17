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
                            Danh sách các khu vực
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
                                    </tr>
                                </thead>
                                <tbody>
	                                                                     
	                                
                                <c:forEach var="region" items="${requestScope.regions}">
	                                        <td>${region.regionID}</td>
	                                        <td>${region.regionName}</td>
	                                        <td>${region.regionArea}</td>
	                                        <td>${region.description}</td>
	                                        <td>${region.regionStatus.regionStatusName}</td>
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
	<jsp:include page="/templates/footer.jsp" />
</body>
</html>
