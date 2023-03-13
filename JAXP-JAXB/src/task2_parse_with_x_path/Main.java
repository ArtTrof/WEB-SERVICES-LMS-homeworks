package task2_parse_with_x_path;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {
        String path = String.join(File.separator, "src", "task2_parse_with_x_path", "employees.xml");
        File file = new File(path);

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        document.getDocumentElement().normalize();

        XPath xPath = XPathFactory.newInstance().newXPath();
        String expression = "/employees/employee";
        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println("*************");
            System.out.println("Current element : " + node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("employee id : " + element.getAttribute("id"));
                System.out.println("employee type : " + element.getAttribute("type"));
                System.out.println("firstname : " + element.getElementsByTagName("firstname").item(0).getTextContent());
                System.out.println("lastname : " + element.getElementsByTagName("lastname").item(0).getTextContent());
                System.out.println("age : " + element.getElementsByTagName("age").item(0).getTextContent());
                System.out.println("email : " + element.getElementsByTagName("email").item(0).getTextContent());
            }

        }

    }
}
