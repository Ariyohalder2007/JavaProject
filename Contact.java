package javaForm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Contact extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField Phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contact frame = new Contact();
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
	public Contact() {
		setTitle("Contact Us");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 61, 80, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblPhone.setBounds(10, 173, 80, 29);
		contentPane.add(lblPhone);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblMessage.setBounds(10, 265, 80, 29);
		contentPane.add(lblMessage);
		
		Name = new JTextField();
		Name.setBounds(100, 61, 202, 26);
		contentPane.add(Name);
		Name.setColumns(10);
		
		Phone = new JTextField();
		Phone.setColumns(10);
		Phone.setBounds(100, 173, 202, 26);
		contentPane.add(Phone);
		
		JTextArea Message = new JTextArea();
		Message.setBounds(100, 265, 202, 96);
		contentPane.add(Message);
		
		JButton Submit = new JButton("Submit");
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Name, "Success redirecting dashboard");
				Dashboard d = new Dashboard();
				d.setVisible(true);
				dispose();
			}
		});
		Submit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		Submit.setBounds(142, 401, 101, 29);
		contentPane.add(Submit);
	}
}
