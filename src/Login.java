import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class Login extends JFrame {
    ButtonGroup g=new ButtonGroup();
	JLabel l4 = new JLabel("");
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public void reset() {
		textField.setText("");
		passwordField.setText("");
	}

	/**
	 * Create the frame.
	 */
	public Login() throws SQLException
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(this);

		JLabel lblLogin = new JLabel("Login    ");
		lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 45));
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				 String s1=textField.getText();
				 char[] psd=passwordField.getPassword();
				 String s2=String.copyValueOf(psd);
				 Connection con=DBInfo.getCon();
				 String query=null;
				    query="select * from admin where UserID=? and Pass=?";
	 
				 if(s1.isEmpty())
				 {
					 JOptionPane.showMessageDialog(null,"Please enter user id !!");
					 s1="-999999";
				 }
				 if(s2.isEmpty())
				 {
					 JOptionPane.showMessageDialog(null,"Please enter password !!");
					 s2="-999999";
				 }
				
				 try
				 {
					 PreparedStatement ps=con.prepareStatement(query);
					 ps.setString(1, s1);
					 ps.setString(2, s2);
					 ResultSet i=ps.executeQuery();
					 
					 if(i.next())
				 		{
				 		  JOptionPane.showMessageDialog(null,"Login Successful!!");
				 		  
				 			  new GroceryBillGenerator().setVisible(true);
				 			  dispose();
			            }
					 else
					 {
						 JOptionPane.showMessageDialog(null,"Invalid ID or Password !! Permission Denied");
						   reset();
					 }
				 }
				 catch(Exception e)
				 {
					 e.printStackTrace();
				 }
					
			}
		}
		);
		
		JButton btnReser = new JButton("Reset");
		btnReser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			reset();
			}

			
		});
		
		passwordField = new JPasswordField();
		
	
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(l4, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(50)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblUserId, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(100)
									.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnReser, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(l4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
						.addComponent(lblUserId, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
						.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnReser))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
