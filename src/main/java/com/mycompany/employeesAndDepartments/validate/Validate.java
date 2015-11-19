package com.mycompany.employeesAndDepartments.validate;

import java.util.Map;

public interface Validate {  
	
	public Map<String, String> getMessagesMap();
    public void validate();

}
