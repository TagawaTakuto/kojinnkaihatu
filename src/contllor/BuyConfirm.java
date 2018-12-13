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

import beans.DeliveryMethodDataBeans;
import dao.DeliveryDao;
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

		if (session.getAttribute("LoginInfo") == null) {
			response.sendRedirect("Login");
			return;

		}

		int DeliveryId = Integer.parseInt(request.getParameter("delivery"));
		DeliveryMethodDataBeans dmdb = DeliveryDao.DeliveryMethod(DeliveryId);
		ArrayList<Item> cartIDBList = (ArrayList<Item>) session.getAttribute("cart");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/BuyConfirm.jsp");
		dispatcher.forward(request, response);

	}
}
