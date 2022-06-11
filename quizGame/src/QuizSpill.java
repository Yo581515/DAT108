
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizSpill {


    DataBase db;

    private String DATA_BASE;

    private String BINARY_QUIZ;

    private String MULTICHOICE_QUIZE;

    private String SCORE_HISTROTY;

    private final String NULL;

    BasketBallDataBase basketBallDataBase;

    MusicDataBase musicDataBase;

    ResultSet resultSet;


    public QuizSpill() {
        DATA_BASE = data.DATA_BASE;
        this.BINARY_QUIZ = data.BINARY_QUIZ_TABLE;
        this.MULTICHOICE_QUIZE = data.MULTICHOICE_QUIZ_TABLE;
        this.SCORE_HISTROTY = data.SCORE_HISTORY_TABLE;
        this.NULL = " NULL ";

        this.db = new DataBase(DATA_BASE);
        this.basketBallDataBase = new BasketBallDataBase(data.MULTICHOICE_QUIZ_TABLE);
        this.musicDataBase = new MusicDataBase(data.BINARY_QUIZ_TABLE);

    }


    /**
     * db.createNewTable(tab, " `id` ", "INT",
     * " `first_name` " + DataBaseDataTypes.VARCHAR(255) + " NULL ," +
     * " `last_name` " + DataBaseDataTypes.VARCHAR(255) + " NULL ," +
     * " `birth_date` " + DataBaseDataTypes.VARCHAR(255) + " NULL ,",
     * false
     * );
     **/


    public void init() {
        if (!db.doesDBExist(DATA_BASE)) {
            db.createNewDataBase(DATA_BASE);
        }

        if (!db.doesTableExist(SCORE_HISTROTY)) {
            db.createNewTable(SCORE_HISTROTY, " `id` ", " INT ",
                    " `user` " + DataBaseDataTypes.VARCHAR(255) + NULL + ","
                            + " `topic` " + DataBaseDataTypes.VARCHAR(255) + NULL + ","
                            + " `score` " + " INT " + NULL + ","
                    , true);
        }

        if (!db.doesTableExist(MULTICHOICE_QUIZE)) {
            db.createNewTable(MULTICHOICE_QUIZE, " `id` ", " INT ",
                    " `question` " + DataBaseDataTypes.VARCHAR(255) + NULL + ","
                            + " `answerA` " + DataBaseDataTypes.VARCHAR(255) + NULL + ","
                            + " `answerB` " + DataBaseDataTypes.VARCHAR(255) + NULL + ","
                            + " `answerC` " + DataBaseDataTypes.VARCHAR(255) + NULL + ","
                            + " `answerD` " + DataBaseDataTypes.VARCHAR(255) + NULL + ","
                            + " `correctAnswer` " + DataBaseDataTypes.VARCHAR(255) + NULL + ","
                    , false);
        }

        //initBasketBallQuizene
        BasketballQuesion bQ1 = new BasketballQuesion("BasketBall", "1", "who is the famous basketball player in the world?",
                "Michael Jordan", "Roger Federe", "Michael Jordan", "Novak Djokovic", "Alexander Zverev");

        BasketballQuesion bQ2 = new BasketballQuesion("BasketBall", "2", "Which basketball teams won the championship in 2021-2022?",
                "Atlanta", "Atlanta", "Celtics", "New York", "La Clippers");

        BasketballQuesion bQ3 = new BasketballQuesion("BasketBall", "3", "Who is the 1 team in the NBA?",
                "PHX", "PHX", "Warrioirs", "Chicago Bulls", "PHX");

        BasketballQuesion bQ4 = new BasketballQuesion("BasketBall", "4", "What country founded basketball?",
                "US", "Norway", "US", "Sweeden", "London");

        basketBallDataBase.insert(bQ1);
        basketBallDataBase.insert(bQ2);
        basketBallDataBase.insert(bQ3);
        basketBallDataBase.insert(bQ4);



        //initBasketBallQuizene
        if (!db.doesTableExist(BINARY_QUIZ)) {
            db.createNewTable(BINARY_QUIZ, " `id` ", "INT",
                    " `question` " + DataBaseDataTypes.VARCHAR(255) + NULL + ","
                            + " `correctAnswer` " + DataBaseDataTypes.VARCHAR(255) + NULL + ","
                    , false);
        }

        MusicQuesion mQ1 = new MusicQuesion("Music", "1", "Chayce Beckham is the winner of America Idol 2021.", "true");
        MusicQuesion mQ2 = new MusicQuesion("Music", "2", "Justin Bieber have a baby.", "false");
        MusicQuesion mQ3 = new MusicQuesion("Music", "3", "Michael Jackson died at the age of 50.", "true");
        MusicQuesion mQ4 = new MusicQuesion("Music", "4", "Rihanna gave Birth to triplets.", "false");

        musicDataBase.insert(mQ1);
        musicDataBase.insert(mQ2);
        musicDataBase.insert(mQ3);
        musicDataBase.insert(mQ4);
    }



    public void initBasketBallQuizene() {
        init();
        /*
        if (!db.doesTableExist(MULTICHOICE_QUIZE)) {
            db.createNewTable(MULTICHOICE_QUIZE, " `id` ", " INT ",
                    " `question` " + DataBaseDataTypes.VARCHAR(255) + NULL + ","
                            + " `answerA` " + DataBaseDataTypes.VARCHAR(255) + NULL + ","
                            + " `answerB` " + DataBaseDataTypes.VARCHAR(255) + NULL + ","
                            + " `answerC` " + DataBaseDataTypes.VARCHAR(255) + NULL + ","
                            + " `answerD` " + DataBaseDataTypes.VARCHAR(255) + NULL + ","
                            + " `correctAnswer` " + DataBaseDataTypes.VARCHAR(255) + NULL + ","
                    , false);
        }


        BasketballQuesion bQ1 = new BasketballQuesion("BasketBall", "1", "who is the famous basketball player in the world?",
                "Michael Jordan", "Roger Federe", "Michael Jordan", "Novak Djokovic", "Alexander Zverev");

        BasketballQuesion bQ2 = new BasketballQuesion("BasketBall", "2", "Which basketball teams won the championship in 2021-2022?",
                "Atlanta", "Atlanta", "Celtics", "New York", "La Clippers");

        BasketballQuesion bQ3 = new BasketballQuesion("BasketBall", "3", "Who is the 1 team in the NBA?",
                "PHX", "PHX", "Warrioirs", "Chicago Bulls", "PHX");

        BasketballQuesion bQ4 = new BasketballQuesion("BasketBall", "4", "What country founded basketball?",
                "US", "Norway", "US", "Sweeden", "London");


        basketBallDataBase.insert(bQ1);
        basketBallDataBase.insert(bQ2);
        basketBallDataBase.insert(bQ3);
        basketBallDataBase.insert(bQ4);

         */
    }



    public List<Quesion> getBaskteBallQuizene() {
        List<Quesion> spoorsmaalene = new ArrayList<>();

        try {
            resultSet = basketBallDataBase.getBasketballQuestions();
            while (resultSet != null && resultSet.next()) {

                String id = resultSet.getString("id");
                String question = resultSet.getString("question");
                String answerA = resultSet.getString("answerA");
                String answerB = resultSet.getString("answerB");
                String answerC = resultSet.getString("answerC");
                String answerD = resultSet.getString("answerD");
                String correctAnswer = resultSet.getString("correctAnswer");

                BasketballQuesion Q = new BasketballQuesion("BasketBall", id, question, correctAnswer, answerA, answerB, answerC, answerD);

                spoorsmaalene.add(Q);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spoorsmaalene;
    }

    public void initMusicQuizene() {
        init();
     /*   if (!db.doesTableExist(BINARY_QUIZ)) {
            db.createNewTable(BINARY_QUIZ, " `id` ", "INT",
                    " `question` " + DataBaseDataTypes.VARCHAR(255) + NULL + ","
                            + " `correctAnswer` " + DataBaseDataTypes.VARCHAR(255) + NULL + ","
                    , false);
        }

        MusicQuesion mQ1 = new MusicQuesion("Music", "1", "Chayce Beckham is the winner of America Idol 2021.", "true");
        MusicQuesion mQ2 = new MusicQuesion("Music", "2", "Justin Bieber have a baby.", "false");
        MusicQuesion mQ3 = new MusicQuesion("Music", "3", "Michael Jackson died at the age of 50.", "true");
        MusicQuesion mQ4 = new MusicQuesion("Music", "4", "Rihanna gave Birth to triplets.", "false");

        musicDataBase.insert(mQ1);
        musicDataBase.insert(mQ2);
        musicDataBase.insert(mQ3);
        musicDataBase.insert(mQ4);*/
    }

    public List<Quesion> getMusicQuizene() {
        List<Quesion> spoorsmaalene = new ArrayList<>();
        try {
            resultSet = musicDataBase.getMusicQuestions();

            while (resultSet != null && resultSet.next()) {

                String id = resultSet.getString("id");
                String question = resultSet.getString("question");
                String correctAnswer = resultSet.getString("correctAnswer");

                MusicQuesion Q = new MusicQuesion("Music", id, question, correctAnswer);

                spoorsmaalene.add(Q);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spoorsmaalene;
    }
}

