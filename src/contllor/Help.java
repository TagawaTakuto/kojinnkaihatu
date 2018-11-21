package contllor;

import javax.servlet.http.HttpSession;

public class Help {


	public static Object cutSessionAttribute(HttpSession session, String str) {
		Object test = session.getAttribute(str);
		session.removeAttribute(str);

		return test;
	}
}
