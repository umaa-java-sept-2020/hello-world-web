package com.java.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EmployeeServlet  extends HttpServlet {

    // Constructor |  LifeCycle Methods | Service | Destroy | ServletConfig Parameters | ServletContext Parameters

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp);
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("welcome to webapp: "+this.getClass());
    }
}
