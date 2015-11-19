package com.mycompany.employeesAndDepartments.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.employeesAndDepartments.dao.impl.EmployeesDAOImpl;

@SuppressWarnings("serial")
public class EmployeeDeleteController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("delete"));
        
            EmployeesDAOImpl daoImpl = new EmployeesDAOImpl();
            daoImpl.deleteEmployee(id);
            response.sendRedirect("/employeesAndDepartments/listDepartment");
        
    }

}
