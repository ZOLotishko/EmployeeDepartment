package com.mycompany.employeesAndDepartments.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity  
@Table(name="employees")
public class Employees implements Serializable{ 
	
	@Column( name = "employees_id")
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int employees_id;
	
	@Column( name = "first_name")
	private String first_name;
	
	@Column( name = "last_name")
	private String last_name;
	
	@Column( name = "mail")
	private String mail;
	
	@Column( name = "position")
	private String position;
	
	@Column( name = "salary")
	private int salary;
	
	@Column( name = "date")
	private Date dat;
		
	@Column( name = "departments_id")	
	private int departments_id;
//	private Departments departments_id;
	
	public Employees(){
		super();
	}
//	public Employees(String first_name, String last_name, String mail, String position, int salary, Date dat){
//		this.first_name = first_name;
//		this.last_name = last_name;
//		this.mail = mail;
//		this.position = position;
//		this.salary = salary;
//		this.dat = dat;
//	}
//	public Employees(String first_name, String last_name, String mail, String position, int salary, Date dat, int idd){
//		this.first_name = first_name;
//		this.last_name = last_name;
//		this.mail = mail;
//		this.position = position;
//		this.salary = salary;
//		this.dat = dat;
//		this.departments_id = idd;
//	}
//	public Employees(int employees_id, String first_name, String last_name, String mail, String position, int salary, Date dat){
//		this.employees_id = employees_id;
//		this.first_name = first_name;
//		this.last_name = last_name;
//		this.mail = mail;
//		this.position = position;
//		this.salary = salary;
//		this.dat = dat;
//	}
//	public Employees(int employees_id, String first_name, String last_name, String mail, String position, int salary, Date dat, int idd){
//		this.employees_id = employees_id;
//		this.first_name = first_name;
//		this.last_name = last_name;
//		this.mail = mail;
//		this.position = position;
//		this.salary = salary;
//		this.dat = dat;
//		this.departments_id = idd;
//	}
	
	public int getEmployees_id() {
		return employees_id;
	}
	public void setEmployees_id(int employees_id) {
		this.employees_id = employees_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getDat() {
		return dat;
	}
	public void setDat(Date dat) {
		this.dat = dat;
	}
	
//	public int getDepartments_id() {
//		return departments_id;
//	}
//	public void setDepartments_id(int departments_id) {
//		this.departments_id = departments_id;
//	}
	
	@Override
	public String toString() {
		return "Employees [id=" + employees_id + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", mail=" + mail + ", position="
				+ position + ", salary=" + salary + ", dat=" + dat
				+ ", departments_id=" + departments_id + "]";
	}

	public int getDepartments_id() {
		return departments_id;
	}

	public void setDepartments_id(int departments) {
		this.departments_id = departments;
	}
}
