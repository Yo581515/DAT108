import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BasketBallDataBase {

    private String URL;
    private String DATA_BASE;
    private String USER;
    private String PASSWORD;

    private String TABLE;

    Connection connection;

    public BasketBallDataBase(String BB_TABLE) {
        this.URL = data.URL;
        this.DATA_BASE = data.DATA_BASE;
        this.USER = data.USER;
        this.PASSWORD = data.PASSWORD;
        this.TABLE = BB_TABLE;
    }

    public BasketBallDataBase() {
        this.URL = data.URL;
        this.DATA_BASE = data.DATA_BASE;
        this.USER = data.USER;
        this.PASSWORD = data.PASSWORD;
        this.TABLE = data.MULTICHOICE_QUIZ_TABLE;
    }
    public void insert(BasketballQuesion basketballQuesion) {


        if (!exist(basketballQuesion.getId())) {
            String hopp = "\n";
            String sql = "INSERT INTO " + "`" + getDATA_BASE() + "`." + "`" + getTABLE() + "` " + "(`id`, `question`, `answerA`, `answerB`, `answerC`, `answerD`, `correctAnswer`) " + "\n" +
                    "VALUES (" + basketballQuesion.getId() + ",'" + basketballQuesion.getQuestion() + "'," + hopp +
                    "'" + basketballQuesion.getAnswerA() + "'," + hopp +
                    "'" + basketballQuesion.getAnswerB() + "'," + hopp +
                    "'" + basketballQuesion.getAnswerC() + "'," + hopp +
                    "'" + basketballQuesion.getAnswerD() + "'," + hopp +
                    "'" + basketballQuesion.getCorrectAnswer() + "'" + hopp
                    + ");" + hopp;
            //System.out.println(sql);
            try {
                connection = DriverManager.getConnection(getURL() + getDATA_BASE(), getUSER(),getPASSWORD());

                Statement statement = connection.createStatement();

                statement.executeUpdate(sql);

            } catch (Exception e) {
            }
        }

    }

    public boolean exist(String id) {
        boolean funet = false;

        String sql = "select * from " + getTABLE() + " where id = " + "'" + id + "'";
        //System.out.println(sql);

        try {

            connection = DriverManager.getConnection(getURL() + getDATA_BASE(), getUSER(),getPASSWORD());

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from " + getTABLE() + " where id = " + "'" + id + "'");

            if (resultSet.next()) {
                funet = true;
                //System.out.println("questin " + id + " is already in table "+getTABLE());
            } else {
                //System.out.println("questin " + id + " is not in table "+getTABLE());
            }

        } catch (Exception e) {
        }

        return funet;
    }




    public ResultSet getBasketballQuestions() {

        ResultSet resultSet = null;
        String sql ="SELECT * FROM " + TABLE;
        //System.out.println(sql+"\n\n\n\n");

        try {

            connection = DriverManager.getConnection(getURL() + getDATA_BASE(), getUSER(),getPASSWORD());

            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery(sql);

        } catch (Exception e) {
            System.out.println("Exception i getBasketballQuestions() metode");
        }

        return resultSet;
    }



    public String getDATA_BASE() {
        return DATA_BASE;
    }

    public String getUSER() {
        return USER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getURL() {
        return URL;
    }

    public String getTABLE() {
        return TABLE;
    }

}
