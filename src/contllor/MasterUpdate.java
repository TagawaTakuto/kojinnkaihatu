package contllor;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;

/**
 * Servlet implementation class MasterUpdate
 */
@WebServlet("/MasterUpdate")
public class MasterUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MasterUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/MasterUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int Id = Integer.parseInt(request.getParameter("id"));
		String Name = request.getParameter("title");
		String fileName = request.getParameter("fileName");
		String Detail = request.getParameter("setumei");
		String saleDate = request.getParameter("saleDate");
		int Price = Integer.parseInt(request.getParameter("price"));
		int Stock = Integer.parseInt(request.getParameter("zaiko"));
		int Hard = Integer.parseInt(request.getParameter("Hard"));

		String[] GenreId = request.getParameterValues("Genre");
		ArrayList<Integer> GId = new ArrayList<Integer>();
		if (GenreId != null) {
			for (int i = 0; i < GenreId.length; i++) {
				String s = GenreId[i];
				int I = Integer.parseInt(s);
				GId.add(I);
			}
		}
		ItemDao itemdao = new ItemDao();
		itemdao.ItemUpdate(Id, Name, fileName, Detail, saleDate, Price, Stock, Hard);
		itemdao.GenreDelete(Id);
		itemdao.GenreCreate(Id, GId);

		response.sendRedirect("MasterList");

	}

}
