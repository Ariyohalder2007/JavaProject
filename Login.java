package javaForm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	
	private JPanel contentPane;
	private JTextField InpAge;
	private JTextField InpName;
	private String myname2;
	private String Myage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tushar Chowdhury\\Desktop\\my icons\\favicon-32x32.png"));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 314, 379);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel head = new JLabel("Login");
		head.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		head.setHorizontalAlignment(SwingConstants.CENTER);
		head.setBounds(89, 11, 90, 24);
		contentPane.add(head);
		
		JLabel name = new JLabel("Name");
		name.setFont(new Font("Times New Roman", Font.BOLD, 17));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(10, 101, 67, 24);
		contentPane.add(name);
		
		JLabel roll = new JLabel("age");
		roll.setHorizontalAlignment(SwingConstants.CENTER);
		roll.setFont(new Font("Times New Roman", Font.BOLD, 17));
		roll.setBounds(10, 183, 67, 24);
		contentPane.add(roll);
		
		InpAge = new JTextField();
		InpAge.setBackground(Color.WHITE);
		InpAge.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		InpAge.setBounds(89, 183, 135, 24);
		contentPane.add(InpAge);
		InpAge.setColumns(10);
		
		InpName = new JTextField();
		InpName.setColumns(10);
		InpName.setBounds(89, 103, 135, 24);
		contentPane.add(InpName);
		
		JButton log = new JButton("Login");
		log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Connection con=null;
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdb", "root", "");
					PreparedStatement ps=con.prepareStatement("select * from student where name=? and age=?");
					ps.setString(1,InpName.getText().toString());
					ps.setInt(2, Integer.parseInt(InpAge.getText().toString()));
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
//						 System.out.print(rs.getString(3));
						 Dashboard d = new Dashboard();
							d.setVisible(true);
							dispose();
						 
					}
					
					
					
				}catch (Exception e1) {
					e1.printStackTrace();
					// TODO: handle exception
				}
				
				
				
				
			}
		});
		log.setBackground(Color.GREEN);
		log.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		log.setBounds(89, 268, 89, 33);
		contentPane.add(log);
		
		
		
	}
}
