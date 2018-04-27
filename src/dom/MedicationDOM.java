package dom;

import model.Medication;
import model.User;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by julia on 4/23/2018.
 */
public class MedicationDOM {
	
	private static final String PATH = "/Users/jully/Assignment2/medication.xml";

    public void addMeds(Medication med){
        String newId;

        try{
        	Document doc = DocAccess.getAccess(PATH);
        	
            Node root = doc.getDocumentElement();
            Element newMed = doc.createElement("med");

            //id tag
            Element idMed = doc.createElement("idMed");
            NodeList nodeList = doc.getElementsByTagName("med");
            newId = Integer.toString(nodeList.getLength() + 1);
            idMed.appendChild(doc.createTextNode(newId));
            newMed.appendChild(idMed);

            //name tag
            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(med.getName()));
            newMed.appendChild(name);

            //ingredients tag
            Element ingredients = doc.createElement("ingredients");
            ingredients.appendChild(doc.createTextNode(med.getIngredients()));
            newMed.appendChild(ingredients);

            //manufacturer tag
            Element manufacturer = doc.createElement("manufacturer");
            manufacturer.appendChild(doc.createTextNode(med.getManufacturer()));
            newMed.appendChild(manufacturer);

            //price tag
            Element price = doc.createElement("price");
            price.appendChild(doc.createTextNode(med.getPrice()));
            newMed.appendChild(price);

            //quantity tag
            Element quantity = doc.createElement("quantity");
            quantity.appendChild(doc.createTextNode(med.getQuantity()));
            newMed.appendChild(quantity);
            
            root.appendChild(newMed);

            DocAccess.updateXml(doc, PATH);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void updateMeds(Medication med){
        try{
        	Document doc = DocAccess.getAccess(PATH);
        	
            NodeList nodeList = doc.getElementsByTagName("med");
            for(int i = 0; i < nodeList.getLength(); i++){
                Element medUp = (Element) nodeList.item(i);
                if(Integer.parseInt(medUp.getElementsByTagName("idMed").item(0).getTextContent()) == med.getIdMed()){
                    medUp.getElementsByTagName("name").item(0).setTextContent(med.getName());
                    medUp.getElementsByTagName("ingredients").item(0).setTextContent(med.getIngredients());
                    medUp.getElementsByTagName("manufacturer").item(0).setTextContent(med.getManufacturer());
                    medUp.getElementsByTagName("price").item(0).setTextContent(med.getPrice());
                    medUp.getElementsByTagName("quantity").item(0).setTextContent(med.getQuantity());
                }
            }
            DocAccess.updateXml(doc, PATH);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteMeds(int id){
        try{
        	Document doc = DocAccess.getAccess(PATH);
        	
            NodeList nodeList = doc.getElementsByTagName("med");
            for(int i = 0; i < nodeList.getLength(); i++){
                Element med = (Element) nodeList.item(i);
                System.out.println(med);
                if(Integer.parseInt(med.getElementsByTagName("idMed").item(0).getTextContent()) == id){
                    med.getParentNode().removeChild(med);
                }
            }
            DocAccess.updateXml(doc, PATH);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    
    public List<Medication> findAllMeds(){

        List<Medication> list = new ArrayList<Medication>();

        try{
        	Document doc = DocAccess.getAccess(PATH);
        	
            NodeList nodeList = doc.getElementsByTagName("med");
            for(int i = 0; i < nodeList.getLength(); i++){
                Element med = (Element) nodeList.item(i);
                int idMed = Integer.parseInt(med.getElementsByTagName("idMed").item(0).getTextContent());
                String name = med.getElementsByTagName("name").item(0).getTextContent();
                String ingredients = med.getElementsByTagName("ingredients").item(0).getTextContent();
                String manufacturer = med.getElementsByTagName("manufacturer").item(0).getTextContent();
                String price = med.getElementsByTagName("price").item(0).getTextContent();
                String quantity = med.getElementsByTagName("quantity").item(0).getTextContent();

                Medication med1 = new Medication(idMed, name, ingredients, manufacturer, price, quantity); 
                System.out.println(idMed);
				list.add(med1);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

	public Medication findMedName(String medName) {   //folosit pt vanzare
		Medication med = null;
		try{ 
			Document doc = DocAccess.getAccess(PATH);  
			  NodeList nodeList = doc.getElementsByTagName("med");		
			
			boolean found = false;
			for(int i=0; i<nodeList.getLength() && found == false; i++) { 
				Element medEl = (Element) nodeList.item(i);
				
				if (medEl.getElementsByTagName("name").item(0).getTextContent().equals(medName)) {  
					found = true;
					
					int idMed = Integer.parseInt(medEl.getElementsByTagName("idMed").item(0).getTextContent());  
					String name = medEl.getElementsByTagName("name").item(0).getTextContent(); 
					String ingredients = medEl.getElementsByTagName("ingredients").item(0).getTextContent();  
					String manufacturer = medEl.getElementsByTagName("manufacturer").item(0).getTextContent(); 
					String price = medEl.getElementsByTagName("price").item(0).getTextContent();	
					String quantity = medEl.getElementsByTagName("quantity").item(0).getTextContent();
								
					med = new Medication(idMed, name, ingredients, manufacturer, price, quantity);   
				}
			}
								
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return med;
	}

	
	

}
