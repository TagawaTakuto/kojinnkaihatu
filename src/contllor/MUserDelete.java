package contllor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDataBeans;
import dao.UserDao;

/**
 * Servlet implementation class MUserDelete
 */
@WebServlet("/MUserDelete")
public class MUserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MUserDelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		try {
			int Id = Integer.parseInt(request.getParameter("id"));

			UserDao userdao = new UserDao();
			UserDataBeans userd = userdao.getUserData(Id);
			HttpSession session = request.getSession();
			session.setAttribute("userd", userd);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/MUserDelete.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ERROR.jsp");
			dispatcher.forward(request, response);
			return;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		try {
			String Id = request.getParameter("id");

			UserDao userdao = new UserDao();
			userdao.UserDelete(Id);

			response.sendRedirect("UserList");

		} catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ERROR.jsp");
			dispatcher.forward(request, response);
			return;
		}
	}

}
