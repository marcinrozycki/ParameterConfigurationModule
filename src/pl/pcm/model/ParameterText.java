package pl.pcm.model;

public class ParameterText extends Parameter {
	private String value;
	
	public ParameterText(){
		super();
		this.type="text";
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(Object value) {
		this.value = (String) value;
	}

}
