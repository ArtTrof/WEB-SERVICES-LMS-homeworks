package task4_unparsing_with_jaxB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "employees")
public class Employees {
    @XmlElement(name = "employee")
    private List<Employee> employeeList;

    @Override
    public String toString() {
        return Arrays.deepToString(employeeList.toArray());
    }
}


