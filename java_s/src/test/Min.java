package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Min {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Min window = new Min();
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
	public Min() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		frame.getContentPane().add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String arrayStr = textField.getText();
				lblNewLabel.setText("数组中最小的数是：" + arrayStr);
				
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.WEST);
		
		lblNewLabel = new JLabel("New label");
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
	}

}
