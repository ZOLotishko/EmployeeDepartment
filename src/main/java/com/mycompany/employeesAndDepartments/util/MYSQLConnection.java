package com.mycompany.employeesAndDepartments.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class MYSQLConnection {
	
	private static final String USER = "root";  
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/mycompany?useEncoding=true&characterEncoding=UTF-8" ;		
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    public static Connection getConnection(){

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("ERROR: can't load mysql driver");
        }

        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
