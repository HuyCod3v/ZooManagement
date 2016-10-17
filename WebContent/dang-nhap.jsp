<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
	<%@include file="/templates/header.jsp" %>
  <title>Đăng nhập</title>
  <style type="text/css">
  body{
    width: 400px;
    margin: 20px auto;
  }
  input{
  	margin-top: 10px;
  }
  </style>
</head>
<body>
  <h3 style="text-align: center;">CHƯƠNG TRÌNH QUẢN LÝ SỞ THÚ</h3>
   <script type="text/javascript">
			$(document).ready(function(){
				jQuery.validator.setDefaults({
					  success: "valid"
				});
				$("#frm-login").validate({
					ignore : [],
					debug : false,
					rules: {
						username: {
							required: true,
							maxlength: 30,
							minlength: 6,
						},
						
						password: {
							required: true,
							maxlength: 30,
							minlength: 6,
						},
					},
					messages: {
						username: {
							required: "<span style='color:red;'>Bạn chưa nhập tên đăng nhập</span>",
							maxlength: "<span style='color:red;'>Tên đăng nhập không được quá 30 ký tự</span>",
							minlength: "<span style='color:red;'>Tên đăng nhập tối thiểu là 6 ký tự</span>",
						},
						password: {
							required: "<p style='color:red;'>Bạn chưa nhập mật khẩu</p>",
							maxlength: "<span style='color:red;'>Mật khẩu không được quá 30 ký tự</span>",
							minlength: "<span style='color:red;'>Mật khẩu tối thiểu là 6 ký tự</span>",
						},
					}
				});
			});
			</script>
  <form method="POST" action="<%=request.getContextPath()%>/checklogin" id="frm-login">
  <legend style="text-align: center;">Thông tin đăng nhập</legend>
    <label for="input_username" class="sr-only">Username</label>
        <input style="margin-top: 10px;" type="text" id="input_username" class="form-control" placeholder="Username" name="username" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input style="margin-bottom: 10px;" type="password" id="inputPassword" class="form-control" placeholder="Password" name = "password" required>
   <br>
    <a href="#">Quên mật khẩu</a><br>
    <button style="margin-top: 10px;" class="btn btn-lg btn-primary btn-block" type="submit" name="submit">Đăng nhập</button>
    <%
			String mgs = request.getParameter("msg");
			if("0".equals(mgs)){
		%>
		<p style="color:red;font-weight: bold;margin-top: 10px;">Sai username hoặc password</p>
		<%}%>
  </form>
</body>
</html>