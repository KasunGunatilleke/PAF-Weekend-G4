package com;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import model.Patient;

@Path("/Patient") 
public class PatientService {
	
	Patient patientObj = new Patient();
	
	  @GET
	   @Path("/")
	  @Produces(MediaType.TEXT_HTML)
	 
	   public String readPatient()
	   {
		  System.out.println("Welcome!!!!..."); 	  
		  return patientObj.readPatient();
	  
	   }
	  
	   @POST
	   @Path("/")
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	   @Produces(MediaType.TEXT_PLAIN)
	   public String insertPatient(
			    @FormParam("PatientName") String PatientName,
			    @FormParam("Gender") String Gender,
			    @FormParam("Email") String Email,
			    @FormParam("Phone") String Phone,
			    @FormParam("address") String address,
			    @FormParam("Password") String Password,
			    @FormParam("ConfirmPassword") String ConfirmPassword
			   )
	   {
		    String output = patientObj.insertPatient(PatientName,Gender ,Email ,Phone,address,Password,ConfirmPassword);
		   return output;
		   } 
	   @PUT
	   @Path("/")
	   @Consumes(MediaType.APPLICATION_JSON)
	   @Produces(MediaType.TEXT_PLAIN)
	   public String updatePatient(String dData)
	   {
	   
	    JsonObject P1 = new JsonParser().parse(dData).getAsJsonObject();
	    String PID = P1.get("PID").getAsString();
	    String PatientName = P1.get("PatientName").getAsString();
	    String Gender = P1.get("Gender").getAsString();
	    String Email = P1.get("Email").getAsString();
	    String Phone = P1.get("Phone").getAsString();
	    String address = P1.get("address").getAsString();
	    String Password = P1.get("Password").getAsString();
	    String ConfirmPassword = P1.get("ConfirmPassword").getAsString();
	    
	   
	   String output = patientObj.updatePatient(PID,PatientName,Gender,Email,Phone,address,Password,ConfirmPassword);
	   return output;
	   }
	   @DELETE
	   @Path("/")
	   @Consumes(MediaType.APPLICATION_XML)
	   @Produces(MediaType.TEXT_PLAIN)
	   public String deletePatient(String dData)
	   {
	  
	    Document doc = Jsoup.parse(dData, "", Parser.xmlParser());

	 
	    String PID = doc.select("PID").text();
	    String output = patientObj.deletePatient(PID);
	   return output;
	   }
	
}


