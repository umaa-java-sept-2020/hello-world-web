package com.java.filters;

import javax.servlet.*;
import java.io.IOException;

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
}
