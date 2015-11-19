package com.mycompany.employeesAndDepartments.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import com.mycompany.employeesAndDepartments.dao.EmployeesDAO;
import com.mycompany.employeesAndDepartments.entity.Employees;
import com.mycompany.employeesAndDepartments.util.MYSQLConnection;



public class EmployeesDAOImpl implements EmployeesDAO{



	public Employees readEmployeeByID(int id) {

		Connection connection = MYSQLConnection.getConnection();
		String sql = "Select first_name, last_name, mail, position, salary, date From employees WHERE employees_id = ?";
		ResultSet resultSet = null;
		Employees employee = new Employees();

		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				employee.setFirst_name(resultSet.getString("first_name"));
				employee.setLast_name(resultSet.getString("last_name"));
				employee.setMail(resultSet.getString("mail"));
				employee.setPosition(resultSet.getString("position"));
				employee.setSalary(resultSet.getInt("salary"));
				employee.setDat(resultSet.getDate("date"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return employee;
	}

	public List<Employees> readEmployeeByIDDepartment(int id) {

		Connection connection = MYSQLConnection.getConnection();
		String sql = "Select employees_id, first_name, last_name, mail, position, salary, date, departments_id From employees WHERE departments_id = ?";
		ResultSet resultSet = null;
		List<Employees> employees = new ArrayList<Employees>();

		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){

			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if(resultSet != null){
				while (resultSet.next()) {

					Employees employee = new Employees();	
					employee.setEmployees_id(resultSet.getInt("employees_id"));
					employee.setFirst_name(resultSet.getString("first_name"));
					employee.setLast_name(resultSet.getString("last_name"));
					employee.setMail(resultSet.getString("mail"));
					employee.setPosition(resultSet.getString("position"));
					employee.setSalary(resultSet.getInt("salary"));
					employee.setDat(resultSet.getDate("date"));
//					employee.setDepartments_id(resultSet.getInt("departments_id"));
					employees.add(employee);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return employees;
	}

	public List<Employees> readEmployees() {

		Connection connection = MYSQLConnection.getConnection();
		String sql = "SELECT employees_id, first_name, last_name, mail, position, salary, date , departments_id FROM employees";
		ResultSet resultSet = null;
		List<Employees> employees = new ArrayList<Employees>();
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){

			resultSet = preparedStatement.executeQuery();
			if(resultSet != null){
				while (resultSet.next()) {

					Employees employee = new Employees();
					employee.setEmployees_id(resultSet.getInt("employees_id"));
					employee.setFirst_name(resultSet.getString("first_name"));
					employee.setLast_name(resultSet.getString("last_name"));
					employee.setMail(resultSet.getString("mail"));
					employee.setPosition(resultSet.getString("position"));
					employee.setSalary(resultSet.getInt("salary"));
					employee.setDat(resultSet.getDate("date"));
//					employee.setDepartments_id(resultSet.getInt("departments_id"));

					employees.add(employee);
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
	}

	public void createEmployee(Employees employee) {

		Connection connection = MYSQLConnection.getConnection();
		String sql = "INSERT into employees (first_name, last_name, mail, position, salary, date, departments_id ) VALUES (?,?,?,?,?,?,?)";
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){

			//			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(1, employee.getFirst_name());
			preparedStatement.setString(2, employee.getLast_name());
			preparedStatement.setString(3, employee.getMail());
			preparedStatement.setString(4, employee.getPosition());
			preparedStatement.setInt(5, employee.getSalary());
			preparedStatement.setDate(6,employee.getDat());
			preparedStatement.setInt(7, employee.getDepartments_id());
			preparedStatement.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateEmployee(Employees employee) {

		Connection connection = MYSQLConnection.getConnection();
		String sql = "UPDATE employees SET first_name = ?, last_name = ?, mail = ?, position = ?, salary = ?, date = ? WHERE employees_id = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

			preparedStatement.setString(1, employee.getFirst_name());
			preparedStatement.setString(2, employee.getLast_name());
			preparedStatement.setString(3, employee.getMail());
			preparedStatement.setString(4, employee.getPosition());
			preparedStatement.setInt(5, employee.getSalary());
			preparedStatement.setDate(6, employee.getDat());
			//			preparedStatement.setDate(6, employee.getDate());
			preparedStatement.executeQuery();


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteEmployee(int id) {

		Connection connection = MYSQLConnection.getConnection();
		String sql = "DELETE FROM employees WHERE employees_id = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
