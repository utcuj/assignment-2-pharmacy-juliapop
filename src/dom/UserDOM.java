package dom;

import model.User;

import org.w3c.dom.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by julia on 4/22/2018.
 */
public class UserDOM {
	
	private static final String PATH = "/Users/jully/Assignment2/users.xml";

    public  void addUser(User user){
        String newId;

        try{
        	 Document doc = DocAccess.getAccess(PATH);
        	 
            Node root = doc.getDocumentElement();
            Element newUser = doc.createElement("user");
           // newUser.appendChild(doc.createTextNode(""));

            //id tag
            Element idUser = doc.createElement("idUser");
            NodeList nodeList = doc.getElementsByTagName("user");
            newId = Integer.toString(nodeList.getLength() + 1);
            idUser.appendChild(doc.createTextNode(newId));
            newUser.appendChild(idUser);

            //name tag
            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(user.getName()));
            newUser.appendChild(name);

            //username tag
            Element username = doc.createElement("username");
            username.appendChild(doc.createTextNode(user.getUsername()));
            newUser.appendChild(username);

            //password tag
            Element password = doc.createElement("password");
            password.appendChild(doc.createTextNode(user.getPassword()));
            newUser.appendChild(password);

            //type tag
            Element type = doc.createElement("type");
            type.appendChild(doc.createTextNode(user.getType()));
            newUser.appendChild(type);

            root.appendChild(newUser);

            DocAccess.updateXml(doc, PATH);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    public void updateUser(User user){
        try{
        	 Document doc = DocAccess.getAccess(PATH);
        	 
            NodeList nodeList = doc.getElementsByTagName("user");
            for(int i = 0; i < nodeList.getLength(); i++){
                Element userUp = (Element) nodeList.item(i);
                if(Integer.parseInt(userUp.getElementsByTagName("idUser").item(0).getTextContent()) == user.getIdUser()){
                    userUp.getElementsByTagName("name").item(0).setTextContent(user.getName());
                    userUp.getElementsByTagName("username").item(0).setTextContent(user.getUsername());
                    userUp.getElementsByTagName("password").item(0).setTextContent(user.getPassword());
                }
            }
            DocAccess.updateXml(doc, PATH);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void deleteUser(int id){
        try{
        	 Document doc = DocAccess.getAccess(PATH);
        	 
            NodeList nodeList = doc.getElementsByTagName("user");
            // System.out.println(nodeList.item(0));
            for(int i =0 ; i < nodeList.getLength(); i++){
                Element user = (Element) nodeList.item(i);
                System.out.println(user);
                if(Integer.parseInt(user.getElementsByTagName("idUser").item(0).getTextContent()) == id){
                    user.getParentNode().removeChild(user);
                }
            }
            DocAccess.updateXml(doc, PATH);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<User> findAllUsers(){

        List<User> list = new ArrayList<User>();

        try{
        	 Document doc = DocAccess.getAccess(PATH);
        	 
            NodeList nodeList = doc.getElementsByTagName("user");
            for(int i = 0; i < nodeList.getLength(); i++){
                Element user = (Element) nodeList.item(i);
                int idUser = Integer.parseInt(user.getElementsByTagName("idUser").item(0).getTextContent());
                String name = user.getElementsByTagName("name").item(0).getTextContent();
                String username = user.getElementsByTagName("username").item(0).getTextContent();
                String password = user.getElementsByTagName("password").item(0).getTextContent();
                String type = user.getElementsByTagName("type").item(0).getTextContent();
                
                User user1 = new User(idUser, name, username, password, type); 
                System.out.println(idUser);
				list.add(user1);	
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }


    public String findUser(String username, String password){
        User user = null;

        try{
        	 Document doc = DocAccess.getAccess(PATH);
        	 
            NodeList nodeList = doc.getElementsByTagName("user");
            for(int i = 0; i < nodeList.getLength(); i++){
                Element userFind = (Element) nodeList.item(i);

                if(userFind.getElementsByTagName("type").item(0).getTextContent().equals("user")){
                    return user.getType();
                }
                if(userFind.getElementsByTagName("type").item(0).getTextContent().equals("admin")){
                    return user.getType();
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }



	public User getUser(String givenUsername, String givenPassword) {
		User user = null;
		try{
			Document doc = DocAccess.getAccess(PATH);
       	 
            NodeList nodeList = doc.getElementsByTagName("user");

			for(int i=0; i<nodeList.getLength(); i++) {
				Element userEl = (Element) nodeList.item(i);	
				String username = userEl.getElementsByTagName("username").item(0).getTextContent();
				String password = userEl.getElementsByTagName("password").item(0).getTextContent();
				String type = userEl.getElementsByTagName("type").item(0).getTextContent();
				if (username.equals(givenUsername) && password.equals(givenPassword)) {
					int id = Integer.parseInt(userEl.getElementsByTagName("id").item(0).getTextContent());
					String name = userEl.getElementsByTagName("name").item(0).getTextContent();
					
					user = new User(id, name, username, password, type);
					System.out.println(id);	
					String isAdmin =  userEl.getElementsByTagName("isAdmin").item(0).getTextContent();
					//user.setIsAdmin(isAdmin);
					return user;
				}
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
