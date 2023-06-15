package JDBCPackage;

import java.sql.Connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainDatabase {

	private static  Logger logger = LogManager.getLogger(MainDatabase.class);

	public static void main(String[] args) {
		
		Connection connection = ConnectionPool.getInstance().retrieve();

	}

}
