package pl.pcm.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.pcm.controller.ParameterDao;
import pl.pcm.model.Parameter;
import pl.pcm.model.ParameterFactory;

public class AddParameterServlet extends HttpServlet {

	private static final String TEXT = "text";
	private static final String VALUE = "value";
	private static final String DESCRIPTION = "description";
	private static final String CATEGORY = "category";
	private static final String NAME = "name";

	private static final long serialVersionUID = -135042806481194962L;

	private ParameterDao paramDao;

	public AddParameterServlet() {
		paramDao = new ParameterDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter(NAME);
		String category = request.getParameter(CATEGORY);
		String description = request.getParameter(DESCRIPTION);
		String value = request.getParameter(VALUE);
		Parameter param = ParameterFactory.createParameter(TEXT);
		param.setName(name);
		param.setCategory(category);
		param.setDescription(description);
		param.setValue(value);
		paramDao.addParameter(param);
		displayResponse(response);
	}

	private void displayResponse(HttpServletResponse response) {
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print("Parametr dodany.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
