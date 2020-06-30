package controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller{
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "index.jsp";
		HttpSession session = request.getSession();
		if (session.getAttribute("uVo") != null) {// 로그인한 상태라면
			session.invalidate();
		}
		return new ModelAndView(path);
	}
}
