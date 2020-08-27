package javaForm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import java.awt.Canvas;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class JavaForm extends JFrame {

	/**
	 * 
	 */
	static int age;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaForm frame = new JavaForm();
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
	public JavaForm() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tushar Chowdhury\\Desktop\\my icons\\favicon-32x32.png"));
		setTitle("Java form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("JAVA FORM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setBounds(44, 41, 263, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 103, 89, 32);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(94, 103, 197, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("AGE:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(22, 159, 58, 32);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 159, 197, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("GENDER:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 215, 89, 25);
		contentPane.add(lblNewLabel_3);
		ButtonGroup bg=new ButtonGroup();
				
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("male");
		rdbtnNewRadioButton.setBounds(122, 218, 74, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("female");
		rdbtnNewRadioButton_1.setSelected(false);
		rdbtnNewRadioButton_1.setBounds(233, 218, 74, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Connection con=null;
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdb", "root", "");
				PreparedStatement ps=con.prepareStatement("insert into student values(?, ?, ?, ?, ?)");
				// variables
				age= Integer.valueOf(textField_1.getText().toString());
				ps.setString(1, textField.getText().toString());
				ps.setInt(2, Integer.valueOf(textField_1.getText().toString()));
				String gen="";
				if(rdbtnNewRadioButton.isSelected()==true) {
					gen="Male";
				} else {
					gen="Female";
				}
				ps.setString(3, gen);
				ps.setString(4, textField_2.getText().toString());
				ps.setString(5, textField_3.getText().toString());
				
				
				int i=ps.executeUpdate();
				if(i>0) {
					JOptionPane.showMessageDialog(btnNewButton, "Success...Rediricting to dashboard");
					Dashboard d=new Dashboard();
					d.setVisible(true);
					dispose();
					
				} else {
					System.out.println("Failed");
					JOptionPane.showMessageDialog(btnNewButton, "Failed");
				}
				
				
				} catch (Exception f) {
					System.out.println(f);
					// TODO: handle exception
				}
				
			}
		});
		btnNewButton.setBackground(new Color(153, 204, 255));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		btnNewButton.setBounds(94, 390, 129, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("HOBBY:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 270, 77, 25);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(94, 272, 197, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("SCHOOL:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 333, 89, 25);
		contentPane.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(94, 333, 197, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l=new Login();
				l.setVisible(true);
				dispose();
			}
		});
		login.setForeground(Color.YELLOW);
		login.setBackground(Color.GREEN);
		login.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		login.setBounds(98, 439, 123, 35);
		contentPane.add(login);
	}
}
