package org.bhawanisingh.java.demo.others;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

/**
 * Class to show show how to redirect output streams to gui.
 * In this class System.out & System.err are connected to "outputTextArea"
 */
public class RedirectOutputToGUI extends JFrame {

	private JTextArea inputTextArea;
	private JScrollPane inputScrollPane;
	private JTextArea outputTextArea;
	private JScrollPane outputScrollPane;

	public RedirectOutputToGUI() {
		super("Demonstration Of Redirection Of Console Output");
		this.initialize();
		this.redirectingOutputStreams();
		this.addComponents();
		this.addListeners();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	private void initialize() {
		this.inputTextArea = new JTextArea(10, 80);
		this.inputScrollPane = new JScrollPane(this.inputTextArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.outputTextArea = new JTextArea(10, 80);
		this.outputScrollPane = new JScrollPane(this.outputTextArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	}

	private void addComponents() {
		this.add(this.inputScrollPane, BorderLayout.NORTH);
		this.add(this.outputScrollPane, BorderLayout.CENTER);

	}

	private void addListeners() {
		this.inputTextArea.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				System.out.print(e.getKeyChar());
			}
		});
	}

	private void updateTextArea(final String text) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				RedirectOutputToGUI.this.outputTextArea.append(text);
			}
		});
	}

	private void redirectingOutputStreams() {
		OutputStream out = new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				RedirectOutputToGUI.this.updateTextArea(String.valueOf((char) b));
			}

			@Override
			public void write(byte[] b, int off, int len) throws IOException {
				RedirectOutputToGUI.this.updateTextArea(new String(b, off, len));
			}

			@Override
			public void write(byte[] b) throws IOException {
				this.write(b, 0, b.length);
			}
		};
		System.setOut(new PrintStream(out, true));
		System.setErr(new PrintStream(out, true));
	}

	public static void main(String[] args) {
		new RedirectOutputToGUI();

	}

}
