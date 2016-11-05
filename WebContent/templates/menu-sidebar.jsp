<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-default navbar-static-top" role="navigation"
	style="margin-bottom: 0">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href='<c:url value="employee"/>'>QUẢN LÝ SỞ THÚ</a>
	</div>
	<!-- /.navbar-header -->

	<ul class="nav navbar-top-links navbar-right">
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#"> <i class="fa fa-envelope fa-fw"></i>
				<i class="fa fa-caret-down"></i>
		</a> <!-- /.dropdown -->
			<ul class="dropdown-menu dropdown-user">
				<li><a href=""><i class="fa fa-user fa-fw"></i> User
						Profile</a></li>
				<li><a href="<c:url value='/settings'/>"><i
						class="fa fa-gear fa-fw"></i> Settings</a></li>
				<li class="divider"></li>
				<li><a href="<c:url value='/logout'/>"><i
						class="fa fa-sign-out fa-fw"></i> Logout</a></li>
			</ul> <!-- /.dropdown-user --></li>
		<!-- /.dropdown -->
	</ul>
	<!-- /.navbar-top-links -->

	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">			
				<li><a href="<c:url value='/notification'/>" ><i class="fa fa-dashboard fa-fw"></i>
						Thông báo</a></li>
				<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>
						Quản lý khu vực<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href='<c:url value="/regions"/>'>Khu vực</a></li>
						<li><a href="<c:url value="/cells"/>">Chuồng thú</a></li>
					</ul> <!-- /.nav-second-level --></li>
					
					<li><a href="#"><i class="fa fa-wrench fa-fw"></i> Quản lý động vật<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="panels-wells.html">Động vật</a></li>
						<li><a href='<c:url value="/species"/>'>Loài</a></li>
					</ul> <!-- /.nav-second-level --></li>
				<li><a href="tables.html"><i class="fa fa-table fa-fw"></i>
						Công việc của tôi</a></li>
				<li><a href="/ZooManagement/employee"><i class="fa fa-user fa-fw"></i> Quản lý công việc<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href='<c:url value="/job/"/>'>Công Việc</a></li>
					</ul>
				</li>
				
				
				<li><a href="/ZooManagement/employee"><i class="fa fa-user fa-fw"></i> Quản lý nhân viên<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="<c:url value='/employee'/>">Nhân Viên</a></li>
						<li><a href="<c:url value='manager'/>">Tài Khoản</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side -->
</nav>
