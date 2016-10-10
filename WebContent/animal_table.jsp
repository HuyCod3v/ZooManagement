<%@page import="model.Animal"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<table id="animal-info" class="table table-striped table-responsive" style="width: 100%">
	<tr>
		<th>Mã ĐV</th>
		<th>Tên động vật</th>
		<th>Loài</th>
		<th>Khu vực</th>
		<th>Chuồng</th>
		<th>Sức khỏe</th>
		<th></th>
	</tr>
	<%
		ArrayList<Animal> animalList = (ArrayList<Animal>) request.getAttribute("animal_list");
		for (Animal animal : animalList) {
	%>
	<tr>
		<td><%=animal.getAnimalID()%></td>
		<td><%=animal.getAnimalName()%></td>
		<td><%=animal.getSpecies().getSpeciesName()%></td>
		<td><%=animal.getRegionID()%></td>
		<td><%=animal.getCellID()%></td>
		<td><%=animal.getHealthStatus()%></td>
		<td><a href=<%=request.getContextPath() + "/update_animal?animal_id=" + animal.getAnimalID() %>><button class="btn btn-info">Cập nhật</button></a></td>
	</tr>
	<%
        }
    %>
</table>