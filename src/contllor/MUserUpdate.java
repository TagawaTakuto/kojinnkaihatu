package contllor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class MUserUpdate
 */
@WebServlet("/MUserUpdate")
public class MUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MUserUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		request.getParameter("id");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/MUserUpdate.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String UserId = request.getParameter("userId");
		String loginId = request.getParameter("LoginId");
		String Password = request.getParameter("Password");
		String Kpass = request.getParameter("Kpassword");
		String Name = request.getParameter("Name");

		UserDao userDao = new UserDao();

		if (!Kpass.equals(Password)) {
			request.setAttribute("errMsg", "入力された内容が正しくありません。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/MUserUpdate.jsp");
			dispatcher.forward(request, response);
			return;

		} else

			userDao.UserUpdate(UserId, loginId, Name, Password);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserList.jsp");
		dispatcher.forward(request, response);
	}

}
