package com.homePageGui;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JFrame;

import com.controller.Controller;

public class FirstPage extends JFrame {
	
	
	private NavigationTab navigationTab;
	private UserStoryPanel userStoryPanel;
	private HomePanel homePanel;
	private Controller controller;

	public FirstPage() throws SQLException {

		super("Dashboard");
		setVisible(true);
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		navigationTab = new NavigationTab();
		userStoryPanel=new UserStoryPanel();
		homePanel=new HomePanel();
		controller=new Controller();

		setLayout(new BorderLayout());
		add(navigationTab, BorderLayout.NORTH);
		add(homePanel,BorderLayout.CENTER);
		
		navigationTab.setNaviListener(new NavigationBarListener() {
			
			@Override
			public void changePanel(String btn) {
				getContentPane().removeAll();
				add(navigationTab, BorderLayout.NORTH);
				if(btn.equalsIgnoreCase("user"))
					add(userStoryPanel,BorderLayout.CENTER);
				else if(btn.equalsIgnoreCase("Home"))
					add(homePanel,BorderLayout.CENTER);
				revalidate();
				repaint();
				
			}

			@Override
			public void disposeFrame() {
				setVisible(false);
				
			}
		});


	}
	
	
	
}
