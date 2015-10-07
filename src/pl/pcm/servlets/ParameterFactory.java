package pl.pcm.servlets;

public class ParameterFactory {

	private final static String DATE = "date";
	private final static String TEXT = "text";
	private final static String NUMBER = "number";

	public static Parameter createParameter(String type) {
		switch (type) {
		case DATE:
			return new ParameterDate();
		case TEXT:
			return new ParameterText();
		case NUMBER:
			return new ParameterNumber();
		default:
			return null;
		}

	}

}
