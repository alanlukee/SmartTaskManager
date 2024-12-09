package com.dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDbManager {

	private static final String URL="jdbc:mysql://localhost:3306/task_manager_app";
	private static final String USER="root";
	private static final String PASSWORD="Test1234";
	
	public boolean authenticate(String username,String password) {
		String query="SELECT user_id,pasword FROM users_data WHERE Username = ?";
		try(Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement statement=con.prepareStatement(query)){
			statement.setString(1,username);
			ResultSet resultSet=statement.executeQuery();
			if(resultSet.next()) {
				String storedPassword=resultSet.getString("pasword");
				return storedPassword.equals(password);
			}
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
				
		
	}
		
		
	
}

