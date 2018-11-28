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

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemList.jsp");
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
		int HId[] = new int[4];
		int GId[] = new int[5];
		for (int i = 0; i < HardId.length; i++) {
			String s = HardId[i];
			int I = Integer.parseInt(s);
			HId[i] = I;
			}
		int HId1 = HId[0];
		int HId2 = HId[1];
		int HId3 = HId[2];
		int HId4 = HId[3];
		for (int i = 0; i < GenreId.length; i++) {
			String s = GenreId[i];
			int I = Integer.parseInt(s);
			GId[i] = I;
		}
		int GId1 = GId[0];
		int GId2 = GId[1];
		int GId3 = GId[2];
		int GId4 = GId[3];
		int GId5 = GId[4];
		List<Item> ItemList = new ArrayList<Item>();
		ItemDao itemdao = new ItemDao();
		ItemList = itemdao.ItemSearch(Keyword, SdateS, SdateE, HId1,HId2,HId3,HId4, GId1,GId2,GId3,GId4,GId5,Sort);
		HttpSession session = request.getSession();
		session.setAttribute("ItemList", ItemList);


		response.sendRedirect("ItemList");
	}
}

