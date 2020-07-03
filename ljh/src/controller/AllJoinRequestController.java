package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FootBallDAOImpl;
import model.TeamVO;
import model.UserVO;

public class AllJoinRequestController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "";
		HttpSession sss = request.getSession();
		TeamVO tVo = (TeamVO)sss.getAttribute("tVo");
		
		int teamId = tVo.getTeamId();
		ArrayList<UserVO> uVoList = FootBallDAOImpl.getInstance().getJoinRequest(teamId);
		request.setAttribute("uVoList", uVoList);
		if(uVoList!=null) {
			path = "joinRequest.jsp";
		}
		
		return new ModelAndView(path);
	}
	

}
