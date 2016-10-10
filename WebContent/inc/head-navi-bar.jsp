<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="head-navi-bar">
    <h1>
        <a href="<%= request.getContextPath() %>">Trang chủ</a>
        <% 
        String uri = request.getRequestURI();
//        out.print(uri + "<br>");
        String[] paths = uri.split("/");
        if (paths.length > 2) {
            if (paths[2].contains("add-animal"))
                out.print("> <a href=\"" + request.getContextPath() + "/animal-management\">Quản lý động vật</a> > Thêm động vật");
            else if (paths[2].contains("update-animal"))
                out.print("> <a href=\"" + request.getContextPath() + "/animal-management\">Quản lý động vật</a> > Cập nhật động vật");
            else if (paths[2].contains("qldv-main"))
                out.print("> Quản lý động vật");
        } %>
    </h1>
</div>
