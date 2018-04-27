package dom;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by julia on 4/21/2018.
 */
public class DocAccess {

    public static Document getAccess(String path_to_file){
        Document doc = null;

        try {
        //    File file = new File("/Users/jully/Assignment2/users.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
            doc = docBuilder.parse(path_to_file);
        } catch(Exception e){
            e.printStackTrace();
        }
        return doc;
    }

    public static void printDocument(NodeList list){

        for (int count = 0; count < list.getLength(); count++){
            Node temp = list.item(count);
            System.out.println("Node: " + temp.getNodeName());

            if(temp.getNodeType() == Node.ELEMENT_NODE){
                System.out.println("Element: " + temp.getTextContent()); //pt ca iau tot textul deodata?

                if(temp.hasAttributes()){
                    NamedNodeMap nodeMap = temp.getAttributes();

                    for(int i = 0 ; i < nodeMap.getLength(); i++){
                        Node node = nodeMap.item(i);
                        System.out.println("Attribute name: " + node.getNodeName());
                        System.out.println("Attribute value: " + node.getNodeValue());
                    }
                }
            }
        }
    }


    public static void updateXml(Document doc, String path_to_file){

            try {

                NodeList list = doc.getElementsByTagName("user");
                Node node = list.item(0);
          //      System.out.println(node.getNodeName());

                Element el = (Element) node;
             //   System.out.println(el.getElementsByTagName("idUser").item(0).getTextContent());
               // el.getElementsByTagName("idUser").item(0).setTextContent("10"); //schimba id-ul elementului de la index 0
              //  el.getElementsByTagName("name").item(0).setTextContent("10");
              //  el.getElementsByTagName("username").item(0).setTextContent("10");
              //  el.getElementsByTagName("password").item(0).setTextContent("10");

                TransformerFactory transFact = TransformerFactory.newInstance();
                Transformer transformer = transFact.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(path_to_file));
                transformer.transform(source, result);

                System.out.println("Done");
            } catch (TransformerException tfe) {
                tfe.printStackTrace();
            }
    }
}
