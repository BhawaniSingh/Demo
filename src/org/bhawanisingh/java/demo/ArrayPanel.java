package org.bhawanisingh.java.demo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.bhawanisingh.java.demo.array.ArrayDemo;

public class ArrayPanel extends JPanel {
	private ButtonGroup buttonGroup;
	private JRadioButton maxRadioButton;
	private JRadioButton maxArrayRadioButton;
	private JRadioButton minRadioButton;
	private JRadioButton minArrayRadioButton;
	private JRadioButton sortRadioButton;
	private JRadioButton sortArrayRadioButton;
	private JRadioButton mergeSortRadioButton;
	private JRadioButton unionRadioButton;
	private JRadioButton intersectionRadioButton;
	private JRadioButton matrixAdditionRadioButton;
	private JRadioButton matrixSumRadioButton;
	private JRadioButton matrixMultiplicationRadioButton;
	private JRadioButton triangleAMatrixMaxRadioButton;
	private JRadioButton triangleAMatrixMinRadioButton;
	private JRadioButton triangleAMatrixSumRadioButton;
	private JRadioButton triangleAMatrixAddRadioButton;
	private JRadioButton triangleBMatrixMaxRadioButton;
	private JRadioButton triangleBMatrixMinRadioButton;
	private JRadioButton triangleBMatrixSumRadioButton;
	private JRadioButton triangleBMatrixAddRadioButton;

	private Main main;

	public ArrayPanel(Main main) {
		this.main = main;
		this.initialize();
		this.addComponents();
		this.addListeners();
	}

	private void initialize() {
		this.setLayout(new GridLayout(7, 3));
		this.buttonGroup = new ButtonGroup();

		this.maxRadioButton = new JRadioButton("Max");
		this.buttonGroup.add(this.maxRadioButton);
		this.maxArrayRadioButton = new JRadioButton("Max of Matrix");
		this.buttonGroup.add(this.maxArrayRadioButton);
		this.minRadioButton = new JRadioButton("Min");
		this.buttonGroup.add(this.minRadioButton);
		this.minArrayRadioButton = new JRadioButton("Min of Matrix");
		this.buttonGroup.add(this.minArrayRadioButton);
		this.sortRadioButton = new JRadioButton("Sort");
		this.buttonGroup.add(this.sortRadioButton);
		this.sortArrayRadioButton = new JRadioButton("Sort Matrix");
		this.buttonGroup.add(this.sortArrayRadioButton);
		this.mergeSortRadioButton = new JRadioButton("Merge Sort");
		this.buttonGroup.add(this.mergeSortRadioButton);
		this.unionRadioButton = new JRadioButton("Union");
		this.buttonGroup.add(this.unionRadioButton);
		this.intersectionRadioButton = new JRadioButton("Intersection");
		this.buttonGroup.add(this.intersectionRadioButton);
		this.matrixAdditionRadioButton = new JRadioButton("Matrix Add");
		this.buttonGroup.add(this.matrixAdditionRadioButton);
		this.matrixMultiplicationRadioButton = new JRadioButton("Matix Mul");
		this.buttonGroup.add(this.matrixMultiplicationRadioButton);
		this.matrixSumRadioButton = new JRadioButton("Matrix Sum");
		this.buttonGroup.add(this.matrixSumRadioButton);
		this.triangleAMatrixMaxRadioButton = new JRadioButton("Triangle A Max");
		this.buttonGroup.add(this.triangleAMatrixMaxRadioButton);
		this.triangleAMatrixMinRadioButton = new JRadioButton("Triangle A Min");
		this.buttonGroup.add(this.triangleAMatrixMinRadioButton);
		this.triangleAMatrixSumRadioButton = new JRadioButton("Triangle A Sum");
		this.buttonGroup.add(this.triangleAMatrixSumRadioButton);
		this.triangleAMatrixAddRadioButton = new JRadioButton("Triangle A Add");
		this.buttonGroup.add(this.triangleAMatrixAddRadioButton);
		this.triangleBMatrixMaxRadioButton = new JRadioButton("Triangle B Max");
		this.buttonGroup.add(this.triangleBMatrixMaxRadioButton);
		this.triangleBMatrixMinRadioButton = new JRadioButton("Triangle B Min");
		this.buttonGroup.add(this.triangleBMatrixMinRadioButton);
		this.triangleBMatrixSumRadioButton = new JRadioButton("Triangle B Sum");
		this.buttonGroup.add(this.triangleBMatrixSumRadioButton);
		this.triangleBMatrixAddRadioButton = new JRadioButton("Triangle B Add");
		this.buttonGroup.add(this.triangleBMatrixAddRadioButton);
	}

