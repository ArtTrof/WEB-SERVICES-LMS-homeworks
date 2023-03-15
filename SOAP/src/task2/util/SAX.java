package task2.util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import task2.entity.Book;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SAX extends DefaultHandler {
    private String currentQName;
    private List<Book> books;
    private Book currentBook;
    private String currentAttribute;
    private String currentSecondAttribute;

    public SAX() {
        books = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
        currentQName = qName;
        if (attributes.getLength() > 0) {
            currentAttribute = attributes.getValue(0);
            currentSecondAttribute = attributes.getValue(1);//doesn't work attributes finding
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        System.out.println("Characters: " + value);
        switch (currentQName) {
            case "book":
                currentBook = new Book();
                currentBook.setId(currentAttribute);//todo
                currentBook.setIsdn(Long.parseLong(currentSecondAttribute));
                break;
            case "title":
                currentBook.setTitle(value);
                break;
            case "author":
                currentBook.setAuthor(value);
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
        currentQName = "";

        if (qName.equals("book")) {
            books.add(currentBook);
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void endDocument() throws SAXException {
        currentBook = null;
    }

    public static List<Book> parseBooksWithSax() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        SAX sax = new SAX();
        String path = String.join(File.separator, "src", "task2", "books.xml");
        File file = new File(path);
        if (file.exists()) {
            saxParser.parse(file, sax);
            return sax.getBooks();
        } else
            throw new RuntimeException();
    }
}
