package database.daoimpl;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import models.Accessories;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class mainDAOExecution {
	
final static Logger logger = LogManager.getLogger(mainDAOExecution.class);
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
	
		AccessoriesDAO accesoriesDAO = new AccessoriesDAO();
		Accessories accessories = accesoriesDAO.getID(102);
		logger.info(accessories);
		
		Accessories accessories1 = new Accessories(106,"Apple", "Airpods", "bluetooth connectivity", 99.99f);
		int result = accesoriesDAO.insert(accessories1);
		logger.info("insert operation", accessories1);	
		
	}

}
