package com.dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
	private static final String URL="jdbc:mysql://localhost:3306/task_manager_app";
	private static final String USERNAME="root";
	private static final String PASSWORD="Test1234";
	
	public static Connection getConnection()throws SQLException{
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}

}
