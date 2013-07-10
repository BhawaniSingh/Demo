package org.bhawanisingh.java.demo;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

/**
 *
 */
public class Main extends JFrame {

	private JPanel mainPanel;
	private JPanel componentPanel;
	private JPanel arrayPanel;
	private StringBasicPanel stringBasicPanel;
	private JPanel sidePanel;
	private JScrollPane arrayScrollPane;
	private JScrollPane stringBasicScrollPane;
	private JScrollPane stringAdvanceScrollPane;
	private JScrollPane sideScrollPane;
	private JScrollPane outputScrollPane;
	private JSplitPane splitPane;

	private JTextArea outputTextArea;

	/**
	 * 
	 */
	public Main() {
		this.redirectingOutputStreams();
		this.initialize();
		this.addComponents();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	private void initialize() {
		this.mainPanel = new JPanel(new BorderLayout(5, 5));
		this.componentPanel = new JPanel(new CardLayout());
		this.stringBasicPanel = new StringBasicPanel(this);
		this.stringBasicScrollPane = new JScrollPane(this.stringBasicPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.sidePanel = new JPanel();
		this.sideScrollPane = new JScrollPane(this.sidePanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.outputTextArea = new JTextArea(20, 40);
		this.outputScrollPane = new JScrollPane(this.outputTextArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, this.mainPanel, this.outputScrollPane);
	}

	private void addComponents() {
		this.componentPanel.add(this.stringBasicScrollPane);
		this.mainPanel.add(this.sideScrollPane, BorderLayout.WEST);
		this.mainPanel.add(this.componentPanel, BorderLayout.CENTER);
		this.add(this.splitPane);
	}

	private void updateTextArea(final String text) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Main.this.outputTextArea.append(text);
			}
		});
	}

	private void redirectingOutputStreams() {
		OutputStream out = new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				Main.this.updateTextArea(String.valueOf((char) b));
			}

			@Override
			public void write(byte[] b, int off, int len) throws IOException {
				Main.this.updateTextArea(new String(b, off, len));
			}

			@Override
			public void write(byte[] b) throws IOException {
				this.write(b, 0, b.length);
			}
		};

		System.setOut(new PrintStream(out, true));
		System.setErr(new PrintStream(out, true));
	}

	public void clearOutput() {
		this.outputTextArea.setText("");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Main();

	}

}
