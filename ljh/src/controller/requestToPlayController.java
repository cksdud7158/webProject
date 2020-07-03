package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FootBallDAOImpl;
import model.TeamVO;

public class requestToPlayController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession sss = request.getSession();
		TeamVO tVo = (TeamVO)sss.getAttribute("tVo");
		
		String check = "false";
		
		// DAO 인자값 받아오기
		int awayId = tVo.getTeamId();
		int matchId = Integer.parseInt(request.getParameter("matchId"));
		System.out.println(awayId+", "+matchId);
		PrintWriter out = response.getWriter();
		
		if(!FootBallDAOImpl.getInstance().isExistMatch(awayId, matchId)) {
			FootBallDAOImpl.getInstance().updateMatch(awayId, matchId);
			check = "true";
			System.out.println("경기 신청됨");
		}
		return null;
	}
	

}
