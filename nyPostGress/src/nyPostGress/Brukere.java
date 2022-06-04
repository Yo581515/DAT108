package nyPostGress;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Brukere {
	
	 static Connection connection;

	 public static void printBrukereNavn() {
		 
		   try {
	            Class.forName("org.postgresql.Driver");
	            connection = DriverManager.getConnection("jdbc:postgresql://"+data.HOST+":"+data.PORT+"/"+ data.DATA_BASE+"", ""+data.USER+"", ""+data.PASSWORD+"");
	            Statement statement = connection.createStatement();

	            ResultSet  resultSet = statement.executeQuery("select * from " + data.tab);

	            while(resultSet.next()){
	                System.out.println(resultSet.getString("brukernavn"));

	            }
	        }catch (Exception e){
	           e.printStackTrace();
	        }
	 }
	 
	 
}
