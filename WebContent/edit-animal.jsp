<%@page import="model.Animal"%>
<%@page import="model.Cell"%>
<%@page import="model.Region"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Species"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/inc/header.jsp"%>
<title>Chỉnh sửa động vật</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/lib/jquery-2.1.1.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/lib/jquery.validate.js"></script>
	<script type="text/javascript">
	$(document).ready(
		function() {
			 
		}
	);
	
	</script>
<style>
body {
	width: 500px;
	margin: auto;
}

.medium {
	width: 350px;
}

</style>
</head>
<body>
	<form method="POST" action=<%=request.getContextPath() + "/UpdateAnimal" %> id="frm-edit-animal">
		<fieldset>
			<legend style="text-align: center;">Chỉnh sửa động vật</legend>
			
			<% 
				Animal animal = (Animal) request.getAttribute("animal");
			%>
			
			<table id="animal-info" style="width: 100%; border: 1px">
				<tr>
					<td><label>Loài</label></td>
					<td><select name="species_id"
						class="form-control medium ">
							<%
								ArrayList<Species> speciesList = (ArrayList<Species>) request.getAttribute("species_list");
								for (Species species : speciesList) {
									if (species.getSpeciesID().equals(animal.getSpeciesID())) {
									
							%>
							<option value=<%=species.getSpeciesID()%> selected><%=species.getSpeciesName()%></option>
							<%
								}
							else {
							%>
								<option value=<%=species.getSpeciesID()%>><%=species.getSpeciesName()%></option>
							<%
							}
								}
							%>
					</select>(*)</td>
				</tr>
				<tr>
					<td><label>Mã động vật</label></td>
					<td><input style="margin-top: 10px;" readonly
						class="form-control medium" type="text" class="form-control" 
					     name="animal_id" value=<%=animal.getAnimalID()%> ></input>(*)</td>
				</tr>
				<tr>
					<td><label>Tên động vật</label></td>
					<td><input class="form-control medium" type="text"
						class="form-control medium" name="animal_name" value=<%=animal.getAnimalName() %>></td>
				</tr>
				<tr>
					<td><label for="gender">Giới tính</label></td>
					<td>
					<%
						if (animal.getGender() == 0) {
					%>
						<input type="radio" name="gender" value="male" checked>
					<%
						}
						else {
					%>	
						<input type="radio" name="gender" value="male">
					<%
						}
					%>
						Con cái 
					<%
						if (animal.getGender() == 1) {
					%>
						<input type="radio" name="gender" value="female" checked>
					<%
						}
						else {
					%>
						<input type="radio" name="gender" value="female">
					<%
						}
					%>
						Con đực
					
					
					</td>
				</tr>
				<tr>
					<td><label for="weight">Cân nặng</label></td>
					<td><input style="margin-top: 10px;"
						class="form-control medium" type="text" name="weight"
						class="form-control" value=<%=animal.getWeight() %>></input></td>
				</tr>
				<tr>
					<td><label for="height">Chiều cao</label></td>
					<td><input style="margin-top: 10px;"
						class="form-control medium" type="text" name="height"
						class="form-control" value=<%=animal.getHeight() %>></input></td>
				</tr>
				<tr>
					<td><label>Sức khỏe</label></td>
					<td><input type="text" class="form-control medium" name="health_status" style="margin-top: 10px;" value=<%=animal.getHealthStatus() %>></td>
				</tr>
				<tr>
					<td><label>Mô tả</label></td>
					<td><textarea class="form-control medium" rows="3"
							cols="30" name="description" style="margin-top: 10px;" value=<%=animal.getDescription() %>></textarea></td>
				</tr>
				<tr>
					<td><label>Mã khu vực</label ></td>
					<td><select style="margin-top: 10px;"
						class="form-control medium" name="region">
							<%
								ArrayList<Region> regionList = (ArrayList<Region>) request.getAttribute("region_list");
								for (Region region : regionList) {
									if (region.getRegionID().equals(animal.getRegionID())) {
								
							%>
							<option value=<%=region.getRegionID()%> selected><%=region.getRegionName() %></option>
							<%
									}
									else {
										%>
								<option value=<%=region.getRegionID()%>"><%=region.getRegionName() %></option>		
							<%
									}
								}
							%>
					</select><span>(*)</span></td>
				</tr>
				<tr>
					<td><label>Mã chuồng</label></td>
					<td><select style="margin-top: 10px;"
						class="form-control medium" name="cell_id">
							<%
							ArrayList<Cell> cellList = (ArrayList<Cell>) request.getAttribute("cell_list");
							for (Cell cell : cellList) {
								if (cell.getCellID().equals(animal.getCellID())) {
						%>
							<option value=<%=cell.getCellID() %> selected><%=cell.getCellID()%></option>

							<%
							}
								else {
									%>
									<option value=<%=cell.getCellID() %>><%=cell.getCellID()%></option>
									<%
								}
								}
						%>
					</select><span>(*)</span></td>
				</tr>
			</table>
			<div class="bt">
				<a href=<%=request.getContextPath() + "/delete_animal?animal_id=" + animal.getAnimalID() %>><input style="margin-top: 10px;" type="button" class="btn btn-default btn-primary" name="delete" value="Xóa động vật"></a> 
				<input style="margin-top: 10px;" type="submit" name="submit" class="btn btn-default btn-primary" name="save" value="Lưu">
				<a href=<%=request.getContextPath() + "/animal-management" %>><input style="margin-top: 10px;" type="button" class="btn btn-default btn-primary" name="cancel" value="Hủy"></a>
			</div>
		</fieldset>
	</form>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							jQuery.validator.setDefaults({
								success : "valid"
							});
							$("#frm-edit-animal")
									.validate(
											{
												ignore : [],
												debug : false,
												rules : {
													animal_id : {
														required : true,
														maxlenght: 10,
													},
													animal_name : {
														required : true,
														maxlenght: 30,
													},
													gender: {
														required: true,
													},
												},
												messages : {
													animal_id : {
														required : "<span style='color:red;'>Vui lòng nhập mã động vật</span>",
														maxlength : "<span style='color:red;'>Mã động vật không thể hơn 10 ký tự</span>",
													},
													animal_name : {
														required : "<span style='color:red;'>Vui lòng nhập tên động vật</span>",
														maxlength : "<span style='color:red;'>Tên động vật không thể hơn 30 ký tự</span>",
													},
													gender: {
														required : "<p style='color:red;'>Vui lòng chọn giới tính</p>",
													}
												}
							});
						});
	</script>
</body>
</html>
