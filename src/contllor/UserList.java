package contllor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDataBeans;
import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserList
 */
@WebServlet("/UserList")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserList() {
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

		UserDataBeans login = (UserDataBeans) session.getAttribute("LoginInfo");
		if (!login.getLoginId().equals("admin")) {

			request.setAttribute("errMsg", "不正なログインです。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
			dispatcher.forward(request, response);
			return;
		}

		int pageNum = Integer
				.parseInt(request.getParameter("page_num") == null ? "1" : request.getParameter("page_num"));
		int pageMax = Integer
				.parseInt(request.getParameter("pageMax") == null ? "1" : request.getParameter("pageMax"));
		List<User> List = (List<User>) session.getAttribute("UserList");
		List<User> AllList = (List<User>) session.getAttribute("AllUser");
		session.removeAttribute("pageMax");

		if (List == null || List.isEmpty() && AllList == null || AllList.isEmpty()) {
			List<User> UserList = UserDao.findAll();
			pageMax = (int) Math.ceil((double) UserList.size() / 4);

			session.setAttribute("AllUser", UserList);
			session.setAttribute("UserList", UserList);
			session.setAttribute("pageMax", pageMax);
			session.setAttribute("pageNum", pageNum);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserList.jsp");
			dispatcher.forward(request, response);
			return;
		}
		List<User> UserList = new ArrayList<User>();
		for (int i = pageNum * 4 - 4; i <= pageNum * 4 - 1; i++) {
			try {
				User user = AllList.get(i);
				UserList.add(user);
			} catch (Exception e) {
				break;
			}
		}
		pageMax = (int) Math.ceil((double) AllList.size() / 4);
		session.setAttribute("UserList", UserList);
		session.setAttribute("pageMax", pageMax);
		session.setAttribute("pageNum", pageNum);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserList.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int pageNum = Integer
				.parseInt(request.getParameter("page_num") == null ? "1" : request.getParameter("page_num"));
		String loginId = request.getParameter("loginId");
		String Name = request.getParameter("userName");
		String birthDateS = request.getParameter("birthDateS");
		String birthDateE = request.getParameter("birthDateE");
		UserDao userdao = new UserDao();
		List<User> UserList = userdao.findSearch(loginId, Name, birthDateS, birthDateE);

		int pageMax = (int) Math.ceil((double) UserList.size() / 4);

		HttpSession session = request.getSession();

		session.setAttribute("loginId", loginId);
		session.setAttribute("userName", Name);
		session.setAttribute("birthDateS", birthDateS);
		session.setAttribute("birthDateE", birthDateE);

		session.setAttribute("UserList", UserList);
		session.setAttribute("AllUser", UserList);
		session.setAttribute("pageNum", pageNum);
		session.setAttribute("pageMax", pageMax);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserList.jsp");
		dispatcher.forward(request, response);
	}

}
