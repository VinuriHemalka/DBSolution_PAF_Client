package service;

import javax.ws.rs.Consumes;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import com.FunderServelet;
@Path("/Funders")

public class FunderService {
	
	FunderServelet funderObj = new FunderServelet();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readFunders()
	 {
	  return funderObj.readFunders();
	 }
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertFunder(
	@FormParam("funderName") String funderName,
	@FormParam("phoneNumber") String phoneNumber,
	@FormParam("country") String country
	)

	{
	String output = funderObj.insertFunder(funderName, phoneNumber, country);
	return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateFunder(String funderData)
	{

	//Convert the input string to a JSON object
	JsonObject funderObject = new JsonParser().parse(funderData).getAsJsonObject();
	
	//Read the values from the JSON object
	String funder_ID = funderObject.get("funder_ID").getAsString();
	String funderName = funderObject.get("funderName").getAsString();
	String phoneNumber = funderObject.get("phoneNumber").getAsString();
	String country = funderObject.get("country").getAsString();

	String output = funderObj.updateFunder(funder_ID, funderName, phoneNumber, country);
	
	return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteFunder(String funderData)
	{

	//Convert the input string to an XML document
	Document doc = Jsoup.parse(funderData, "", Parser.xmlParser());

	//Read the value from the element <funder_ID>
	String funder_ID = doc.select("funder_ID").text();
	String output = funderObj.deleteFunder(funder_ID);
	return output;
	}
}
