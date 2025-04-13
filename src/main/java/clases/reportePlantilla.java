package clases;

import java.io.FileWriter;
import java.io.IOException;

public class reportePlantilla {

    private String name;
    private String status;
    private String duration;

    public reportePlantilla(String name, String status, String duration) {
        this.name = name;
        this.status = status;
        this.duration = duration;
    }

    public void generateReport(String filename) {
        String content =
                "=========================\n" +
                        "A continuación se muestra el informe de los resultados de las pruebas de TestNG\n"+
                        "\n"+
                        "      INFORME DE TAREA\n" +
                        "=========================\n" +
                        "Nombre     : " + name + "\n" +
                        "Estado     : " + status + "\n" +
                        "Duración   : " + duration + "\n" +
                        "=========================\n";

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
            System.out.println("✅ Reporte guardado como '" + filename + "'");
        } catch (IOException e) {
            System.err.println("❌ Error al guardar el archivo: " + e.getMessage());
        }

    }
}