package Utilitarios;

import java.io.FileWriter;
import java.io.IOException;

public class CreateFileCsv {

    public void createCsv(String[] data, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.append(",password,length,date,class\n");

            for (String dado : data) {
                writer.append(parseLinhaParaCSV(dado)).append("\n");
            }

        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao gerar o arquivo CSV.");
            e.printStackTrace();
        }
    }

    public static String parseLinhaParaCSV(String linha) {
        String[] partes = linha.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        return String.join(",", partes);
    }
}
