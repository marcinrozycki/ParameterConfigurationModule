package pl.pcm.controller;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pl.pcm.controller.SQLParameterParser;
import pl.pcm.model.Parameter;
import pl.pcm.model.ParameterFactory;
import pl.pcm.model.ParameterText;

public class SQLParameterParserTest {
	SQLParameterParser parser = new SQLParameterParser();
	Parameter param;
	
	@Before
	public void setUp() throws Exception {
		param = ParameterFactory.createParameter("text");
		param.setName("testName");
		param.setCategory("testCategory");
		param.setDescription("description");
		param.setValue("testValue");
	}

	@Test
	public void testCreateAddParameterQuery() {
		// given
		String expectedQuery = "INSERT INTO parameters VALUES ('testName','description','text','testCategory'); INSERT INTO parameterstext (name, value) values ( 'testName','testValue');";
		// when
		String parsedQuery = parser.createAddParameterQuery(param);
		//then
		assertEquals(expectedQuery, parsedQuery);
	}

	@Test
	public void testGetParameterQuery() {
		// given
		String expectedQuery = "SELECT * FROM parameters WHERE name = 'testName';"; 
		// when
		String parsedQuery = parser.getParameterQuery(param.getName());
		//then
		assertEquals(expectedQuery, parsedQuery);		
	}

	@Test
	public void testGetParameterValueQuery() {
		// given
		String expectedQuery = "SELECT value FROM parameterstext WHERE name = 'testName';";
		// when
		String parsedQuery = parser.getParameterValueQuery(param);
		//then
		assertEquals(expectedQuery, parsedQuery);	
	}

}
