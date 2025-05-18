package Utilitarios;

import Algoritmos.*;
import estrutura_dados.SequentialList;
import estrutura_dados.SortAlgorithm;
import casos_uso.CreateCasesByDate;
import casos_uso.CreateCasesByLength;
import casos_uso.CreateCasesByMonth;

import java.util.function.Supplier;

public class RunTests {
    private final SequentialList<String, SortAlgorithm> algorithms = new SequentialList<>();
    private final SequentialList<String, SequentialList<String, Supplier<String[]>>> cases = new SequentialList<>();

    public void setCases() {
        var byLength = new CreateCasesByLength();
        var byDate = new CreateCasesByDate();
        var byMonth = new CreateCasesByMonth();

        SequentialList<String, Supplier<String[]>> lengthCases = new SequentialList<>();
        SequentialList<String, Supplier<String[]>> monthCases = new SequentialList<>();
        SequentialList<String, Supplier<String[]>> dateCases = new SequentialList<>();

        lengthCases.put("melhor caso", byLength::bestCase);
        lengthCases.put("médio caso", byLength::mediumCase);
        lengthCases.put("pior caso", byLength::worstCase);

        monthCases.put("melhor caso", byMonth::bestCase);
        monthCases.put("médio caso", byMonth::mediumCase);
        monthCases.put("pior caso", byMonth::worstCase);

        dateCases.put("melhor caso", byDate::bestCase);
        dateCases.put("médio caso", byDate::mediumCase);
        dateCases.put("pior caso", byDate::worstCase);

        cases.put("Tamanho da Senha", lengthCases);
        cases.put("Mês", monthCases);
        cases.put("Data", dateCases);
    }

    private void setAlgorithms() {
        algorithms.put("SelectionSort", new SelectionSort());
        algorithms.put("InsertionSort", new InsertionSort());
        algorithms.put("MergeSort", new MergeSort());
        algorithms.put("QuickSort", new QuickSort());
        algorithms.put("QuickSort com Mediana 3", new QuickSortMedianaTres());
        algorithms.put("HeapSort", new HeapSort());
        algorithms.put("CountingSort", new CountingSort());
    }

    private void showResults() {
        for (int i = 0; i < cases.size(); i++) {
            var caseEntry = cases.getEntry(i);
            String tipoOrdenacao = caseEntry.key;
            SequentialList<String, Supplier<String[]>> tipoCasos = caseEntry.value;

            System.out.printf("___________Ordenando a partir de %s___________\n", tipoOrdenacao);

            for (int j = 0; j < algorithms.size(); j++) {
                var algoEntry = algorithms.getEntry(j);
                String nameAlgorithm = algoEntry.key;
                SortAlgorithm algorithm = algoEntry.value;

                System.out.printf("___________Algoritmo %s___________\n\n", nameAlgorithm);

                for (int k = 0; k < tipoCasos.size(); k++) {
                    var caseTypeEntry = tipoCasos.getEntry(k);
                    String caseName = caseTypeEntry.key;
                    String[] caseArray = caseTypeEntry.value.get();

                    algorithm.toggleSort(caseArray, caseName, tipoOrdenacao);
                }

                System.out.println();
            }

            System.out.println();
            System.out.println();
        }
    }

    public void run() {
        setAlgorithms();
        setCases();
        showResults();
    }
}
