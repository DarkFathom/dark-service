package com.darkwolf.service.wildfly;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = {"hello"}, loadOnStartup = 1)
public class HelloService extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<String> users = getNameString();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Web Demo</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<P>A hello from all the users.</P>");
        out.println("<P></P>");
        for(int i = 0; i < users.size(); i++){
            out.println("<P>'Hello' - " + users.get(i) + "</P>");
        }
        out.println("</BODY></HTML>");
    }

    public ArrayList<String> getNameString() {
        DBConnect dbconnect = new DBConnect();
        dbconnect.setDataFromDB();
        ArrayList<String> users = dbconnect.getData();
        return users;
    }
}