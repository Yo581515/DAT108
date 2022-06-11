import java.sql.ResultSet;
import java.util.List;

public class Topics {


    List<Quesion> musicSpoorsmaalene;
    List<Quesion> basketballSpoorsmalene;
    QuizSpill quizSpill;
    Scores scores;


    public Topics() {
        quizSpill = new QuizSpill();
        scores = new Scores();
    }


    public void getBasketbalQuiz() {

        quizSpill.initBasketBallQuizene();

        basketballSpoorsmalene = quizSpill.getBaskteBallQuizene();
    }

    public void doBBQuiz(String name) {

        int score = 0;
        for (Quesion Q : basketballSpoorsmalene) {
            Q.print();

            String svar = QuizUtils.getInput("Skriv in en av bokstavene a,b,c, eller d og tast enter");

            svar = finVelgetSvar(svar,  Q);

            if (svar.equals(Q.getCorrectAnswer())) {
                score++;
            }
            System.out.println("\n");
            System.out.println("\n");
        }
        System.out.println("\nscore = " + score);

        scores.addScoreHistory(name, "BasketBall", score);
        printLastScore(name);
    }

    public void printLastScore(String name) {

        System.out.println("|  name  |  Topic  |  score  |");
        ResultSet resultSet = scores.getLastScore();
        try {
            while (resultSet != null && resultSet.next()) {
                System.out.print("| " + resultSet.getString("user") + " |");
                System.out.print("" + resultSet.getString("topic") + " |");
                System.out.print("" + resultSet.getString("score") + " |");

                System.out.println("\n\n");
                System.out.println("\n\n");
            }
        } catch (Exception e) {

        }
    }

    public  void printAllUserScore(String name) {
        System.out.println("|  name  |  Topic  |  score  |");
        ResultSet resultSet = scores.getscorehistoryByName(name);
        try {
            while (resultSet != null && resultSet.next()) {

                System.out.print("| " + resultSet.getString("user") + " |");
                System.out.print("" + resultSet.getString("topic") + " |");
                System.out.print("" + resultSet.getString("score") + " |");

                System.out.println();
            }
        } catch (Exception e) {

        }

    }


    private String finVelgetSvar(String svar, Quesion Q) {
        String velgetSvar = "";
        BasketballQuesion q = null;
        switch (svar) {
            case "a":
                q = (BasketballQuesion) Q;
                System.out.println("ditt svar var = " + q.getAnswerA());
                velgetSvar = q.getAnswerA();
                break;
            case "b":
                q = (BasketballQuesion) Q;
                System.out.println("ditt svar var = " + q.getAnswerB());
                velgetSvar = q.getAnswerB();
                break;
            case "c":
                q = (BasketballQuesion) Q;
                System.out.println("ditt svar var = " + q.getAnswerC());
                velgetSvar = q.getAnswerC();
                break;
            case "d":
                q = (BasketballQuesion) Q;
                System.out.println("ditt svar var = " + q.getAnswerD());
                velgetSvar = q.getAnswerA();
                break;
            default:
                velgetSvar = svar;
                System.out.println("ditt svar var = " + svar);
                break;
        }
        return velgetSvar;
    }

    public void getMusicQuiz() {

        quizSpill.initMusicQuizene();

        musicSpoorsmaalene = quizSpill.getMusicQuizene();

    }

    public void doMusicQuiz(String name) {
        int score = 0;
        for (Quesion Q : musicSpoorsmaalene) {
            Q.print();

            String svar = QuizUtils.getInput("Skriv inn true eller false og tast enter");

            svar = finVelgetSvar(svar, (Quesion) Q);

            if (svar.equals(Q.getCorrectAnswer())) {
                score++;
            }
            System.out.println("\n");
            System.out.println("\n");
        }
        System.out.println("\nscore = " + score);

        scores.addScoreHistory(name, "Music", score);
        printLastScore(name);



    }
}
