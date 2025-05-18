package Algoritmos;

import estrutura_dados.SortAlgorithm;
import Utilitarios.CreateFileCsv;
import Utilitarios.GetVariables;

public class QuickSort extends SortAlgorithm {
    CreateFileCsv create = new CreateFileCsv();

    public void length(String[] data, String nameCase) {
        GetVariables v = new GetVariables();
        String[] copiaDados = data.clone();

        long startTime = System.nanoTime();

        quickSortLength(copiaDados, 0, copiaDados.length - 1, v);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        System.out.println("Tempo de execução Quick Sort p/ o " + nameCase + ": " + duration + " milissegundos");
        String filename = "";

        if (nameCase.equals("melhor caso")) {
            filename = "./src/dataset/passwords_length_quickSort_melhorCaso.csv";
        } else if (nameCase.equals("médio caso")) {
            filename = "./src/dataset/passwords_length_quickSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_length_quickSort_piorCaso.csv";
        }

        create.createCsv(copiaDados, filename);
    }

    private void quickSortLength(String[] arr, int low, int high, GetVariables v) {
        if (low < high) {
            int pi = partitionLength(arr, low, high, v);

            quickSortLength(arr, low, pi - 1, v);
            quickSortLength(arr, pi + 1, high, v);
        }
    }

    private int partitionLength(String[] arr, int low, int high, GetVariables v) {
        String pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (v.getTamanhoSenha(arr[j]) >= v.getTamanhoSenha(pivot)) {
                i++;

                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // -----------------------------------------------------------------------------------------

    public void month(String[] data, String nameCase) {
        GetVariables v = new GetVariables();
        String[] copiaDados = data.clone();

        long startTime = System.nanoTime();

        quickSortMonth(copiaDados, 0, copiaDados.length - 1, v);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        System.out.println("Tempo de execução Quick Sort p/ o " + nameCase + ": " + duration + " milissegundos");
        String filename = "";

        if (nameCase.equals("melhor caso")) {
            filename = "./src/dataset/passwords_data_month_quickSort_melhorCaso.csv";
        } else if (nameCase.equals("médio caso")) {
            filename = "./src/dataset/passwords_data_month_quickSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_data_month_quickSort_piorCaso.csv";
        }

        create.createCsv(copiaDados, filename);
    }

    private void quickSortMonth(String[] array, int inicio, int fim, GetVariables v) {
        if (inicio < fim) {
            int posicaoPivo = partitionMonth(array, inicio, fim, v);
            quickSortMonth(array, inicio, posicaoPivo - 1, v);
            quickSortMonth(array, posicaoPivo + 1, fim, v);
        }
    }

    private int partitionMonth(String[] array, int inicio, int fim, GetVariables v) {
        String pivo = array[fim];
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (v.getMesData(array[j]) <= v.getMesData(pivo)) {
                i++;
                String temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        String temp = array[i + 1];
        array[i + 1] = array[fim];
        array[fim] = temp;
        return i + 1;
    }

    // -----------------------------------------------------------------------------------------

    public void date(String[] data, String nameCase) {
        GetVariables v = new GetVariables();
        String[] copiaDados = data.clone();

        long startTime = System.nanoTime();

        quickSortDate(copiaDados, 0, copiaDados.length - 1, v);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        System.out.println("Tempo de execução Quick Sort p/ o " + nameCase + ": " + duration + " milissegundos");
        String filename = "";

        if (nameCase.equals("melhor caso")) {
            filename = "./src/dataset/passwords_data_quickSort_melhorCaso.csv";
        } else if (nameCase.equals("médio caso")) {
            filename = "./src/dataset/passwords_data_quickSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_data_quickSort_piorCaso.csv";
        }

        create.createCsv(copiaDados, filename);
    }

    private void quickSortDate(String[] array, int inicio, int fim, GetVariables v) {
        if (inicio < fim) {
            int posicaoPivo = partitionDate(array, inicio, fim, v);
            quickSortDate(array, inicio, posicaoPivo - 1, v);
            quickSortDate(array, posicaoPivo + 1, fim, v);
        }
    }

    private int partitionDate(String[] array, int inicio, int fim, GetVariables v) {
        String pivo = array[fim];
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (v.getDataCompleta(array[j]) <= v.getDataCompleta(pivo)) {
                i++;
                String temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        String temp = array[i + 1];
        array[i + 1] = array[fim];
        array[fim] = temp;
        return i + 1;
    }


}
