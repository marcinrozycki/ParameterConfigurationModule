package pl.pcm.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddParameterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -135042806481194962L;

	private ParameterDao paramDao;

	public AddParameterServlet() {
		new SQLParameterParser();
		paramDao = new ParameterDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		Parameter param = ParameterFactory.createParameter("text");
		param.setName("testName");
		param.setCategory("testCategory");
		param.setDescription("testDescription");

		paramDao.addParameter(param);
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print("Test!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
