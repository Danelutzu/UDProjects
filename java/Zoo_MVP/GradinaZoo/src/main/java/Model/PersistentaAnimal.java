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
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.opencsv.CSVWriter;
import org.json.simple.JSONObject;

public class PersistentaAnimal {

        private ArrayList<Animal> animale;

        public PersistentaAnimal() {
            this.animale = new ArrayList<>();
            citireXML();
        }

        public void addAnimal(Animal animal) {

            animale.add(animal);
            scrieXML();
        }

        public void citireXML() {
            try {
                File xmlDoc = new File("src/main/java/Model/animale.xml");
                DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuild = dbFact.newDocumentBuilder();
                org.w3c.dom.Document doc = dBuild.parse(xmlDoc);

                NodeList animaleXML = doc.getElementsByTagName("animal");
                System.out.println(animaleXML.getLength());
                for (int i = 0; i < animaleXML.getLength(); i++) {

                    Node animal = animaleXML.item(i);
                    if (animal.getNodeType() == Node.ELEMENT_NODE) {

                        Element eAnimal = (Element) animal;
                        Animal newAn = new Animal();

                        newAn.setNume(eAnimal.getElementsByTagName("nume").item(0).getTextContent());
                        newAn.setSpecie(eAnimal.getElementsByTagName("specie").item(0).getTextContent());
                        newAn.setAlimentatie(eAnimal.getElementsByTagName("alimentatie").item(0).getTextContent());
                        newAn.setHabitat(eAnimal.getElementsByTagName("habitat").item(0).getTextContent());

                        animale.add(newAn);
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

                Element listElementeAnimal = document.createElement("animale");
                root.appendChild(listElementeAnimal);

                for (Animal animal : animale) {
                    System.out.println(animal);
                    Element newAnimal = document.createElement("animal");


                    Element nume = document.createElement("nume");
                    nume.appendChild(document.createTextNode(animal.getNume()));
                    newAnimal.appendChild(nume);

                    Element specie = document.createElement("specie");
                    specie.appendChild(document.createTextNode(animal.getSpecie()));
                    newAnimal.appendChild(specie);

                    Element alimentatie = document.createElement("alimentatie");
                    alimentatie.appendChild(document.createTextNode(animal.getAlimentatie()));
                    newAnimal.appendChild(alimentatie);

                    Element habitat = document.createElement("habitat");
                    habitat.appendChild(document.createTextNode(animal.getHabitat()));
                    newAnimal.appendChild(habitat);

                    listElementeAnimal.appendChild(newAnimal);
                }

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource domSource = new DOMSource(document);
                StreamResult streamResult = new StreamResult(new File("src/main/java/Model/animale.xml"));

                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.transform(domSource, streamResult);


            } catch (Exception e) {
                System.out.println("Write Error:");
                System.out.println(e.getMessage());
            }

        }

        public ArrayList<Animal> getAnimaleByNume(String nume) {
            ArrayList<Animal> animalArrayList = new ArrayList<>();
            for (Animal a : animale) {
                if (a.getNume().equals(nume)) {
                    animalArrayList.add(a);
                }
            }
            return animalArrayList;
        }

    public ArrayList<Animal> getAnimaleByHabitat(String nume) {
        ArrayList<Animal> animalArrayList = new ArrayList<>();
        for (Animal a : animale) {
            if (a.getHabitat().equals(nume)) {
                animalArrayList.add(a);
            }
        }
        return animalArrayList;
    }

    public ArrayList<Animal> getAnimaleBySpecie(String nume) {
        ArrayList<Animal> animalArrayList = new ArrayList<>();
        for (Animal a : animale) {
            if (a.getSpecie().equals(nume)) {
                animalArrayList.add(a);
            }
        }
        return animalArrayList;
    }

    public ArrayList<Animal> getAnimaleByAlimentatie(String nume) {
        ArrayList<Animal> animalArrayList = new ArrayList<>();
        for (Animal a : animale) {
            if (a.getAlimentatie().equals(nume)) {
                animalArrayList.add(a);
            }
        }
        return animalArrayList;
    }



        public void deleteAnimal(String animal) {
            System.out.println(animal);
            animale.removeIf(an -> an.getNume().equals(animal));

            scrieXML();
        }
        public void updateAnimal(String nume,String specie,String alimentatie,String habitat){
            deleteAnimal(nume);
            addAnimal(new Animal(nume,specie,alimentatie,habitat));
        }

        public void raportCSV(String name) {
            CSVWriter csvWriter = null;
            try {
                csvWriter = new CSVWriter(new FileWriter(name + ".csv"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] header = {"Nume", "Specie", "Alimentatie", "Habitat"};
            assert csvWriter != null;
            csvWriter.writeNext(header);
            List<String[]> rows = new LinkedList<>();
            for (Animal a : animale) {
                System.out.println(a.getClass());
                String[] an = a.toStringAn();

                rows.add(new String[]{an[0], an[1], an[2], an[3]});
            }
            csvWriter.writeAll(rows);
            try {
                csvWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void raportJSON(String name) {
            //Creating a JSONObject object

            Map<String, ArrayList<String>> map = new HashMap<>();
            int id = 1;
            try {
                FileWriter file = new FileWriter(name + ".json");

                for (Animal a: animale) {
                    ArrayList<String> array = new ArrayList<>();
                    array.add("Nume: "+ a.getNume());
                    array.add("Specie: " + a.getSpecie());
                    array.add("Alimentatie: " + a.getAlimentatie());
                    array.add("Habitat: " + a.getHabitat());
                    map.put("Animal " + id,array);
                    id++;
                }
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("",map);
                file.write(jsonObject.toJSONString());
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void setAnimale(ArrayList<Animal> animale){
            this.animale =animale;
        }
        public ArrayList<Animal> getAnimale(){
            return animale;
        }


        public void regetAnimale(){
            animale.removeAll(animale);
            citireXML();
        }
        public void updateAnimale(Animal animal){
            for (Animal an: animale) {
                if(an.getNume().equals(animal.getNume())){
                    an.setSpecie(animal.getSpecie());
                    an.setAlimentatie(animal.getAlimentatie());
                    an.setHabitat(an.getHabitat());
                }
            }
            scrieXML();
        }
}

