package pl.pcm.servlets;

public class ParameterNumber extends Parameter {

	private double value;

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public void setValue(Object value) {
		this.value = (double) value;
	}

}
