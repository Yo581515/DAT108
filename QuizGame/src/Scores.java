import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Scores {

	private String tab = "scorehistory";
	Connection connection;

	public ResultSet getscorehistoryByName(String name) {
		ResultSet resultSet = null;

		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + data.DATA_BASE, data.USER,
					data.PASSWORD);
			Statement statement = connection.createStatement();

			// SELECT * FROM quizdb.scorehistory WHERE user = 'tereza'
			resultSet = statement.executeQuery("select * from " + tab + " where user = " + "'" + name + "'");

		} catch (Exception e) {
			System.out.println("Exception i getscorehistory() metode");
		}

		return resultSet;
	}

	public ResultSet getLastScore() {
		ResultSet resultSet = null;

		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + data.DATA_BASE, data.USER,
					data.PASSWORD);
			Statement statement = connection.createStatement();

			resultSet = statement.executeQuery("select * from " + tab + " ORDER BY id DESC LIMIT 1");

		} catch (Exception e) {
			System.out.println("Exception i getLastScore() metode");
		}

		return resultSet;
	}

	public void addScoreHistory(String user, String topic, int score) {
		String sql = "INSERT INTO " + tab + "(user, topic, score) VALUES('" + user + "','" + topic + "'," + score + ")";

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + data.DATA_BASE, data.USER,
					data.PASSWORD);

			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);

			System.out.println("ny Score i tabellen scorehistory ble opprettet.");
		} catch (Exception e) {
			System.out.println("Exception i addScoreHistory() metode");
		}
	}

}
