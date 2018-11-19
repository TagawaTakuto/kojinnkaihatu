package contllor;

import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class UserData
 */
@WebServlet("/UserData")
public class UserData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserData() {
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

		HttpSession session = request.getSession();

		if (session.getAttribute("LoginInfo") == null) {

			request.setAttribute("errMsg", "ログインセッションが切れました。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
			dispatcher.forward(request, response);
			return;

		}

		String id = request.getParameter("login_id");

		UserDao userdao = new UserDao();
		UserDataBeans user;
		try {
			user = userdao.getUserData(id);
			session.setAttribute("UserInfo",user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserData.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}



	}

}
