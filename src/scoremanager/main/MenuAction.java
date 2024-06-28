package scoremanager.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class MenuAction extends Action {

	public void execute (
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
			request.getRequestDispatcher("menu.jsp")
				.forward(request, response);
	}
}