package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class testDemo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					testDemo frame = new testDemo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public testDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ThinkCentre\\Desktop\\J%@22JI~VS@8%5PF$$Q7A}R.jpg"));
		lblNewLabel.setBounds(27, 20, 54, 15);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setOpaque(false);
		textArea.setText("\u8BF7\u8F93\u5165\u7A0B\u5E8F\u6587\u4EF6");
		textArea.setBounds(86, 20, 157, 24);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("\u6253\u5F00(O):");
		lblNewLabel_1.setBounds(27, 66, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(86, 63, 232, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.setBounds(172, 145, 70, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.setBounds(260, 145, 57, 23);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("\u6D4F\u89C8");
		button.setBounds(331, 145, 70, 23);
		contentPane.add(button);
	}
}
