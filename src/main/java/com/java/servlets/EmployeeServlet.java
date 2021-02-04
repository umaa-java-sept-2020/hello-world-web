package com.java.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class EmployeeServlet  extends HttpServlet {

    // Constructor |  LifeCycle Methods | Service | Destroy | ServletConfig Parameters | ServletContext Parameters

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp);
        displayContextAndConfig();
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("welcome to webapp: "+this.getClass());
    }

    // can call this method any where inside the LifeCycle methods or inside doXXX
    private void displayContextAndConfig()
    {
        ServletContext servletContext =  getServletContext();
        servletContext = getServletConfig().getServletContext();

        ServletConfig servletConfig = getServletConfig();

        servletContext.log("====print servlet context key values===");

        servletContext.log("c1= "+servletContext.getInitParameter("c1"));
        Enumeration<String> contextKeys =  servletContext.getInitParameterNames();

        while(contextKeys.hasMoreElements())
        {
            String key = contextKeys.nextElement();
            String value = servletContext.getInitParameter(key);
            servletContext.log("key: "+key+" value: "+value);
        }


        servletContext.log("====print servlet config key values===");

        Enumeration<String> configKeys = servletConfig.getInitParameterNames();
        while(configKeys.hasMoreElements())
        {
            String key = configKeys.nextElement();
            String value = servletConfig.getInitParameter(key);
            servletContext.log("key: "+key+" value: "+value);
        }


    }
}
