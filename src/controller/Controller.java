package controller;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import dom.MedicationDOM;
import dom.UserDOM;
import model.Medication;
import model.User;
import report.Report;
import report.ReportFactory;
import validators.MedNameValidator;
import validators.MedPriceValidator;
import validators.MedQuantityValidator;
import validators.UserNameValidator;
import validators.Validator;
import view.AdminView;
import view.ChemistView;
import view.SignInView;

/**
 * Created by julia on 4/23/2018.
 */
public class Controller {
	
//	private User user;
//	private Medication medication;

	private  UserDOM userDom = new UserDOM();
	private  MedicationDOM medDom = new MedicationDOM();
	
	private AdminView adminView;
	private ChemistView chemistView;

	 private List<Validator<User>> validators;
	 private List<Validator<Medication>> validators1;

	 
	 private ReportFactory reportFactory = new ReportFactory();
	
	public Controller(AdminView adminView) {
		this.adminView = adminView;	
		this.validators = new ArrayList<Validator<User>>();
		this.validators1 = new ArrayList<Validator<Medication>>();
	}
	
	public Controller(ChemistView chemistView) {
		this.chemistView = chemistView;
		 this.validators = new ArrayList<Validator<User>>();
	}
	

	public Controller(SignInView signInView) {
		//this.signInView = signInView;
	}
	
