package start;

import dom.DocAccess;
import dom.MedicationDOM;
import dom.UserDOM;
import model.Medication;
import model.User;
import report.Report;
import report.ReportFactory;
import view.AdminView;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import controller.Controller;

/**
 * Created by julia on 4/21/2018.
 */
public class Start {
	
    public static void main(String[] args){

    	AdminView adminView = new AdminView();
    	Controller controller = new Controller(adminView);
        Document doc = DocAccess.getAccess("/Users/jully/Assignment2/users.xml");
      
        
        DocAccess.printDocument(doc.getChildNodes());

      //  DocAccess.updateXml(doc);
        User user = new User(5, "Pop Carmen", "carmen2", "parola", "user");

       // UserDOM.addUser(user);
       // UserDOM.deleteUser(3);
       // UserDOM.updateUser(user);

    
        UserDOM userDom = new UserDOM();
        MedicationDOM medDom = new MedicationDOM();
        
       // userDom.findAllUsers();
       // medDom.findAllMeds();
        
   //     Medication med = new Medication(4, "Aerius", "antihistaminics", "Pharma Industry", "23.45", "7");
       // medDom.addMeds(med);
        
        medDom.findMedName("Claritine");
    

    }
}
