package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FootBallDAOImpl2;
import model.UserVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "loginFail.jsp";
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		System.out.println("여기까지 실행");
		try {
			UserVO uVo = FootBallDAOImpl2.getInstance().login(id, pass);
			HttpSession session = request.getSession();

			if (uVo != null) {
				session.setAttribute("uVo", uVo);
				System.out.println("JSESSIONID :: " + session.getId());
				path = "login.jsp";
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return new ModelAndView(path);

	}

}
