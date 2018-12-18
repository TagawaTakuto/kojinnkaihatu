package contllor;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class Easybuy
 */
@WebServlet("/Easybuy")
public class Easybuy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Easybuy() {
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

		ArrayList<Item> cart = (ArrayList<Item>) session.getAttribute("cart");
		int id = Integer.parseInt(request.getParameter("id"));
		int count = Integer.parseInt(request.getParameter("buycount"));
		Item item = ItemDao.Data(id);
		item.setBuycount(count);

		if (cart == null) {
			cart = new ArrayList<Item>();
		}

		// カートの中の商品に同一のものがあれば、購入数を加算

		boolean uniqueFlg = true;

		for (Item itm : cart) {
			if(itm.getId() == id) {
				itm.setBuycount(itm.getBuycount() + count);
				uniqueFlg = false;
			}
		}

		if(uniqueFlg) {
			cart.add(item);
		}

		session.setAttribute("cart", cart);
		request.setAttribute("Mess", "カートに商品を追加しました。");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemList.jsp");
		dispatcher.forward(request, response);
	}

}
