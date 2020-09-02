package com.ckSeleniumDemo.SeleniumDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterTest;

public class MySqlDbDemo {
	
	static Connection conn=null;
	private static Statement stmt;
	private static ResultSet results=null;
	private static String db_url="jdbc:mysql://localhost:3306/practice_db";
	private static String db_user="sa";
	private static String db_pwd="1qazZAQ!";
	public static String driver = "com.mysql.jdbc.Driver"; 
	
	

  @BeforeTest
  public void beforeTest() throws SQLException {
	  try {
		  
		// STEP 1: Register JDBC driver
		Class.forName(driver).newInstance();
		
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	// STEP 2: Get connection to DB
	  System.out.println("Connecting to a selected database...");
	  
		conn = DriverManager.getConnection(db_url, db_user, db_pwd);
		
		System.out.println("Connected database successfully...");
		
		// STEP 3: Statement object to send the SQL statement to the Database
		System.out.println("Creating statement...");
		stmt = conn.createStatement();
	  
  }
  
  @Test
  public void dbQuery() throws SQLException {
	  
	  String query = "select * from pet";
	  results = stmt.executeQuery(query);
	  while(results.next()){
		  
		  String name=results.getString("name");
		  String owner=results.getString("owner");
		  String species = results.getString("species");
		  String gender = results.getString("sex");
		  String birth = results.getString("birth");
		  String death = results.getString("death");
		  
		  System.out.println("name: "+ name);
		  System.out.println("owner: "+ owner);
		  System.out.println("species : "+ species);
		  System.out.println("gender: "+ gender);
		  System.out.println("birth: "+ birth);
		  System.out.println("death: "+ death);
		  
		  System.out.println("----------------------");
	  }
	  results.close();
  }

  @AfterTest
  public void afterTest() {
	  try {
			if (results != null)
				results.close();
			if (stmt != null)
				conn.close();
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
  }

}
