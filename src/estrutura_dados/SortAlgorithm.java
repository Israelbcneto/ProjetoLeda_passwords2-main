package estrutura_dados;

public abstract class SortAlgorithm {

    public abstract void length(String[] data, String nameCase);

    public abstract void month(String[] data, String nameCase);

    public abstract void date(String[] data, String nameCase);

    public void toggleSort(String[] data, String nameCase, String type) {
        if (type.equals("Mês")) {
            month(data, nameCase);
        } else if (type.equals("Tamanho da Senha")) {
            length(data, nameCase);
        } else {
            date(data, nameCase);
        }
    }

}
