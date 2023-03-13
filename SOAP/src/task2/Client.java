package task2;

import org.xml.sax.SAXException;
import task2.util.StAX;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class Client {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XMLStreamException {
//        DOM domParser = new DOM();
//        List<Book> books = domParser.getAll();

//        List<Book> books = SAX.parseBooksWithSax();
//        for (Book book : books) {
//            System.out.println(book.getId() + " " + book.getIsdn()+ " " + book.getAuthor() +" " + book.getTitle());
//        }

        StAX.parseWithStax();

    }
}
