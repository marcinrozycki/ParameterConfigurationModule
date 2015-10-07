package pl.pcm.servlets;

public class ParameterText extends Parameter {
	private String value;

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(Object value) {
		this.value = (String) value;
	}

}
