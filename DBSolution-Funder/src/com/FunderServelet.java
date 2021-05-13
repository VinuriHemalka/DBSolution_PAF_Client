package com;

import java.sql.*;

public class FunderServelet {
	//A common method to connect to the DB
	
		private Connection connect()
		 {
			Connection con = null;
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");

		 //Provide the correct details: DBServer/DBName, username, password
		 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/dbsolutions-funder", "root", "root");
		 }
		 catch (Exception e)
		 	{e.printStackTrace();}
		 return con;
		 }
		
		public String insertFunder(String fName, String PhNumber,  String fCountry)
		
		 {
			String output = "";
		 try
		 {
			 Connection con = connect();
			 
		 if (con == null)
		 {return "Error while connecting to the database for inserting."; }
		 
		 // create a funder
		 String query = " insert into funderdetail(`funder_ID`,`funderName`,`phoneNumber`,`country` )" + " values (?, ?, ?, ?)";
		 
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 
		 // binding values
		 preparedStmt.setInt(1, 0);
		 preparedStmt.setString(2, fName);
		 preparedStmt.setInt(3, Integer.parseInt(PhNumber));
		 preparedStmt.setString(4, fCountry);
		 
		// execute the funder statement
		 preparedStmt.execute();
		 con.close();
		 
		 String newFunder = readFunders();
		 output = "{\"status\":\"success\", \"data\": \"" + newFunder + "\"}";
		 
		 }
		 catch (Exception e)
		 {
			 output = "{\"status\":\"error\", \"data\": \"Error while inserting the funder.\"}";
			 System.err.println(e.getMessage());
			 System.out.println(e.getMessage());
			 System.out.println(e);
			 e.printStackTrace();
		 }
		 return output;
		 }
		
		public String readFunders()
		 {
			String output = "";
		 try
		 {
			 Connection con = connect();
		 
		 if (con == null)
		 {return "Error while connecting to the database for reading."; }
		 
		 // Prepare the display
		 output = "<table border='1'><tr><th>Funder ID</th>" +
		 "<th>Funder Name</th>" +
		 "<th>Phone Number</th>" +
		 "<th>Country</th>" + 
		 "<th>Update</th><th>Remove</th></tr>";

		 String query = "select * from funderdetail";
		 Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery(query);
		 
		 // read funder details
		 while (rs.next())
		 {
			 String funder_ID = Integer.toString(rs.getInt("funder_ID"));
			 String funderName = rs.getString("funderName");
			 String phoneNumber =Integer.toString(rs.getInt("phoneNumber"));
			 String country = rs.getString("country");
		 
		 // Add into the html table
		 output += "<td>" + funder_ID + "</td>";
		 output += "<td>" + funderName + "</td>";
		 output += "<td>" + phoneNumber + "</td>";
		 output += "<td>" + country + "</td>";
		 
		 // buttons
		 output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
				 + "<td><button class='btnRemove btn btn-danger' name='btnRemove' id ='btnRemove' value='"+ funder_ID +"' >Remove</button></td></tr>";
				 
		 }
		 con.close();
		 
		 // output of funders
		 output += "</table>";
		 
		 }
		 catch (Exception e)
		 { 
			 output = "Error while reading the items.";
			 System.err.println(e.getMessage());
		 
		 }
		 
		 return output;
		 }
		
		public String updateFunder(String funderID, String fName, String PhNumber,  String fCountry)
		{
			 String output = "";
			 try
			 {
				 Connection con = connect();
			 if (con == null)
			 {
				 return "Error while connecting to the database for updating."; 
			 }
			 
			 // create a prepared statement
			 	String query = "UPDATE funderdetail SET funderName=?,phoneNumber=?,country=?WHERE funder_ID=?";
			 	PreparedStatement preparedStmt = con.prepareStatement(query);
			 	
			 // binding values
			 preparedStmt.setString(1, fName);
			 preparedStmt.setInt(2, Integer.parseInt(PhNumber));
			 preparedStmt.setString(3, fCountry);
			 preparedStmt.setInt(4, Integer.parseInt(funderID));
			 
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 String newFunder = readFunders(); output = "{\"status\":\"success\", \"data\": \"" + newFunder + "\"}";
			 }
			 catch (Exception e)
			 {
				 output = "{\"status\":\"error\", \"data\": \"Error while updating the Funder.\"}";
				 System.err.println(e.getMessage());
			 }
			 return output;
			 }
		
			public String deleteFunder(String funder_ID)
			 {
				String output = "";
			 try
			 {
				 Connection con = connect();
				 
			 if (con == null)
			 {return "Error while connecting to the database for deleting."; }
			 
			 // create a prepared statement
			 String query = "delete from funderdetail where funder_ID=?";
			 
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 
			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(funder_ID));
			 
			 // execute the statement
			 preparedStmt.execute();
			 
			 con.close();
			 
			 String newFunder = readFunders(); output = "{\"status\":\"success\", \"data\": \"" + newFunder + "\"}";
			 }
			 catch (Exception e)
			 {
				 output = "{\"status\":\"error\", \"data\": \"Error while deleting the funder.\"}";
				 System.err.println(e.getMessage());
				 System.out.println(e);
			 }
			 return output;
			 }

}
