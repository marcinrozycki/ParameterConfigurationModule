package pl.pcm.servlets;

public class SQLParameterParser {

	public String createAddParameterQuery(Parameter param)
	{
		return "INSERT INTO parameters VALUES ('"+ param.getName()+"','"+ param.getDescription()+"','"+ param.getType()+"','"+param.getCategory()+"');";
	}
	
}
