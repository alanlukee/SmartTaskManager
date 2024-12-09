package com.homePageGui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewUserStoryPage extends JFrame {
	private JLabel userStory;
	private JTextField userStoryName;
	private JButton nextBtn;
	
	public NewUserStoryPage() {
		
		setSize(200,300);
		setVisible(true);
		
		userStory=new JLabel("Name: ");
		userStoryName=new JTextField(10);
		nextBtn=new JButton("Next>>");
		
		nextBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();
		
		
		gc.gridy = 0;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(userStory, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(userStoryName, gc);
		
		gc.gridy++;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(nextBtn, gc);
		
		
		
	}

}
