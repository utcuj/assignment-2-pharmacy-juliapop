package view;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Controller;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignInView {

	private JFrame frmSignIn;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;

	private Controller signInController;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignInView window = new SignInView();
					window.frmSignIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignInView() {
		signInController = new Controller(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignIn = new JFrame();
		frmSignIn.setTitle("Sign In");
		frmSignIn.setBounds(100, 100, 450, 300);
		frmSignIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSignIn.getContentPane().setLayout(null);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(168, 93, 150, 20);
		frmSignIn.getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(168, 141, 150, 20);
		frmSignIn.getContentPane().add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// signInController.btnSignInClicked();
			}
		});
		btnSignIn.setBounds(200, 190, 89, 23);
		frmSignIn.getContentPane().add(btnSignIn);
	}

	
	public void displayError(String msg) {
		JOptionPane.showMessageDialog(new Frame(), msg);
	}
	
	public String[] getSignInData() {
		String username = textFieldUsername.getText();
		String password = textFieldPassword.getText();
		String[] data = {username, password};
		return data;
	}
}
