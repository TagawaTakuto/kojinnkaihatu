package contllor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GenreDao;
import dao.ItemDao;

/**
 * Servlet implementation class MasterCreate
 */
@WebServlet("/MasterCreate")
public class MasterCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MasterCreate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/MasterCreate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String Title = request.getParameter("title");
		String Detail = request.getParameter("setumei");
		int Price = Integer.parseInt(request.getParameter("price"));
		int Stock = Integer.parseInt(request.getParameter("zaiko"));
		String saleDate = request.getParameter("saleDate");
		String fileName = request.getParameter("fileName");
		int Hard = Integer.parseInt(request.getParameter("Hard"));
		String[] Genre = request.getParameterValues("Genre");
		ArrayList<Integer> G = new ArrayList<Integer>();
		if (Genre != null) {
			for (int i = 0; i < Genre.length; i++) {
				String s = Genre[i];
				int I = Integer.parseInt(s);
				G.add(I);
			}
		}
		ItemDao itemdao = new ItemDao();
		GenreDao genredao = new GenreDao();
		try {
			itemdao.Create(Title, Detail, Price, Stock, saleDate, fileName, Hard);
			int Id = itemdao.Id();
			genredao.GenreCreate(Id, G);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		response.sendRedirect("MasterList");
		return;

	}
}
