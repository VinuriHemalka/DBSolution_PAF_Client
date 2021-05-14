package model;
import java.sql.*;

public class ResearchProject{ 
	
	private Connection connect()
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbsolution-reserchproject", "root", "root");
			
			System.out.println("Succsess");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	//Add projects
	public String insertProject(String projectName, String Cost, String projectCategory, String Description)
	{
		String output = "";
			try
			{
				Connection con = connect();
				if (con == null)
				{return "Error while connecting to the database for inserting."; }
 
				// create a prepared statement
				String query = " insert into researchproject(`project_ID`, `project_Name`,`cost`,`project_Category`,`description` )" + " values (?, ?, ?, ?, ?)";
				
				PreparedStatement preparedStmt = con.prepareStatement(query);
 
				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, projectName);
				preparedStmt.setDouble(3, Double.parseDouble(Cost));
				preparedStmt.setString(4, projectCategory);
				preparedStmt.setString(5, Description);

				// execute the statement				
				preparedStmt.execute();
				con.close();
				String newProject = readProjects(); 
				 output = "{\"status\":\"success\", \"data\": \"" + newProject + "\"}";
				//output = "Successfully Inserted";
			}
			catch (Exception e)
			{
				//output = "Error while inserting the project.";
				output = "{\"status\":\"error\", \"data\": \"Error while inserting the project.\"}";
				 System.err.println(e.getMessage());
				 System.out.println(e.getMessage());
					System.out.println(e);
					e.printStackTrace();
			}
			
			return output;
	}
	
	//Read Projects
	public String readProjects()
	{
		String output = "";
		try
		{
			Connection con = connect();
			if (con == null)
			{return "Error while connecting to the database for reading."; }
 
			// Prepare the html table to be displayed
			output = "<table border='1'>"+ "<tr><th>Project ID</th>"+ 
			"<th>Project cost</th>" +
			"<th>Project cost</th>" + 
			"<th>Category</th>" + 
			"<th>Description</th>" + 
			"<th>Update</th><th>Delete</th></tr>";

			String query = "select * from researchproject";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			// iterate through the rows in the result set
			while (rs.next())
			{
				String project_ID = Integer.toString(rs.getInt("project_ID"));
				String project_Name = rs.getString("project_Name");
				String cost = Double.toString(rs.getDouble("cost"));
				String project_Category = rs.getString("project_Category");
				String description = rs.getString("description");
 
				// Add into the html table
				output += "<tr><td>" + project_ID + "</td>";
				output += "<td>" + project_Name + "</td>";
				output += "<td>" + cost + "</td>";
				output += "<td>" + project_Category + "</td>";
				output += "<td>" + description + "</td>";
 
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-outline-warning'></td>"
						 + "<td><button class='btnRemove btn btn-outline-danger' name='btnRemove' id ='btnRemove' value='"+ project_ID +"' >Remove</button></td></tr>";
			}
 
			con.close();
		
			// Complete the html table
			output += "</table>";
		}
		catch (Exception e)
		{
			output = "Error while Reading the projects.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	
	//Update Projects
	public String updateProjects(String PID, String projectName, String Cost, String projectCategory, String Description)
	{
		String output = "";
		try
		{
			Connection con = connect();
			if (con == null)
			{return "Error while connecting to the database for Updating."; }
	 
			// create a prepared statement
			String query = "UPDATE researchproject SET project_Name=?,cost=?,project_Category=?,description=? WHERE project_ID=?";
	 
			PreparedStatement preparedStmt = con.prepareStatement(query);
	 
			// binding values
			preparedStmt.setString(1, projectName);
			preparedStmt.setDouble(2, Double.parseDouble(Cost));
			preparedStmt.setString(3, projectCategory);
			preparedStmt.setString(4, Description);
			preparedStmt.setInt(5, Integer.parseInt(PID));
	 
			// execute the statement
			preparedStmt.execute();
			con.close();
	 
			//output = "Updated successfully";
			String newProject = readProjects(); 
			 output = "{\"status\":\"success\", \"data\": \"" + newProject + "\"}"; 
		}
		catch (Exception e)
		{
			//output = "Error while updating the projects.";
			output = "{\"status\":\"error\", \"data\": \"Error while updating the project.\"}"; 
			System.err.println(e.getMessage()); 
			System.out.println(e);
		}
		return output;
	 	}
	
	
	//Delete Projects
	public String deleteProjects(String project_ID)
	{
		String output = "";
		try
		{
			Connection con = connect();
	 
			if (con == null)
			{return "Error while connecting to the database for deleting."; }
	 
			// create a prepared statement
			String query = "delete from researchproject where project_ID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
	 
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(project_ID));
	 
			// execute the statement
			preparedStmt.execute();
			con.close();
			//output = "Deleted successfully";
			 String newOrder = readProjects(); output = "{\"status\":\"success\", \"data\": \"" + newOrder + "\"}";
		}
		catch (Exception e)
		{
			//output = "Error while deleting the project.";
			output = "{\"status\":\"error\", \"data\": \"Error while Deleting the project.\"}"; 
			System.err.println(e.getMessage()); 
			System.out.println(e);
		}
	
		return output;
	}
} 
