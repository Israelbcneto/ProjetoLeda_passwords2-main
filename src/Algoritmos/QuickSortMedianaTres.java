package Algoritmos;

import estrutura_dados.SortAlgorithm;
import Utilitarios.CreateFileCsv;
import Utilitarios.GetVariables;

public class QuickSortMedianaTres extends SortAlgorithm {

    CreateFileCsv create = new CreateFileCsv();

    public void length(String[] data, String nameCase) {
        GetVariables v = new GetVariables();
        String[] copiaDados = data.clone();

        long startTime = System.nanoTime();

        quickSortLength(copiaDados, 0, copiaDados.length - 1, v);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        System.out.println("Tempo de execução Quick Sort (Mediana de 3) p/ o " + nameCase + ": " + duration + " milissegundos");
        String filename = "";

        if (nameCase.equals("melhor caso")) {
            filename = "./src/dataset/passwords_length_quickSort_mediana3_melhorCaso.csv";
        } else if (nameCase.equals("médio caso")) {
            filename = "./src/dataset/passwords_length_quickSort_mediana3_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_length_quickSort_mediana3_piorCaso.csv";
        }

        create.createCsv(copiaDados, filename);
    }

    private void quickSortLength(String[] array, int inicio, int fim, GetVariables v) {
        if (inicio < fim) {
            int meio = partitionLength(array, inicio, fim, v);
            quickSortLength(array, inicio, meio, v);
            quickSortLength(array, meio + 1, fim, v);
        }
    }

    private int partitionLength(String[] array, int inicio, int fim, GetVariables v) {
        int meio = (inicio + fim) / 2;

        if (v.getTamanhoSenha(array[inicio]) < v.getTamanhoSenha(array[meio]))
            swap(array, inicio, meio);

        if (v.getTamanhoSenha(array[inicio]) < v.getTamanhoSenha(array[fim]))
            swap(array, inicio, fim);

        if (v.getTamanhoSenha(array[meio]) < v.getTamanhoSenha(array[fim]))
            swap(array, meio, fim);

        String pivot = array[meio];
        int i = inicio - 1;
        int j = fim + 1;

        while (true) {
            do {
                i++;
            } while (v.getTamanhoSenha(array[i]) > v.getTamanhoSenha(pivot));

            do {
                j--;
            } while (v.getTamanhoSenha(array[j]) < v.getTamanhoSenha(pivot));

            if (i >= j)
                return j;

            swap(array, i, j);
        }
    }

    // -----------------------------------------------------------------------------

    public void month(String[] data, String nameCase) {
        GetVariables v = new GetVariables();
        String[] copiaDados = data.clone();

        long startTime = System.nanoTime();

        quickSortMonth(copiaDados, 0, copiaDados.length - 1, v);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        System.out.println("Tempo de execução Quick Sort (Mediana de 3) p/ o " + nameCase + ": " + duration + " milissegundos");
        String filename = "";

        if (nameCase.equals("melhor caso")) {
            filename = "./src/dataset/passwords_data_month_quickSort_mediana3_melhorCaso.csv";
        } else if (nameCase.equals("médio caso")) {
            filename = "./src/dataset/passwords_data_month_quickSort_mediana3_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_data_month_quickSort_mediana3_piorCaso.csv";
        }

        create.createCsv(copiaDados, filename);
    }

    private void quickSortMonth(String[] array, int inicio, int fim, GetVariables v) {
        if (inicio < fim) {
            int meio = partitionMonth(array, inicio, fim, v);
            quickSortMonth(array, inicio, meio, v);
            quickSortMonth(array, meio + 1, fim, v);
        }
    }

    private int partitionMonth(String[] array, int inicio, int fim, GetVariables v) {
        int meio = (inicio + fim) / 2;

        if (v.getMesData(array[inicio]) > v.getMesData(array[meio]))
            swap(array, inicio, meio);

        if (v.getMesData(array[inicio]) > v.getMesData(array[fim]))
            swap(array, inicio, fim);

        if (v.getMesData(array[meio]) > v.getMesData(array[fim]))
            swap(array, meio, fim);

        String pivot = array[meio];
        int i = inicio - 1;
        int j = fim + 1;

        while (true) {
            do {
                i++;
            } while (v.getMesData(array[i]) < v.getMesData(pivot));

            do {
                j--;
            } while (v.getMesData(array[j]) > v.getMesData(pivot));

            if (i >= j)
                return j;

            swap(array, i, j);
        }
    }

    // -----------------------------------------------------------------------------------

    public void date(String[] data, String nameCase) {
        GetVariables v = new GetVariables();
        String[] copiaDados = data.clone();

        long startTime = System.nanoTime();

        quickSortDate(copiaDados, 0, copiaDados.length - 1, v);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        System.out.println("Tempo de execução Quick Sort (Mediana de 3) p/ o " + nameCase + ": " + duration + " milissegundos");
        String filename = "";

        if (nameCase.equals("melhor caso")) {
            filename = "./src/dataset/passwords_data_quickSort_mediana3_melhorCaso.csv";
        } else if (nameCase.equals("médio caso")) {
            filename = "./src/dataset/passwords_data_quickSort_mediana3_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_data_quickSort_mediana3_piorCaso.csv";
        }

        create.createCsv(copiaDados, filename);
    }

    private void quickSortDate(String[] array, int inicio, int fim, GetVariables v) {
        if (inicio < fim) {
            int meio = partitionDate(array, inicio, fim, v);
            quickSortDate(array, inicio, meio, v);
            quickSortDate(array, meio + 1, fim, v);
        }
    }

    private int partitionDate(String[] array, int inicio, int fim, GetVariables v) {
        int meio = (inicio + fim) / 2;

        if (v.getDataCompleta(array[inicio]) > v.getDataCompleta(array[meio]))
            swap(array, inicio, meio);

        if (v.getDataCompleta(array[inicio]) > v.getDataCompleta(array[fim]))
            swap(array, inicio, fim);

        if (v.getDataCompleta(array[meio]) > v.getDataCompleta(array[fim]))
            swap(array, meio, fim);

        String pivot = array[meio];
        int i = inicio - 1;
        int j = fim + 1;

        while (true) {
            do {
                i++;
            } while (v.getDataCompleta(array[i]) < v.getDataCompleta(pivot));

            do {
                j--;
            } while (v.getDataCompleta(array[j]) > v.getDataCompleta(pivot));

            if (i >= j)
                return j;

            swap(array, i, j);
        }
    }


    private void swap(String[] array, int a, int b) {
        String temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
