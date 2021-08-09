import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class GroceryBillGenerator extends JFrame {
	private JTable table;
	private JTextField tfSearch;
	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfQty;
	private JTextField tfSPrice;
	private JTextField tfPrice;
	JComboBox cb1 = new JComboBox();
	JComboBox cb2 = new JComboBox();
	private JTextField tfSrch;
	private JTextField tfQu;
	private JTextField tfItem;
	JComboBox cbOption = new JComboBox();
	private JTextField tfBill;
	private JTable table_1;
	/**
	 * Launch the application.
	 */
	float billAmount = 0.0f;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	JComboBox c1 = new JComboBox();
	void reset()
	{
	 t1.setText(""+id());
	 t2.setText("");
	 t3.setText("");
	 t4.setText("");
	 c1.setSelectedIndex(0);
	}
	private void reset2() {
		// TODO Auto-generated method stub
		tfName.setText("");
		tfId.setText("");
		tfQty.setText("");
		tfPrice.setText("");
		tfSPrice.setText("");
		tfSearch.setText("");
		cb1.removeAllItems();
		cb2.removeAllItems();
	}
	
    int id()
	{
		return((int)(Math.random()*1000));
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroceryBillGenerator frame = new GroceryBillGenerator();
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
	public GroceryBillGenerator() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 450);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(169, 169, 169));
		panel.setBounds(0, 74, 208, 337);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel tab1 = new JPanel();
		tab1.setBounds(0, 0, 208, 48);
		panel.add(tab1);
		tab1.setLayout(null);
		tab1.setBackground(Color.white);;
		
		JLabel lblNewLabel = new JLabel("Add Item");
		
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 188, 26);
		tab1.add(lblNewLabel);
		
		JPanel tab2 = new JPanel();
		
		tab2.setBounds(0, 48, 208, 48);
		panel.add(tab2);
		tab2.setLayout(null);
		
		JLabel lblUpdateItem = new JLabel("Update Item");
		lblUpdateItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateItem.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblUpdateItem.setBounds(10, 11, 188, 26);
		tab2.add(lblUpdateItem);
		
		JPanel tab3 = new JPanel();
		tab3.setLayout(null);
		tab3.setBounds(0, 96, 208, 48);
		panel.add(tab3);
		
		JLabel lblViewStock = new JLabel("View Stock");
		lblViewStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewStock.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblViewStock.setBounds(10, 11, 188, 26);
		tab3.add(lblViewStock);
		
		JLabel lblNewLabel_2 = new JLabel("DEVELOPED BY:");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 275, 198, 23);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Pushpendra Jain");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(10, 296, 198, 41);
		panel.add(lblNewLabel_3);
		
		JPanel tab4 = new JPanel();
		tab4.setLayout(null);
		tab4.setBounds(0, 144, 208, 48);
		panel.add(tab4);
		
		tab2.setBackground(new Color(204,204,205));
		tab3.setBackground(new Color(204,204,205));
		tab4.setBackground(new Color(204,204,205));
		
		JLabel lblGenerateBill = new JLabel("Generate Bill");
		lblGenerateBill.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerateBill.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblGenerateBill.setBounds(10, 11, 188, 26);
		tab4.add(lblGenerateBill);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(207, 74, 547, 337);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 0, 547, 337);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Add Item");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setBounds(0, 0, 547, 48);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_8 = new JLabel("Item ID");
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(10, 59, 98, 36);
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("Item Name");
		lblNewLabel_8_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_8_1.setBounds(297, 59, 91, 36);
		panel_2.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_8_2 = new JLabel("Quantity");
		lblNewLabel_8_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_8_2.setBounds(10, 106, 98, 36);
		panel_2.add(lblNewLabel_8_2);
		
		JLabel lblNewLabel_8_3 = new JLabel("Price");
		lblNewLabel_8_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_8_3.setBounds(297, 106, 67, 36);
		panel_2.add(lblNewLabel_8_3);
		
		JLabel lblNewLabel_8_3_1 = new JLabel("Brand");
		lblNewLabel_8_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_8_3_1.setBounds(10, 153, 98, 36);
		panel_2.add(lblNewLabel_8_3_1);
		
		t1 = new JTextField();
		t1.setText("197");
		t1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		t1.setEditable(false);
		t1.setColumns(10);
		t1.setBounds(118, 59, 139, 36);
		panel_2.add(t1);
		
		t2 = new JTextField();
		t2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		t2.setColumns(10);
		t2.setBounds(398, 59, 139, 36);
		panel_2.add(t2);
		
		t3 = new JTextField();
		t3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		t3.setColumns(10);
		t3.setBounds(118, 106, 139, 36);
		panel_2.add(t3);
		
		t4 = new JTextField();
		t4.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		t4.setColumns(10);
		t4.setBounds(398, 106, 139, 36);
		panel_2.add(t4);
		
		
		c1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		c1.setBounds(118, 153, 139, 36);
		panel_2.add(c1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String item=t2.getText();
				int qty;
				float pr;
			
			if(t2.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please enter valid item name"); 
			}
			
			else if(t3.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please enter valid quantity"); 
			}
			else if(t4.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please enter valid price"); 
			}
			
			else
			{	
				
				qty=Integer.parseInt(t3.getText());
				pr=Float.parseFloat(t4.getText());
				float sp;
				sp = pr+ (pr * 0.10f);
				String Brand=(String) c1.getSelectedItem();		
				Connection con=DBInfo.getCon();
				String query="Insert into item values(?,?,?,?,?,?)";
				try
				{
					 PreparedStatement ps=con.prepareStatement(query);
					 ps.setString(1, t1.getText());
					 ps.setString(2, t2.getText());
					 ps.setString(3, t3.getText());
					 ps.setString(4, t4.getText());
					 ps.setString(5, ""+sp);
					 ps.setString(6, (String) c1.getSelectedItem());	 
					 int i=ps.executeUpdate();
					 if(i==1)
					     JOptionPane.showMessageDialog(null, "Item inserted Successfully!!!"); 
					 else
						 JOptionPane.showMessageDialog(null, "Item not Inserted. Please try again!!!"); 	 
				}
				catch(Exception e)
				{
					e.printStackTrace();	
				}
				reset();
			} 	
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnNewButton.setBounds(168, 234, 89, 36);
		panel_2.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnReset.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnReset.setBounds(297, 234, 89, 36);
		panel_2.add(btnReset);
		
		JButton btnAddNewBrand = new JButton("Add New Brand");
		btnAddNewBrand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  Connection con=DBInfo.getCon();
				  String s1=JOptionPane.showInputDialog("Enter BrandID");
				  String s2=JOptionPane.showInputDialog("Enter Brand Name");
				  String query;
				  if(s1.isEmpty()) {
					  JOptionPane.showMessageDialog(null, "Please Enter valid Brand ID!!");
					  s1=JOptionPane.showInputDialog("Enter BrandID");
					  s2=JOptionPane.showInputDialog("Enter Brand Name");
				  }
				  else if(s2.isEmpty()) {
					  JOptionPane.showMessageDialog(null, "Please Enter valid Brand Name!!");
					  s1=JOptionPane.showInputDialog("Enter BrandID");
					  s2=JOptionPane.showInputDialog("Enter Brand Name");					  
				  }
				  
				  else {
					  query="insert into brand values(?,?)";
				  try
				  {
					  PreparedStatement ps=con.prepareStatement(query);
					  ps.setString(1, s1);
					  ps.setString(2, s2);
					 int i=ps.executeUpdate();
					 if(i==1)
					     JOptionPane.showMessageDialog(null, "Brand inserted Successfully!!!"); 
					 else
						 JOptionPane.showMessageDialog(null, "Brand not Inserted. Please try again!!!"); 
					 
				 }
				  catch(Exception e) {
					  e.printStackTrace();
				  }
				  
				  c1.removeAllItems();
				  c1.insertItemAt("Select",0);
				  query="Select * from brand";
					try {
						 PreparedStatement ps=con.prepareStatement(query);
						 java.sql.ResultSet rs=ps.executeQuery();
						 while(rs.next())
						 {
							 String name=rs.getString("brandname");
							 c1.addItem(name);
						 }				
						 	ps.close();
							rs.close();
					}
					catch(Exception e) {
						 e.printStackTrace();	
					}	  
					
					c1.setSelectedIndex(0);
				  }
			}
		});
		btnAddNewBrand.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnAddNewBrand.setBounds(398, 153, 139, 36);
		panel_2.add(btnAddNewBrand);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(0, 0, 547, 337);
		panel_1.add(panel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Generate Bill");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblNewLabel_7.setBounds(0, 0, 547, 49);
		panel_5.add(lblNewLabel_7);
		
		tfSrch = new JTextField();
		tfSrch.setBounds(22, 60, 148, 34);
		panel_5.add(tfSrch);
		tfSrch.setColumns(10);
		
		
		
		c1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c1.removeAllItems();
				Connection con=DBInfo.getCon();
				String query="Select * from brand";
				try {
					 PreparedStatement ps=con.prepareStatement(query);
					 java.sql.ResultSet rs=ps.executeQuery();
					 while(rs.next())
					 {
						 String name=rs.getString("brandname");
						 c1.addItem(name);
					 }				
					 	ps.close();
						rs.close();
				}
				catch(Exception e2) {
					 e2.printStackTrace();	
				}
			}
		});
		
		
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s = tfSrch.getText();
				Connection con=DBInfo.getCon();
				String query="Select * from item where item like '%"+s+"%'";
				cbOption.removeAllItems();
				try {
					 PreparedStatement ps=con.prepareStatement(query);
					 java.sql.ResultSet rs=ps.executeQuery();
					 while (rs.next()) {
						 cbOption.addItem(rs.getString(2));
					 }
					 	ps.close();
						rs.close();
				}
				catch(Exception e2) {
					 e2.printStackTrace();	
				}
				
			}
		});
		btnNewButton_2.setBounds(180, 60, 112, 34);
		panel_5.add(btnNewButton_2);
		
		
		cbOption.setBounds(308, 60, 173, 34);
		panel_5.add(cbOption);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfItem.setText((String)cbOption.getSelectedItem());
			}
		});
		lblNewLabel_10.setIcon(new ImageIcon("F:\\JAVA ECLIPSE\\GroceryManagement\\src\\Go.png"));
		lblNewLabel_10.setBounds(491, 60, 46, 34);
		panel_5.add(lblNewLabel_10);
		
		tfQu = new JTextField();
		tfQu.setHorizontalAlignment(SwingConstants.CENTER);
		tfQu.setText("0");
		tfQu.setToolTipText("Enter Quantity");
		tfQu.setBounds(22, 157, 148, 34);
		panel_5.add(tfQu);
		tfQu.setColumns(10);
		
		DefaultTableModel model1 = new DefaultTableModel() ;
		 model1.addColumn("Item Name");
		 model1.addColumn("Price");
		 model1.addColumn("Quantity");
		 model1.addColumn("Amount");
		
		JButton btnNewButton_3 = new JButton("Add Item To List");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = tfItem.getText();
				int quantity = Integer.parseInt(tfQu.getText());
				float price = 0.0f;
				Connection con = DBInfo.getCon();
				String query = "select * from item where item = '"+ item +"'";
				try {
					PreparedStatement ps=con.prepareStatement(query);
					 java.sql.ResultSet rs=ps.executeQuery();
					 while (rs.next()) {
						 price = Float.parseFloat(rs.getString(5));
					 }
					 	ps.close();
						rs.close();
				}catch(Exception e3){
					e3.printStackTrace();
				}
				float cost = quantity*price;
				billAmount += cost; 
				
				model1.addRow(new String[] {item, Float.toString(price), Integer.toString(quantity), Float.toString(cost)});
				table_1.setModel(model1);
				tfBill.setText("Total bill amount - " + billAmount);
				
				tfSrch.setText("");
				tfItem.setText("");
				tfQu.setText("0");
				cbOption.removeAllItems();
			}
		});
		btnNewButton_3.setBounds(22, 202, 148, 34);
		panel_5.add(btnNewButton_3);
		
		tfItem = new JTextField();
		tfItem.setEditable(false);
		tfItem.setBounds(22, 112, 148, 34);
		panel_5.add(tfItem);
		tfItem.setColumns(10);
		
		JButton btnNewButton_3_1 = new JButton("Generate Bill");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Final Bill Amount Generated is - " + billAmount);
				model1.setRowCount(0);
			}
		});
		btnNewButton_3_1.setBounds(22, 247, 148, 34);
		panel_5.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_1_1 = new JButton("Reset List");
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				billAmount =  0.0f;
				tfBill.setText("Total bill amount - " + billAmount);
				model1.setRowCount(0);
				tfSrch.setText("");
				tfItem.setText("");
				tfQu.setText("0");
				cbOption.removeAllItems();
			}
		});
		btnNewButton_3_1_1.setBounds(22, 292, 148, 34);
		panel_5.add(btnNewButton_3_1_1);
		
		tfBill = new JTextField();
		tfBill.setEditable(false);
		tfBill.setBounds(180, 292, 357, 34);
		panel_5.add(tfBill);
		tfBill.setColumns(10);
		
		table_1 = new JTable();
		table_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table_1.setBounds(180, 105, 357, 176);
		panel_5.add(table_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 0, 547, 337);
		panel_1.add(panel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Update Item");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblNewLabel_5.setBounds(0, 0, 547, 48);
		panel_3.add(lblNewLabel_5);
		
		tfSearch = new JTextField();
		tfSearch.setColumns(10);
		tfSearch.setBounds(10, 59, 146, 27);
		panel_3.add(tfSearch);
		
		
		cb1.setBounds(388, 59, 149, 27);
		panel_3.add(cb1);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s = tfSearch.getText();
				Connection con=DBInfo.getCon();
				String query="Select * from item where item like '%"+s+"%'";
				cb1.removeAllItems();
				try {
					 PreparedStatement ps=con.prepareStatement(query);
					 java.sql.ResultSet rs=ps.executeQuery();
					 while (rs.next()) {
						 cb1.addItem(rs.getString(2));
					 }
					 	ps.close();
						rs.close();
				}
				catch(Exception e2) {
					 e2.printStackTrace();	
				}
			}
		});
		btnNewButton_1.setBounds(199, 59, 146, 27);
		panel_3.add(btnNewButton_1);
		
		JLabel lblNewLabel_8_2_1 = new JLabel("Item Id");
		lblNewLabel_8_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_8_2_1.setBounds(20, 139, 98, 36);
		panel_3.add(lblNewLabel_8_2_1);
		
		JLabel lblNewLabel_8_2_1_1 = new JLabel("Quantity");
		lblNewLabel_8_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_8_2_1_1.setBounds(20, 186, 98, 36);
		panel_3.add(lblNewLabel_8_2_1_1);
		
		JLabel lblNewLabel_8_2_1_2 = new JLabel("Selling Price");
		lblNewLabel_8_2_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_8_2_1_2.setBounds(20, 233, 98, 36);
		panel_3.add(lblNewLabel_8_2_1_2);
		
		JLabel lblNewLabel_8_2_1_3 = new JLabel("Item Name");
		lblNewLabel_8_2_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_8_2_1_3.setBounds(279, 139, 98, 36);
		panel_3.add(lblNewLabel_8_2_1_3);
		
		JLabel lblNewLabel_8_2_1_4 = new JLabel("Price");
		lblNewLabel_8_2_1_4.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_8_2_1_4.setBounds(279, 186, 98, 36);
		panel_3.add(lblNewLabel_8_2_1_4);
		
		JLabel lblNewLabel_8_2_1_5 = new JLabel("Brand");
		lblNewLabel_8_2_1_5.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_8_2_1_5.setBounds(279, 233, 98, 36);
		panel_3.add(lblNewLabel_8_2_1_5);
		
		tfId = new JTextField();
		tfId.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfId.setEditable(false);
		tfId.setColumns(10);
		tfId.setBounds(128, 139, 139, 36);
		panel_3.add(tfId);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfName.setColumns(10);
		tfName.setBounds(398, 139, 139, 36);
		panel_3.add(tfName);
		
		tfQty = new JTextField();
		tfQty.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfQty.setColumns(10);
		tfQty.setBounds(128, 186, 139, 36);
		panel_3.add(tfQty);
		
		tfSPrice = new JTextField();
		tfSPrice.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfSPrice.setColumns(10);
		tfSPrice.setBounds(128, 233, 139, 36);
		panel_3.add(tfSPrice);
		
		tfPrice = new JTextField();
		tfPrice.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfPrice.setColumns(10);
		tfPrice.setBounds(398, 186, 139, 36);
		panel_3.add(tfPrice);
		
		cb2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		cb2.setBounds(398, 233, 139, 36);
		panel_3.add(cb2);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=DBInfo.getCon();
				String query = "update item set item = '" + tfName.getText() + "', quantity = '" + tfQty.getText() + "', costprice = '" + tfPrice.getText() + "', sellprice = '" + tfSPrice.getText() + "', brand = '" + cb2.getSelectedItem() + "' where itemid = '" + tfId.getText() + "'";
				PreparedStatement ps;
				try {
					ps = con.prepareStatement(query);
					int rs=ps.executeUpdate();
					JOptionPane.showMessageDialog(null, rs+" item updated !!!!");
					reset2();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
			}

			
		});
		btnUpdate.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnUpdate.setBounds(178, 290, 89, 36);
		panel_3.add(btnUpdate);
		
		JButton btnNewButton_2_1 = new JButton("Reset");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset2();
			}
		});
		btnNewButton_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnNewButton_2_1.setBounds(279, 290, 89, 36);
		panel_3.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String item = (String) cb1.getSelectedItem();
				Connection con=DBInfo.getCon();
				String cb = "Select * from brand";
				cb2.removeAllItems();
				try {
					PreparedStatement ps=con.prepareStatement(cb);
					 java.sql.ResultSet rs=ps.executeQuery();
					 while(rs.next())
						 cb2.addItem(rs.getString(2));
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				String query="Select * from item where item='"+item+"'";
						try {
							 PreparedStatement ps=con.prepareStatement(query);
							 java.sql.ResultSet rs=ps.executeQuery();
							 while (rs.next()) {	
								tfId.setText(rs.getString(1));
								tfName.setText(rs.getString(2));
								tfQty.setText(rs.getString(3));
								tfPrice.setText(rs.getString(4));
								tfSPrice.setText(rs.getString(5));
								cb2.setSelectedItem(rs.getString(6));
							 }
							 	ps.close();
								rs.close();
						}
						catch(Exception e2) {
							 e2.printStackTrace();	
						}
			}
		});
		lblNewLabel_9.setIcon(new ImageIcon("F:\\JAVA ECLIPSE\\GroceryManagement\\src\\Go.png"));
		lblNewLabel_9.setBounds(491, 97, 46, 36);
		panel_3.add(lblNewLabel_9);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(0, 0, 547, 337);
		panel_1.add(panel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Stock");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblNewLabel_6.setBounds(0, 0, 547, 49);
		panel_4.add(lblNewLabel_6);
		
		DefaultTableModel model = new DefaultTableModel() ;
		 model.addColumn("Item ID");
		 model.addColumn("Item Name");
		 model.addColumn("Quantity");
		 model.addColumn("Cost Price");
		 model.addColumn("Sell Price");
		 model.addColumn("Brand");
		
		JLabel lblNewLabel_9_1 = new JLabel("");
		lblNewLabel_9_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection con=DBInfo.getCon();
				String query="Select * from item";
				//model.removeRow(0);
				model.setRowCount(0);
				try {
					 PreparedStatement ps=con.prepareStatement(query);
					 java.sql.ResultSet rs=ps.executeQuery();
					 while(rs.next())
					 {	
						 model.addRow(new String[] {rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
					 }				
					 	ps.close();
						rs.close();
					table.setModel(model);
					table.setAutoResizeMode(0);
					table.getColumnModel().getColumn(0).setPreferredWidth(40);
					table.getColumnModel().getColumn(1).setPreferredWidth(150);
					table.getColumnModel().getColumn(2).setPreferredWidth(40);
					table.getColumnModel().getColumn(3).setPreferredWidth(40);
					table.getColumnModel().getColumn(4).setPreferredWidth(40);
					table.getColumnModel().getColumn(5).setPreferredWidth(120);
				}
				catch(Exception e2) {
					 e2.printStackTrace();	
				}
			}
		});
		lblNewLabel_9_1.setIcon(new ImageIcon("F:\\JAVA ECLIPSE\\GroceryManagement\\src\\Go.png"));
		lblNewLabel_9_1.setBounds(254, 60, 46, 36);
		panel_4.add(lblNewLabel_9_1);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		table.setBounds(10, 107, 527, 219);
		panel_4.add(table);
		
		JLabel lblNewLabel_1 = new JLabel("GROCERY BILL GENERATOR");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 33));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 754, 74);
		getContentPane().add(lblNewLabel_1);
		
		tab1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.setVisible(true);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				tab1.setBackground(Color.white);
				tab2.setBackground(new Color(204,204,205));
				tab3.setBackground(new Color(204,204,205));
				tab4.setBackground(new Color(204,204,205));
			}
		});
		
		tab2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.setVisible(false);
				panel_3.setVisible(true);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				tab2.setBackground(Color.white);
				tab1.setBackground(new Color(204,204,205));
				tab3.setBackground(new Color(204,204,205));
				tab4.setBackground(new Color(204,204,205));
			}
		});
		
		tab3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(true);
				panel_5.setVisible(false);
				tab3.setBackground(Color.white);
				tab2.setBackground(new Color(204,204,205));
				tab1.setBackground(new Color(204,204,205));
				tab4.setBackground(new Color(204,204,205));
			}
		});
		
		tab4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(true);
				tab4.setBackground(Color.white);
				tab2.setBackground(new Color(204,204,205));
				tab3.setBackground(new Color(204,204,205));
				tab1.setBackground(new Color(204,204,205));
			}
		});
	}
}
