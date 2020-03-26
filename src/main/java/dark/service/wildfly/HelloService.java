package com.darkwolf.service.wildfly;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = {"hello"}, loadOnStartup = 1)
public class HelloService extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().println(getNameString(null));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        PrintWriter out = response.getWriter();
        out.println(getNameString(name));
    }

    public String getNameString(String passedName) {
        String strResponse = "";
        if (passedName == null || passedName == "") {
            strResponse = "Hello World!";
        }else {
            strResponse = "Hello " + passedName + "!";
        }
        return strResponse;
    }
}