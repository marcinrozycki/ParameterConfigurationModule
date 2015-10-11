package pl.pcm.model;

import java.time.LocalDate;

public class ParameterDate extends Parameter {

public ParameterDate() {
		super();
		this.type="date";
	}

private LocalDate value;
	
	@Override
	public LocalDate getValue() {
		return value;
	}

	@Override
	public void setValue(Object value) {
		 this.value = (LocalDate) value;
	}

}
