package com;

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

import model.Doctor;
@Path("/Doctor") 

public class DoctorService {
	Doctor d1 = new Doctor();
	   @GET
	   @Path("/")
	@Produces(MediaType.TEXT_HTML)
	 
	   public String readDoctor()
	   {
	   return d1.readDoctor();
	   }
	   @POST
	   @Path("/")
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	   @Produces(MediaType.TEXT_PLAIN)
	   public String insertDoctor(
	    @FormParam("docName") String docName,
	    @FormParam("docAge") String docAge,
	    @FormParam("docGender") String docGender,
	    @FormParam("docSpecialization") String docSpecialization,
	    @FormParam("hosID") String hosID
	 )
	   {
	    String output = d1.insertDoctor(docName,docAge ,docGender ,docSpecialization, hosID);
	   return output;
	   }
	   @PUT
	   @Path("/")
	   @Consumes(MediaType.APPLICATION_JSON)
	   @Produces(MediaType.TEXT_PLAIN)
	   public String updateDoctor(String dData)
	   {
	   
	    JsonObject d2 = new JsonParser().parse(dData).getAsJsonObject();
	    String docID = d2.get("docID").getAsString();
	    String docName = d2.get("docName").getAsString();
	    String docAge = d2.get("docAge").getAsString();
	    String docGender = d2.get("docGender").getAsString();
	    String docSpecialization = d2.get("docSpecialization").getAsString();
	    String hosID = d2.get("hosID").getAsString();
	    
	   
	   String output = d1.updateDoctor(docID, docName,docAge,docGender,docSpecialization,hosID);
	   return output;
	   }
	   @DELETE
	   @Path("/")
	   @Consumes(MediaType.APPLICATION_XML)
	   @Produces(MediaType.TEXT_PLAIN)
	   public String deleteDoctor(String dData)
	   {
	  
	    Document doc = Jsoup.parse(dData, "", Parser.xmlParser());

	 
	    String docID = doc.select("docID").text();
	    String output = d1.deleteDoctor(docID);
	   return output;
	   }


}
