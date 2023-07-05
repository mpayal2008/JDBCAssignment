package database.jdbc;


	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
	import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
	import java.sql.Connection;
	import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

	
	public class ConnectionPool {
	    private static final Logger logger = LogManager.getLogger(ConnectionPool.class);
	    
	    private static final int CON_POOL_SIZE = 5;
	    private static Properties properties = new Properties();
	    private static String userName;
	    private static String url;
	    private static String password;
	    private List<Connection> conPool = new ArrayList<>(CON_POOL_SIZE);
	    private List<Connection> activeConnections = new ArrayList<Connection>();
 
	    private ConnectionPool() {
	        for (int i = 0; i < CON_POOL_SIZE; i++) {
	            Connection connection = null;
	            try {
	                connection = DriverManager.getConnection(url, userName, password);
	            } catch (SQLException e) {
	                logger.info(e);
	            }
	            conPool.add(connection);
	        }
	    }
	    private static ConnectionPool instance = null;
	    public static ConnectionPool getInstance() {
	        if (instance == null) {
	        	instance = new ConnectionPool();
	        }
	        return instance;
	    }
	    static {
	    	FileInputStream file;
			try {
				file = new FileInputStream("src/main/resources/dbResource.properties");
				properties.load(file);
			} catch (FileNotFoundException e1) {
					e1.printStackTrace();
			}
	    	catch (IOException e) {
					e.printStackTrace();
			}
	   
	        url = properties.getProperty(url);
	        userName = properties.getProperty(userName);
	        password = properties.getProperty(password);
	    }
	    private Connection getConnection() {
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(url, userName, password);
	        } catch (Exception e) {
	            logger.info(e);
	        }
	        return conn;
	    }
	    public synchronized Connection retrieve() {
	    	Connection newConnection = null;
	    	if(conPool.size()==0){
	    		newConnection= getConnection();
	    	}else {
	    		newConnection=conPool.remove(conPool.lastIndexOf(newConnection));
		 }
	    	activeConnections.add(newConnection);
	    	logger.info("connection retrive "+newConnection.toString());
			return newConnection; 
	    }
	 
	    public synchronized void putback(Connection conn) {
		 	if(conn!= null) {
		 		activeConnections.remove(conn);
		 		conPool.add(conn);
		 		logger.info("connection putback "+conn.toString());
		 	}else {
		 		logger.info("no connection");
		 }
	 }
	    public static void closeConnection(Connection connection) {
			try {
				if(connection != null ) {
					connection.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		public static void closeStatement(Statement statement) {
			try {
				if(statement != null ) {
					statement.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		public static void closeResultSet(ResultSet resultSet) {
			try {
				if(resultSet != null ) {
					resultSet.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
}





/*private static final String db_driver = "com.mysql.cj.jdbc.Driver";

private static final String db_name = "jdbc:mysql://localhost:3306/Solvd_computer";

private static final String username = "root";
private static final String password = "root1234";

public static void main(String[] argv) throws SQLException {

	System.out.println("-------- MySQL JDBC Connection Testing ------------");

	try {
		Class.forName(db_driver);
		Connection connection = DriverManager.getConnection( db_name, username, password);
		{
			if (connection != null) {
				System.out.println("Connection Established");
			} else {
				System.out.println("Failed to make connection!");
			}
		}	
	}catch (ClassNotFoundException e) {
		System.out.println("Can't find JDBC driver.");
		return;
	}
}
*/