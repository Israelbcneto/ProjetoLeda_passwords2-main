package Algoritmos;

import estrutura_dados.SortAlgorithm;
import Utilitarios.CreateFileCsv;
import Utilitarios.GetVariables;

public class MergeSort extends SortAlgorithm {
    CreateFileCsv create = new CreateFileCsv();

    public void length(String[] data, String nameCase) {
        GetVariables v = new GetVariables();
        String[] copiaDados = data.clone();

        long startTime = System.nanoTime();

        mergeSortLength(copiaDados, 0, copiaDados.length - 1, v);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        System.out.println("Tempo de execução Merge Sort p/ o " + nameCase + ": " + duration + " milissegundos");
        String filename = "";

        if (nameCase.equals("melhor caso")) {
            filename = "./src/dataset/passwords_length_mergeSort_melhorCaso.csv";
        } else if (nameCase.equals("médio caso")) {
            filename = "./src/dataset/passwords_length_mergeSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_length_mergeSort_piorCaso.csv";
        }

        create.createCsv(copiaDados, filename);
    }

    private void mergeSortLength(String[] array, int inicio, int fim, GetVariables v) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSortLength(array, inicio, meio, v);
            mergeSortLength(array, meio + 1, fim, v);
            mergeLength(array, inicio, meio, fim, v);
        }
    }

    private void mergeLength(String[] array, int inicio, int meio, int fim, GetVariables v) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        String[] L = new String[n1];
        String[] R = new String[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = array[inicio + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[meio + 1 + j];

        int i = 0, j = 0;

        int k = inicio;
        while (i < n1 && j < n2) {
            if (v.getTamanhoSenha(L[i]) >= v.getTamanhoSenha(R[j])) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // --------------------------------------------------------------------

    public void month(String[] data, String nameCase) {
        GetVariables v = new GetVariables();
        String[] copiaDados = data.clone();

        long startTime = System.nanoTime();

        mergeSortMonth(copiaDados, 0, copiaDados.length - 1, v);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        System.out.println("Tempo de execução Merge Sort p/ o " + nameCase + ": " + duration + " milissegundos");
        String filename = "";

        if (nameCase.equals("melhor caso")) {
            filename = "./src/dataset/passwords_data_month_mergeSort_melhorCaso.csv";
        } else if (nameCase.equals("médio caso")) {
            filename = "./src/dataset/passwords_data_month_mergeSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_data_month_mergeSort_piorCaso.csv";
        }

        create.createCsv(copiaDados, filename);
    }

    private void mergeSortMonth(String[] array, int inicio, int fim, GetVariables v) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSortMonth(array, inicio, meio, v);
            mergeSortMonth(array, meio + 1, fim, v);
            mergeMonth(array, inicio, meio, fim, v);
        }
    }

    private void mergeMonth(String[] array, int inicio, int meio, int fim, GetVariables v) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        String[] L = new String[n1];
        String[] R = new String[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = array[inicio + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[meio + 1 + j];

        int i = 0, j = 0;

        int k = inicio;
        while (i < n1 && j < n2) {
            if (v.getMesData(L[i]) <= v.getMesData(R[j])) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // -----------------------------------------------------------------------------------

    public void date(String[] data, String nameCase) {
        GetVariables v = new GetVariables();
        String[] copiaDados = data.clone();

        long startTime = System.nanoTime();

        mergeSortDate(copiaDados, 0, copiaDados.length - 1, v);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        System.out.println("Tempo de execução Merge Sort p/ o " + nameCase + ": " + duration + " milissegundos");
        String filename = "";

        if (nameCase.equals("melhor caso")) {
            filename = "./src/dataset/passwords_data_mergeSort_melhorCaso.csv";
        } else if (nameCase.equals("médio caso")) {
            filename = "./src/dataset/passwords_data_mergeSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_data_mergeSort_piorCaso.csv";
        }

        create.createCsv(copiaDados, filename);
    }

    private void mergeSortDate(String[] array, int inicio, int fim, GetVariables v) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSortDate(array, inicio, meio, v);
            mergeSortDate(array, meio + 1, fim, v);
            mergeDate(array, inicio, meio, fim, v);
        }
    }

    private void mergeDate(String[] array, int inicio, int meio, int fim, GetVariables v) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        String[] L = new String[n1];
        String[] R = new String[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = array[inicio + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[meio + 1 + j];

        int i = 0, j = 0;

        int k = inicio;
        while (i < n1 && j < n2) {
            if (v.getDataCompleta(L[i]) <= v.getDataCompleta(R[j])) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

}
