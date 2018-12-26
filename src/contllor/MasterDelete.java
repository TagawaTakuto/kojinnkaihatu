package contllor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemDao;
import model.Item;

/**
 * Servlet implementation class MasterDelete
 */
@WebServlet("/MasterDelete")
public class MasterDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MasterDelete() {
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
			ItemDao itemdao = new ItemDao();

			Item item = itemdao.Data(Id);

			HttpSession session = request.getSession();
			session.setAttribute("Item", item);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/MasterDelete.jsp");
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
		try {
			int Id = Integer.parseInt(request.getParameter("id"));
			ItemDao itemdao = new ItemDao();

			itemdao.ItemDelete(Id);

			response.sendRedirect("MasterList");
		} catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ERROR.jsp");
			dispatcher.forward(request, response);
			return;
		}
	}

}
