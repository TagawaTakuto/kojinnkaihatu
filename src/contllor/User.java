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

import beans.BuyDataBeans;
import dao.BuyDataDao;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public User() {
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
		try {

			if (session.getAttribute("LoginInfo") == null) {

				response.sendRedirect("Login");
				return;
			}
			int pageNum = Integer
					.parseInt(request.getParameter("page_num") == null ? "1" : request.getParameter("page_num"));
			int pageMax = Integer
					.parseInt(request.getParameter("pageMax") == null ? "1" : request.getParameter("pageMax"));
			int id = (int) session.getAttribute("userId");
			List<BuyDataBeans> List = (List<BuyDataBeans>) session.getAttribute("UserBuy");
			List<BuyDataBeans> AllList = (List<BuyDataBeans>) session.getAttribute("AllBuy");

			if (List == null || List.isEmpty() && AllList == null || AllList.isEmpty()) {

				AllList = (List<BuyDataBeans>) BuyDataDao.BuyHis(id);
				pageMax = (int) Math.ceil((double) AllList.size() / 4);

				session.setAttribute("AllBuy", AllList);
				session.setAttribute("UserBuy", AllList);
				session.setAttribute("pageMax", pageMax);
				session.setAttribute("pageNum", pageNum);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/User.jsp");
				dispatcher.forward(request, response);
				return;
			}

			List<BuyDataBeans> BuyList = new ArrayList<BuyDataBeans>();
			for (int i = pageNum * 4 - 4; i <= pageNum * 4 - 1; i++) {
				try {
					BuyDataBeans buy = AllList.get(i);
					BuyList.add(buy);
				} catch (Exception e) {
					break;
				}
			}
			request.setAttribute("UserBuy", BuyList);
			session.setAttribute("pageNum", pageNum);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/User.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ERROR.jsp");
			dispatcher.forward(request, response);
			return;
		}
	}
}
