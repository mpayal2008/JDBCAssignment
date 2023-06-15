package JDBCPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class mainDB {
	private static  Logger logger = LogManager.getLogger(mainDB.class);
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		String db_url = "jdbc:mysql://localhost:3306/Solvd_computer";
		String username = "root";
		String password = "root1234";
		
		Connection connection= null;
		Statement statement= null;
		
		try {
			//JDBC connection 
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = JdbcConnection.getConnection(db_url, username, password);			
			logger.info("Database connecion successful");
			statement = connection.createStatement();
			} catch (SQLException e) {
			logger.error("Exception", e);
		} 	//select query 
											
		
		try {
			String query1= "select * from Computers";	
			ResultSet rs;
			rs = statement.executeQuery(query1);
			while(rs.next()) {
				logger.info(rs.getInt("computer_id"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {	//update query
			String query2= "update Internal_Configuration set operating_system = 'IOS' where operating_system= 'Apple'";
			int update;
			update = statement.executeUpdate(query2);
			logger.info(update);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

}

	


