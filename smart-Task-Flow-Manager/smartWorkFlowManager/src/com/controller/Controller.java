package com.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.dbmanager.DbConnector;
import com.dbmanager.DbManager;

public class Controller {

	private DbManager dbManager;
	
	public Controller() {
		dbManager=new DbManager();
	}
	
	public ResultSet getData() throws SQLException {
		ResultSet rs=dbManager.getData();
		return rs;
	}
	public ResultSet loadData() throws SQLException
	{
		ResultSet rs=dbManager.loadData();
		return rs;
	}
	public Connection getConnector() throws SQLException 
	{
		Connection connection =DbConnector.getConnection();
		return connection;
	}
	public void saveData(List<String> columns, List<Object[]> data, Set<Integer> modifiedRows) throws SQLException
	
	{
		dbManager.saveData(columns,data,modifiedRows);
	}
	
	
	
}
