package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.jdbc.JdbcConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import database.daoimpl.ComputersDAO;
import database.services.IComputers;
import models.Computers;

public class mainDB {
	private static  Logger logger = LogManager.getLogger(mainDB.class);
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
	
		Connection connection= null;
		Statement statement= null;
		
		try {
			//JDBC connection 
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = JdbcConnection.getConnection();
			logger.info("Database connecion successful");
			statement = connection.createStatement();
			} catch (SQLException e) {
			logger.error("Exception", e);
		} 	//select query 
											
		IComputers computerInterface = new ComputersDAO();
	
			Computers comp =computerInterface.getID(1001);
			logger.info(comp);
		
		
		
	}

}

	


