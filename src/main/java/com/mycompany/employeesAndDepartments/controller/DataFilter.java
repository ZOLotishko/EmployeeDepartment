package com.mycompany.employeesAndDepartments.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



public class DataFilter implements Filter{
	
	private String encoding;
 
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	encoding = filterConfig.getInitParameter("requestEncoding");
    	if( encoding == null) encoding = "UTF-8";
//    	if( encoding==null ) encoding="Cp1251";
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);}
 
    @Override
    public void destroy() {}
}

//
//<filter>
//<filter-name>DepartmentFilter</filter-name>
//<filter-class>com.mycompany.employeesAndDepartments.servlet.DataFilter</filter-class>
//</filter>
//
//<filter-mapping>
//<filter-name>DepartmentFilter</filter-name>
//<url-pattern>/*</url-pattern>
//</filter-mapping>
