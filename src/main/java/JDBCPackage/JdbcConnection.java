package JDBCPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {

//	private static final String MYSQL_JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	private JdbcConnection() {
	}
	
	public static Connection getConnection(String db_url, String username, String password) throws SQLException {
		
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
