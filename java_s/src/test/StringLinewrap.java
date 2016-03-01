package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;

public class StringLinewrap {

	private JFrame frame;
	private JTextArea input;
	private JTextArea output;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StringLinewrap window = new StringLinewrap();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StringLinewrap() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea input = new JTextArea();
		input.setBounds(10, 10, 414, 94);
		frame.getContentPane().add(input);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 151, 414, 100);
		frame.getContentPane().add(scrollPane);
		
		JTextArea output = new JTextArea();
		output.setBounds(10, 151, 414, 101);
		frame.getContentPane().add(output);
		
		
		
		
		JButton btnNewButton = new JButton("\u5206\u884C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String source=input.getText();
				String[] lines=source.split(",|£¬");
				StringBuilder sb=new  StringBuilder();
				for(String line:lines){
					sb.append(line+"\n");
				}
				output.setText(sb.toString());
			}
		});
		btnNewButton.setBounds(165, 114, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
	}
}
