package pl.pcm.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ParameterDao {
	private final static String DB_URL = "jdbc:postgresql://localhost:5432";
	private final static String DB_USER = "postgres";
	private final static String DB_PASS = "postgres";

	private Connection connection;

	private Statement statement;

	private String query;

	private SQLParameterParser parser;

	public ParameterDao() {
		parser = new SQLParameterParser();
	}

	public void addParameter(Parameter param) {
		query = parser.createAddParameterQuery(param);
		executeQuery();
	}


	private void executeQuery() {
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			statement = connection.createStatement();
			statement.executeUpdate(query);
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
