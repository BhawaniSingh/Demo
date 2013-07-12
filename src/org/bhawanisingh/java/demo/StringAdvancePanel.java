package org.bhawanisingh.java.demo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.bhawanisingh.java.demo.String.StringDemo;

/**
 *
 */
public class StringAdvancePanel extends JPanel {

	private JPanel textfieldPanel;
	private JLabel mainLabel;
	private JTextField mainTextField;
	private JLabel searchLabel;
	private JTextField searchTextField;
	private JLabel replaceLabel;
	private JTextField replaceTextField;

	private JPanel buttonPanel;
	private ButtonGroup buttonGroup;
	private JRadioButton compareRadioButton;
	private JRadioButton equalsRadioButton;
	private JRadioButton findRadioButton;
	private JRadioButton replaceRadioButton;
	private JPanel submitPanel;
	private JButton submitButton;

	private Main main;

	/**
	 * 
	 */
	public StringAdvancePanel(Main main) {
		this.main = main;
		this.initialize();
		this.addComponents();
		this.addListeners();
	}

	private void initialize() {
		this.setLayout(new BorderLayout(10, 10));
		this.textfieldPanel = new JPanel(new GridBagLayout());
		this.mainLabel = new JLabel("String");
		this.mainTextField = new JTextField(30);
		this.searchLabel = new JLabel("Search");
		this.searchTextField = new JTextField(30);
		this.replaceLabel = new JLabel("Replace");
		this.replaceTextField = new JTextField(30);

		this.buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.buttonGroup = new ButtonGroup();
		this.compareRadioButton = new JRadioButton("Compare");
		this.equalsRadioButton = new JRadioButton("Equals");
		this.findRadioButton = new JRadioButton("Find");
		this.replaceRadioButton = new JRadioButton("Replace");

		this.buttonGroup.add(this.compareRadioButton);
		this.buttonGroup.add(this.equalsRadioButton);
		this.buttonGroup.add(this.findRadioButton);
		this.buttonGroup.add(this.replaceRadioButton);

		this.submitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.submitButton = new JButton("Submit");
	}

	private void addComponents() {
		Layout.add(this.textfieldPanel, this.mainLabel, 0, 0, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE);
		Layout.add(this.textfieldPanel, this.mainTextField, 1, 0, 1, 1, 0, 100, GridBagConstraints.EAST, GridBagConstraints.BOTH);

		Layout.add(this.textfieldPanel, this.searchLabel, 0, 1, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE);
		Layout.add(this.textfieldPanel, this.searchTextField, 1, 1, 1, 1, 0, 100, GridBagConstraints.EAST, GridBagConstraints.BOTH);

		Layout.add(this.textfieldPanel, this.replaceLabel, 0, 2, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE);
		Layout.add(this.textfieldPanel, this.replaceTextField, 1, 2, 1, 1, 0, 100, GridBagConstraints.EAST, GridBagConstraints.BOTH);

		this.buttonPanel.add(this.compareRadioButton);
		this.buttonPanel.add(this.equalsRadioButton);
		this.buttonPanel.add(this.findRadioButton);
		this.buttonPanel.add(this.replaceRadioButton);

		this.submitPanel.add(this.submitButton);

		this.add(this.textfieldPanel, BorderLayout.NORTH);
		this.add(this.buttonPanel, BorderLayout.CENTER);
		this.add(this.submitPanel, BorderLayout.SOUTH);
	}

	private void addListeners() {
		this.submitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StringAdvancePanel.this.submitAction();

			}
		});
	}

	private void submitAction() {

		if (this.findRadioButton.isSelected()) {
			System.out.println("Find :\t" + StringDemo.find(this.mainTextField.getText(), this.searchTextField.getText()));
		} else if (this.replaceRadioButton.isSelected()) {
			System.out.println("Replace :\t" + StringDemo.replace(this.mainTextField.getText(), this.searchTextField.getText(), this.replaceTextField.getText()));
		} else if (this.equalsRadioButton.isSelected()) {
			System.out.println("Equals :\t" + StringDemo.equals(this.mainTextField.getText(), this.searchTextField.getText()));
		} else if (this.compareRadioButton.isSelected()) {
			System.out.println("Compare :\t" + StringDemo.compare(this.mainTextField.getText(), this.searchTextField.getText()));
		} else {
			System.out.println("Error !!! No option selected");
		}

	}

}
