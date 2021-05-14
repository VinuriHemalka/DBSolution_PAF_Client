<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
			<title>User Management</title>
	
		<link href="myStyle.css" rel="stylesheet" />
		<link rel="stylesheet" href="Views/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="Components/jquery-3.5.0.min.js"></script>
		<script src="Components/Customer.js"></script>

	</head>
	
	<body>
		<div class="container">
	
			<p class="font-weight-bold">
				<center>
					<h1><u><i><b>User Management</b></i></u></h1>
				</center>
			</p>
			<br><br>
			
			<fieldset>
	
				<legend><b>Add New USER </b></legend>
					<form id="USER" name="USER" class="border border-light p-5">
						
						<div class="form-outline mb-4">
						    <label class="form-label" for="form6Example3" class="col-sm-2 col-form-label col-form-label-sm">User Name:</label>
						    <input type="hidden" id="user_ID" name="user_ID">
						    <input type="text" id="user_Name" class="form-control" name="user_Name">						    
						</div>
						
						<div class="form-outline mb-4">
						    <label class="form-label" for="form6Example3" class="col-sm-2 col-form-label col-form-label-sm">Password:</label>
						    <input type="text" id="password" class="form-control" name="password">						    
						</div>
						
						<div class="form-outline mb-4">
						    <label class="form-label" for="form6Example3" class="col-sm-2 col-form-label col-form-label-sm">Phone number:</label>
						    <input type="text" id="userType" class="form-control" name="userType">						    
						</div>
						
						<br>
					<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>
					<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary btn-lg btn-block">	
					</form>	
				
				
							
			</fieldset>
			<div class="container" id="UserGrid">
			<fieldset>
					<legend><b>User  Details</b></legend>
						<form method="post" action="User.jsp" class="table table-striped">
						<%
						User viewUsers = new User();
								out.print(viewUsers.readUsers());
						%>
			</form>
					<br>
			</fieldset>
			</div>
			</div>
		</body>
</html>



