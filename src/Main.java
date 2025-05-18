import Utilitarios.PasswordClassifier;
import Utilitarios.PasswordClassifierFilter;
import Utilitarios.PasswordDateFormatter;
import Utilitarios.RunTests;

public class Main {

    public static void main(String[] args) {

        PasswordClassifier classifier = new PasswordClassifier();
        classifier.classifyPasswords(
                "./src/dataset/passwords.csv",
                "./src/dataset/password_classifier.csv"
        );

        PasswordDateFormatter formatter = new PasswordDateFormatter();
        formatter.formatDates(
                "./src/dataset/password_classifier.csv",
                "./src/dataset/passwords_formated_data.csv"
        );

        PasswordClassifierFilter filterClassifier = new PasswordClassifierFilter();
        filterClassifier.filterPasswords(
                "./src/dataset/password_classifier.csv",
                "./src/dataset/passwords_classifier.csv"
        );

        RunTests runTests = new RunTests();

        System.out.println("\nInicio de Ordenação\n\n");

        runTests.run();

    }
}
