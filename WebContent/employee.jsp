<%@page import="dao.UserDAO"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/inc/header.jsp"%>
<title>Quản lý nhân viên</title>
<style>
body {
	width: 400px;
	height: 500px;
	margin: auto;
}

input {
	margin-top: 10px;
}

a {
	text-decoration: none;
	font-style: italic;
	margin-left: 20px;
}

a:hover {
	text-decoration: underline;
}

span {
	margin-left: 10px;
}
</style>
</head>
<body>
	<%
		UserDAO userDAO = new UserDAO();
		User sUser = (User) session.getAttribute("sUser");
		User user = userDAO.getEmployeeByID(sUser.getEmployeeID());
		if (user != null) {
	%>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							jQuery.validator.setDefaults({
								success : "valid"
							});
							$("#frm-changepass")
									.validate(
											{
												ignore : [],
												debug : false,
												rules : {
													employeename : {
														required : true,
														minlength : 10,
													},
													birthday : {
														required : true,
													},
													phone : {
														required : true,
													},
													address : {
														required : true,
														minlength : 20,
													},
												},
												messages : {
													employeename : {
														required : "<span style='color:red;'>Không được bỏ trống</span>",
														minlength : "<span style='color:red;'>Quá ngắn</span>",
													},
													birthday : {
														required : "<span style='color:red;'>Không được bỏ trống</span>",
													},
													phone : {
														required : "<span style='color:red;'>Không được bỏ trống</span>",

													},
													address : {
														required : "<span style='color:red;'>Không được bỏ trống</span>",
														minlength : "<span style='color:red;'>Quá ngắn</span>",
													},
												}
											});
						});
	</script>
	<form action="<%=request.getContextPath()%>/employee-management"
		method="POST">
		<fieldset>
			<legend style='text-align: center;'>Thông tin nhân viên</legend>
			Tên đăng nhập: <span style="font-weight: bold; color: blue;">
				<%=user.getUsername()%></span><br> Quyền quản trị: <span
				style="font-weight: bold; color: blue;"> <%=user.getUserTypeName()%></span>
			<br />
			<div class="form-group">
				<label>Tên nhân viên</label> <input class="form-control" type="text"
					name="employeename" value="<%=user.getEmployeeName()%>">
			</div>
			<div class="form-group">
				<label>Giới tính</label>
				<%
					if (user.getGender() == 1) {
				%>
				<input type="radio" name="gender" checked="checked" value="Nam">Nam
				<input type="radio" name="gender" value="Nữ">Nữ
				<%
					} else {
				%>
				<input type="radio" name="gender" value="Nam">Nam <input
					type="radio" name="gender" checked="checked" value="Nữ">Nữ
				<%
					}
				%>
			</div>
			<div class="form-group">
				<label>Ngày sinh</label> <input class="form-control" type="text"
					name="birthday" value="<%=user.getBirthday()%>">
			</div>
			<div class="form-group">
				<label>Số điện thoại</label> <input class="form-control"
					type="number" name="phone" value="<%=user.getPhone()%>">
			</div>
			<div class="form-group">
				<label>Địa chỉ</label>
				<textarea class="form-control" rows="3" cols="40" name="address"><%=user.getAddress()%></textarea>
				<br />
			</div>
			<input type="submit" name="submit"
				class="btn btn-default btn-primary" value="Cập nhật"> 
			<a href="<%=request.getContextPath()%>/info-user"><input style="font-style: normal;"
				type="button" name="quit" class="btn btn-default btn-primary"
				value="Thoát" /> </a>
		</fieldset>
	</form>
	<%
		}
	%>
</body>
</html>