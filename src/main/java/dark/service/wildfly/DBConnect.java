package com.darkwolf.service.wildfly;

import java.util.ArrayList;
import java.sql.*;

public class DBConnect{

  ArrayList<String> users = new ArrayList<String>();
  ArrayList<String> getUsersFromDB() {
    connectToDb();
    return users;
  }

  void connectToDb() {
    try (Connection conn = DriverManager.getConnection(
        "jdbc:oracle:thin:@10.10.210.250:1521:ORCLCDB", "dummy", "dummy")) {

        if (conn != null) {
            System.out.println("Connected to the database!");
        } else {
            System.out.println("Failed to make connection!");
        }
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select name from users");  
      while(rs.next())  
        users.add(rs.getString(1)); 

    } catch (SQLException e) {
        System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (Exception e) {
        e.printStackTrace();
    }
    /*try{  
      //step1 load the driver class  
      Class.forName("oracle.jdbc.driver.OracleDriver");
      //step2 create  the connection object  
      Connection con=DriverManager.getConnection(  
        "jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
      
      //step3 create the statement object  
      Statement stmt=con.createStatement();  
      
      //step4 execute query  
      ResultSet rs=stmt.executeQuery("select * from emp");  
      while(rs.next())  
        users.add(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
      
      //step5 close the connection object  
      con.close();  
      
    } catch(Exception e) {
      System.out.println(e);
    }*/

  }
} 