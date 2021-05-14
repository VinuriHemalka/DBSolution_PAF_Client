<%@page import="model.ResearchServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
			<title>Researcher Management</title>
	
		<link href="myStyle.css" rel="stylesheet" />
		<link rel="stylesheet" href="Views/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="Components/jquery-3.5.0.min.js"></script>
		<script src="Components/Reseachers.js"></script>

	</head>
	
	<body>
		<div class="container">
	
			<p class="font-weight-bold">
				<center>
					<h1><u><i><b>Researcher Management</b></i></u></h1>
				</center>
			</p>
			<br><br>
			
			<fieldset>
	
				<legend><b>Add Researcher Details</b></legend>
					<form id="RESEARCHER" name="RESEARCHER" class="border border-light p-5">
						
						
						
						<div class="form-outline mb-4">
						    <label class="form-label" for="form6Example3" class="col-sm-2 col-form-label col-form-label-sm">Reseracher_name</label>
						    <input type="hidden" id="Researcher_ID" name="Researcher_ID">
						    <input type="text" id="Reseracher_name" name="Reseracher_name" class="form-control" >						    
						</div>
						
						<div class="form-outline mb-4">
						    <label class="form-label" for="form6Example3" class="col-sm-2 col-form-label col-form-label-sm">Category</label>
						    <input type="text" id="Category" name="Category" class="form-control" >						    
						</div>
						
						<div class="form-outline mb-4">
						    <label class="form-label" for="form6Example3" class="col-sm-2 col-form-label col-form-label-sm">PhoneNumber</label>
						    <input type="text" id="PhoneNumber" name="PhoneNumber" class="form-control" >						    
						</div>
						
						<div class="form-outline mb-4">
						    <label class="form-label" for="form6Example3" class="col-sm-2 col-form-label col-form-label-sm">Email</label>
						    <input type="text" id="Emai" name="Emai" class="form-control" >						    
						</div>
						
						<div class="form-outline mb-4">
						    <label class="form-label" for="form6Example3" class="col-sm-2 col-form-label col-form-label-sm">Address</label>
						    <input type="text" id="Address" name="Address" class="form-control" >						    
						</div>
						<div class="form-outline mb-4">
						    <label class="form-label" for="form6Example3" class="col-sm-2 col-form-label col-form-label-sm">Country </label>
						    <input type="text" id="Country" name="Country" class="form-control" 
>						    
						</div>
						 
												
						<br> 
						
						
					
				
					<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>
					<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-success btn-lg btn-block"> 
					</form>			
			</fieldset>
			
			<br> 
			
			<div class="container" id="OrderGrid">
				<fieldset>
					<legend><b>View Researcher Details</b></legend>
					<form method="post" action="Researcher.jsp" class="table table-striped">
						<%
						ResearchServlet viewResearcher = new ResearchServlet();
							out.print(viewResearcher.readResearchers());
						%>
					</form>
					<br>
				</fieldset>
			</div>
		</div>
	</body>
</html>



