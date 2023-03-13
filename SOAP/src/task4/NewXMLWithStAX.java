package task4;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NewXMLWithStAX {
    public static void main(String[] args) throws IOException, XMLStreamException {
        XMLOutputFactory factory = XMLOutputFactory.newFactory();
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter("candies.xml"));

        writer.writeStartDocument();
        writer.writeStartElement("shop");
        writer.writeStartElement("candy");
        writer.writeAttribute("id", "1");

        writer.writeStartElement("name");
        writer.writeCharacters("bee");
        writer.writeEndElement();

        writer.writeStartElement("price");
        writer.writeAttribute("kilograms", "1");
        writer.writeCharacters("100");
        writer.writeEndElement();

        writer.writeEndElement();
        writer.writeStartElement("candy");
        writer.writeAttribute("id", "2");

        writer.writeStartElement("name");
        writer.writeCharacters("ra4ok");
        writer.writeEndElement();

        writer.writeStartElement("price");
        writer.writeAttribute("kilograms", "1");
        writer.writeCharacters("50");
        writer.writeEndElement();

        writer.writeEndElement();

        writer.writeEndElement();
        writer.writeEndDocument();

        writer.flush();
        writer.close();
    }
}
