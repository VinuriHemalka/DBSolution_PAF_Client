<%@page import="model.ResearchProject"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>GBSolutions_ResearchProject</title>
		
		<link href="myStyle.css" rel="stylesheet" />
		<link rel="stylesheet" href="Views/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="Components/jquery-3.5.0.min.js"></script>
		<script src="Components/ResearchProject.js"></script>
</head>
<body>
<div class="container">
	
			<p class="font-weight-bold">
				<center>
					<h1><u><i><b>Research Project Management</b></i></u></h1>
				</center>
			</p>
			<br><br>
			
			<fieldset>
	
				<legend><b>Add Research Project Details</b></legend>
					<form id="RESEARCHPROJECT" name="RESEARCHPROJECT" class="border border-light p-5">
						
						<div class="form-outline mb-4">
						    <label class="form-label" for="form6Example3" class="col-sm-2 col-form-label col-form-label-sm">Project Name</label>
						    <input type="hidden" id="project_ID" name="project_ID">
						    <input type="text" id="project_Name" class="form-control" name="project_Name">						    
						</div>
						
						<div class="form-outline mb-4">
						    <label class="form-label" for="form6Example3" class="col-sm-2 col-form-label col-form-label-sm">Project Cost</label>
						    <input type="text" id="cost" class="form-control" name="cost">						    
						</div>
						
						<div class="form-outline mb-4">
						    <label class="form-label" for="form6Example3" class="col-sm-2 col-form-label col-form-label-sm">Category</label>
						    <input type="text" id="project_Category" class="form-control" name="project_Category">						    
						</div>
						
						<div class="form-outline mb-4">
						    <label class="form-label" for="form6Example3" class="col-sm-2 col-form-label col-form-label-sm">Description</label>
						    <input type="text" id="description" class="form-control" name="description">						    
						</div>
											
						<br> 
						<div id="alertSuccess" class="alert alert-success"></div>
						<div id="alertError" class="alert alert-danger"></div>	
						<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-success btn-sm btn-block"> 
						
						
					</form>		
			</fieldset>
			
			<br> 
			
			<div class="container" id="ResearchProjectGrid">
				<fieldset>
					<legend><b>View Research Project Details</b></legend>
					<form method="post" action="ResearchProject.jsp" class="table table-striped">
						<%
						ResearchProject viewProject = new ResearchProject();
							out.print(viewProject.readProjects());
						%>
					</form>
					<br>
				</fieldset>
			</div>
		</div>
</body>
</html>