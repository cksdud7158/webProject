package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FootBallDAOImpl;
import model.PlayerInfoVO;

public class showAllMemberController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "index.jsp";
		int teamId = Integer.parseInt(request.getParameter("teamId"));

		ArrayList<PlayerInfoVO> allMember = new ArrayList<>(); 

		allMember = FootBallDAOImpl.getInstance().showAllMember(teamId);
		System.out.println(allMember);
		request.setAttribute("allMember", allMember);
		if(!allMember.isEmpty()) {
			path = "showAllMember.jsp";
		}
		return new ModelAndView(path);
	}

}
