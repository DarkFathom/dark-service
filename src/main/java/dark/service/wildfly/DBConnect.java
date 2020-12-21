package com.darkwolf.service.wildfly;

import java.util.ArrayList;
import java.sql.*;

public class DBConnect{

  private String dbUrl = "jdbc:oracle:thin:@10.10.210.250:1521:ORCLCDB";
  private String dbUser = "dummy";
  private String dbPassword = "dummy";
  private ArrayList<String> users = new ArrayList<String>();

  public ArrayList<String> getData(){
    return users;
  }

  public void setDataFromDB() {
    try (Connection conn = DriverManager.getConnection(
        dbUrl, dbUser, dbPassword)) {

        if (conn != null) {
            System.out.println("Connected to the database!");
        
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select name from users");
            
            rs.last();
            System.out.println("database query resulted in " + rs.getRow() + " records.");
            
            while(rs.next())
              users.add(rs.getString(1));
        } else {
            System.out.println("Failed to make connection!");
            users.add("connection error record");
        } 

    } catch (SQLException e) {
        System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
} 