package nyPostGress;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Quiry {
	
	static Connection connection;
	
	public static void executeQuiry(String quiry) {
		
		 try {
	            Class.forName("org.postgresql.Driver");
	            connection = DriverManager.getConnection("jdbc:postgresql://"+data.HOST+":"+data.PORT+"/"+ data.DATA_BASE+"", ""+data.USER+"", ""+data.PASSWORD+"");
	            Statement statement = connection.createStatement();
	            
	            statement.executeLargeUpdate(quiry);
	            
	            System.out.println("done!");

	        }catch (Exception e){
	           e.printStackTrace();
	        }
		
	}
	
	
	
}
