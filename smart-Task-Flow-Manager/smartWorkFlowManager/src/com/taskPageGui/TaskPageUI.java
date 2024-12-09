package com.taskPageGui;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.TableColumn;

import com.controller.Controller;




public class TaskPageUI extends JFrame{

	private JComboBox<String> statusBox;
	private TaskTableModel model;
	private JTable table;
	private TableColumn statusColumn;
	private JButton saveButton;
	private Controller controller;

	public TaskPageUI()
	{
		controller=new Controller();
		
		try
		{

			TaskTableModel tablemodel=new TaskTableModel(controller.loadData(),controller.getConnector());
			table=new JTable(tablemodel);


			String[] dropDownOptions = {"Pending","In Progress","Completed","Blocked"};
			statusBox=new JComboBox<>(dropDownOptions);
			statusColumn =table.getColumnModel().getColumn(3);
			statusColumn.setCellEditor(new DefaultCellEditor(statusBox));

			saveButton=new JButton("Save");

			add(saveButton,BorderLayout.SOUTH);

			saveButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					tablemodel.saveChanges();
				}

			});

			add(new JScrollPane(table),BorderLayout.NORTH);
			setSize(600,500);
			setLocationRelativeTo(null);
			setVisible(true);
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,"Error connecting to database"+e.getMessage());
		}



	}


}

