<%@page import="model.Species"%>
<%@page import="model.Cell"%>
<%@page import="model.Region"%>
<%@page import="model.Animal"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <script type="text/javascript" src="<%=request.getContextPath()%>/lib/jquery-2.1.1.min.js" ></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/lib/jquery.validate.js" ></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
  <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/menu-sidebar.css">
  <style>
    table, th, td {
      border: 1px solid black;
      border-collapse: collapse;
    }
    table {
        margin-top: 20px;
        margin-bottom: 20px;
    }
    #form-filter {
        float: left;
    }
    #add-btn {
        float: right;
    }
    li{
    	margin-top: 10px;
    }
  </style>

  <script type="text/javascript">
  	$(document).ready(function() {
  		$('#region_select').on('change', function() {
  			var region_id = this.value;
  			$.ajax({
  				type:'POST',
  				url:'animals_by_region',
  				data:{region_id:region_id},
  				success:function(result) {
  					$('#table_animal').html(result);

  				}

  			});
  		});

  		$('#cell_select').on('change', function() {
  			var cell_id = this.value;
  			$.ajax({
  				type:'POST',
  				url:'animals_by_cell',
  				data:{cell_id:cell_id},
  				success:function(result) {
  					$('#table_animal').html(result);

  				}

  			});
  		});

  		$('#species_select').on('change', function() {
  			var species_id = this.value;
  			$.ajax({
  				type:'POST',
  				url:'animals_by_species',
  				data:{species_id:species_id},
  				success:function(result) {
  					$('#table_animal').html(result);

  				}

  			});
  		});

  		$('#id_animal_search').click(function() {
  			var animal_id = $('#animal_id_txt').val();
  			$.ajax({
  				type:'POST',
  				url:'animals_by_id',
  				data:{animal_id:animal_id},
  				success:function(result) {
  					$('#table_animal').html(result);

  				}

  			});
  		});

  	});
  </script>
  <title>Quản lý động vật</title>
</head>
<body>
    <%
		String key_search = (String) request.getAttribute("key_search");

	%>
  <div class="container">
    <jsp:include page= "/inc/head-navi-bar.jsp" />
    <jsp:include page= "/inc/menu-sidebar.jsp" />
    <div id="animal-filter" class="col-md-8">
      <div id="filter">
        <div id="form-filter">
        <form class="form-inline" role="form" action=<%=request.getContextPath() + "/search" %> method="post">
            <div class="from-group">
                <select name="region" id="region_select" class="form-control">
                <%
                	ArrayList<Region> regionList = (ArrayList<Region>) request.getAttribute("region_list");
                	for (Region region : regionList) {

                %>
                	<option value=<%=region.getRegionID() %>><%=region.getRegionName() %></option>
                <%
                	}
                %>
                </select>
                <select name="cell" id="cell_select" class="form-control">
                  	<%
                	ArrayList<Cell> cellList = (ArrayList<Cell>) request.getAttribute("cell_list");
                	for (Cell cell : cellList) {

               		 %>
                	<option value=<%=cell.getCellID() %>><%=cell.getCellID() %></option>
                	<%
                	}
                	%>
                </select>
                <select name="species" id="species_select" class="form-control">
					<%
                	ArrayList<Species> speciesList = (ArrayList<Species>) request.getAttribute("species_list");
                	for (Species species : speciesList) {

               		 %>
                	<option value=<%=species.getSpeciesID() %>><%=species.getSpeciesName() %></option>
                	<%
                	}
                	%>
                </select>
                <input type="text" name="animal_id" id="animal_id_txt" class="form-control">
                <span class="btn btn-info glyphicon glyphicon-search" id="id_animal_search"></span>
            </div>
        </form>
        </div>
        <div id="add-btn">
        	<a href=<%=request.getContextPath() + "/add-animal" %>>
        		<span class="btn btn-info glyphicon glyphicon glyphicon-plus" name="add" onClick=""></span>
        	</a>
        </div>
      </div>
      <br>
      <div id="table_animal">
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
        	if(animalList.size()>0){
        	for (Animal animal : animalList) {
        %>
        <tr>
          <td><%=animal.getAnimalID()%></td>
          <td><%=animal.getAnimalName()%></td>
          <td><%=animal.getSpecies().getSpeciesName()%></td>
          <td><%=animal.getRegionID()%></td>
          <td><%=animal.getCellID()%></td>
          <td><%=animal.getHealthStatus()%></td>
          <td><a href=<%=request.getContextPath() + "/UpdateAnimal?animal_id=" + animal.getAnimalID() %>><button class="btn btn-info glyphicon glyphicon-edit"></button></a></td>
        </tr>
        <%
        	}}else{
        %>
        	<tr>
        		<td colspan="7" style="text-align: center; color:red;">Không tìm thấy động vật nào thỏa mãn điều kiện trên</td>
        	</tr>
        <%} %>
      </table>
       </div>
    </div>
  </div>
</body>
</html>
