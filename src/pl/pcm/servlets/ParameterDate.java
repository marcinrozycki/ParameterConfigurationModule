package pl.pcm.servlets;

import java.time.LocalDate;

public class ParameterDate extends Parameter {

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
