package casos_uso;

import estrutura_dados.AVLTree;
import Utilitarios.GetVariables;

public class CreateCasesByLength {

    public GetVariables csvToArray = new GetVariables();

    public   String[] data;
    public AVLTree treeData;

    public CreateCasesByLength() {
        this.treeData = new AVLTree(this::compareLength);
        this.data = csvToArray.readDataToArray();
        treeData.insertAll(data);
    }

    public int compareLength(String s1, String s2) {
        int length1 = csvToArray.getTamanhoSenha(s1);
        int length2 = csvToArray.getMesData(s2);

        return Integer.compare(length1, length2);
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
