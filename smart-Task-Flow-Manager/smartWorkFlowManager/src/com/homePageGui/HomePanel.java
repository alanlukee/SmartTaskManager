package com.homePageGui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.controller.Controller;
import com.dbmanager.DbConnector;

public class HomePanel extends JPanel {

	private JLabel label;
	private JTextArea textArea;
	private Controller controller;
	
	public HomePanel() throws SQLException {
		controller=new Controller();
		textArea=new JTextArea();
		
		ResultSet rs=controller.getData();
		while(rs.next()) {
			textArea.append(rs.getString("username")+"\n");
			
		}
		
//		label=new JLabel("Welcome to Your Project");
//		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		setLayout(new BorderLayout());
		add(textArea,BorderLayout.CENTER);
		
		
		
	}
}
