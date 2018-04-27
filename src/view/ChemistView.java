package view;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.Controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ChemistView {

	private JFrame frmChemistView;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textFieldMedName;
	private JTextField textFieldMedId;
	private JTextField textFieldMedQuantity;
	
	private Controller controller;
	private DefaultTableModel tableModel;
	private String col_table[]= {"Med ID", "Name", "Ingredients", "Manufacturer", "Price", "Quantity"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChemistView window = new ChemistView();
					window.frmChemistView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChemistView() {
		controller = new Controller(this);
		initialize();
		controller.btnDisplayMedication();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChemistView = new JFrame();
		frmChemistView.setTitle("Chemist View");
		frmChemistView.setBounds(100, 100, 508, 383);
		frmChemistView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChemistView.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(32, 100, 368, 101);
		frmChemistView.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.RowDataSelected();
			}
		});
		tableModel = new DefaultTableModel(col_table, 0);
		
		textFieldMedName = new JTextField();
		textFieldMedName.setBounds(32, 69, 86, 20);
		frmChemistView.getContentPane().add(textFieldMedName);
		textFieldMedName.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.btnSearchMedByNameClicked();
			}
		});
		btnSearch.setBounds(128, 66, 89, 23);
		frmChemistView.getContentPane().add(btnSearch);
		
		textFieldMedId = new JTextField();
		textFieldMedId.setBounds(108, 212, 86, 20);
		frmChemistView.getContentPane().add(textFieldMedId);
		textFieldMedId.setColumns(10);
		
		textFieldMedQuantity = new JTextField();
		textFieldMedQuantity.setBounds(108, 243, 86, 20);
		frmChemistView.getContentPane().add(textFieldMedQuantity);
		textFieldMedQuantity.setColumns(10);
		
		JButton btnSell = new JButton("Sell");
		btnSell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//controller.btnSellClicked();
			}
		});
		btnSell.setBounds(241, 211, 89, 23);
		frmChemistView.getContentPane().add(btnSell);
		
		JLabel lblMedId = new JLabel("Med ID");
		lblMedId.setBounds(32, 215, 46, 14);
		frmChemistView.getContentPane().add(lblMedId);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(32, 246, 46, 14);
		frmChemistView.getContentPane().add(lblQuantity);
		
		JLabel lblMedName = new JLabel("Med Name");
		lblMedName.setBounds(32, 49, 69, 17);
		frmChemistView.getContentPane().add(lblMedName);
	}
	
	
	
	public void getRowData() {
	    DefaultTableModel model = (DefaultTableModel)table.getModel();
	    int selectedRowIndex = table.getSelectedRow();
	    textFieldMedName.setText(model.getValueAt(selectedRowIndex, 1).toString());
	}	
	
	public void displayMedications(List<Object[]> dataList) {
		tableModel.setRowCount(0);
		table.setModel(tableModel);
		
		for(Object[] med: dataList) {
			 tableModel.addRow(med);	 
		}
	}
	
	public String getSearchField() {
		String medName = textFieldMedName.getText();
		return medName;
	}
	


	

	
}
