package database;

import java.sql.Connection;
import java.sql.DriverManager;


public class dbconnect {
	public Connection connect()
	 {
	 Connection con = null;
	
	 try
	 {
	 Class.forName("com.mysql.cj.jdbc.Driver");
   //Connection//good
	 //Provide the correct details: DBServer/DBName, username, password
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paf_db?useTimezone=true&serverTimezone=UTC", "root", "");
	 System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
	 
	 }
	 catch (Exception e)
	 {
		 System.out.println("errrrror - "+e);
		 e.printStackTrace();}
	 return con;
	 } 
	
	
	
}