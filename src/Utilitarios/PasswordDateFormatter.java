package Utilitarios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PasswordDateFormatter {

    public void formatDates(String inputFile, String outputFile) {
        String line;
        String csvSplitBy = ",";
        String csvQuotedBy = "\"";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter(outputFile)) {

            writer.append(",password,length,date,class\n");

            int lineNumber = -1;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (lineNumber == 0) continue;
                String[] data = parseCSVLine(line, csvSplitBy, csvQuotedBy);
                if (data.length >= 4) {
                    String formattedDate = formatDate(data[3]);

                    writer.append(String.valueOf(lineNumber - 1)).append(",").append(String.join(",", csvQuotedBy + data[1] + csvQuotedBy, data[2], formattedDate, data[4]));
                    writer.append("\n");
                }
            }

            System.out.println("Formatação de datas concluída. Novo arquivo gerado: " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] parseCSVLine(String line, String csvSplitBy, String csvQuotedBy) {
        boolean inQuotes = false;
        StringBuilder field = new StringBuilder();
        String[] fields = new String[5];
        int fieldIndex = 0;

        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                fields[fieldIndex++] = field.toString();
                field = new StringBuilder();
            } else {
                field.append(c);
            }
        }
        fields[fieldIndex] = field.toString();
        return fields;
    }

    private String formatDate(String date) {
        String[] parts = date.split(" ");
        if (parts.length < 2) {
            return "";
        }
        String[] datePart = parts[0].split("-");
        if (datePart.length < 3) {
            return "";
        }
        return datePart[2] + "/" + datePart[1] + "/" + datePart[0] + " " + parts[1];
    }
}
