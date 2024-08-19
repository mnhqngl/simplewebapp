package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		try {
			response.setContentType("text/html");
			out = response.getWriter();
			request.getRequestDispatcher("link.html").include(request, response);
			HttpSession session = request.getSession();
			session.invalidate();
			out.print("You are successfully logged out!");
			out.close();
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
	}

}
