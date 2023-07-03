package com.messi.demo.core.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;

@Component
public class AccessFilter implements Filter {

    private final static Logger logger = LoggerFactory.getLogger(AccessFilter.class) ;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("doFilter -- across the Filter") ;
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest ;

        Enumeration<String> headers = httpServletRequest.getHeaderNames();
        if( headers != null ) {
            Iterator<String> itr = headers.asIterator();
            while( itr.hasNext() ) {
                String header = itr.next() ;
                String value = httpServletRequest.getHeader(header) ;

                //logger.info("Request header : [{}] -- [{}]", header, value) ;
            }
        }

        // continue to access
        filterChain.doFilter(servletRequest, servletResponse);

        // return error page
        //PrintWriter writer = servletResponse.getWriter(); //
        //writer.write("<html><h1>error error error</h1></html>");
    }
}
