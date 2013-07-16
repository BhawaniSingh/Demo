package org.bhawanisingh.java.demo;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 *
 */
public class Main extends JFrame {

	private JPanel mainPanel;
	private JPanel componentPanel;
	private ArrayPanel arrayPanel;
	private StringBasicPanel stringBasicPanel;
	private StringAdvancePanel stringAdvancePanel;
	private JPanel sidePanel;
	private JScrollPane arrayScrollPane;
	private JScrollPane stringBasicScrollPane;
	private JScrollPane stringAdvanceScrollPane;
	private JScrollPane sideScrollPane;
	private JScrollPane outputScrollPane;
	private JSplitPane splitPane;
	private JLabel stringBasicLabel;
	private JLabel stringAdvanceLabel;
	private JLabel arrayLabel;

	private JTextArea outputTextArea;

	private Border paddingBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
	private Border bevelRaised = BorderFactory.createBevelBorder(BevelBorder.RAISED);
	private Border bevelLowered = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
	private Border compoundRaised = BorderFactory.createCompoundBorder(this.bevelRaised, this.paddingBorder);
	private Border compoundLowered = BorderFactory.createCompoundBorder(this.bevelLowered, this.paddingBorder);

	private CardLayout cardLayout = new CardLayout();

	/**
	 * 
	 */
	public Main() {
		this.redirectingOutputStreams();
		this.initialize();
		this.addComponents();
		this.theming();
		this.addListeners();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	private void initialize() {
		this.mainPanel = new JPanel(new BorderLayout(5, 5));
		this.componentPanel = new JPanel(this.cardLayout);
		this.stringBasicPanel = new StringBasicPanel(this);
		this.stringBasicLabel = new JLabel("String Basic");
		this.stringBasicScrollPane = new JScrollPane(this.stringBasicPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		this.stringAdvanceLabel = new JLabel("Advance String");
		this.stringAdvancePanel = new StringAdvancePanel(this);
		this.stringAdvanceScrollPane = new JScrollPane(this.stringAdvancePanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		this.arrayLabel = new JLabel("Arrays");
		this.arrayPanel = new ArrayPanel(this);
		this.arrayScrollPane = new JScrollPane(this.arrayPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		this.sidePanel = new JPanel(new GridBagLayout());
		// this.sidePanel.setLayout(new BoxLayout(this.sidePanel, BoxLayout.PAGE_AXIS));
		this.sideScrollPane = new JScrollPane(this.sidePanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.outputTextArea = new JTextArea(20, 40);
		this.outputScrollPane = new JScrollPane(this.outputTextArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, this.mainPanel, this.outputScrollPane);
	}

	private void addComponents() {
		Layout.add(this.sidePanel, this.stringBasicLabel, 0, 0, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		Layout.add(this.sidePanel, this.stringAdvanceLabel, 0, 1, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		Layout.add(this.sidePanel, this.arrayLabel, 0, 2, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);

		this.componentPanel.add("StringBasic", this.stringBasicScrollPane);
		this.componentPanel.add("StringAdvance", this.stringAdvanceScrollPane);
		this.componentPanel.add("Arrays", this.arrayScrollPane);
		this.mainPanel.add(this.sideScrollPane, BorderLayout.WEST);
		this.mainPanel.add(this.componentPanel, BorderLayout.CENTER);
		this.add(this.splitPane);
	}

	private void theming() {
		this.stringBasicLabel.setBorder(this.compoundRaised);
		this.stringAdvanceLabel.setBorder(this.compoundRaised);
		this.arrayLabel.setBorder(this.compoundRaised);
	}

	private void addListeners() {
		this.stringBasicLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.this.updateLabelBorder(Main.this.stringBasicLabel);
				Main.this.cardLayout.show(Main.this.componentPanel, "StringBasic");
			}
		});

		this.stringAdvanceLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.this.updateLabelBorder(Main.this.stringAdvanceLabel);
				Main.this.cardLayout.show(Main.this.componentPanel, "StringAdvance");
			}
		});
		this.arrayLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.this.updateLabelBorder(Main.this.arrayLabel);
				Main.this.cardLayout.show(Main.this.componentPanel, "Arrays");
			}
		});

	}

	private void updateLabelBorder(JLabel label) {
		this.stringBasicLabel.setBorder(this.compoundRaised);
		this.stringAdvanceLabel.setBorder(this.compoundRaised);
		this.arrayLabel.setBorder(this.compoundRaised);
		label.setBorder(this.compoundLowered);
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
