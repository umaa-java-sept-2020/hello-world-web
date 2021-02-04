package com.java.filters;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class StudentFilter implements Filter {

    private FilterConfig filterConfig;

    public StudentFilter() {
        // execute only once on startUp
        System.out.println("constructor: "+this.getClass());
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // only once on init on Startup
        this.filterConfig = filterConfig;
        filterConfig.getServletContext().log("init: "+this.getClass());
        displayContextAndConfig();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      // for every http request

        // filter --> filter --> servlet
        // preProcessing
        filterConfig.getServletContext().log("preProcessing: doFilter: "+this.getClass());
        chain.doFilter(request, response); // without this it wont delegate the call to next filter or servlet
        //postProcessing
        filterConfig.getServletContext().log("postProcessing: doFilter: "+this.getClass());

    }

    @Override
    public void destroy() {// only once on destroy
        filterConfig.getServletContext().log("destroy: "+this.getClass());
    }

    // can call this method any where inside the LifeCycle methods (init , doFilter, destroy)
    private void displayContextAndConfig()
    {
        ServletContext servletContext =  filterConfig.getServletContext();


        servletContext.log("====print servlet context key values===");

        servletContext.log("c1= "+servletContext.getInitParameter("c1"));
        Enumeration<String> contextKeys =  servletContext.getInitParameterNames();

        while(contextKeys.hasMoreElements())
        {
            String key = contextKeys.nextElement();
            String value = servletContext.getInitParameter(key);
            servletContext.log("key: "+key+" value: "+value);
        }


        servletContext.log("====print filter config key values===");

        Enumeration<String> configKeys = filterConfig.getInitParameterNames();
        while(configKeys.hasMoreElements())
        {
            String key = configKeys.nextElement();
            String value = filterConfig.getInitParameter(key);
            servletContext.log("key: "+key+" value: "+value);
        }
    }
}
