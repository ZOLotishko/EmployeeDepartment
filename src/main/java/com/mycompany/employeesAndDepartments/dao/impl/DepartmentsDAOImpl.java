package com.mycompany.employeesAndDepartments.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.employeesAndDepartments.dao.DepartmentsDAO;
import com.mycompany.employeesAndDepartments.entity.Departments;
import com.mycompany.employeesAndDepartments.util.MYSQLConnection;

public class DepartmentsDAOImpl implements DepartmentsDAO{

	@Override
	public Departments readDepartmentByID(int id) {

		Connection connection = MYSQLConnection.getConnection();
		String sql = "SELECT id, name , specification FROM departments WHERE id = ?";
		ResultSet resultSet = null;
		Departments department = new Departments();
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				department.setId(resultSet.getInt("id"));
				department.setName(resultSet.getString("name"));
				department.setSpecification(resultSet.getString("specification"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return department;
	}

	@Override
	public List<Departments> readDepartments() {

		Connection connection = MYSQLConnection.getConnection();
		String sql = "SELECT id, name, specification FROM departments ";
		List<Departments> departments = new ArrayList<Departments>();
		ResultSet resultSet = null;

		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null){
				while (resultSet.next()) {

					Departments department = new Departments();
					department.setId(resultSet.getInt("id"));
					department.setName(resultSet.getString("name"));
					department.setSpecification(resultSet.getString("specification"));
					departments.add(department);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return departments;
	}

	@Override
	public void createDepartment(Departments department) {

		Connection connection = MYSQLConnection.getConnection();
		String sql = "INSERT into departments ( name, specification) VALUES (?,?)";
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			//			preparedStatement.setInt(1, department.getId());
			preparedStatement.setString(1, department.getName());
			preparedStatement.setString(2, department.getSpecification());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateDepartment(Departments department) {
		Connection connection = MYSQLConnection.getConnection();
		String sql = "UPDATE departments SET name = ? , specification = ? WHERE id = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

			preparedStatement.setString(1, department.getName());
			preparedStatement.setString(2, department.getSpecification());
			preparedStatement.setInt(3, department.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteDepartment(int id) {
		Connection connection = MYSQLConnection.getConnection();
		String sql ="DELETE FROM departments WHERE id = ? ";
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Departments checkName( String name)  {
		Connection connection = MYSQLConnection.getConnection();
		Departments department = new Departments();

		String sql = "SELECT * FROM departments WHERE name = ? ";
		ResultSet resultSet = null;
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, name);
//			preparedStatement.setInt(2, id);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				department.setId(resultSet.getInt("id"));
				department.setName(resultSet.getString("name"));
				department.setSpecification(resultSet.getString("specification"));
			}
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return department;
	}
}
