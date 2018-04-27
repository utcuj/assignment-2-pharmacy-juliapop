package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.NodeList;

import controller.Controller;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class AdminView {

	private JFrame frame;
	private JTextArea textArea;
	private JTextField textFieldUserId;
	private JTextField textFieldUserName;
	private JTextField textFieldUserUsername;
	private JTextField textFieldUserPassword;
	private JTextField textFieldUserType;

	private JButton btnShowClients;
	private JButton btnAddUser;
	private JButton btnUpdateUser;
	private JButton btnDeleteUser;
	private JTextField textFieldMedId;
	private JTextField textFieldMedName;
	private JTextField textFieldMedIngredients;
	private JTextField textFieldMedManufacturer;
	private JTextField textFieldMedPrice;
	private JTextField textFieldMedQuantity;
	
	private JButton btnAddMed;
	private JButton btnUpdateMed;
	private JButton btnDeleteMed;
	
	
	private JButton btnGeneratePdf;
	private JButton btnGenerateCsv;
	
	private Controller controller;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	
	private DefaultTableModel tableModel;
	private String col_table[]= {"idUser", "name", "username", "password", "type"};
	private JTable table_1;
	
	private DefaultTableModel tableModel_2;
	private String col_table_2[]=  {"Med ID", "Name", "Ingredients", "Manufacturer", "Price", "Quantity"} ;
	private JTable table_2;
	private JButton btnShowMeds;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView window = new AdminView();
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
	public AdminView() {
		controller = new Controller(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Administrator View");
		frame.setBounds(100, 100, 711, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(124, 51, 278, 209);
		frame.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		tableModel = new DefaultTableModel(col_table, 0);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getRowDataTable1();
			}
		});
		//JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setBounds(124, 51, 278, 209);
		//frame.getContentPane().add(scrollPane);
		
	//	textArea = new JTextArea();
	//	textArea.setEditable(false);
	//	scrollPane.setViewportView(textArea);
		
		scrollPane_1 = new JScrollPane(table_2);
		scrollPane_1.setBounds(412, 51, 273, 209);
		frame.getContentPane().add(scrollPane_1);
		
		table_2 = new JTable();
		scrollPane_1.setViewportView(table_2);
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getRowDataTable2();
			}
		});
		tableModel_2 = new DefaultTableModel(col_table_2, 0);
		
		JLabel lblUsers = new JLabel("Users");
		lblUsers.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblUsers.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsers.setBounds(184, 26, 122, 14);
		frame.getContentPane().add(lblUsers);
		
		JLabel lblMedication = new JLabel("Medication");
		lblMedication.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedication.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblMedication.setBounds(456, 26, 122, 14);
		frame.getContentPane().add(lblMedication);
		
		btnAddUser = new JButton("Add user");
		btnAddUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.btnAddUser();
			}
		});
		btnAddUser.setBounds(144, 271, 76, 23);
		frame.getContentPane().add(btnAddUser);
		
		btnUpdateUser = new JButton("Update user");
		btnUpdateUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.btnUpdateUser();
			}
		});
		btnUpdateUser.setBounds(230, 271, 76, 23);
		frame.getContentPane().add(btnUpdateUser);
		
		btnDeleteUser = new JButton("Delete user");
		btnDeleteUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.btnDeleteUser();
			}
		});
		btnDeleteUser.setBounds(316, 271, 76, 23);
		frame.getContentPane().add(btnDeleteUser);
		
		btnAddMed = new JButton("Add med");
		btnAddMed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.btnAddMed();
			}
		});
		btnAddMed.setBounds(422, 271, 76, 23);
		frame.getContentPane().add(btnAddMed);
		
		btnUpdateMed = new JButton("Update med");
		btnUpdateMed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.btnUpdateMed();
			}
		});
		btnUpdateMed.setBounds(511, 271, 76, 23);
		frame.getContentPane().add(btnUpdateMed);
		
		btnDeleteMed = new JButton("Delete med");
		btnDeleteMed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.btnDeleteMed();
			}
		});
		btnDeleteMed.setBounds(597, 271, 79, 23);
		frame.getContentPane().add(btnDeleteMed);
		
		btnGeneratePdf = new JButton("Generate PDF");
		btnGeneratePdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGeneratePdf.setBounds(10, 211, 104, 36);
		frame.getContentPane().add(btnGeneratePdf);
		
		btnGenerateCsv = new JButton("Generate CSV");
		btnGenerateCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.btnCSVClicked();
			}
		});
		btnGenerateCsv.setBounds(10, 258, 104, 36);
		frame.getContentPane().add(btnGenerateCsv);
		
		textFieldUserId = new JTextField();
		textFieldUserId.setBounds(124, 327, 151, 23);
		frame.getContentPane().add(textFieldUserId);
		textFieldUserId.setColumns(10);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setColumns(10);
		textFieldUserName.setBounds(124, 348, 151, 20);
		frame.getContentPane().add(textFieldUserName);
		
		textFieldUserUsername = new JTextField();
		textFieldUserUsername.setColumns(10);
		textFieldUserUsername.setBounds(124, 366, 151, 20);
		frame.getContentPane().add(textFieldUserUsername);
		
		textFieldUserPassword = new JTextField();
		textFieldUserPassword.setColumns(10);
		textFieldUserPassword.setBounds(124, 383, 151, 23);
		frame.getContentPane().add(textFieldUserPassword);
		
		textFieldUserType = new JTextField();
		textFieldUserType.setColumns(10);
		textFieldUserType.setBounds(124, 405, 151, 20);
		frame.getContentPane().add(textFieldUserType);
		
		textFieldMedId = new JTextField();
		textFieldMedId.setColumns(10);
		textFieldMedId.setBounds(472, 327, 151, 23);
		frame.getContentPane().add(textFieldMedId);
		
		textFieldMedName = new JTextField();
		textFieldMedName.setColumns(10);
		textFieldMedName.setBounds(472, 348, 151, 20);
		frame.getContentPane().add(textFieldMedName);
		
		textFieldMedIngredients = new JTextField();
		textFieldMedIngredients.setColumns(10);
		textFieldMedIngredients.setBounds(472, 366, 151, 20);
		frame.getContentPane().add(textFieldMedIngredients);
		
		textFieldMedManufacturer = new JTextField();
		textFieldMedManufacturer.setColumns(10);
		textFieldMedManufacturer.setBounds(472, 383, 151, 23);
		frame.getContentPane().add(textFieldMedManufacturer);
		
		textFieldMedPrice = new JTextField();
		textFieldMedPrice.setColumns(10);
		textFieldMedPrice.setBounds(472, 405, 151, 20);
		frame.getContentPane().add(textFieldMedPrice);
		
		textFieldMedQuantity = new JTextField();
		textFieldMedQuantity.setColumns(10);
		textFieldMedQuantity.setBounds(472, 423, 151, 23);
		frame.getContentPane().add(textFieldMedQuantity);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(62, 331, 46, 14);
		frame.getContentPane().add(lblUserId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(62, 351, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(60, 369, 54, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(60, 387, 46, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(62, 408, 46, 14);
		frame.getContentPane().add(lblType);
		
		JLabel lblMedId = new JLabel("Med ID");
		lblMedId.setBounds(389, 331, 46, 14);
		frame.getContentPane().add(lblMedId);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(389, 351, 46, 14);
		frame.getContentPane().add(lblName_1);
		
		JLabel lblIngredients = new JLabel("Ingredients");
		lblIngredients.setBounds(389, 369, 73, 14);
		frame.getContentPane().add(lblIngredients);
		
		JLabel lblManufacturer = new JLabel("Manufacturer");
		lblManufacturer.setBounds(389, 387, 73, 14);
		frame.getContentPane().add(lblManufacturer);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(389, 408, 46, 14);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(389, 427, 46, 14);
		frame.getContentPane().add(lblQuantity);
		
		btnShowClients = new JButton("Show Clients");
		btnShowClients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.btnDisplayUsers();
			}
		});
		btnShowClients.setBounds(10, 48, 104, 23);
		frame.getContentPane().add(btnShowClients);
		
		btnShowMeds = new JButton("Show Meds");
		btnShowMeds.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.btnDisplayMeds();
			}
		});
		btnShowMeds.setBounds(10, 105, 89, 23);
		frame.getContentPane().add(btnShowMeds);
	}
	
	
	
	public void displayUsers(List<Object[]> list) {
		tableModel.setRowCount(0);
		table_1.setModel(tableModel);
		
		for(Object[] user: list) {
			tableModel.addRow(user);
		}
	}
	
	public void displayMeds(List<Object[]> list) {
		tableModel_2.setRowCount(0);
		table_2.setModel(tableModel_2);
		
		for(Object[] med: list) {
			tableModel_2.addRow(med);
		}
	}
	
	public List<String> getUserData(){
		List<String> list = new ArrayList<>();
		
		int userId = Integer.parseInt(textFieldUserId.getText());
		String name = textFieldUserName.getText();
		String username = textFieldUserUsername.getText();
		String password = textFieldUserPassword.getText();
		String type = textFieldUserType.getText();
		
		list.add(Integer.toString(userId));
		list.add(name);
		list.add(username);
		list.add(password);
		list.add(type);
		
		return list;
		
	}
	
	
	public List<String> getMedicationData() {
		List<String> list = new ArrayList<String>();
		
		 int medId = Integer.parseInt(textFieldMedId.getText());
		 String name = textFieldMedName.getText();
		 String ingredients = textFieldMedIngredients.getText();
		 String manufacturer = textFieldMedManufacturer.getText();
		 String price = textFieldMedPrice.getText();
		 String quantity = textFieldMedQuantity.getText();
		
		 
		 list.add(Integer.toString(medId));
		 list.add(name);
		 list.add(ingredients);
		 list.add(manufacturer);
		 list.add(price);
		 list.add(quantity);
		 
		return list;	
	}
	
	
	
	
	private void getRowDataTable1() {
		DefaultTableModel model = (DefaultTableModel)table_1.getModel();
		int selectedRowIndex = table_1.getSelectedRow();
		
		textFieldUserId.setText(model.getValueAt(selectedRowIndex, 0).toString());
		textFieldUserName.setText(model.getValueAt(selectedRowIndex, 1).toString());
		textFieldUserUsername.setText(model.getValueAt(selectedRowIndex, 2).toString());
		textFieldUserPassword.setText(model.getValueAt(selectedRowIndex, 3).toString());
		textFieldUserType.setText(model.getValueAt(selectedRowIndex, 4).toString());
		
	}
	
	
	
	private void getRowDataTable2() {
		// get the model from the jtable
	    DefaultTableModel model = (DefaultTableModel)table_2.getModel();

	    // get the selected row index
	    int selectedRowIndex = table_2.getSelectedRow();
	       
	    // set the selected row data into jtextfields
	    textFieldMedId.setText(model.getValueAt(selectedRowIndex, 0).toString());
	    textFieldMedName.setText(model.getValueAt(selectedRowIndex, 1).toString());
	    textFieldMedIngredients.setText(model.getValueAt(selectedRowIndex, 2).toString());
	    textFieldMedManufacturer.setText(model.getValueAt(selectedRowIndex, 3).toString());
	    textFieldMedPrice.setText(model.getValueAt(selectedRowIndex, 5).toString());    
	    textFieldMedQuantity.setText(model.getValueAt(selectedRowIndex, 4).toString());
	}
	
}
