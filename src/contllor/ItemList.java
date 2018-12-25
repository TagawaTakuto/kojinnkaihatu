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
import dao.HardDao;
import dao.ItemDao;
import model.Item;
import model.Seach;

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
		int pageNum = Integer
				.parseInt(request.getParameter("page_num") == null ? "1" : request.getParameter("page_num"));
		int pageMax = Integer
				.parseInt(request.getParameter("pageMax") == null ? "1" : request.getParameter("pageMax"));
		List<Item> List = (List<Item>) session.getAttribute("ItemList");
		List<Item> AllList = (List<Item>) session.getAttribute("AllList");
		session.removeAttribute("pageMax");
		List<Seach> GL = (List<Seach>) session.getAttribute("GL");
		List<Seach> HL = (List<Seach>) session.getAttribute("HL");

		if (List == null || List.isEmpty() && AllList == null || AllList.isEmpty()) {
			List<Item> ItemList = new ArrayList<Item>();
			ItemDao itemdao = new ItemDao();
			ItemList = itemdao.ItemAll();
			pageMax = (int) Math.ceil((double) ItemList.size() / 8);
			GL = GenreDao.GenreAll();
			HL = HardDao.HardAll();
			session.setAttribute("AllList", ItemList);
			session.setAttribute("ItemList", ItemList);
			session.setAttribute("pageMax", pageMax);
			session.setAttribute("pageNum", pageNum);
			session.setAttribute("GL", GL);
			session.setAttribute("HL", HL);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemList.jsp");
			dispatcher.forward(request, response);
			return;
		}
		List<Item> ItemList = new ArrayList<Item>();
		for (int i = pageNum * 8 - 8; i <= pageNum * 8 - 1; i++) {
			try {
				Item item = AllList.get(i);
				ItemList.add(item);
			} catch (Exception e) {
				break;
			}
		}
		pageMax = (int) Math.ceil((double) AllList.size() / 8);
		session.setAttribute("ItemList", ItemList);
		session.setAttribute("pageMax", pageMax);
		session.setAttribute("pageNum", pageNum);
		session.setAttribute("GL", GL);
		session.setAttribute("HL", HL);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemList.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int pageNum = Integer
				.parseInt(request.getParameter("page_num") == null ? "1" : request.getParameter("page_num"));
		int pageMax = 0;
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
		} else {
			HId.add(0);
		}
		if (GenreId != null) {
			for (int i = 0; i < GenreId.length; i++) {
				String s = GenreId[i];
				int I = Integer.parseInt(s);
				GId.add(I);
			}
		} else {
			GId.add(0);
		}
		List<Item> ItemList = new ArrayList<Item>();
		ItemDao itemdao = new ItemDao();
		ItemList = itemdao.ItemSearch(Keyword, SdateS, SdateE, HId, GId,
				Sort);
		if (ItemList != null || !ItemList.isEmpty()) {
			pageMax = (int) Math.ceil((double) ItemList.size() / 8);
		}
		List<Seach> GL = GenreDao.GenreSeachToItemList(GId);
		List<Seach> HL = HardDao.HardSeach(HId);
		HttpSession session = request.getSession();
		session.setAttribute("AllList", ItemList);
		session.setAttribute("ItemList", ItemList);
		session.setAttribute("Keyword", Keyword);
		session.setAttribute("Sdate", SdateS);
		session.setAttribute("Edate", SdateE);
		session.setAttribute("HardId", HardId);
		session.setAttribute("GenreId", GenreId);
		session.setAttribute("sort", Sort);
		session.setAttribute("pageNum", pageNum);
		session.setAttribute("pageMax", pageMax);
		session.setAttribute("GL", GL);
		session.setAttribute("HL", HL);
		if (ItemList.isEmpty()) {
			request.setAttribute("Mess", "該当する商品が存在しません。");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemList.jsp");
		dispatcher.forward(request, response);
	}
}
