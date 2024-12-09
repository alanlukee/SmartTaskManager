package com.taskPageGui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import com.controller.Controller;


public	class TaskTableModel extends AbstractTableModel
	{
		private final List<String> columns=new ArrayList<>();
		private final List<Object[]> data = new ArrayList<>();
		private final Set<Integer> modifiedRows=new HashSet<>();
		private Connection connection;
		private Controller controller;

		public TaskTableModel(ResultSet resultSet,Connection connection) throws SQLException 
		{
			controller=new Controller();
			this.connection = connection;
			ResultSetMetaData metaData=resultSet.getMetaData();
			int columnCount=metaData.getColumnCount();

			for(int i=1;i<=columnCount;i++ )
			{
				columns.add(metaData.getColumnName(i));
			}

			while(resultSet.next())
			{
				Object[] row=new Object[columnCount];
				for(int i=1;i<=columnCount;i++ )
				{
					row[i-1]=resultSet.getObject(i);
				}
				data.add(row);
			}
		}


		@Override
		public int getRowCount() {
			return data.size();
		}

		@Override
		public int getColumnCount() {
			return columns.size();
		}

		@Override
		public Object getValueAt(int row, int column) {

			return data.get(row)[column];
		}

		@Override
		public String getColumnName(int column) {
			return columns.get(column);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return column!=0 & column!=1 & column!=2 & column!=4;//cannot edit the id
		}

		@Override
		public void setValueAt(Object value, int row, int column) {
			data.get(row)[column]=value;

			modifiedRows.add(row);

			fireTableCellUpdated(row, column);
		}

		@Override
		public Class<?> getColumnClass(int columnIndex)//for ensuring that the column supports the string dropdown 
		{
			return String.class;
		}
		public void saveChanges() 
		{
			if(modifiedRows.isEmpty())
			{
				JOptionPane.showMessageDialog(null,"No changes to save");
				return;
			}

			try
			{
				
				controller.saveData(columns,data,modifiedRows);
				
				modifiedRows.clear();

				JOptionPane.showMessageDialog(null,"Changes saved successfully");

			}
			
			catch (SQLException e)
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"Failed to update database:" +e.getMessage());
			}
			

		}
	}

