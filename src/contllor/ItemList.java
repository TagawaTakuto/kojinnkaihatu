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

import dao.GenreDao;
import dao.ItemDao;
import model.GenreSeach;
import model.Item;

/**
 * Servlet implementation class ItemList
 */
@WebServlet("/ItemList")
public class ItemList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemList() {
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
		int pageMax = ItemList.size() / 8;
		pageMax++;
		List<GenreSeach> GL = GenreDao.GenreAll();

		session.setAttribute("ItemList", ItemList);
		session.setAttribute("pagemax", pageMax);
		session.setAttribute("GL", GL);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemList.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
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
		List<GenreSeach> GL = GenreDao.GenreSeachToItemList(GId);
		HttpSession session = request.getSession();
		session.setAttribute("ItemList", ItemList);
		session.setAttribute("Keyword", Keyword);
		session.setAttribute("Sdate", SdateS);
		session.setAttribute("EdateS", SdateE);
		session.setAttribute("HardId", HardId);
		session.setAttribute("GenreId", GenreId);
		session.setAttribute("sort", Sort);
		session.setAttribute("GL", GL);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemList.jsp");
		dispatcher.forward(request, response);
	}
}
