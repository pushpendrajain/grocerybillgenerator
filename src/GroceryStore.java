import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JProgressBar;

public class GroceryStore extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)throws SQLException
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroceryStore frame = new GroceryStore();
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
	public GroceryStore() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 459);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		JProgressBar progressBar = new JProgressBar();

		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0)
			{
				int i;
				for(i=0;i<9999999;i++)
					progressBar.setValue(i);
				dispose();
				try {
					new Login().setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblGroceryStore = new JLabel("Grocery Bill Generator");
		lblGroceryStore.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 45));
		lblGroceryStore.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblCreatedByPushpendra = new JLabel("Developed By: PUSHPENDRA JAIN");
		lblCreatedByPushpendra.setFont(new Font("Segoe UI", Font.ITALIC, 20));
		
		JLabel label = new JLabel("      ");
		label.setIcon(new ImageIcon("F:\\JAVA ECLIPSE\\GroceryManagement\\src\\grocery.jpg"));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
								.addGap(141))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblGroceryStore, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
								.addContainerGap()))
						.addComponent(lblCreatedByPushpendra, Alignment.TRAILING)))
				.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addComponent(lblGroceryStore, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblCreatedByPushpendra)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
