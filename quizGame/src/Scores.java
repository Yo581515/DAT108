import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Scores {

    private String URL;
    private String DATA_BASE;
    private String USER;
    private String PASSWORD;

    private String TABLE;


    public Scores() {
        this.URL = data.URL;
        this.DATA_BASE = data.DATA_BASE;
        this.USER = data.USER;
        this.PASSWORD = data.PASSWORD;

        this.TABLE = data.SCORE_HISTORY_TABLE;
    }

    Connection connection;

    public ResultSet getscorehistoryByName(String name) {
        ResultSet resultSet = null;
        String sql ="select * from " + TABLE + " where user = " + "'" + name + "'" ;
        try {


            connection = DriverManager.getConnection(getURL() + getDATA_BASE(), getUSER(),
                    getPASSWORD());
            Statement statement = connection.createStatement();

            // SELECT * FROM quizdb.scorehistory WHERE user = 'tereza'
            resultSet = statement.executeQuery(sql);

        } catch (Exception e) {
            System.out.println("Exception i getscorehistory() metode");
        }

        return resultSet;
    }

    public ResultSet getLastScore() {
        ResultSet resultSet = null;
        String sql ="select * from " + TABLE + " ORDER BY id DESC LIMIT 1" ;
        try {

            connection = DriverManager.getConnection(getURL() + getDATA_BASE(), getUSER(),
                    getPASSWORD());
            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery(sql);

        } catch (Exception e) {
            System.out.println("Exception i getLastScore() metode");
        }

        return resultSet;
    }

    public void addScoreHistory(String user, String topic, int score) {
        String sql = "INSERT INTO " + TABLE + "(user, topic, score) VALUES('" + user + "','" + topic + "'," + score + ")";
        System.out.println("\n"+sql);
        try {
            connection = DriverManager.getConnection(getURL() + getDATA_BASE(), getUSER(),
                    getPASSWORD());

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            System.out.println("ny Score i tabellen scorehistory ble opprettet.");
        } catch (Exception e) {
            System.out.println("Exception i addScoreHistory() metode");
        }
    }

    public String getURL() {
        return URL;
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

    public String getTABLE() {
        return TABLE;
    }
}
