import java.sql.ResultSet;
import java.util.Scanner;

public class Quiz {
	static BasketBallQuizer basketBallQuizer;
	static MusicQuizer musicQuizer = new MusicQuizer();
	static Scores scores = new Scores();
	static ResultSet resultSet;

	static Scanner scanner = null;

	public static void main(String[] args) {

		boolean sluttSpill = false;

		String name = null;
		while (!sluttSpill) {

			if (name == null) {
				name = getInput("hva er ditt navn");
				System.out.println("welcome " + name);
			} else {
				System.out.println("Welcome again  " + name + " ;)");
			}

			System.out.println("press 1 and then enter for basketballball quizes");
			System.out.println("press 2 and then enter for music quiz");
			System.out.println("press 3 and then enter if you want to quit");

			scanner = new Scanner(System.in);
			String value = scanner.next();

			switch (value) {
			case "1":
				doBasketBallQuizes(name);
				break;
			case "2":
				doMusicQuizes(name);
				break;
			case "3":
				sluttSpill = true;
				break;
			default:
				sluttSpill = true;
				break;
			}
		}

		printAllUserScore(name);
	}

	private static void doMusicQuizes(String user) {
		int score = 0;

		musicQuizer = new MusicQuizer();
		resultSet = musicQuizer.getMusicQuestions();

		try {
			while (resultSet != null && resultSet.next()) {
				System.out.println("spoorsmaal : " + resultSet.getString("question"));
				String valgA = "-true";
				String valgB = "-false";

				System.out.println("\t" + valgA);
				System.out.println("\t" + valgB);

				System.out.println("riktig svar er - " + resultSet.getString("correctAnswer"));

				String valg = getInput("velg true eller false og tast enter");
				String velgetSvar = valg;

				if (velgetSvar.equals(resultSet.getString("correctAnswer"))) {
					score++;
				}

				System.out.println("\n\n");
			}
		} catch (Exception e) {
		}

		scores.addScoreHistory(user, "Music", score);

		printLastScore(user);

	}

	public static void doBasketBallQuizes(String user) {

		int score = 0;
		basketBallQuizer = new BasketBallQuizer();
		resultSet = basketBallQuizer.getBasketballQuestions();
		try {
			while (resultSet != null && resultSet.next()) {
				System.out.println("spoorsmaal : " + resultSet.getString("question"));
				String valgA = "a-" + resultSet.getString("answerA");
				String valgB = "b-" + resultSet.getString("answerB");
				String valgC = "c-" + resultSet.getString("answerC");
				String valgD = "d-" + resultSet.getString("answerD");

				System.out.println("\t" + valgA);
				System.out.println("\t" + valgB);
				System.out.println("\t" + valgC);
				System.out.println("\t" + valgD);

				System.out.println("riktig var er - " + resultSet.getString("correctAnswer"));

				String valg = getInput("velg et boktav og tast enter");
				String velgetSvar = "";
				switch (valg) {
				case "a":
					System.out.println("ditt svar var = " + valgA);
					velgetSvar = resultSet.getString("answerA");
					break;
				case "b":
					System.out.println("ditt svar var = " + valgB);
					velgetSvar = resultSet.getString("answerB");
					break;
				case "c":
					System.out.println("ditt svar var = " + valgC);
					velgetSvar = resultSet.getString("answerC");
					break;
				case "d":
					System.out.println("ditt svar var = " + valgD);
					velgetSvar = resultSet.getString("answerD");
					break;
				default:
					System.out.println("ditt svar var = " + valg);
					break;
				}

				if (velgetSvar.equals(resultSet.getString("correctAnswer"))) {
					score++;
				}

				System.out.println("\n\n");
			}
		} catch (Exception e) {
		}

		scores.addScoreHistory(user, "Basketball", score);

		printLastScore(user);

	}

	public static void printAllUserScore(String name) {
		System.out.println("|  name  |  Topic  |  score  |");
		resultSet = scores.getscorehistoryByName(name);
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

	public static void printLastScore(String name) {

		System.out.println("|  name  |  Topic  |  score  |");
		resultSet = scores.getLastScore();
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

	public static String getInput(String in) {
		System.out.println(in);
		String input = null;
		try {
			scanner = new Scanner(System.in);
			input = scanner.nextLine();
		} catch (Exception e) {

		}
		return input;
	}
}
