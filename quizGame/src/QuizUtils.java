import java.util.Scanner;

public class QuizUtils {


    public static String getInput(String in) {

        Scanner scanner;

        System.out.println(in);

        String input = null;

        try {
            scanner = new Scanner(System.in);
            input = scanner.nextLine();
        } catch (Exception e) {
        }
        return input;
    }


}



