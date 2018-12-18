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
import javax.servlet.http.HttpSession;

import beans.BuyDataBeans;
import beans.BuyDetailDataBeans;
import dao.BuyDataDao;
import dao.BuyDetailDao;
import dao.ItemDao;
import model.Item;

/**
 * Servlet implementation class BuyComplete
 */
@WebServlet("/BuyComplete")
public class BuyComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyComplete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		try {
			ArrayList<Item> BuyList = (ArrayList<Item>) session.getAttribute("BuyList");
			BuyDataBeans bdb = (BuyDataBeans) session.getAttribute("buydata");
			int buyId = BuyDataDao.Buy(bdb);
			for (Item item : BuyList) {
				BuyDetailDataBeans bddb = new BuyDetailDataBeans();
				bddb.setBuyId(buyId);
				bddb.setItemId(item.getId());
				bddb.setBuyCount(item.getBuycount());
				BuyDetailDao.insertBuyDetail(bddb);
				ItemDao.StockDown(item.getId(),item.getBuycount());
			}

			BuyDataBeans buyresult = BuyDataDao.BuyData(buyId);
			ArrayList<Item> buyIDBList = BuyDetailDao.getItemDataBeansListByBuyId(buyId);

			request.setAttribute("BuyResult", buyresult);
			request.setAttribute("buyIDBList", buyIDBList);


			session.removeAttribute("cart");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/BuyComplete.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
