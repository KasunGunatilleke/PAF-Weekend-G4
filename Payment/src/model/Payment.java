package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;  
import database.dbconnect;
import java.sql.DriverManager;

public class Payment {
	
	dbconnect obj=new dbconnect();
		
public String insertPayment(String payDate, String payMethod, String payAmount,String PID,String hosID,String AppID) {
	
	System.out.println(payDate);
	System.out.println(payMethod);
	System.out.println(payAmount);
	System.out.println(PID);
	System.out.println(hosID);
	System.out.println(AppID);
	
			System.out.println("insert");
			String output = "";
			try {
				Connection con = obj.connect();
				if (con == null) {
					return "Error while connecting to the database for inserting.";
				}
				// create a prepared statement
				String query = " insert into payment(`payDate`,`payMethod`,`payAmount`,`PID`,`hosID`,`AppID`)"
						+ " values (?, ?, ?,?,?,?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				preparedStmt.setDate(1, Date.valueOf(payDate));
				preparedStmt.setString(2, payMethod);
				preparedStmt.setFloat(3, Float.parseFloat(payAmount));
				preparedStmt.setInt(4, Integer.parseInt(PID));
				preparedStmt.setInt(5, Integer.parseInt(hosID));
				preparedStmt.setInt(6, Integer.parseInt(AppID));
			
			    preparedStmt.execute();
				con.close();
				output = "Inserted successfully";
			} catch (Exception e) {
				output = "Error while inserting the Payments.";
				System.out.println("Error while inserting the Payments........."+ e);
				System.err.println(e.getMessage());
			}
			return output;
		}
 
		public String readPayment() {
			String output = "";
			try {
				Connection con = obj.connect();
				if (con == null) {
					return "Error while connecting to the database for reading.";
				}
				// Prepare the html table to be displayed
				output = "<table border=\"1\">"
						+ "<th> pay Date </th"
						+ "><th> pay Method </th>"
						+ "<th> pay Amount</th>"
						+ "<th> PID</th>"
						+ "<th> hosID</th>"
						+ "<th> AppID</th>"
						+ "<th>Update</th>"
						+ "<th>Remove</th></tr>";
				String query = "select * from payment";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				// iterate through the rows in the result set
				while (rs.next()) {
					String payID = Integer.toString(rs.getInt("payID"));
					String payDate = rs.getString("payDate");
					String payMethod = rs.getString("payMethod");
					String payAmount = rs.getString("payAmount");
					String PID = Integer.toString(rs.getInt("PID"));
					String hosID = Integer.toString(rs.getInt("hosID"));
					String AppID = Integer.toString(rs.getInt("AppID"));
					
					// Add into the html table
					output += "<tr><td><input id=\"pidPaymentIDUpdate\"date=\"pidPaymentIDUpdate\"type=\"hidden\" value=\"" + payID + "\">"
                            + payDate + "</td>";
					output += "<td>" + payMethod + "</td>";
					output += "<td>" + payAmount + "</td>";
					output += "<td>" + PID + "</td>";
					output += "<td>" + hosID + "</td>";
					output += "<td>" + AppID + "</td>";
				
					// buttons
					output += "<td><input name=\"btnUpdate\" type=\"submit\"value=\"Update\" class=\"btn btn-warning btnUpdate\"></td>"
							+ "<td><form method=\"post\" action=\"Payment_Insert.jsp\">"
							+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
							+ "<input name=\"pidPaymentIDDelete\" type=\"hidden\" value=\"" + payID + "\">" + "</form></td></tr>";
					//1233
				}
				con.close();
				// Complete the html table
				output += "</table>";
			} catch (Exception e) {
				output = "Error while reading the Payments.";
				System.err.println(e.getMessage());
			}
			return output;
		}
		
		public String updatePayment(String payID, String payDate, String payMethod, String payAmount,String PID,String hosID,String AppID) {
			System.out.println("Update method...............................................................................");
			String output = "";
			try {
				Connection con = obj.connect();
				if (con == null) {
					return "Error while connecting to the database for updating.";
				}
				//update
				// create a prepared statement
				String query = "UPDATE payment SET payDate=?, payMethod=?, payAmount=?,PID=?,hosID=?,AppID=? WHERE payID=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setDate(1, Date.valueOf(payDate));
				preparedStmt.setString(2, payMethod);
				preparedStmt.setFloat(3, Float.parseFloat(payAmount));
				preparedStmt.setInt(4, Integer.parseInt(PID));
				preparedStmt.setInt(5, Integer.parseInt(hosID));
				preparedStmt.setInt(6, Integer.parseInt(AppID));
				preparedStmt.setInt(7, Integer.parseInt(payID));
				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Updated successfully";
			} catch (Exception e) {
				output = "Error while updating the Payment.";
				System.err.println(e.getMessage());
			}
			return output;
		}
		
		public String deletePayment(String payID) {
			String output = "";
			try {
				Connection con = obj.connect();
				if (con == null) {
					return "Error while connecting to the database for deleting.";
				}
				// create a prepared statement
				String query = "delete from payment where payID=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setInt(1, Integer.parseInt(payID));
				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Payment Deleted successfully";
			} catch (Exception e) {
				output = "Error while deleting the Payment.";
				System.err.println(e.getMessage());
			}
			return output;
		}
				
}