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

import beans.ItemDataBeans;
import dao.ItemDao;

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
		List<Integer> HId = new ArrayList<Integer>();
		List<Integer> GId = new ArrayList<Integer>();
		for (int i = 0; i < HardId.length; i++) {
			String s = HardId[i];
			int I = Integer.parseInt(s);
			HId.add(I);
		}

		for (int i = 0; i < GenreId.length; i++) {
			String s = GenreId[i];
			int I = Integer.parseInt(s);
			GId.add(I);
		}
		List<ItemDataBeans> ItemList = new ArrayList<ItemDataBeans>();
		ItemDao itemdao = new ItemDao();
		ItemList = itemdao.ItemSearch(Keyword, SdateS, SdateE, HId, GId, Sort);
	}

}
