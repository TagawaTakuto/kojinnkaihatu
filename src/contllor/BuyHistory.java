package contllor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BuyDataBeans;
import dao.BuyDataDao;
import dao.BuyDetailDao;
import model.Item;

/**
 * Servlet implementation class BuyHistory
 */
@WebServlet("/BuyHistory")
public class BuyHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyHistory() {
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

			List<Item> BuyHisList = BuyDetailDao.getItemDataBeansListByBuyId(Id);
			BuyDataBeans bdb = BuyDataDao.BuyData(Id);
			request.setAttribute("BuyHisList", BuyHisList);
			request.setAttribute("BuyHisDeli", bdb);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/BuyHistory.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
