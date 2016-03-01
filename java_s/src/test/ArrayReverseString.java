package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArrayReverseString {

	private JFrame frame;
	private JTextField inputField;
	private JTextField outputField;
	private JTextArea infoArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayReverseString window = new ArrayReverseString();
					window.frame.setVisible(true);
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ArrayReverseString() {
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
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u4E00\u4E2A\u5B57\u7B26\u4E32");
		lblNewLabel.setBounds(21, 21, 84, 15);
		frame.getContentPane().add(lblNewLabel);
		
		inputField = new JTextField();
		inputField.setBounds(121, 18, 287, 21);
		frame.getContentPane().add(inputField);
		inputField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u53CD\u8F6C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String inputStr=inputField.getText();
				char[] strArray=inputStr.toCharArray();
				infoArea.setText("");
				for(int i=0;i<strArray.length/2;i++){
					char temp=strArray[i];
					strArray[i]=strArray[strArray.length-i-1];
					strArray[strArray.length-i-1]=temp;
					infoArea.append("µÚ"+(i+1)+"´ÎÑ­»·£º\t");
					for(char c:strArray){
						infoArea.append(c+"");
					}
					infoArea.append("\n");
				}
				String outputStr=new String(strArray);
				outputField.setText(outputStr);
			}
		});
		btnNewButton.setBounds(12, 66, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		outputField = new JTextField();
		outputField.setBounds(121, 67, 287, 21);
		frame.getContentPane().add(outputField);
		outputField.setColumns(10);
		
		infoArea = new JTextArea();
		infoArea.setBounds(21, 144, 387, 92);
		frame.getContentPane().add(infoArea);
	}
}
