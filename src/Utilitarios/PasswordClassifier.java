package Utilitarios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PasswordClassifier {

    public void classifyPasswords(String inputFile, String outputFile) {
        String line;
        String csvSplitBy = ",";
        String csvQuotedBy = "\"";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter(outputFile)) {

            writer.append(",password,length,data,class\n");

            int lineNumber = -1;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (lineNumber == 0) continue;
                String[] data = parseCSVLine(line, csvSplitBy, csvQuotedBy);
                if (data.length >= 3) {
                    String password = data[1];
                    int length;
                    try {
                        length = Integer.parseInt(data[2]);
                    } catch (NumberFormatException e) {
                        length = 0;
                    }

                    String passwordClass = classifyPassword(password, length);

                    // Manter as aspas ao redor da senha
                    writer.append(String.valueOf(lineNumber - 1)).append(",").append(String.join(",", csvQuotedBy + data[1] + csvQuotedBy, String.valueOf(length), data[3], passwordClass));
                    writer.append("\n");
                }
            }

            System.out.println("Classificação concluída. Novo arquivo gerado: " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] parseCSVLine(String line, String csvSplitBy, String csvQuotedBy) {
        boolean inQuotes = false;
        StringBuilder field = new StringBuilder();
        String[] fields = new String[4];
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

    private static String classifyPassword(String password, int length) {
        if (length < 5 && containsOnlyOneType(password)) {
            return "Muito Ruim";
        }
        else if (length <= 5 && containsOnlyOneType(password)) {
            return "Ruim";
        }
        else if (length <= 6 && containsTwoTypes(password)) {
            return "Fraca";
        }
        else if (length <= 7 && containsAllTypes(password)) {
            return "Boa";
        }
        else if (length > 8 && containsAllTypes(password)) {
            return "Muito Boa";
        }
        else {
            return "Sem Classificação";
        }
    }

    private static boolean containsOnlyOneType(String password) {
        // Verifica se a senha contém apenas um tipo
        return password.matches("[a-zA-Z]+") || password.matches("[0-9]+") || password.matches("[^a-zA-Z0-9]+");
    }

    private static boolean containsAllTypes(String password) {
        // Verifica se a senha contém todos os três tipos
        return password.matches("(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).+");
    }

    private static boolean containsTwoTypes(String password) {
        // Verifica se a senha contém pelo menos dois tipos
        return password.matches("(?=.*[a-zA-Z])(?=.*[0-9]).+|(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).+|(?=.*[0-9])(?=.*[^a-zA-Z0-9]).+");
    }



}
