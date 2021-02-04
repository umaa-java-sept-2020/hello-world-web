package com.java.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Enumeration;

// You can have bunch of listeners. And registered them in deployment descriptor (web.xml)

// OnStartUp it executes
// OnDestroy it executes
// this is one time activity
public class AppEventListener implements ServletContextListener {

    private ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
      servletContext =  sce.getServletContext();
      servletContext.log("contextInitialized: "+this.getClass());
      displayContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        servletContext =  sce.getServletContext();
        servletContext.log("contextDestroyed: "+this.getClass());
        displayContext();
    }

    private void displayContext()
    {

        servletContext.log("====print servlet context key values===");

        servletContext.log("c1= "+servletContext.getInitParameter("c1"));
        Enumeration<String> contextKeys =  servletContext.getInitParameterNames();

        while(contextKeys.hasMoreElements())
        {
            String key = contextKeys.nextElement();
            String value = servletContext.getInitParameter(key);
            servletContext.log("key: "+key+" value: "+value);
        }

    }
}
