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

	
	private JFrame frame;
	private JTextField input_field;
	JTextPane chatHistory;
	JScrollPane scrollPane;
	static Bot bot=new Bot();
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
		bot.greet();
		output(bot.currentOutput);
		
		
		
	}
	private void events() {
		
		input_field.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input=input_field.getText();
				bot.setOutput(bot.name+": "+input);
				output(bot.currentOutput);
				bot.setInput(input);
				input_field.setText("");
				bot.exchange_count++;
				if(bot.exchange_count==1) {
					bot.name=PoSTagger.getProperNoun(input);
					if(bot.name=="") {
						output("Serenity: I'm going to need your name before we continue!");
						bot.name="User";
						bot.exchange_count--;
					}
					else {
					bot.setOutput("Serenity: Nice to meet you "+bot.name +" :) How's it going?");
					output(bot.currentOutput);
					}
				}
				else {
					
					
				}
			}
		});
		
	}
	private void output(String s) {
		chatHistory.setText(chatHistory.getText()+s+"\n");
	}

}
