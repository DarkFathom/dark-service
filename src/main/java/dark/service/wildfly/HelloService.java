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
        System.out.println("GETTING");
        System.out.println(getNameString(null));
        response.getWriter().println(getNameString(null));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = getNameString(request.getParameter("name"));
        PrintWriter out = response.getWriter();
        out.println(getNameString(name));
        System.out.println("POSTING");
        System.out.println(getNameString(name));
    }

    public String getNameString(String passedName) {
        System.out.println(passedName);
        String strResponse;
        if (passedName == null) {
            strResponse = "Hello World!";
            System.out.println("NULL");
            System.out.println(strResponse);
        }else {
            strResponse = passedName + "!";
            System.out.println("NOT NULL");
            System.out.println(strResponse);
        }
        System.out.println(strResponse);
        return strResponse;
    }
}