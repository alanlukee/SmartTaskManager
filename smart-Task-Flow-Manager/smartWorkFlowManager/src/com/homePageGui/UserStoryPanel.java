package com.homePageGui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.taskPageGui.TaskPageUI;

public class UserStoryPanel extends JPanel {
	private JTable mainTable;
	private DefaultTableModel tableModel;

	public UserStoryPanel() {

		tableModel = new DefaultTableModel(new Object[] { "User", "Estimated Time", "Actual Time", "Todo", "UserStory Details" }, 0) {
			public boolean isCellEditable(int row, int coloumn) {
				return coloumn == 4 ;
			}
		};
		mainTable = new JTable(tableModel);

//		mainTable.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
//		mainTable.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor("Add Task"));

		mainTable.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
		mainTable.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor("Details"));

		setLayout(new BorderLayout());
		add(new JScrollPane(mainTable), BorderLayout.CENTER);

		addRowToTable("User Story 1", "5 hrs", "4 hrs", "1 hrs");
		addRowToTable("User Story 1", "5 hrs", "4 hrs", "1 hrs");
	}

	public void addRowToTable(String userStory, String estimatedTime, String actualTime, String toDo) {
		tableModel.addRow(new Object[] { userStory, estimatedTime, actualTime, toDo, "Details" });
	}

	static class ButtonRenderer extends JButton implements TableCellRenderer {

		public ButtonRenderer() {
			setOpaque(true);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setText(value != null ? value.toString() : "");
			return this;
		}

	}

	static class ButtonEditor extends DefaultCellEditor {
		private JButton btn;
		private String label;

		public ButtonEditor(String buttonText) {
			super(new JTextField());
			btn = new JButton(buttonText);
			btn.setOpaque(true);
			
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new TaskPageUI();
					
				}
			});

		}

		@Override
		public Object getCellEditorValue() {
			return label;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			label = value != null ? value.toString() : "";
			btn.setText(label);
			return btn;
		}
	}

}
