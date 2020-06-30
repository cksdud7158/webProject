package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FootBallDAOImpl;
import model.TeamVO;
import model.UserVO;

public class teamHomeController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "index.jsp";
		int teamId = Integer.parseInt(request.getParameter("teamId"));
		HttpSession session = request.getSession();
		UserVO uvo = (UserVO)session.getAttribute("uVo");
		String userId = uvo.getUserId();
		
		// 팀 정보(회원수, 랭킹, 엠블럼) 가져오기 --- 새로운 메소드 getMyTeam
		TeamVO tVo = FootBallDAOImpl.getInstance().getSelectedTeam(userId, teamId);
		session.setAttribute("tVo", tVo);
		if(tVo!=null) {
			path = "teamHome.jsp";
		}
		return new ModelAndView(path);
	}

}
