package com.homePageGui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.loginGui.LoginUI;

public class NavigationTab extends JToolBar  {

	private JButton logoutBtn;
	private JButton homeBtn;
	private JButton userBtn;
	private NavigationBarListener listener;
	
	

	public NavigationTab() {

		homeBtn = new JButton("Home");
		logoutBtn = new JButton("Logout");
		userBtn=new JButton("User Story");
		
		logoutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				listener.disposeFrame();
				new LoginUI().displayLoginWindow();

			}
		});

		homeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener.changePanel("Home");

			}
		});
		
		userBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.changePanel("User");
				
			}
		});

		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(homeBtn);
		add(logoutBtn);
		add(userBtn);

	}
	
	public void setNaviListener(NavigationBarListener listener)
	{
		this.listener=listener;
	}
	
	

	
	}

