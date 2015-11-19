package com.mycompany.employeesAndDepartments.validate;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mycompany.employeesAndDepartments.dao.impl.EmployeesDAOImpl;

public class EmployeeValidate implements Validate{ 
	
	private Map<String, String> error;
	EmployeesDAOImpl daoImpl ;
	
	private String first_name;
	private String last_name;
	private String email;
	private String position;
	private String salary;
	private String date;
	
	private Pattern pattern;
    private Matcher matcher;
 
    private static final String EMAIL_PATTERN =
                    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
 
//    public EmailValidator() {
//        pattern = Pattern.compile(EMAIL_PATTERN);
//    }
 
//    public boolean validate(final String hex) {
//        matcher = pattern.matcher(hex);
// 
//        return matcher.matches();
//    }
	

	public EmployeeValidate(String first_name, String last_name, String email, String position, String salary, String date){
		daoImpl = new EmployeesDAOImpl();
		error = new HashMap<String, String>();
		pattern = Pattern.compile(EMAIL_PATTERN);
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.position = position;
		this.salary = salary;
		this.date = date;
		
	}
	@Override
	public Map<String, String> getMessagesMap() {
		return error;
	}

	@Override
	public void validate() {
		
		checkFirstName(first_name);
		checkLasttName(last_name);
		checkEmail(email);
		checkPosition(position);
		checkSalary(salary);
		chrckDate(date);
		
	}
	
	private void checkFirstName(String first_name){
		if (first_name.equals(""))
            error.put("first_name", "Pls Enter first name!");
        else if (first_name.length() < 3)
            error.put("first_name", "So short first name");
        else if (first_name.length() > 15)
            error.put("first_name", "So long first name");
	}
	
	private void checkLasttName(String last_name){
		if (last_name.equals(""))
            error.put("last_name", "Pls Enter last name!");
        else if (last_name.length() < 3)
            error.put("last_name", "So short last name");
        else if (last_name.length() > 15)
            error.put("last_name", "So long last name");
	}
	
	private void checkEmail( String email){
		matcher = pattern.matcher(email);		
		if(email.equals("")){
			error.put("email","Pls Enter email");
		}
	}
	
	private void checkPosition(String position){
		if(position.equals("")){
			error.put("position", "Pls Enter position!");
		}
	}

	private void checkSalary(String salary){
		if(salary.equals("")){
			error.put("salary", "Pls Enter salary!");
		}
	}
	private void chrckDate(String date){
		if(date.equals("")){
			error.put("dat", "Pls Enter date!");
		}
		
	}
}
