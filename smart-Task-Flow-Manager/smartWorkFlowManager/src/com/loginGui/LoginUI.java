package com.loginGui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.dbmanager.LoginDbManager;
import com.homePageGui.FirstPage;

public class LoginUI extends JFrame {

	private JLabel usernameLabel;
	private JTextField usernameField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JButton loginButton;


	public void displayLoginWindow() {

		usernameLabel = new JLabel("Username: ");
		usernameField = new JTextField(10);
		passwordLabel = new JLabel("Password: ");
		passwordField = new JPasswordField(10);
		loginButton = new JButton("Login");

		loginButton.addActionListener(e->{
			String username=usernameField.getText().trim();
			String password=new String(passwordField.getPassword());

			if(username.isEmpty()||password.isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Username or Password Cannot be Empty!","Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else 
			{
				LoginDbManager manager=new LoginDbManager();
				if(manager.authenticate(username, password))
				{
					JOptionPane.showMessageDialog(this, "Login Successfull!");
					dispose();
					try 
					{
						new FirstPage();
					}
					catch (SQLException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();//edit
					}

				}
				else {
					JOptionPane.showMessageDialog(this, "Invalid Credentials");
				}
			}
		});

		ImageIcon icon=new ImageIcon(LoginUI.class.getResource(""));
		setSize(200, 200);
		setVisible(true);
		setTitle("Login");
		setMinimumSize(new Dimension(400,400));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		layoutComponents();

	}

	public void layoutComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		/////////// FIRST ROW///////////////////////
		gc.weightx = 1;
		gc.weighty=0.02;


		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_END;

		gc.insets = new Insets(100, 0, 0, 5);
		add(usernameLabel, gc);


		gc.gridx++;
		gc.anchor = GridBagConstraints.LINE_START;
		add(usernameField, gc);

		/////////// NEXT ROW///////////////////////
		gc.weightx = 1;
		gc.weighty=0.1;

		gc.gridx = 0;
		gc.gridy++;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(20, 0, 0, 5);

		add(passwordLabel, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(passwordField, gc);

		///////////NEXT ROW///////////////////////
		gc.weightx = 1;
		gc.weighty = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx=1;
		gc.gridy++;
		add(loginButton, gc);



	}

}
