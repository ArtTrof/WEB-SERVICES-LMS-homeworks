package task4_unparsing_with_jaxB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) throws JAXBException {
        String path = String.join(File.separator, "src", "task4_unparsing_with_jaxB", "employees.xml");
        File file = new File(path);

        JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Employees employees;
        employees = (Employees) unmarshaller.unmarshal(file);
        System.out.println(employees);
    }
}
