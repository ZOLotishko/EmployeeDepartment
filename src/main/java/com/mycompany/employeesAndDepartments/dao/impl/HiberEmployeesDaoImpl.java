package com.mycompany.employeesAndDepartments.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.mycompany.employeesAndDepartments.dao.EmployeesDAO;
import com.mycompany.employeesAndDepartments.entity.Employees;
import com.mycompany.employeesAndDepartments.util.HibernateUtil;

public class HiberEmployeesDaoImpl implements EmployeesDAO{

	@Override
	public Employees readEmployeeByID(int id) {

		Employees employee = null;
		Session session = null;

		try{
			session = HibernateUtil.getSessionFactory().openSession();
			employee = (Employees) session.load(Employees.class, id);

		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if((session != null) && (session.isOpen())){
				session.close();
			}
		}
		return employee;
	}

	@Override
	public List<Employees> readEmployees() {

		List<Employees> employees = null;
		Session session = null;

		try{
			session = HibernateUtil.getSessionFactory().openSession();
			employees = session.createCriteria(Employees.class).list();

		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if((session != null) && (session.isOpen())){
				session.close();
			}
		}
		return employees;
	}

	@Override
	public void createEmployee(Employees employee) {
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(((session != null) && (session.isOpen()))){
				session.close();
			}
		}	
	}

	@Override
	public void updateEmployee(Employees employee) {
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(employee);
			session.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(((session != null) && (session.isOpen()))){
				session.close();
			}
		}	
	}

	@Override
	public void deleteEmployee(int id) {

		Session session = null;
		Employees employee;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			employee = (Employees) session.load(Employees.class,id);
			session.delete(employee);
			session.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(((session != null) && (session.isOpen()))){
				session.close();
			}
		}	
	}
}
