

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MusicDataBase {

    private String URL;
    private String DATA_BASE;
    private String USER;
    private String PASSWORD;

    private String TABLE;

    Connection connection;

    public MusicDataBase() {
        this.URL = data.URL;
        this.DATA_BASE = data.DATA_BASE;
        this.USER = data.USER;
        this.PASSWORD = data.PASSWORD;
        this.TABLE = data.BINARY_QUIZ_TABLE;
    }

    public MusicDataBase(String M_TABLE) {
        this.URL = data.URL;
        this.DATA_BASE = data.DATA_BASE;
        this.USER = data.USER;
        this.PASSWORD = data.PASSWORD;
        this.TABLE = M_TABLE;
    }


    public void insert(Quesion mQ) {
        if (!exist(mQ.getId())) {
            String hopp = "\n";
            String sql = "INSERT INTO " + "`" + getDATA_BASE() + "`." + "`" + getTABLE() + "` " +
                    "(`id`, `question`, `correctAnswer`) " + "\n" +
                    "VALUES (" + mQ.getId() + ",'" + mQ.getQuestion() + "'," + hopp +
                    "'" + mQ.getCorrectAnswer() + "'" + hopp
                    + ");" + hopp;
            //System.out.println(sql);
            try {
                connection = DriverManager.getConnection(getURL() + getDATA_BASE(), getUSER(),
                        getPASSWORD());

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

            connection = DriverManager.getConnection(getURL() + getDATA_BASE(), getUSER(), getPASSWORD());

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                funet = true;
                //System.out.println("question " + id + " already in table");
            } else {
                //System.out.println("question " + id + " is not in table");
            }

        } catch (Exception e) {
        }

        return funet;
    }


    public ResultSet getMusicQuestions() {
        ResultSet resultSet = null;

        String sql = "SELECT * FROM " + TABLE;
        //System.out.println(sql);
        try {

            connection = DriverManager.getConnection(getURL() + getDATA_BASE(), getUSER(), getPASSWORD());

            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery(sql);

        } catch (Exception e) {
            System.out.println("Exception i getMusicQuestions() metode");
        }

        return resultSet;
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
