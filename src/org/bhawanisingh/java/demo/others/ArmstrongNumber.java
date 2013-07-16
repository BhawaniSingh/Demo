package org.bhawanisingh.java.demo.others;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.bhawanisingh.java.demo.Layout;

public class ArmstrongNumber extends javax.swing.JFrame {

	private JButton checkButton;
	private JPanel mainPanel;
	private JTextField numField;
	private JLabel numLabel;
	private JLabel resultLabel;
	private JPanel buttonPanel;

	public ArmstrongNumber() {
		super("Demo - Armstrong Check");
		this.initialize();
		this.addComponents();
		this.theming();
		this.addListeners();
		this.mainPanel.setOpaque(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
	}

	private void initialize() {

		this.mainPanel = new JPanel(new GridBagLayout());
		this.numLabel = new JLabel("Enter A Number : ");
		this.numField = new JTextField(30);
		this.checkButton = new JButton("Check");
		this.buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.resultLabel = new JLabel(" ");

	}

	private void addComponents() {

		this.buttonPanel.add(this.checkButton);
		Layout.add(this.mainPanel, this.numLabel, 0, 0, 2, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE);
		Layout.add(this.mainPanel, this.numField, 2, 0, 2, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		Layout.add(this.mainPanel, this.resultLabel, 0, 1, 4, 1, 100, 0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		Layout.add(this.mainPanel, this.buttonPanel, 0, 2, 4, 1, 100, 0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		this.add(this.mainPanel);

	}

	private void theming() {
		this.mainPanel.setBackground(new java.awt.Color(255, 255, 255));
		this.buttonPanel.setBackground(new java.awt.Color(255, 255, 255));
		this.resultLabel.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18));
		this.setBackground(new java.awt.Color(255, 255, 255));
		this.numField.setBackground(new java.awt.Color(240, 240, 240));
	}

	private void addListeners() {
		this.checkButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ArmstrongNumber.this.checkArmstrong();
			}
		});
	}

	private void checkArmstrong() {
		int len = this.numField.getText().trim().toCharArray().length;
		if (len != 0) {
			long num = Integer.parseInt(this.numField.getText().trim());
			long sum = 0L;
			long temp = num;
			while (temp > 0) {
				sum = (long) (sum + java.lang.Math.pow(temp % 10, len));
				temp = temp / 10;
			}
			if (sum == num) {
				this.resultLabel.setForeground(Color.black);
				this.resultLabel.setText("Number Is ArmStrong");
			} else {
				this.resultLabel.setForeground(Color.red);
				this.resultLabel.setText("Number Is Not ArmStrong");
			}
		}
	}

	public static void main(String args[]) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new ArmstrongNumber();
	}
}
