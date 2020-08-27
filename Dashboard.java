package javaForm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setTitle("Dashboard");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tushar Chowdhury\\Desktop\\my icons\\favicon-32x32.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DASHBOARD");
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(219, 11, 152, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(43, 94, 89, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(142, 94, 127, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Hobby:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(53, 131, 81, 26);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(152, 131, 117, 26);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("Age:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(327, 94, 91, 26);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblSchool = new JLabel("School:");
		lblSchool.setHorizontalAlignment(SwingConstants.CENTER);
		lblSchool.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblSchool.setBounds(327, 131, 91, 26);
		contentPane.add(lblSchool);
		
		JLabel lblYourAge = new JLabel("");
		lblYourAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourAge.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblYourAge.setBounds(414, 94, 91, 26);
		contentPane.add(lblYourAge);
		
		JLabel lblYourSchool = new JLabel("");
		lblYourSchool.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblYourSchool.setBounds(428, 131, 216, 26);
		contentPane.add(lblYourSchool);
		
		JButton About = new JButton("About us");
		About.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About about = new About();
				about.setVisible(true);
				dispose();
			}
		});
		About.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		About.setBounds(152, 213, 117, 23);
		contentPane.add(About);
		
		JButton Contact = new JButton("Contact");
		Contact.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		Contact.setBounds(279, 215, 117, 23);
		contentPane.add(Contact);
		try {

			Connection con=null;
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdb", "root", "");

			PreparedStatement ps=con.prepareStatement("select * from student where age=?");
			ps.setInt(1, JavaForm.age);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				lblNewLabel_2.setText(rs.getString(1));
				lblNewLabel_4.setText(rs.getString(4));
				lblYourAge.setText(rs.getString(2));
				lblYourSchool.setText(rs.getString(5));
			}
			
		}catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}
}
