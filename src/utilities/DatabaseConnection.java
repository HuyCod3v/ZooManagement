package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static Connection getMySQLConnection(){
		Connection connection = null;
		String URL = "jdbc:mysql://" + Configuration.MYSQL_HOST + Configuration.MYSQL_DATABASE + "?useUnicode=true&characterEncoding=UTF8";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, Configuration.MYSQL_USER, Configuration.MYSQL_PASSWORD);
		} catch (ClassNotFoundException | SQLException exception) {
			exception.printStackTrace();
		}
		
		return connection;
	}
	
	public static Connection getConnection() {
		return getMSSQLConnection();
	}
	
	private static Connection getMSSQLConnection() {
		Connection connection = null;
		String URL = "jdbc:sqlserver://" + Configuration.MSSQL_HOST + ";instanceName=SQLEXPRESS;databaseName=" + Configuration.MSSQL_DATABASE;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
			connection = DriverManager.getConnection(URL, Configuration.MSSQL_USER, Configuration.MSSQL_PASSWORD);
		} catch (ClassNotFoundException | SQLException exception) {
			exception.printStackTrace();
		}
		
		return connection;
	}

}
