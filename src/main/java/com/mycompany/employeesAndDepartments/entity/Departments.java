package com.mycompany.employeesAndDepartments.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity    
@Table(name="departments")
public class Departments implements Serializable{ 

	 
	@Id
	@Column( name = "id")
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "specification")
	private String specification;

	public Departments(){
		super();
	}
	
	public Departments(int id , String name){
		this.id = id;
		this.name = name;
		
	}

	public Departments(String name, String specification){
		this.name = name;
		this.specification = specification;
	}

	public Departments(int id, String name, String specification){
		super();
		this.id = id;
		this.name = name;
		this.specification = specification;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	@Override
	public String toString() {
		return "Departments [id=" + id + 
				", name=" + name + 
				", specification="	+ specification + "]";
	}


}
