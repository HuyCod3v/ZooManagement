<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-sidebar" class="col-md-3">
    <ul>
        <li><a href="#">Quản lý động vật</a>
            <ul>
                <li><a href="#">Khu vực</a></li>
                <li><a href="#">Chuồng</a></li>
                <li><a href=<%=request.getContextPath() + "/animal-management"%>>Động vật</a></li>
            </ul>
        </li>
        <li><a href="<%=request.getContextPath()%>/info-user">Quản lý nhân viên</a>
        </li>
        <li><a href="#">Quản lý thức ăn</a>
        </li>
        <li><a href="#">Quản lý vé</a></li>
    </ul>
</div>
