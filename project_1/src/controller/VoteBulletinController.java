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
		System.out.println(teamId+"팀아이디입니다. 보트불레틴컨트롤러");
		try {

			vVo = FootBallDAOImpl.getInstance().findVoteByTeamId(teamId);
			System.out.println(vVo+"확인중입니다.");
			session.setAttribute("vVo", vVo);
		} catch (SQLException e) {
			System.out.println(e);
		}

		return new ModelAndView(path);
	}

}
