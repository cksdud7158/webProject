package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FootBallDAOImpl;
import model.TeamVO;
import model.UserVO;

public class AllTeamController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "";
		ArrayList<TeamVO> tvList = new ArrayList<TeamVO>();
		
		// 전체 팀 불러오기
		tvList = FootBallDAOImpl.getInstance().showAllTeam();
		request.setAttribute("tvList", tvList);
		
		if(!tvList.isEmpty()) {
			path = "searchTeam.jsp";
		}
		
		return new ModelAndView(path);
	}

}
