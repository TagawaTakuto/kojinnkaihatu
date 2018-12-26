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

import beans.BuyDataBeans;
import beans.DeliveryMethodDataBeans;
import dao.DeliveryDao;
import dao.ItemDao;
import model.Item;

/**
 * Servlet implementation class BuyConfirm
 */
@WebServlet("/BuyConfirm")
public class BuyConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyConfirm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			if (session.getAttribute("LoginInfo") == null) {
				String Mess = "購入にはログインする必要があります。";
				request.setAttribute("errMsg", Mess);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
				dispatcher.forward(request, response);
				return;
			}

			int userId = Integer.parseInt(request.getParameter("userId"));
			int DeliveryId = Integer.parseInt(request.getParameter("delivery"));
			String[] BuyCount = request.getParameterValues("count");
			DeliveryMethodDataBeans selectDMB = DeliveryDao.DeliveryMethod(DeliveryId);
			ArrayList<Item> cartList = (ArrayList<Item>) session.getAttribute("cart");
			ArrayList<Item> BuyList = new ArrayList<Item>();
			int i = 0;
			for (Item cartInItem : cartList) {
				String Count = BuyCount[i];
				cartInItem.setBuycount(Integer.parseInt(Count));
				BuyList.add(cartInItem);
				i++;
			}
			int totalPrice = ItemDao.getTotalPrice(cartList) + selectDMB.getPrice();
			BuyDataBeans bdb = new BuyDataBeans();
			bdb.setUserId(userId);
			bdb.setTotalPrice(totalPrice);
			bdb.setDeliveryMethodId(DeliveryId);
			bdb.setDeliveryMethodPrice(selectDMB.getPrice());
			bdb.setDeliveryMethodName(selectDMB.getName());

			session.setAttribute("buydata", bdb);
			session.setAttribute("BuyList", BuyList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/BuyConfirm.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ERROR.jsp");
			dispatcher.forward(request, response);
			return;
		}
	}
}
