package pl.pcm.controller;

import pl.pcm.model.Parameter;

public class SQLParameterParser {

	public String createAddParameterQuery(Parameter param) {
		return "INSERT INTO parameters VALUES ('" + param.getName() + "','" + param.getDescription() + "','"
				+ param.getType() + "','" + param.getCategory() + "'); INSERT INTO parameters" + param.getType()
				+ " (name, value) values ( '" + param.getName() + "','" + param.getValue() + "');";
	}

	public String getParameterQuery(String name) {
		return "SELECT * FROM parameters WHERE name = '" + name + "';";
	}

	public String getParameterValueQuery(Parameter param) {
		return "SELECT value FROM parameters" + param.getType() + " WHERE name = '" + param.getName() + "';";
	}

}
