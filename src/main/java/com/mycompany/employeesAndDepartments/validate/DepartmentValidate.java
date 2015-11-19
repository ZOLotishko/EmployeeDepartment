package com.mycompany.employeesAndDepartments.validate;

import java.util.HashMap;
import java.util.Map;

import com.mycompany.employeesAndDepartments.dao.impl.DepartmentsDAOImpl;
import com.mycompany.employeesAndDepartments.entity.Departments;


public class DepartmentValidate implements Validate{

	private Map<String, String> errors;
	private DepartmentsDAOImpl departmentsDAO ;

	private String name;
	private String specification;

	public DepartmentValidate( String name, String specification ) {
		errors = new HashMap<>();
		departmentsDAO = new DepartmentsDAOImpl();
		this.name = name;
		this.specification = specification;

	}

	@Override
	public Map<String, String> getMessagesMap() {
		return errors;
	}

	@Override
	public void validate() {
		checkName( name);
		checkSpecification(specification);
	}

	private void checkName( String name) {

		Departments department = new Departments();
		department = departmentsDAO.checkName( name);


		if (name.equals("")){
			errors.put("name", "Pls, Enter name department");
		}
		if (name.length() < 2){
			errors.put("name", "Name department so short");
		}
		if (name.length() > 25){
			errors.put("name", "Name department so long");
		}
		if (department.getId() != 0){
			errors.put("name", "Name Exist");
		}
	}

	private void checkSpecification(String specification){
		if (specification.equals("")){
			errors.put("specification", "Pls, Enter specification");
		}
	}
}
