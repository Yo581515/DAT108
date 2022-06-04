import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BasketBallQuizer {

	private String tab = "multichoicequiz";
	Connection connection;

	public ResultSet getBasketballQuestions() {
		ResultSet resultSet = null;

		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + data.DATA_BASE, data.USER,
					data.PASSWORD);

			Statement statement = connection.createStatement();

			resultSet = statement.executeQuery("select * from " + tab);

		} catch (Exception e) {
			System.out.println("Exception i getBasketballQuestions() metode");
		}

		return resultSet;
	}

}
