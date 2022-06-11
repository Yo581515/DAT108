public class BasketballQuesion extends Quesion {


    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;


    public BasketballQuesion(String topicName, String id,
                             String question, String correctAnswer, String answerA,
                             String answerB, String answerC, String answerD) {
        super(topicName, id, question, correctAnswer);

        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("\ta-" + answerA);
        System.out.println("\tb-" + answerB);
        System.out.println("\tc-" + answerC);
        System.out.println("\td-" + answerD);
    }


    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }




}
