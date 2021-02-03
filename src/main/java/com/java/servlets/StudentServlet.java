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

public class StudentServlet extends HttpServlet {
    // GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        // write own implementation
        getServletContext().log("hashCode: "+this.hashCode());
//        System.out.println("it is recommended");
        getServletContext().log("current thread: "+Thread.currentThread());
        PrintWriter writer = resp.getWriter();
        writer.write("welcome to webapp: "+this.getClass());
    }

    public StudentServlet() {
       // getServletContext().log("constructor");  java.lang.NullPointerException
        System.out.println("constructor: "+this.getClass());
    }
    // Servlet (3)Life Cycle Methods: init, service, destroy

    @Override
    public void init(ServletConfig config) throws ServletException {
        config.getServletContext().log("param based init: "+this.getClass());
        super.init(config);
    }

    @Override
    public void init() throws ServletException {
        //super.init();
        getServletContext().log("0 params based init: "+this.getClass());
    }

    @Override
    public void destroy() {
        super.destroy();
        getServletContext().log("destroy is executing: "+this.getClass());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().log("service is executing: "+this.getClass());
        super.service(req, resp);
        displayContextAndConfig();

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
