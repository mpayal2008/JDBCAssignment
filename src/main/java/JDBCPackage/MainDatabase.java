package JDBCPackage;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import DAOClasses.*;
import IntefaceDAO.*;
import models.*;

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
