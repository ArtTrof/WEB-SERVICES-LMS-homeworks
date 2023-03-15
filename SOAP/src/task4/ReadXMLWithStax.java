package task4;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class ReadXMLWithStax {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        String path = String.join(File.separator, "candies.xml");
        Reader reader = new FileReader(path);
        XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(reader);

        while (xmlStreamReader.hasNext()) {

            switch (xmlStreamReader.next()) {
                case XMLStreamReader.START_ELEMENT:

                    String elem = xmlStreamReader.getName().toString();

                    switch (elem) {

                        case "candy":
                            System.out.println("******************");
                            System.out.println("Start element: " + elem);
                            for (int i = 0; i < xmlStreamReader.getAttributeCount(); i++) {
                                String attributeName = xmlStreamReader.getAttributeLocalName(i);
                                String attributeValue = xmlStreamReader.getAttributeValue(i);
                                System.out.println(attributeName + " " + attributeValue);
                            }
                            break;
                        case "name":
                            System.out.println("name: " + xmlStreamReader.getElementText());
                            break;
                        case "price":
                            for (int i = 0; i < xmlStreamReader.getAttributeCount(); i++) {
                                String attributeName = xmlStreamReader.getAttributeLocalName(i);
                                String attributeValue = xmlStreamReader.getAttributeValue(i);
                                System.out.println(attributeName + " " + attributeValue);
                            }
                            System.out.println("price: " + xmlStreamReader.getElementText() + "\n");
                            break;
                    }

                    break;
                case XMLStreamReader.END_ELEMENT:
                    System.out.println("End element: " + xmlStreamReader.getName());
                    System.out.println("******************");
                    break;

            }
        }
    }
}
