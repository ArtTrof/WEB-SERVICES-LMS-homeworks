package task2.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import task2.entity.Book;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOM {
    private Document document;

    public DOM() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringComments(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
//        Path path = Paths.get("/task2/books.xml");
        document = db.parse("src/task2/books.xml");
    }

    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        Element root = document.getDocumentElement();
        NodeList nodeList = root.getElementsByTagName("book");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Book book = new Book();
            String title = root.getElementsByTagName("title").item(i).getFirstChild().getTextContent();
            String author = root.getElementsByTagName("author").item(i).getFirstChild().getTextContent();
            String id = node.getAttributes().item(0).getNodeValue();
            long isdn = Long.valueOf(node.getAttributes().item(1).getNodeValue());
            book.setTitle(title);
            book.setAuthor(author);
            book.setId(id);
            book.setIsdn(isdn);
            books.add(book);
        }
        return books;
    }


}
