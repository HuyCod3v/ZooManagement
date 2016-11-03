<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/templates/header.jsp" />
<title>Create Employee</title>
</head>
<body>
	<div id="container">
		<div class="row" style="margin-top:20px">
			<div class="col-md-4"></div>
		    <div class="col-md-4">
		      <h2 class="text-center">ZOO MANAGERMENT</h2>
			  <form class="form-horizontal" method="post" action="<c:url value='/login' />" style="margin-top:40px;">
			    <c:if test="${requestScope.message != null}">
					<div class="alert alert-danger">
						${requestScope.message}
					</div>
				</c:if>
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="username">UserName:</label>
			      <div class="col-sm-10">
			        <input type="text" class="form-control" id="username" name="username" placeholder="Enter UserName">
			      </div>
			    </div>
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="pwd">Password:</label>
			      <div class="col-sm-10">
			        <input type="password" class="form-control" id="pwd" name="password" placeholder="Enter Password">
			      </div>
			    </div>
			    <div class="form-group">
			      <div class="col-sm-offset-2 col-sm-10">
			        <button type="submit" class="btn btn-default">Login</button>
			      </div>
			    </div>
			  </form>
		    </div>
		</div>
	</div>
</body>
</html>