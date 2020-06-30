package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FootBallDAOImpl;
import model.TeamVO;

public class myTeamListController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "index.jsp";
		String userId = request.getParameter("userId");
		ArrayList<TeamVO> tVo = new ArrayList<>();
		
		tVo = FootBallDAOImpl.getInstance().myTeamList(userId);
		request.setAttribute("tVo", tVo);
		if(!tVo.isEmpty()) {
			path = "login_myteam.jsp";
		}
		
		return new ModelAndView(path);
	}

}