	//Users
	public void btnAddUser() { 
		List<String> list = adminView.getUserData();
		
		User user = new User(Integer.parseInt(list.get(0)), list.get(1), list.get(2), list.get(3), list.get(4));
		try {
			for(Validator<User> v: validators) {
				v.validate(user);
			}
			Validator<User> v = new UserNameValidator();
			v.validate(user);
		
		userDom.addUser(user);	
		
		btnDisplayUsers();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void btnUpdateUser() {
		List<String> list = adminView.getUserData();
		User user = new User(Integer.parseInt(list.get(0)), list.get(1), list.get(2), list.get(3), list.get(4));
		try {
			for(Validator<User> v: validators) {
				v.validate(user);
			}
			Validator<User> v = new UserNameValidator();
			v.validate(user);
		
		userDom.updateUser(user);
		
		btnDisplayUsers();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void btnDeleteUser() {
		List<String> list = adminView.getUserData();
		int userId = Integer.parseInt(list.get(0));
		userDom.deleteUser(userId);
		
		btnDisplayUsers();
	}
	
	public  void btnDisplayUsers(){
		List<User> list = userDom.findAllUsers();
		List<Object[]> data = new ArrayList<>();
		
		for(int i = 0; i< list.size(); i++) {
			int idUser = list.get(i).getIdUser();
			String name = list.get(i).getName();
			String username = list.get(i).getUsername();
			String password = list.get(i).getPassword();
			String type = list.get(i).getType();
			
			Object[] users = {idUser, name, username, password, type};
			data.add(users);
		}
		//return data.toString();
		adminView.displayUsers(data);
	}
	
	
	public List<String> findUsers(int idUser, String name, String username, String password, String type){
		List<String> list = new ArrayList<>();
		
		list.add(Integer.toString(idUser));
		list.add(name);
		list.add(username);
		list.add(password);
		list.add(type);
		
		return list;
		
	}
	
	//Medication
	
	public  void btnDisplayMeds(){
		List<Medication> list = medDom.findAllMeds();
		List<Object[]> data = new ArrayList<>();
		
		for(int i = 0; i< list.size(); i++) {
			int idMed = list.get(i).getIdMed();
			String name = list.get(i).getName();
			String ingredients = list.get(i).getIngredients();
			String manufacturer = list.get(i).getManufacturer();
			String price = list.get(i).getPrice();
			String quantity = list.get(i).getQuantity();
			
			Object[] meds = {idMed, name, ingredients, manufacturer, price, quantity};
			data.add(meds);
		}
		//return data.toString();
		adminView.displayMeds(data);
	}
	
	public  void btnDisplayMedication(){
		List<Medication> list = medDom.findAllMeds();
		List<Object[]> data = new ArrayList<>();
		
		for(int i = 0; i< list.size(); i++) {
			int idMed = list.get(i).getIdMed();
			String name = list.get(i).getName();
			String ingredients = list.get(i).getIngredients();
			String manufacturer = list.get(i).getManufacturer();
			String price = list.get(i).getPrice();
			String quantity = list.get(i).getQuantity();
			
			Object[] meds = {idMed, name, ingredients, manufacturer, price, quantity};
			data.add(meds);
		}

		chemistView.displayMedications(data);
	}
	
	public void btnAddMed() {
		List<String> list = adminView.getMedicationData();
		Medication med = new Medication(Integer.parseInt(list.get(0)), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));
		
		try {
			for(Validator<Medication> v: validators1) {
				v.validate(med);
			}
			Validator<Medication> v = new MedNameValidator();
			Validator<Medication> v1 = new MedQuantityValidator();
			Validator<Medication> v2 = new MedPriceValidator();
			v.validate(med);
			v1.validate(med);
			v2.validate(med);
		
		medDom.addMeds(med);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		btnDisplayMeds();
	}
	
	public void btnUpdateMed() {
		List<String> list = adminView.getMedicationData();
		Medication med = new Medication(Integer.parseInt(list.get(0)), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));
		
		
		try {
			for(Validator<Medication> v: validators1) {
				v.validate(med);
			}
			Validator<Medication> v = new MedNameValidator();
			Validator<Medication> v1 = new MedQuantityValidator();
			Validator<Medication> v2 = new MedPriceValidator();
			v.validate(med);
			v1.validate(med);
			v2.validate(med);
			
		medDom.updateMeds(med);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		btnDisplayMeds();
	}
	
	
	public void btnDeleteMed() {
		List<String> list = adminView.getMedicationData();
		int idMed = Integer.parseInt(list.get(0));
		medDom.deleteMeds(idMed);
		
		btnDisplayMeds();
	}
	
	
	public List<String> findMeds(int idMed, String name, String ingredients, String manufacturer, String price, String quantity){
		List<String> list = new ArrayList<>();
		
		list.add(Integer.toString(idMed));
		list.add(name);
		list.add(ingredients);
		list.add(manufacturer);
		list.add(price);
		list.add(quantity);
		
		return list;
	}
	
	
	public Medication getMedicationByName(String medName) {
		Medication med = medDom.findMedName(medName);
		return med;
	}
	
	
	public void RowDataSelected() {
		chemistView.getRowData();
	}
	
	
	public void btnSearchMedByNameClicked() {	
		String medName = chemistView.getSearchField(); 
		Medication med = medDom.findMedName(medName);
		if (med == null) {
			errorMessage("The medication doesn't exist");
		} else {
			List<Object[]> dataList = new ArrayList<>();
			Object[] data = {med.getIdMed(), med.getName(), med.getIngredients(), med.getManufacturer(), med.getPrice(), med.getQuantity()};
			dataList.add(data);
			chemistView.displayMedications(dataList);
		}		
	}
	
	
	public List<Medication> getMedications() {
		List<Medication> medList = medDom.findAllMeds();
		return medList;
	}
	
	
	public void btnCSVClicked() {
		List<Medication> medList = getMedications();
		List<List<String>> dataList = new ArrayList<>();
		for (int i = 0; i < medList.size(); i++){
			if (medList.get(i).getQuantity().equals("0")) {	
				   int idMed = medList.get(i).getIdMed();
				   String name = medList.get(i).getName();
				   String ingredients = medList.get(i).getIngredients();
				   String manufacturer = medList.get(i).getManufacturer();
				   String quantity = medList.get(i).getQuantity();
				   String price = medList.get(i).getPrice();
				   
				   List<String> data = new ArrayList<String>();
				   data.add(Integer.toString(idMed));
				   data.add(name);
				   data.add(ingredients);
				   data.add(manufacturer);
				   data.add(quantity);
				   data.add(price);
				   dataList.add(data);
			}
		}
		// generate the csv file
		Report report = reportFactory.getReport("CSV");
		report.generateReport(dataList);		
	}

	
	public void errorMessage(String msg) {
		JOptionPane.showMessageDialog(new Frame(), msg);
	}
	
	
}
