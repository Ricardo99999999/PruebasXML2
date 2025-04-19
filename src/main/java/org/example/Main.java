package org.example;

import clases.reportePlantilla;
import clases.reportePlantillaHTML;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.io.InputStream;

/*Quiero utilizar el user.dir para ver que es lo que sale*/

public class Main {
    public static void main(String[] args) {
        try {
            //File inputFile = new File("test-output/testng-results.xml");
            //File inputFile = new File("resultsTestNG.xml");
            InputStream inputFile = Main.class.getClassLoader().getResourceAsStream("resultsTestNG");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            // Document doc = dBuilder.parse(inputFile);
            Document doc = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder()
                    .parse(inputFile);

            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();
            System.out.println("Total: " + root.getAttribute("total"));
            System.out.println("Passed: " + root.getAttribute("passed"));
            System.out.println("Failed: " + root.getAttribute("failed"));
            System.out.println("Skipped: " + root.getAttribute("skipped"));

            NodeList testMethods = doc.getElementsByTagName("test-method");

            String [] names = new String[testMethods.getLength()];
            String [] statuses= new String[testMethods.getLength()];
            String [] durations= new String[testMethods.getLength()];

            for (int i = 0; i < testMethods.getLength(); i++) {
                Element method = (Element) testMethods.item(i);
                String name = method.getAttribute("name");
                String status = method.getAttribute("status");
                String duration = method.getAttribute("duration-ms");

                //Variables para utilizarlas en el fichero
                names[i]=method.getAttribute("name");
                statuses[i]=method.getAttribute("status");
                durations[i]=method.getAttribute("duration-ms");

                reportePlantilla reporte = new reportePlantilla(names[i], statuses[i], durations[i]);
                reporte.generateReport("reporte"+i+".txt");

                System.out.println("Method: " + name + " | Status: " + status + " | Duration: " + duration + "ms");

                reportePlantillaHTML reporteHTML = new reportePlantillaHTML(names[i], statuses[i], durations[i]);
                reporteHTML.generateReport("reporteHTML"+i+".html");

                System.out.println("Method: " + name + " | Status: " + status + " | Duration: " + duration + "ms");

            }
            //reportePlantilla reporte = new reportePlantilla("Nombre", "Completado", "2 horas 15 minutos");
            //reporte.generateReport("reporte.txt");

            System.out.println(System.getProperty("user.dir"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
