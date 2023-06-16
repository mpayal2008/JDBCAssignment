package JDBCPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {

//	private static final String MYSQL_JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static String db_url = "jdbc:mysql://localhost:3306/Solvd_computer";
	private static String username = "root";
	private static String password = "root1234";
	
	private JdbcConnection() {
	}
	
	public static Connection getConnection() throws SQLException {
		
		Connection connection = DriverManager.getConnection(db_url, username, password);
		return connection;
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
