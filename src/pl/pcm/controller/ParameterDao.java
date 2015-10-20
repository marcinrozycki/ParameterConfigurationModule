package pl.pcm.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pl.pcm.model.Parameter;
import pl.pcm.model.ParameterFactory;

public class ParameterDao {
	private static final String VALUE = "value";
	private final static String DB_URL = "jdbc:postgresql://localhost:5432";
	private final static String DB_USER = "postgres";
	private final static String DB_PASS = "postgres";

	private Connection connection;

	private Statement statement;

	private SQLParameterParser parser;

	public ParameterDao() {
		parser = new SQLParameterParser();
	}

	public void addParameter(Parameter param) {
		String query = parser.createAddParameterQuery(param);
		executeUpdateQuery(query);
	}

	public Parameter getParemeter(String name) throws SQLException {
		Parameter param = getParameterWithoutValue(name);
		Object paramValue = getParameterValue(param);
		param.setValue(paramValue);
		return param;
	}

	private Object getParameterValue(Parameter param) throws SQLException {
		String getParamValueQuery = parser.getParameterValueQuery(param);
		String type = param.getType();
		ResultSet result = executeQuery(getParamValueQuery);
		return parseResultValue(type, result);
	}

	private Object parseResultValue(String type, ResultSet result) throws SQLException {

		switch (type) {
		case "text": {
			return result.getString(VALUE);
		}
		case "date": {

			return result.getDate(VALUE);
		}
		case "number": {
			return result.getInt(VALUE);
		}
		default:
			return null;
		}
	}

	private Parameter getParameterWithoutValue(String name) throws SQLException {
		String getParameterQuery = parser.getParameterQuery(name);
		ResultSet result = executeQuery(getParameterQuery);

		String type = result.getString("type").trim();
		String description = result.getString("description").trim();
		String category = result.getString("category").trim();
		statement.close();
		Parameter param = ParameterFactory.createParameter(type);
		param.setName(name);
		param.setDescription(description);
		param.setCategory(category);
		return param;
	}

	private ResultSet executeQuery(String getParameterQuery) throws SQLException {
		DriverManager.registerDriver(new org.postgresql.Driver());
		connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet result = statement.executeQuery(getParameterQuery);
		connection.close();
		result.first();
		return result;

	}

	private void executeUpdateQuery(String query) {
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
