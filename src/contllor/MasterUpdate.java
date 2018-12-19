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

import beans.HardDataBeans;
import dao.GenreDao;
import dao.HardDao;
import dao.ItemDao;
import model.GenreSeach;
import model.Item;

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
		request.setCharacterEncoding("UTF-8");
		int Id = Integer.parseInt(request.getParameter("id"));
		GenreDao genredao = new GenreDao();
		HardDao harddao = new HardDao();
		List<GenreSeach> GL = new ArrayList<GenreSeach>();
		List<HardDataBeans> HL = new ArrayList<HardDataBeans>();
		Item item = ItemDao.Data(Id);
		GL = genredao.GenreSeach(Id);
		HL = harddao.HardAll();

		HttpSession session = request.getSession();
		session.setAttribute("Item", item);
		session.setAttribute("GL", GL);
		session.setAttribute("HL", HL);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/MasterUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
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
		GenreDao genredao = new GenreDao();
		itemdao.ItemUpdate(Id, Name, fileName, Detail, saleDate, Price, Stock, Hard);
		genredao.GenreDelete(Id);
		genredao.GenreCreate(Id, GId);

		response.sendRedirect("MasterList");

	}

}
