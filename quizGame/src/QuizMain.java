

public class QuizMain {


    public static void main(String[] args) {
        boolean sluttSpill = false;

        String name = null;
        Topics topics = new Topics();
        while (!sluttSpill) {

            if (name == null) {
                name = QuizUtils.getInput("hva er ditt navn");
                System.out.println("welcome " + name);
            } else {
                System.out.println("Welcome again  " + name + " ;)");
            }

            System.out.println("press 1 and then enter for basketballball quizes");
            System.out.println("press 2 and then enter for music quiz");
            System.out.println("press 3 and then enter if you want to quit");

            String value = QuizUtils.getInput("");

            int score = 0;

            switch (value) {
                case "1":
                    topics.getBasketbalQuiz();
                    topics.doBBQuiz(name);

                    break;
                case "2":
                    topics.getMusicQuiz();
                    topics.doMusicQuiz(name);
                    break;
                case "3":
                    sluttSpill = true;
                    break;
                default:
                    System.out.println("du kan bare skrive inn 1,2 eller 3\nKjoor Spillet paa nyt");
                    sluttSpill = true;
                    return;
            }
        }

        System.out.println("\n");
        System.out.println("din score history");
        topics.printAllUserScore(name);
    }


}
