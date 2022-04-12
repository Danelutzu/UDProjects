package Model;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



public class PersistentaUtilizator {
    private final ArrayList<Utilizator> utilizatori;

    public PersistentaUtilizator(){
        this.utilizatori = new ArrayList<>();
        citireXML();
    }
    public ArrayList<Utilizator> getUtilizatori(){
        return utilizatori;
    }

    public void citireXML()  {
        try{
            File xmlDoc =  new File("src/main/java/Model/utilizatori.xml");
            DocumentBuilderFactory dbFact=DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuild=dbFact.newDocumentBuilder();
            org.w3c.dom.Document doc = dBuild.parse(xmlDoc);

            NodeList utilizatoriXML=doc.getElementsByTagName("utilizator");

            for(int i = 0; i < utilizatoriXML.getLength(); i++)
            {

                Node utilizator = utilizatoriXML.item(i);
                if(utilizator.getNodeType()==Node.ELEMENT_NODE){
                    Element eUtilizator = (Element) utilizator;
                    Utilizator newUser = new Utilizator();
                    newUser.setId(eUtilizator.getElementsByTagName("id").item(0).getTextContent());
                    newUser.setUsername( eUtilizator.getElementsByTagName("username").item(0).getTextContent());
                    newUser.setPassword( eUtilizator.getElementsByTagName("password").item(0).getTextContent());
                    newUser.setRole( eUtilizator.getElementsByTagName("role").item(0).getTextContent());

                    utilizatori.add(newUser);
                }

            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }


    }
    public void scrieXML() {

        try {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element root = document.createElement("ROOT");

            // root element

            document.appendChild(root);

            Element listElementeUtilizatori = document.createElement("utilizatori");
            root.appendChild(listElementeUtilizatori);

            for (Utilizator u : utilizatori) {
                System.out.println(u);
                Element newUser = document.createElement("utilizator");
                Element id = document.createElement("id");
                id.appendChild(document.createTextNode(u.getId()));
                newUser.appendChild(id);

                Element nume = document.createElement("username");
                nume.appendChild(document.createTextNode(u.getUsername()));
                newUser.appendChild(nume);

                Element parola = document.createElement("password");
                parola.appendChild(document.createTextNode(u.getPassword()));
                newUser.appendChild(parola);

                Element rol = document.createElement("role");
                rol.appendChild(document.createTextNode(u.getRole()));
                newUser.appendChild(rol);

                listElementeUtilizatori.appendChild(newUser);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("src/main/java/Model/utilizatori.xml"));

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(domSource, streamResult);


        } catch (Exception e) {
            System.out.println("Write Error:");
            System.out.println(e.getMessage());
        }

    }
    public Utilizator getUtilizator(String userID, String password){
        for (Utilizator u: utilizatori) {
            if(u.getUsername().equals(userID) && u.getPassword().equals(password)){
//                System.out.println(u);
                return u;
            }
        }
        return null;
    }
    public void deleteUtilizator(String id){
        utilizatori.removeIf(u -> u.getId().equals(id));
        scrieXML();
    }
    public void updateUtilizator(Utilizator utilizator){
        for (Utilizator u: utilizatori) {
            if(u.getId().equals(utilizator.getId())){
                u.setUsername(utilizator.getUsername());
                u.setRole(utilizator.getRole());
                u.setPassword(utilizator.getPassword());
            }
        }
        scrieXML();
    }
    public String addUtilizator(Utilizator utilizator){
        for (Utilizator u: utilizatori) {
            if(u.getId().equals(utilizator.getId())){
                return "Error: ID nu este unic!";
            }
        }
        utilizatori.add(utilizator);
        scrieXML();
        return "Utilizator adaugat cu succes!";
    }

}

