public class MusicQuesion extends Quesion {

    public MusicQuesion(String topicName, String id, String question, String correctAnswer) {
        super(topicName, id, question, correctAnswer);
    }



    @Override
    public void print() {
        super.print();
        System.out.println("\t- "+ "true\n\t- false");
    }
}
