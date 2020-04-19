package com;

import model.Appointment;

import java.sql.Date;
import java.sql.Time;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Appointment")

public class AppointmentService {
	Appointment a1 = new Appointment();
	   @GET
	   @Path("/")
	@Produces(MediaType.TEXT_HTML)
	 
	   public String readAppointment()
	   {
	   return a1.readAppointment();
	   }
	
	@POST
	@Path("/")
	
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertAppointment(
			@FormParam("docID") String docID, 
			@FormParam("AppDate") String AppDate,
			@FormParam("AppTime") String AppTime, 
			@FormParam("PID") String PID) {
		String output = a1.insertAppointment(docID,AppDate, AppTime,PID);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAppointment(String dData)
	{
	   
	    JsonObject a2 = new JsonParser().parse(dData).getAsJsonObject();
	    String AppID = a2.get("AppID").getAsString();
	    String docID = a2.get("docID").getAsString();
	    String AppDate = a2.get("AppDate").getAsString();
	    String AppTime = a2.get("AppTime").getAsString();
	    String PID = a2.get("PID").getAsString();
	    
	   
	   String output = a1.updateAppointment( AppID,  docID, AppDate, AppTime, PID);
	   return output;
	   }

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteAppointment(String dData)
	{

		Document doc = Jsoup.parse(dData, "", Parser.xmlParser());

		String AppID = doc.select("AppID").text();
		String output = a1.deleteAppointment(AppID);
		return output;
	}

}
