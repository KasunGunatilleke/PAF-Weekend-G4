package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import database.dbconnect;

public class Patient{

    //A common method to connect to the DB
    dbconnect obj = new dbconnect();
	
			public String insertPatient(String PatientName, String Gender, String Email, String Phone,String address,String Password,String ConfirmPassword) {
				
				System.out.println(PatientName);
				System.out.println(Gender);
				System.out.println(Email);
				System.out.println(Phone);
				System.out.println(address);
				System.out.println(Password);
				System.out.println(ConfirmPassword);
				
				String output = "";
				try {
					Connection con = obj.connect();
					if (con == null) {
						return "Error while connecting to the database for inserting.";
					}
					// create a prepared statement
					String query = " insert into registerpatient(`PatientName`,`Gender`,`Email`,`Phone`,`address`,`Password`,`ConfirmPassword`)"
							+ " values (?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement preparedStmt = con.prepareStatement(query);
					
					preparedStmt.setString(1, PatientName);
					preparedStmt.setString(2, Gender);
					preparedStmt.setString(3, Email);
					preparedStmt.setString(4, Phone);
					preparedStmt.setString(5, address);
					preparedStmt.setString(6, Password);
					preparedStmt.setString(7, ConfirmPassword);

					preparedStmt.execute();
					con.close();
					output = "Inserted successfully";
					System.out.println("Inserted successfully.......................................");
				} catch (Exception e) {
					output = "Error while inserting the Patient.";
					System.out.println("Error while inserting the Patient........."+ e);
					System.err.println(e.getMessage());
				}
				return output;
			}
			public String readPatient() {
				String output = "";
				try {
					Connection con = obj.connect();
					if (con == null) {
						return "Error while connecting to the database for reading.";
					}
					// Prepare the html table to be displayed
					output = "<table border=\"1\">"
							+ "<th>PatientName</th"
							+ "><th>Gender</th>"
							+ "<th>Email</th>"
							+ "<th>Phone</th>"
							+ "<th>address</th>"
							+ "<th>Password</th>"
							+ "<th>ConfirmPassword</th>"
							+ "<th>Update</th>"
							+ "<th>Remove</th></tr>";
					String query = "select * from registerpatient";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					// iterate through the rows in the result set
					while (rs.next()) {
						String PID = Integer.toString(rs.getInt("PID"));
						String PatientName = rs.getString("PatientName");
						String Gender = rs.getString("Gender");
						String Email = rs.getString("Email");
						String Phone = rs.getString("Phone");
						String address = rs.getString("address");
						String Password = rs.getString("Password");
						String ConfirmPassword = rs.getString("ConfirmPassword");
						
						
						// Add into the html table
						output += "<tr><td><input id=\"hidPatientIDUpdate\"name=\"hidPatientIDUpdate\"type=\"hidden\" value=\"" + PID + "\">"
	                            + PatientName + "</td>";
						output += "<td>" + Gender + "</td>";
						output += "<td>" + Email + "</td>";
						output += "<td>" + Phone + "</td>";
						output += "<td>" + address + "</td>";
						output += "<td>" + Password  + "</td>";
						output += "<td>" + ConfirmPassword  + "</td>";
						
						// buttons
						output += "<td><input name=\"btnUpdate\" type=\"submit\"value=\"Update\" class=\"btn btn-warning btnUpdate\"></td>"
								+ "<td><form method=\"post\" action=\"Patient_Insert.jsp\">"
								+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
								+ "<input name=\"hidPatientIDDelete\" type=\"hidden\" value=\"" + PID + "\">" + "</form></td></tr>";
						
					}
					con.close();
					// Complete the html table
					output += "</table>";
				} catch (Exception e) {
					output = "Error while reading the Patient.";
					System.err.println(e.getMessage());
				}
				return output;
			}
			public String updatePatient(String PID, String PatientName, String Gender, String Email, String Phone,String address,String Password,String ConfirmPassword ) {
				System.out.println("Update method...............................................................................");
				String output = "";
				try {
					Connection con = obj.connect();
					if (con == null) {
						return "Error while connecting to the database for updating.";
					}
					//update
					// create a prepared statement
					String query = "UPDATE registerpatient SET PatientName=?,Gender=?,Email=?,Phone=?,address=?,Password=?,ConfirmPassword=? WHERE PID=?";
					PreparedStatement preparedStmt = con.prepareStatement(query);
					// binding values
					preparedStmt.setString(1, PatientName);
					preparedStmt.setString(2, Gender);
					preparedStmt.setString(3, Email);
					preparedStmt.setString(4, Phone);
					preparedStmt.setString(5, address);
					preparedStmt.setString(6, Password);
					preparedStmt.setString(7, ConfirmPassword);
					preparedStmt.setInt(8, Integer.parseInt(PID));
					// execute the statement
					preparedStmt.execute();
					con.close();
					output = "Updated successfully";
				} catch (Exception e) {
					output = "Error while updating the Patient.";
					System.err.println(e.getMessage());
				}
				return output;
			}
			public String deletePatient(String PID) {
				String output = "";
				try {
					Connection con = obj.connect();
					if (con == null) {
						return "Error while connecting to the database for deleting.";
					}
					// create a prepared statement
					String query = "delete from registerpatient  where PID=?";
					PreparedStatement preparedStmt = con.prepareStatement(query);
					// binding values
					preparedStmt.setInt(1, Integer.parseInt(PID));
					// execute the statement
					preparedStmt.execute();
					con.close();
					output = " Patient Deleted successfully";
				} catch (Exception e) {
					output = "Error while deleting the Patient.";
					System.err.println(e.getMessage());
				}
				return output;
			}
		

}
