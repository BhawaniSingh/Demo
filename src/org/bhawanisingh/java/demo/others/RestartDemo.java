package org.bhawanisingh.java.demo.others;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

public class RestartDemo extends JFrame {

	public static final String JAVA_COMMAND = "sun.java.command";

	// File separator is dependent on operating system. You should use System.getProperty() to get
	// file separator.
	public static final String SEPARATOR = System.getProperty("file.separator");

	private JButton button;

	public RestartDemo() {
		super("Restart Demo");
		this.setSize(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.button = new JButton("Click to restart");
		this.button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RestartDemo.this.restart();

			}
		});
		this.add(this.button);
		this.setVisible(true);

	}

	private void restart() {

		try {
			String java = System.getProperty("java.home") + RestartDemo.SEPARATOR + "bin" + RestartDemo.SEPARATOR + "java";
			List<String> args = ManagementFactory.getRuntimeMXBean().getInputArguments();
			StringBuffer jvmArgs = new StringBuffer();
			for (String arg : args) {
				// -agentlib is for debugger.
				if (!arg.contains("-agentlib")) {
					jvmArgs.append(arg);
					jvmArgs.append(" ");
				}
			}
			final StringBuffer cmd = new StringBuffer(java + " " + jvmArgs);
			String[] programPath = System.getProperty(RestartDemo.JAVA_COMMAND).split(" ");

			// Checks if the file is jar or .class file. This is important
			if (programPath[0].endsWith(".jar")) {
				cmd.append("-jar " + new File(programPath[0]).getPath());
			} else {
				cmd.append("-cp " + System.getProperty("java.class.path") + " " + programPath[0]);

				// Uncomment the line below if you want to see the exact command which will run in
				// shutdown hook
				// System.out.println(cmd);

			}
			for (int i = 1; i < programPath.length; i++) {
				cmd.append(" ");
				cmd.append(programPath[i]);
			}
			// Adding shutdown hook. Shutdown hooks contains the code which runs when application is
			// about to close. You can use Shutdown hooks to save setting and do other stuff in your
			// app which is important and must be save before closing of app.
			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					try {
						Runtime.getRuntime().exec(cmd.toString());
					} catch (IOException e) {
						// TODO Must catch exceptions. I didn't catch them because this is just a
						// demo
					}
				}
			});
			System.exit(0);
		} catch (Exception e) {
			// TODO Must catch exceptions. I didn't catch them because this is just a demo
		}
	}

	public static void main(String[] args) {
		new RestartDemo();

	}

}
