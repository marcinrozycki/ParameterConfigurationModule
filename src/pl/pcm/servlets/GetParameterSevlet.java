package pl.pcm.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.pcm.controller.ParameterDao;
import pl.pcm.controller.SQLParameterParser;

@WebServlet("/testGet")
public class GetParameterSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ParameterDao paramDao;

	public GetParameterSevlet() {
		super();
		new SQLParameterParser();
		paramDao = new ParameterDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			paramDao.getParemeter("testName");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
