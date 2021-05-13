<%@page import="com.FunderServelet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
			<title>Funder Management - GadgetBadget</title>
	
		<link href="myStyle.css" rel="stylesheet" />
		<link rel="stylesheet" href="Views/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="Components/jquery-3.5.0.min.js"></script>
		<script src="Components/Funder.js"></script>

	</head>
	
	<body>
		<div class="container">
	
			<p class="font-weight-bold">
				<center>
					<h1><u><i><b>Funder Management - GadgetBadget</b></i></u></h1>
				</center>
			</p>
			<br><br>
			
			<fieldset>
	
				<center>
				<h3><u><i><b>Add new Funder</b></i></u></h3>
				</center>
					<form id="FUNDER" name="FUNDER" class="border border-light p-5">
						
						<div class="form-outline mb-4">
						    <label class="form-label" for="form6Example3" class="col-sm-2 col-form-label col-form-label-sm">Funder Name:</label>
						    <input type="hidden" id="funder_ID" name="funder_ID">
						    <input type="text" id="funderName" class="form-control" name="funderName">						    
						</div>
						
						<div class="form-outline mb-4">
						    <label class="form-label" for="form6Example3" class="col-sm-2 col-form-label col-form-label-sm">Phone Number:</label>
						    <input type="text" id="phoneNumber" class="form-control" name="phoneNumber">						    
						</div>
						
						<div class="form-outline mb-4">
						    <label class="form-label" for="form6Example3" class="col-sm-2 col-form-label col-form-label-sm">Country:</label>
						    <input type="text" id="country" class="form-control" name="country">						    
						</div>
												
						<br> 
						
						<div id="alertSuccess" class="alert alert-success"></div>
						<div id="alertError" class="alert alert-danger"></div>	
						
						<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary btn-lg btn-block">
					</form>
			</fieldset>
			
			<br> 
			
			<div class="container" id="OrderGrid">
				<fieldset>
					<legend><b>View Funder Details</b></legend>
					<form method="post" action="FunderView.jsp" class="table table-striped">
						<%
						FunderServelet viewOrder = new FunderServelet();
							out.print(viewOrder.readFunders());
						%>
					</form>
					<br>
				</fieldset>
			</div>
		</div>
	</body>
</html>