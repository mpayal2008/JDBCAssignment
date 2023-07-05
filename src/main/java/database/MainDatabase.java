package database;

import java.sql.Connection;
import java.sql.SQLException;

import database.daopackage.ComputersDAO;
import database.jdbc.ConnectionPool;
import models.Computers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import services.IComputers;

public class MainDatabase {

	private static  Logger logger = LogManager.getLogger(MainDatabase.class);

	public static void main(String[] args) {
		
		Connection connection = ConnectionPool.getInstance().retrieve();
		
		IComputers computerInterface = new ComputersDAO();
		try {
			Computers comp =computerInterface.getID(1001);
			logger.info(comp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
