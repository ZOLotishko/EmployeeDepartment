package com.mycompany.employeesAndDepartments.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.mycompany.employeesAndDepartments.dao.DepartmentsDAO;
import com.mycompany.employeesAndDepartments.entity.Departments;
import com.mycompany.employeesAndDepartments.util.HibernateUtil;

public class HiberDepartmentsDaoImpl implements DepartmentsDAO{

	@Override
	public Departments readDepartmentByID(int id) {
		Departments department = null;
		Session session = null;

		try{
			session = HibernateUtil.getSessionFactory().openSession();
			department = (Departments) session.load(Departments.class, id);

		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if((session != null) && (session.isOpen())){
				session.close();
			}
		}
		return department;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departments> readDepartments() {

		List<Departments> department = null;
		Session session = null;

		try{
			session = HibernateUtil.getSessionFactory().openSession();
			department = session.createCriteria(Departments.class).list();

		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if((session != null) && (session.isOpen())){
				session.close();
			}
		}
		return department;
	}

	@Override
	public void createDepartment(Departments department) {
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(department);
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
	public void updateDepartment(Departments department) {
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(department);
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
	public void deleteDepartment(int id) {

		Session session = null;
		Departments department;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			department = (Departments)session.load(Departments.class,id);
			session.delete(department);
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
