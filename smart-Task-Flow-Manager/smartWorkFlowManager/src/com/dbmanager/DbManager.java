package com.dbmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

public class DbManager {
	
	public ResultSet getData() throws SQLException {
		
		String s="select * from users_data;";
		Connection con=DbConnector.getConnection();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(s);
		return rs;
	}

public ResultSet loadData() throws SQLException
{
	Connection connection =DbConnector.getConnection();
	String query="select * from story_tasks;";
	ResultSet resultSet =connection.createStatement().executeQuery(query);
	return resultSet;
}

public void saveData(List<String> columns, List<Object[]> data, Set<Integer> modifiedRows) throws SQLException
{
	String query="update story_tasks set status=?,todo=?,actual_time_taken=? where task_id=?;";
	PreparedStatement preparedStatement = DbConnector.getConnection().prepareStatement(query);
	for(int rowIndex:modifiedRows)
	{
		Object[] row=data.get(rowIndex);

		preparedStatement.setObject(1,row[3]);
		preparedStatement.setObject(2,row[5]);
		preparedStatement.setObject(3,row[6]);
		preparedStatement.setObject(4,row[0]);

		preparedStatement.addBatch();
	}
	preparedStatement.executeBatch();
}
}
//	public static void main(String[] args) throws SQLException {
//		String s="select * from user_data;";
//		
//		Connection con=DbConnector.getConnection();
//		Statement stmt=con.createStatement();
//		ResultSet rs=stmt.executeQuery(s);
//		
//		while(rs.next()) {
//			int id=rs.getInt("user_id");
//			System.out.println(id);
//		}
//		
//		con.close();
//	}


