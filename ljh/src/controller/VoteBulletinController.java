package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FootBallDAOImpl;
import model.TeamVO;
import model.VoteVO;

public class VoteBulletinController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "voteBulletin.jsp";
		HttpSession session = request.getSession();
		TeamVO tVo= (TeamVO) session.getAttribute("tVo");
		
		VoteVO vVo = new VoteVO();
		int teamId = tVo.getTeamId();
		try {
			vVo = FootBallDAOImpl.getInstance().findVoteByTeamId(teamId);
			System.out.println(vVo);
			session.setAttribute("vVo", vVo);
			session.setAttribute("voteResultCount",FootBallDAOImpl.getInstance().voteResultCount(vVo.getVoteId()));
		} catch (SQLException e) {
			System.out.println(e);
		}

		return new ModelAndView(path);
	}

}
