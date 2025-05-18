package casos_uso;

import estrutura_dados. AVLTree;
import Utilitarios.GetVariables;

import java.text.*;
import java.util.Date;

public class CreateCasesByDate {
    private GetVariables csvToArray = new GetVariables();

    private String[] data;
    private AVLTree treeData;

    public CreateCasesByDate() {
        this.treeData = new AVLTree(this::compareDates);
        this.data = csvToArray.readDataToArray();
        treeData.insertAll(data);
    }

    public int compareDates(String s1, String s2) {
        Integer dataInt1 = csvToArray.getDataCompleta(s1);
        Integer dataInt2 = csvToArray.getDataCompleta(s2);

        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");

        try {
            Date data1 = formato.parse(dataInt1.toString());
            Date data2 = formato.parse(dataInt2.toString());

            return data1.compareTo(data2);
        } catch(Exception error) {
            error.printStackTrace();
            throw new Error("Linha no formato invalido");
        }

    }

    public String[] bestCase() {
        return treeData.inOrderAscending();
    }
    public String[] mediumCase() {
        return data;
    }
    public String[] worstCase() {
       return treeData.inOrderDescending();
    }

}
