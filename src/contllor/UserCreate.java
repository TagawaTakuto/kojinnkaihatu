package contllor;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class UserCreate
 */
@WebServlet("/UserCreate")
public class UserCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserCreate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserCreate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String loginId = request.getParameter("LoginId");
		String Password = request.getParameter("Password");
		String KPass = request.getParameter("Kpassword");
		String Name = request.getParameter("UserName");
		String Birthdate = request.getParameter("BirthDate");

		UserDao userdao = new UserDao();
		String hikaku;
		try {
			hikaku = userdao.getUserDataBeansByUserId(loginId);

		if(loginId.equals("") || Password.equals("") || Name.equals("") || Birthdate.equals("") ||  !KPass.equals(Password)) {
			request.setAttribute("errMsg", "入力された内容が正しくありません。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserCreate.jsp");
			dispatcher.forward(request, response);
			return;

		}else if(loginId.equals(hikaku)){
			request.setAttribute("errMsg", "このIDはすでに使われています。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserCreate.jsp");
			dispatcher.forward(request, response);
			return;
		}


		UserDao.insertUser(loginId, Name, Password, Birthdate);
		response.sendRedirect("Login");

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}


