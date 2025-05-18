package Algoritmos;

import estrutura_dados.SortAlgorithm;
import Utilitarios.CreateFileCsv;
import Utilitarios.GetVariables;

public class SelectionSort extends SortAlgorithm {

    CreateFileCsv create = new CreateFileCsv();

    public void length(String[] data,String nameCase) {
        GetVariables v = new GetVariables();
        String[] copiaDados = data.clone();

        long startTime = System.nanoTime();

        for (int i = 0; i < copiaDados.length - 1; i++) {
            int maiorIndex = i;
            for (int j = i + 1; j < copiaDados.length; j++) {
                if (v.getTamanhoSenha(copiaDados[j]) > v.getTamanhoSenha(copiaDados[maiorIndex])) {
                    maiorIndex = j;
                }
            }
            if (maiorIndex != i) {
                String temp = copiaDados[i];
                copiaDados[i] = copiaDados[maiorIndex];
                copiaDados[maiorIndex] = temp;
            }
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        System.out.println("Tempo de execução drivers.SelectionSort p/ o " + nameCase + ": " + duration + " milissegundos");
        String filename = "";

        if(nameCase.equals("melhor caso")) {
            filename = "./src/dataset/passwords_length_selectionSort_melhorCaso.csv";
        } else if (nameCase.equals("médio caso")){
            filename = "./src/dataset/passwords_length_selectionSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_length_selectionSort_piorCaso.csv";
        }

        create.createCsv(copiaDados, filename );
    }

    public void month(String[] data, String nameCase) {
        GetVariables v = new GetVariables();
        String[] copiaDados = data.clone();

        long startTime = System.nanoTime();

        for (int i = 0; i < copiaDados.length - 1; i++) {
            int maiorIndex = i;
            for (int j = i + 1; j < copiaDados.length; j++) {
                if (v.getMesData(copiaDados[j]) < v.getMesData(copiaDados[maiorIndex])) {
                    maiorIndex = j;
                }
            }
            if (maiorIndex != i) {
                String temp = copiaDados[i];
                copiaDados[i] = copiaDados[maiorIndex];
                copiaDados[maiorIndex] = temp;
            }
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        System.out.println("Tempo de execução drivers.SelectionSort p/ o " + nameCase + ": " + duration + " milissegundos");
        String filename = "";

        if(nameCase == "melhor caso") {
            filename = "./src/dataset/passwords_data_month_selectionSort_melhorCaso.csv";
        } else if (nameCase == "médio caso" ){
            filename = "./src/dataset/passwords_data_month_selectionSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_data_month_selectionSort_piorCaso.csv";
        }

        create.createCsv(copiaDados, filename );
    }

    public void date(String[] data, String nameCase) {
        GetVariables v = new GetVariables();
        String[] copiaDados = data.clone();

        long startTime = System.nanoTime();

        for (int i = 0; i < copiaDados.length - 1; i++) {
            int maiorIndex = i;
            for (int j = i + 1; j < copiaDados.length; j++) {
                if (v.getDataCompleta(copiaDados[j]) < v.getDataCompleta(copiaDados[maiorIndex])) {
                    maiorIndex = j;
                }
            }
            if (maiorIndex != i) {
                String temp = copiaDados[i];
                copiaDados[i] = copiaDados[maiorIndex];
                copiaDados[maiorIndex] = temp;
            }
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        System.out.println("Tempo de execução drivers.SelectionSort p/ o " + nameCase + ": " + duration + " milissegundos");
        String filename = "";

        if(nameCase == "melhor caso") {
            filename = "./src/dataset/passwords_data_selectionSort_melhorCaso.csv";
        } else if (nameCase == "médio caso" ){
            filename = "./src/dataset/passwords_data_selectionSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_data_selectionSort_piorCaso.csv";
        }

        create.createCsv(copiaDados, filename );
    }
}
