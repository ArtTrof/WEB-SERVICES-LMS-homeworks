package client;

import client.entity.Tool;
import client.util.Handler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SAXException, ParserConfigurationException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        Handler handler = new Handler();

        File file = new File("src/main/java/power_tool/powertool.xml");
        if (file.exists()) {

            {
                try {
                    parser.parse(file, handler);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            List<Tool> tools = handler.getTools();

            System.out.println((char) 27 + "[34m" + "\nAll tools: " + (char) 27 + "[38m");

            for (Tool powerTool : tools) {
                System.out.println(powerTool.getModel() + " " + powerTool.getHandy() + " "
                        + powerTool.getOrigin() + " " + powerTool.getMaterial() + " "
                        + powerTool.getTc().getPowerConsumption() + " "
                        + powerTool.getTc().getProductivity() + " "
                        + powerTool.getTc().isAutonomy()
                );
            }

            System.out.println((char) 27 + "[34m" + "\nSorted by tools name: " + (char) 27 + "[38m");
            tools.sort(Comparator.comparing(Tool::getModel));
            for (Tool powerTool : tools) {
                System.out.println(powerTool.getModel() + " " + powerTool.getHandy() + " "
                        + powerTool.getOrigin() + " " + powerTool.getMaterial() + " "
                        + powerTool.getTc().getPowerConsumption() + " "
                        + powerTool.getTc().getProductivity() + " "
                        + powerTool.getTc().isAutonomy()
                );
            }

            System.out.println((char) 27 + "[34m" + "\nSorted by tools origin: " + (char) 27 + "[38m");
            tools.sort(Comparator.comparing(Tool::getOrigin));
            for (Tool powerTool : tools) {
                System.out.println(powerTool.getModel() + " " + powerTool.getHandy() + " "
                        + powerTool.getOrigin() + " " + powerTool.getMaterial() + " "
                        + powerTool.getTc().getPowerConsumption() + " "
                        + powerTool.getTc().getProductivity() + " "
                        + powerTool.getTc().isAutonomy()
                );
            }

            System.out.println((char) 27 + "[34m" + "\nSorted by tools productivity: " + (char) 27 + "[38m");
            tools.sort(Comparator.comparingInt(o -> o.getTc().getProductivity()));
            for (Tool powerTool : tools) {
                System.out.println(powerTool.getModel() + " " + powerTool.getHandy() + " "
                        + powerTool.getOrigin() + " " + powerTool.getMaterial() + " "
                        + powerTool.getTc().getPowerConsumption() + " "
                        + powerTool.getTc().getProductivity() + " "
                        + powerTool.getTc().isAutonomy()
                );
            }

        }
    }

}
