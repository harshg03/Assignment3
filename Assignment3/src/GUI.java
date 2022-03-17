import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	//private Bot bot;
	private JFrame frame;
	private JTextField input_field;
	JTextPane chatHistory;
	JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		input_field = new JTextField();
		chatHistory = new JTextPane();
		chatHistory.setEditable(false);
		
		chatHistory.setBackground(SystemColor.menu);
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(chatHistory);
		events();
		frame.getContentPane().add(input_field, BorderLayout.SOUTH);
		input_field.setColumns(10);
		
		
		
		
	}
	private void events() {
		
		input_field.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				chatHistory.setText(chatHistory.getText()+input_field.getText()+"\n");
				input_field.setText("");
			}
		});
		
	}

}
