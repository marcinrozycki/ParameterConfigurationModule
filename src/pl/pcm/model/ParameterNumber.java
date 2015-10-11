package pl.pcm.model;

public class ParameterNumber extends Parameter {

	private double value;

	public ParameterNumber(){
		super();
		this.type="number";
	}
	
	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public void setValue(Object value) {
		this.value = (double) value;
	}

}
