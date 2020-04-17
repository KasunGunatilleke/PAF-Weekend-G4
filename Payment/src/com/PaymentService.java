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

import model.Payment;
@Path("/Payment") 

public class PaymentService {
	 Payment p1 = new Payment();
	   @GET
	   @Path("/")
	@Produces(MediaType.TEXT_HTML)
	 
	   public String readPayment()
	   {
	   return p1.readPayment();
	   }
	   @POST
	   @Path("/")
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	   @Produces(MediaType.TEXT_PLAIN)
	   public String insertPayment(
	    @FormParam(" payDate") String payDate,
	    @FormParam("payMethod ") String payMethod ,
	    @FormParam(" payAmount") String  payAmount
	    
	 )
	   {
	    String output = p1.insertPayment(payDate, payMethod,payAmount);
	   return output;
	   }
	   @PUT
	   @Path("/")
	   @Consumes(MediaType.APPLICATION_JSON)
	   @Produces(MediaType.TEXT_PLAIN)
	   public String updatePayment(String dData)
	   {
	   
	    JsonObject p2 = new JsonParser().parse(dData).getAsJsonObject();
	    String payID = p2.get("payID").getAsString();
	    String payDate = p2.get(" payDate").getAsString();
	    String payMethod = p2.get("payMethod").getAsString();
	    String payAmount = p2.get("payAmount").getAsString();
	   
	    
	   
	   String output = p1.updatePayment(payID, payDate ,payMethod,payAmount);
	   return output;
	   }
	   @DELETE
	   @Path("/")
	   @Consumes(MediaType.APPLICATION_XML)
	   @Produces(MediaType.TEXT_PLAIN)
	   public String deletePayment(String dData)
	   {
	  
	    Document doc = Jsoup.parse(dData, "", Parser.xmlParser());

	 
	    String payID = doc.select("payID").text();
	    String output = p1.deletePayment(payID);
	   return output;
	   }
	
}
