package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnector 
{
  static String driver="com.mysql.cj.jdbc.Driver";
  static String url="jdbc:mysql://localhost:3306/studentdb";
  static String un="root";
  static String pass="root";
  static Connection conn;
  
  public static Connection getConnection()
  {
	  try {
		Class.forName(driver);
		conn=DriverManager.getConnection(url, un, pass);
		if(conn==null)
		{
			System.out.println("Error in Connection");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return conn;
	  
  }
}
