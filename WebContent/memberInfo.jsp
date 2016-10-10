<%@page import="dao.UserDAO"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/inc/header.jsp" %>
<title>Thông tin cá nhân</title>
<style>
	table{
	margin-left: 300px;
	}
</style>
</head>
<body >

	 <div id="head-navi-bar">

      <div style="margin-left: 30px;"><h3>TRANG CHỦ > QUẢN LÝ ĐỘNG VẬT > ĐỘNG VẬT</h3></div>
      <div>

      </div>
    </div>
    <div id="navitication" class="col-md-3">
      <ul>
        <li><a href="#">Quản lý động vật</a>
          <ul>
            <li><a href="#">Khu vực</a></li>
            <li><a href="#">Chuồng</a></li>
            <li><a href=<%=request.getContextPath() + "/animal-management" %>>Động vật</a></li>
          </ul>
        </li>
        <li><a href="<%=request.getContextPath()%>/info-user">Quản lý nhân viên</a>
        </li>
        <li><a href="#">Quản lý thức ăn</a>
        </li>
        <li><a href="#">Quản lý vé</a></li>
      </ul>
    </div>



	<%
		User sUser =(User) session.getAttribute("sUser");
		UserDAO userDAO = new UserDAO();
		User u = userDAO.getEmployeeByID(sUser.getEmployeeID());
	%>
	<div class="col-md-7" >
	<label style="margin-left: 1px; margin-top: 20px; font-size: 20px;">Thông tin nhân viên</label>
	<table style="margin-left: 1px;" class="table table-bordered">
		<tr>
			<td>Tên đăng nhập</td>
			<td><%=sUser.getUsername() %></td>
		</tr>
		<tr>
			<td>Mã nhân viên</td>
			<td><%=u.getEmployeeID() %></td>
		</tr>
		<tr>
			<td>Tên nhân viên</td>
			<td><%=u.getEmployeeName() %></td>
		</tr>
		<tr>
			<td>Giới tính</td>
			<%if(u.getGender()==1){%>
				<td>Nam</td>	
			<%}else if(u.getGender()==0){%>
				<td>Nữ</td>
			<%} %>
		</tr>
		<tr>
			<td>Ngày sinh</td>
			<td><%=u.getBirthday() %></td>
		</tr>
		<tr>
			<td>Số điện thoại</td>
			<td><%=u.getPhone() %></td>
		</tr>
		<tr>
			<td>Địa chỉ</td>
			<td><%=u.getAddress() %></td>
		</tr>
	</table>
	<div style="margin-left: 300px;">
		<a href="<%=request.getContextPath()%>/employee-management"><input type="button" value="Chỉnh sửa" name="submit" class="btn btn-default btn-primary"/></a>
		<a href="<%=request.getContextPath()%>/info-user"><input style="font-style: normal;"
				type="button" name="quit" class="btn btn-default btn-primary"
				value="Thoát" /> </a><br/>
		<span><a  style="margin-top: 10px;" href="<%=request.getContextPath()%>/change-pass">Thay đổi mật khấu ?</a></span>
	</div>
	</div>
</body>
</html>