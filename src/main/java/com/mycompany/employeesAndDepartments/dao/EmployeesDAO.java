package com.mycompany.employeesAndDepartments.dao;

import java.util.List;

import com.mycompany.employeesAndDepartments.entity.Employees;

public interface EmployeesDAO {
	
	public Employees readEmployeeByID(int id );
    public List<Employees> readEmployees();
    public void createEmployee(Employees employee);
    public void updateEmployee(Employees employee);
    public void deleteEmployee(int id);

}
