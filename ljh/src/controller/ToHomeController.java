package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ToHomeController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "login.jsp";
		HttpSession sss = request.getSession();
		if(sss.getAttribute("tVo")!=null) {
			sss.setAttribute("tVo", null);
		}
		return new ModelAndView(path);
	}

}
