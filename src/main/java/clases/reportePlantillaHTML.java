package clases;

import java.io.FileWriter;
import java.io.IOException;

public class reportePlantillaHTML {

    private String name;
    private String status;
    private String duration;

    public reportePlantillaHTML(String name, String status, String duration) {
        this.name = name;
        this.status = status;
        this.duration = duration;
    }

    public void generateReport(String filename) {
        String content =
                "<!DOCTYPE html>\n" +
                        "<html lang=\"es\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>Informe de TestNG</title>\n" +
                        "    <style>\n" +
                        "        body {\n" +
                        "            font-family: Arial, sans-serif;\n" +
                        "            margin: 40px;\n" +
                        "            background-color: #f5f5f5;\n" +
                        "        }\n" +
                        "        .container {\n" +
                        "            background: white;\n" +
                        "            padding: 30px;\n" +
                        "            border-radius: 8px;\n" +
                        "            box-shadow: 0 0 10px rgba(0,0,0,0.1);\n" +
                        "        }\n" +
                        "        h1, h2 {\n" +
                        "            text-align: center;\n" +
                        "            color: #333;\n" +
                        "        }\n" +
                        "        table {\n" +
                        "            margin: 0 auto;\n" +
                        "            border-collapse: collapse;\n" +
                        "            width: 50%;\n" +
                        "        }\n" +
                        "        td {\n" +
                        "            padding: 10px 20px;\n" +
                        "            border-bottom: 1px solid #ddd;\n" +
                        "        }\n" +
                        "        td.label {\n" +
                        "            font-weight: bold;\n" +
                        "            color: #555;\n" +
                        "        }\n" +
                        "    </style>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <div class=\"container\">\n" +
                        "        <h1>Informe de TestNG</h1>\n" +
                        "        <h2>INFORME DE TAREA</h2>\n" +
                        "        <table>\n" +
                        "            <tr>\n" +
                        "                <td class=\"label\">Nombre</td>\n" +
                        "                <td>"+name+"</td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td class=\"label\">Estado</td>\n" +
                        "                <td>"+status+"</td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td class=\"label\">Duración</td>\n" +
                        "                <td>"+duration+"</td>\n" +
                        "            </tr>\n" +
                        "        </table>\n" +
                        "    </div>\n" +
                        "</body>\n" +
                        "</html>\n";

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
            System.out.println("✅ Reporte guardado como '" + filename + "'");
        } catch (IOException e) {
            System.err.println("❌ Error al guardar el archivo: " + e.getMessage());
        }

    }
}