	private void addComponents() {
		this.add(this.maxRadioButton);
		this.add(this.maxArrayRadioButton);
		this.add(this.minRadioButton);
		this.add(this.minArrayRadioButton);
		this.add(this.sortRadioButton);
		this.add(this.sortArrayRadioButton);
		this.add(this.mergeSortRadioButton);
		this.add(this.unionRadioButton);
		this.add(this.intersectionRadioButton);
		this.add(this.matrixAdditionRadioButton);
		this.add(this.matrixSumRadioButton);
		this.add(this.matrixMultiplicationRadioButton);
		this.add(this.triangleAMatrixMaxRadioButton);
		this.add(this.triangleAMatrixMinRadioButton);
		this.add(this.triangleAMatrixSumRadioButton);
		this.add(this.triangleAMatrixAddRadioButton);
		this.add(this.triangleBMatrixMaxRadioButton);
		this.add(this.triangleBMatrixMinRadioButton);
		this.add(this.triangleBMatrixSumRadioButton);
		this.add(this.triangleBMatrixAddRadioButton);

	}

	private void addListeners() {
		this.maxRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayPanel.this.main.clearOutput();
				System.out.println("Max Value Is:\t" + ArrayDemo.max(new int[] { 10, 100, 200, 23, 34, 3434, 546, 6, 5, 6, 7, 8, 9, 0, 2, 3, 4, 5, 6, 7, 10, 100, 209 }) + "\n");

			}
		});
		this.maxArrayRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayPanel.this.main.clearOutput();
				System.out.println("Max Value Is (For Array Of Arrays):\t" + ArrayDemo.max1(new int[][] {
						{ 10, 100, 200, 23 },
						{ 34, 3434, 546, 6, 5 },
						{ 6, 7, 8, 9, 0, 2, 3, 4, 5 },
						{ 6, 7 },
						{ 10, 100, 209 }
				}) + "\n");
			}
		});
		this.minRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayPanel.this.main.clearOutput();
				System.out.println("Min Value Is:\t" + ArrayDemo.min(new int[] { 10, 100, 200, 23, 34, 3434, 546, 6, 5, 6, 7, 8, 9, 0, 2, 3, 4, 5, 6, 7, 10, 100, 209 }) + "\n");
			}
		});
		this.minArrayRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayPanel.this.main.clearOutput();
				System.out.println("Min Value Is (For Array Of Arrays):\t" + ArrayDemo.min1(new int[][] {
						{ 10, 100, 200, 23 },
						{ 34, 3434, 546, 6, 5 },
						{ 6, 7, 8, 9, 0, 2, 3, 4, 5 },
						{ 6, 7 },
						{ 10, 100, 209 }
				}) + "\n");
			}
		});
		this.sortRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayPanel.this.main.clearOutput();
				System.out.println("Sorting:");
				ArrayDemo.sort(new int[] { 10, 100, 200, 23, 34, 3434, 546, 6, 5, 6, 7, 8, 9, 0, 2, 3, 4, 5, 6, 7, 10, 100, 209 });
			}
		});
		this.sortArrayRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayPanel.this.main.clearOutput();
				System.out.println("Sorting (For Array of Arrays):");
				ArrayDemo.sort1(new int[][] {
						{ 10, 100, 200, 23 },
						{ 34, 3434, 546, 6, 5 },
						{ 6, 7, 8, 9, 0, 2, 3, 4, 5 },
						{ 6, 7 },
						{ 10, 100, 209 }
				});
			}
		});
		this.mergeSortRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayPanel.this.main.clearOutput();
				System.out.println("Merge Sort:");
				ArrayDemo.mergesort(new int[] { 10, 100, 200, 23, 34, 3434, 546 }, new int[] { 6, 5, 6, 7, 8, 9, 0, 2, 3, 4, 5, 6, 7, 10, 100, 209 });
			}
		});
		this.unionRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayPanel.this.main.clearOutput();
				System.out.println("Union:");
				ArrayDemo.union(new int[] { 10, 100, 200, 23, 34, 3434, 6, 546 }, new int[] { 6, 5, 200, 8, 9, 2, 3, 4, 10, 7, 34, 100, 209 });
			}
		});
		this.intersectionRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayPanel.this.main.clearOutput();
				System.out.println("Intersection:");
				ArrayDemo.intersection(new int[] { 10, 100, 200, 23, 34, 3434, 6, 546 }, new int[] { 6, 5, 200, 8, 9, 2, 3, 4, 0, 7, 34, 10, 100, 209 });
			}
		});
		this.matrixAdditionRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayPanel.this.main.clearOutput();
				System.out.print("Matrix Addition:");
				ArrayDemo.matrixadd(new int[][] { { 10, 20, 30 }, { 40, 50, 55 }, { 15, 25, 50 } }, new int[][] { { 34, 12, 42 }, { 11, 43, 64 }, { 5, 25, 10 } });
			}
		});
		this.matrixSumRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayPanel.this.main.clearOutput();
				System.out.print("Matrix Sum:");
				ArrayDemo.matrixsum(new int[][] { { 10, 20, 30 }, { 40, 50, 55 }, { 15, 25, 50 } });
			}
		});
		this.matrixMultiplicationRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayPanel.this.main.clearOutput();
				System.out.print("Matrix Multiplication:");
				ArrayDemo.matrixm(new int[][] { { 10, 20, 30 }, { 40, 50, 55 }, { 15, 25, 50 } }, new int[][] { { 34, 12, 42 }, { 11, 43, 64 }, { 5, 25, 10 } });
			}
		});
		this.triangleAMatrixMaxRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayPanel.this.main.clearOutput();
				System.out.print("Triangle A Max:\t" + ArrayDemo.triangleAmax(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
			}
		});
		this.triangleAMatrixMinRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayPanel.this.main.clearOutput();
				System.out.print("Triangle A Min:\t" + ArrayDemo.triangleAmin(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
			}
		});
		this.triangleAMatrixSumRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayPanel.this.main.clearOutput();
				System.out.print("Triangle A Sum:");
				ArrayDemo.triangleAsum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
			}
		});
		this.triangleAMatrixAddRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayPanel.this.main.clearOutput();
				System.out.print("Triangle A Sum:\t" + ArrayDemo.triangleAsum1(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
			}
		});
		this.triangleBMatrixMaxRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayPanel.this.main.clearOutput();
				System.out.print("Triangle B Max:\t" + ArrayDemo.triangleBmax(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
			}
		});
		this.triangleBMatrixMinRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayPanel.this.main.clearOutput();
				System.out.print("Triangle B Min:\t" + ArrayDemo.triangleBmin(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
			}
		});
		this.triangleBMatrixSumRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayPanel.this.main.clearOutput();
				System.out.print("Triangle B Sum:");
				ArrayDemo.triangleBsum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
			}
		});
		this.triangleBMatrixAddRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayPanel.this.main.clearOutput();
				System.out.print("Triangle B Sum:\t" + ArrayDemo.triangleBsum1(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
			}
		});

	}
}
