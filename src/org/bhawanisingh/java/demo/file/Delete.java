package org.bhawanisingh.java.demo.file;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.bhawanisingh.java.demo.Layout;

/**
 * @author bhawani
 */

public class Delete extends javax.swing.JFrame {

	private JButton browseButton;
	private JTextField deleteField;
	private JLabel deleteLabel;
	private JPanel mainPanel;
	private JButton okButton;
	private JLabel result;
	private JFileChooser fileChooser;

	private File selFile;

	public Delete() {
		super("Delete Demo");
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.initComponents();
		this.eventHandling();
		this.addComponents();
		this.theming();
		this.result.setVerticalAlignment(SwingConstants.CENTER);
		this.result.setHorizontalAlignment(SwingConstants.CENTER);
		this.result.setFont(new Font("Consolas", Font.ITALIC, 14));
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void initComponents() {
		this.mainPanel = new JPanel(new GridBagLayout());
		this.deleteLabel = new JLabel("Enter A File/Folder To Delete");
		this.deleteField = new JTextField(30);
		this.browseButton = new JButton("Browse");
		this.okButton = new JButton("Delete");
		this.result = new JLabel(" ");
		this.fileChooser = new JFileChooser();
		this.fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	}

	void eventHandling()
	{
		this.browseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int res = Delete.this.fileChooser.showOpenDialog(Delete.this.mainPanel);
				if (res == JFileChooser.APPROVE_OPTION) {
					Delete.this.deleteField.setText(Delete.this.fileChooser.getSelectedFile().toString());
				}
			}
		});

		this.okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Delete.this.selFile = new File(Delete.this.deleteField.getText().trim());
				if (Delete.this.selFile.exists()) {
					if (Delete.this.selFile.isFile()) {
						Delete.this.selFile.delete();
						Delete.this.deleteSuccess("File");
					} else {
						Delete.this.deleteDirectory(Delete.this.selFile);
						Delete.this.deleteSuccess("Directory");
					}
				} else {
					Delete.this.result.setText("<html><font color='red'>File/Folder Doesn't Exists</font></html>");
				}
				Delete.this.selFile = null;
				Delete.this.deleteField.setText("");
			}
		});
	}

	private void addComponents() {
		Layout.add(this.mainPanel, this.deleteLabel, 0, 0, 3, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE);
		Layout.add(this.mainPanel, this.deleteField, 3, 0, 3, 1, 100, 0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		Layout.add(this.mainPanel, this.browseButton, 6, 0, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE);
		Layout.add(this.mainPanel, this.result, 1, 1, 6, 1, 100, 0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		Layout.add(this.mainPanel, this.okButton, 6, 1, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE);

		this.add(this.mainPanel);

	}

	private void theming() {
		this.mainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
	}

	void deleteDirectory(File dirPath) {
		File files[] = dirPath.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				file.delete();
			} else {
				String ft[] = file.list();
				if (ft.length == 0) {
					file.delete();
				} else {
					this.deleteDirectory(file);
				}
			}
		}
		dirPath.delete();
	}

	void deleteSuccess(String s) {
		System.out.println("deleteSuccess");
		if (this.selFile.exists()) {
			this.result.setText("<HTML><font color='red'>Error In Deleting  \" " + this.selFile.getName() + " \" " + s + "</font></html>");
		} else if (!this.selFile.exists()) {
			this.result.setText("<HTML><font color='green'>\"" + this.selFile.getName() + "\"</font> " + s + " Has Been Deleted Successfully !!!!</html>");
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

		new Delete();
	}
}
