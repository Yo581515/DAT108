public class Quesion implements TopicInterface {

    private String topicName;
    private String id;
    private String question;
    private String correctAnswer;

    public Quesion(){};

    public Quesion(String topicName, String id, String question, String correctAnswer) {
        this.topicName = topicName;
        this.id = id;
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public void print() {
        System.out.println("question "+getId() + " : "+getQuestion());
    }

}
