package pl.pcm.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.pcm.controller.ParameterDao;
import pl.pcm.model.Parameter;

public class GetParameterServlet extends HttpServlet {
	
	private static final String PARAM_NAME = "paramName";
	private static final long serialVersionUID = 1L;
	private ParameterDao paramDao;

	public GetParameterServlet() {
		super();
		paramDao = new ParameterDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Parameter param;
		try {
			String paramName = request.getParameter(PARAM_NAME);
			param = paramDao.getParemeter(paramName);
			response.getWriter().append(param.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().append("Error while serving at: ").append(request.getContextPath());
		}

	}
}
