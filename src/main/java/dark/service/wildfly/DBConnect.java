package com.darkwolf.service.wildfly;

import java.util.ArrayList;
import java.sql.*;

public class DBConnect{

  //private String dbUrl = "jdbc:oracle:thin:@10.10.210.250:1521:ORCLCDB";
  //private String dbUser = "dummy";
  //private String dbPassword = "dummy";
  private String dbDriver = "jdbc:oracle:thin:@";
  private String dbPort_sid = ":1521:ORCLCDB";
  private String env_dbHostVar = "ENV_DB_HOST_VARIABLE";
  private String env_dbUser = "ENV_DB_USERNAME";
  private String env_dbPassword = "ENV_DB_USERPASS";
  private String dbHostVar = "";
  private String dbHost = "";
  private String dbUrl = "";
  private String dbUser = "";
  private String dbPassword = "";
  private String dbConnection = "";

  private ArrayList<String> users = new ArrayList<String>();

  public ArrayList<String> getData(){
    return users;
  }

  public void setDataFromDB() {
    /*
      Read in value from configmap that contain db service host env variable
      and use that to find the ip for the db.
    */
    try {
        dbUser = System.getenv(env_dbUser);
        dbPassword = System.getenv(env_dbPassword);
        dbHostVar = System.getenv(env_dbHostVar);
        dbHost = System.getenv(dbHostVar);
        dbConnection = dbDriver + dbHost + dbPort_sid;
    } catch  (Exception e) {
        System.out.println("Error getting environment variables. " + e);
    }

    // Loggin into /wildfly/standalone/log/server.log
    System.out.println("** Environment variables for db connection:");
    System.out.format("%s=%s%n", env_dbHostVar, dbHostVar);
    System.out.format("%s=%s%n", dbHostVar, dbHost);
    System.out.format("%s=%s%n", "dbDriver", dbDriver);
    System.out.format("%s=%s%n", "dbPort_sid", dbPort_sid);
    System.out.format("%s=%s%n", env_dbUser, dbUser);
    System.out.format("%s=%s%n", env_dbPassword, dbPassword);
    System.out.println("** End of environment variables");
    
    try (Connection conn = DriverManager.getConnection(
        dbConnection, dbUser, dbPassword)) {

        if (conn != null) {
            System.out.println("Connected to the database!");
        
            Statement stmt=conn.createStatement();
                        
            ResultSet rsData=stmt.executeQuery("select name from users");

            while(rsData.next()) {
              users.add(rsData.getString(1));
              System.out.println("Record: " + rsData.getString(1));
            }
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
