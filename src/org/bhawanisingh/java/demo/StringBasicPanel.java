package org.bhawanisingh.java.demo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import org.bhawanisingh.java.demo.String.StringDemo;

/**
 *
 */
public class StringBasicPanel extends JPanel {

	private JTextField textField;
	private JPanel buttonPanel;

	private ButtonGroup buttonGroup;
	private JRadioButton wordCountRadioButton;
	private JRadioButton spaceCountRadioButton;
	private JRadioButton charCountRadioButton;
	private JRadioButton reverseRadioButton;
	private JRadioButton pallindromeRadioButton;
	private JRadioButton leftTrimRadioButton;
	private JRadioButton rightTrimRadioButton;
	private JRadioButton trimRadioButton;
	private JRadioButton squeezeRadioButton;
	private JRadioButton vowelCountRadioButton;
	private JRadioButton lengthRadioButton;
	private JRadioButton sequenceCountRadioButton;
	private JRadioButton freqCountCharRadioButton;
	private JRadioButton changeCaseRadioButton;
	private JRadioButton singleOccuranceButton;
	private JRadioButton sortedOrderRadioButton;
	private JRadioButton sortedWordRadioButton;
	private JRadioButton wordTriangleType1RadioButton;
	private JRadioButton wordTriangleType2RadioButton;
	private JRadioButton wordTriangleType3RadioButton;
	private JRadioButton wordTriangleType4RadioButton;

	private Main main;

	/**
	 * 
	 */
	public StringBasicPanel(Main main) {
		this.main = main;
		this.initialize();
		this.addListeners();
		this.theming();
		this.addComponents();
	}

	private void initialize() {

		this.setLayout(new BorderLayout());
		this.textField = new JTextField("Enter A String");
		this.buttonGroup = new ButtonGroup();
		this.buttonPanel = new JPanel(new GridLayout(10, 3));

		this.wordCountRadioButton = new JRadioButton("Word Count");
		this.spaceCountRadioButton = new JRadioButton("Space Count");
		this.charCountRadioButton = new JRadioButton("Char Count");
		this.reverseRadioButton = new JRadioButton("Reverse");
		this.pallindromeRadioButton = new JRadioButton("Pallindrome");
		this.leftTrimRadioButton = new JRadioButton("Lefft Trim");
		this.rightTrimRadioButton = new JRadioButton("Right Trim");
		this.trimRadioButton = new JRadioButton("Trim");
		this.squeezeRadioButton = new JRadioButton("Squeeze");
		this.vowelCountRadioButton = new JRadioButton("Vowel Count");
		this.lengthRadioButton = new JRadioButton("String Length");
		this.sequenceCountRadioButton = new JRadioButton("Sequence Count");
		this.freqCountCharRadioButton = new JRadioButton("Char Freq Count");
		this.changeCaseRadioButton = new JRadioButton("Change Case");
		this.singleOccuranceButton = new JRadioButton("Single Occurance");
		this.sortedOrderRadioButton = new JRadioButton("Sorted Order");
		this.sortedWordRadioButton = new JRadioButton("Sort Words");
		this.wordTriangleType1RadioButton = new JRadioButton("Triangle Type 1");
		this.wordTriangleType2RadioButton = new JRadioButton("Triangle Type 2");
		this.wordTriangleType3RadioButton = new JRadioButton("Triangle Type 3");
		this.wordTriangleType4RadioButton = new JRadioButton("Triangle Type 4");
	}

