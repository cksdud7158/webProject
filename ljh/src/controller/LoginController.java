package controller;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FootBallDAOImpl;
import model.UserVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "loginCheck.jsp";
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		PrintWriter out = response.getWriter();
		System.out.println("여기까지 실행");
		try {
			UserVO uVo = FootBallDAOImpl.getInstance().login(id, pass);
			HttpSession session = request.getSession();

			if (uVo != null) {
				session.setAttribute("uVo", uVo);
				System.out.println("JSESSIONID :: " + session.getId());
				path = "login.jsp";
				out.print(path);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
}
