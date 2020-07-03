package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FootBallDAOImpl;
import model.TeamInfoVO;
import model.TeamVO;

public class SearchTeamController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path="";
		// searchTeam.jsp의 검색창에서 받아온 값
		String teamName = request.getParameter("teamName");
		
		// findByTeamName BL 호출
		TeamVO tVo = FootBallDAOImpl.getInstance().findByTeamName(teamName);
		
		// findTeamIdByTeamName BL 호출
		int teamId = FootBallDAOImpl.getInstance().FindTeamIdByTeamName(teamName);
		
		// getTeamInfo BL 호출
		TeamInfoVO ti = FootBallDAOImpl.getInstance().getTeamInfo(teamId);
		
		// TeamInfoVO를 TeamVO에 주입
		tVo.setTi(ti);
		
		// attribute 바인딩
		request.setAttribute("tVo", tVo);
		
		if(tVo!=null) {
			path = "searchTeam_result.jsp";
		}
		return new ModelAndView(path);
	}
	
}