	private void addListeners() {
		this.wordCountRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBasicPanel.this.main.clearOutput();
				System.out.print("Number of words in the above string is :\t");
				System.out.println(StringDemo.wordCount(StringBasicPanel.this.textField.getText()));
			}
		});

		this.spaceCountRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBasicPanel.this.main.clearOutput();
				System.out.print("Number of spaces in the above string is :\t");
				System.out.println(StringDemo.spaceCount(StringBasicPanel.this.textField.getText()));
			}
		});

		this.charCountRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBasicPanel.this.main.clearOutput();
				System.out.print("Number of spaces in the above string is :\t");
				System.out.println(StringDemo.charCount(StringBasicPanel.this.textField.getText()));
			}
		});

		this.reverseRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBasicPanel.this.main.clearOutput();
				System.out.print("Reverse of above string is :\t");
				System.out.println(StringDemo.reverseString(StringBasicPanel.this.textField.getText()));
			}
		});

		this.pallindromeRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBasicPanel.this.main.clearOutput();
				System.out.print("The above String is ");
				if (!StringDemo.pallindrome(StringBasicPanel.this.textField.getText())) {
					System.out.print("not ");
				}
				System.out.println("a pallindrome");
			}
		});

		this.leftTrimRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBasicPanel.this.main.clearOutput();
				System.out.println("Above String after removing all the spaces from left :\t");
				System.out.println(StringDemo.lTrim(StringBasicPanel.this.textField.getText()));
			}
		});

		this.rightTrimRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBasicPanel.this.main.clearOutput();
				System.out.println("Above String after removing all the spaces from right :\t");
				System.out.println(StringDemo.rTrim(StringBasicPanel.this.textField.getText()));
			}
		});

		this.trimRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBasicPanel.this.main.clearOutput();
				System.out.println("Above String after removing all the spaces from all the sides :\t");
				System.out.println(StringDemo.allTrim(StringBasicPanel.this.textField.getText()));
			}
		});

		this.squeezeRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBasicPanel.this.main.clearOutput();
				System.out.println("Above String after removing all the spaces from everywhere :\t");
				System.out.println(StringDemo.squeeze(StringBasicPanel.this.textField.getText()));
			}
		});

		this.vowelCountRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBasicPanel.this.main.clearOutput();
				System.out.println("Number of vowles in above string :\t");
				System.out.println(StringDemo.vowelCount(StringBasicPanel.this.textField.getText()));
			}
		});

		this.lengthRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBasicPanel.this.main.clearOutput();
				System.out.println("Length of the above string:\t");
				System.out.println(StringDemo.length(StringBasicPanel.this.textField.getText()));
			}
		});

		this.sequenceCountRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBasicPanel.this.main.clearOutput();
				System.out.println("How many times a character is repeated (continuously) in above string:\n");
				StringDemo.sequenceCount(StringBasicPanel.this.textField.getText());
			}
		});

		this.freqCountCharRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBasicPanel.this.main.clearOutput();
				System.out.println("How many times a character is repeated in above string:\n");
				StringDemo.frequencyCount(StringBasicPanel.this.textField.getText());
			}
		});

		this.changeCaseRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBasicPanel.this.main.clearOutput();
				System.out.println("Above string after changing the case :\t");
				System.out.println(StringDemo.changeCase(StringBasicPanel.this.textField.getText()));
			}
		});

		this.singleOccuranceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBasicPanel.this.main.clearOutput();
				System.out.println("Above string after removing continuous occurance of a letter/character :\t");
				System.out.println(StringDemo.singleOccurance(StringBasicPanel.this.textField.getText()));
			}
		});

		this.sortedOrderRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBasicPanel.this.main.clearOutput();
				System.out.println("Above String after sorting :\t");
				System.out.println(StringDemo.sortedOrder(StringBasicPanel.this.textField.getText()));
			}
		});

		this.sortedWordRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBasicPanel.this.main.clearOutput();
				System.out.println("Above string after sorting (sorting according to words) :\t");
				System.out.println(StringDemo.sortedWord(StringBasicPanel.this.textField.getText()));
			}
		});

		this.wordTriangleType1RadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBasicPanel.this.main.clearOutput();
				StringDemo.triangle1(StringBasicPanel.this.textField.getText());
			}
		});

		this.wordTriangleType2RadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBasicPanel.this.main.clearOutput();
				StringDemo.triangle2(StringBasicPanel.this.textField.getText());
			}
		});

		this.wordTriangleType3RadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBasicPanel.this.main.clearOutput();
				StringDemo.triangle3(StringBasicPanel.this.textField.getText());
			}
		});

		this.wordTriangleType4RadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBasicPanel.this.main.clearOutput();
				StringDemo.triangle4(StringBasicPanel.this.textField.getText());
			}
		});
	}

	private void theming() {
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	}

	private void addComponents() {
		this.buttonGroup.add(this.wordCountRadioButton);
		this.buttonGroup.add(this.spaceCountRadioButton);
		this.buttonGroup.add(this.charCountRadioButton);
		this.buttonGroup.add(this.reverseRadioButton);
		this.buttonGroup.add(this.pallindromeRadioButton);
		this.buttonGroup.add(this.leftTrimRadioButton);
		this.buttonGroup.add(this.rightTrimRadioButton);
		this.buttonGroup.add(this.trimRadioButton);
		this.buttonGroup.add(this.squeezeRadioButton);
		this.buttonGroup.add(this.vowelCountRadioButton);
		this.buttonGroup.add(this.lengthRadioButton);
		this.buttonGroup.add(this.sequenceCountRadioButton);
		this.buttonGroup.add(this.freqCountCharRadioButton);
		this.buttonGroup.add(this.changeCaseRadioButton);
		this.buttonGroup.add(this.singleOccuranceButton);
		this.buttonGroup.add(this.sortedOrderRadioButton);
		this.buttonGroup.add(this.sortedWordRadioButton);
		this.buttonGroup.add(this.wordTriangleType1RadioButton);
		this.buttonGroup.add(this.wordTriangleType2RadioButton);
		this.buttonGroup.add(this.wordTriangleType3RadioButton);
		this.buttonGroup.add(this.wordTriangleType4RadioButton);

		this.buttonPanel.add(this.wordCountRadioButton);
		this.buttonPanel.add(this.spaceCountRadioButton);
		this.buttonPanel.add(this.charCountRadioButton);
		this.buttonPanel.add(this.reverseRadioButton);
		this.buttonPanel.add(this.pallindromeRadioButton);
		this.buttonPanel.add(this.leftTrimRadioButton);
		this.buttonPanel.add(this.rightTrimRadioButton);
		this.buttonPanel.add(this.trimRadioButton);
		this.buttonPanel.add(this.squeezeRadioButton);
		this.buttonPanel.add(this.vowelCountRadioButton);
		this.buttonPanel.add(this.lengthRadioButton);
		this.buttonPanel.add(this.sequenceCountRadioButton);
		this.buttonPanel.add(this.freqCountCharRadioButton);
		this.buttonPanel.add(this.changeCaseRadioButton);
		this.buttonPanel.add(this.singleOccuranceButton);
		this.buttonPanel.add(this.sortedOrderRadioButton);
		this.buttonPanel.add(this.sortedWordRadioButton);
		this.buttonPanel.add(this.wordTriangleType1RadioButton);
		this.buttonPanel.add(this.wordTriangleType2RadioButton);
		this.buttonPanel.add(this.wordTriangleType3RadioButton);
		this.buttonPanel.add(this.wordTriangleType4RadioButton);

		this.add(this.textField, BorderLayout.NORTH);
		this.add(this.buttonPanel, BorderLayout.CENTER);
	}
}