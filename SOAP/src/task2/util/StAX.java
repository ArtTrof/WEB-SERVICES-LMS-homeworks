package task2.util;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class StAX {
    public static void parseWithStax() throws FileNotFoundException, XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        String path = String.join(File.separator, "src", "task2", "books.xml");
        Reader reader = new FileReader(path);
        XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(reader);

        while (xmlStreamReader.hasNext()) {

            switch (xmlStreamReader.next()) {
                case XMLStreamReader.START_ELEMENT:

                    String elem = xmlStreamReader.getName().toString();

                    switch (elem) {
                        case "book":
                            for (int i = 0; i < xmlStreamReader.getAttributeCount(); i++) {
                                String attributeName = xmlStreamReader.getAttributeLocalName(i);
                                String attributeValue = xmlStreamReader.getAttributeValue(i);
                                System.out.println(attributeName + " " + attributeValue);
                            }
                            break;
                        case "title":
                            System.out.println("Title: " + xmlStreamReader.getElementText());
                            break;
                        case "author":
                            System.out.println("Author: " + xmlStreamReader.getElementText() + "\n");
                            break;
                    }
                    System.out.println("Start element: " + elem);
                    break;
                case XMLStreamReader.END_ELEMENT:
                    System.out.println("End element: " + xmlStreamReader.getName());
                    break;

            }
        }

    }
}
