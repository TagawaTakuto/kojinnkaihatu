package contllor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GenreDao;
import dao.ItemDao;
import model.Item;

/**
 * Servlet implementation class ItemData
 */
@WebServlet("/ItemData")
public class ItemData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemData() {
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

		int Id = Integer.parseInt(request.getParameter("id"));

		GenreDao genredao = new GenreDao();

		List<String> GL = genredao.Genre(Id);
		Item itemd = ItemDao.Data(Id);
		HttpSession session = request.getSession();
		session.setAttribute("itemd", itemd);
		session.setAttribute("GL", GL);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemData.jsp");
		dispatcher.forward(request, response);
		return;

	}
}
