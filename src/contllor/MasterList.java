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

import dao.ItemDao;
import model.Item;

/**
 * Servlet implementation class MasterList
 */
@WebServlet("/MasterList")
public class MasterList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MasterList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		if (session == null) {

			response.sendRedirect("Login");
			return;
		}

		List<Item> ItemList = new ArrayList<Item>();
		ItemDao itemdao = new ItemDao();
		ItemList = itemdao.ItemAll();

		session.setAttribute("ItemList", ItemList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/MasterList.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Keyword = request.getParameter("Keyword");
		String SdateS = request.getParameter("Sdate");
		String SdateE = request.getParameter("Edate");
		String[] HardId = request.getParameterValues("Hard");
		String[] GenreId = request.getParameterValues("Genre");
		String Sort = request.getParameter("sort");
		ArrayList<Integer> HId = new ArrayList<Integer>();
		ArrayList<Integer> GId = new ArrayList<Integer>();
		if (HardId != null) {
			for (int i = 0; i < HardId.length; i++) {
				String s = HardId[i];
				int I = Integer.parseInt(s);
				HId.add(I);
			}
		}

		if (GenreId != null) {
			for (int i = 0; i < GenreId.length; i++) {
				String s = GenreId[i];
				int I = Integer.parseInt(s);
				GId.add(I);
			}
		}

		List<Item> ItemList = new ArrayList<Item>();
		ItemDao itemdao = new ItemDao();
		ItemList = itemdao.ItemSearch(Keyword, SdateS, SdateE, HId, GId,
				Sort);
		HttpSession session = request.getSession();
		session.setAttribute("ItemList", ItemList);

		response.sendRedirect("ItemList");
	}
}
