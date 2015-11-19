package com.mycompany.employeesAndDepartments.dao;

import java.util.List;

import com.mycompany.employeesAndDepartments.entity.Departments;

public interface DepartmentsDAO {
	
	public Departments readDepartmentByID(int id );
    public List<Departments> readDepartments();
    public void createDepartment(Departments department);
    public void updateDepartment(Departments department);
    public void deleteDepartment(int id);

}
