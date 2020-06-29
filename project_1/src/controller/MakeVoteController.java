package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FootBallDAOImpl;
import model.MatchVO;
import model.TeamVO;
import model.UserVO;
import model.VoteVO;

public class MakeVoteController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "voteBulletin.jsp";
		int voteId = 0;
		HttpSession session = request.getSession();
		UserVO uVo= (UserVO) session.getAttribute("uVo");
		TeamVO tVo= (TeamVO) session.getAttribute("tVo");
		VoteVO vVo= new VoteVO();
		MatchVO mVo= new MatchVO();
		
		//VoteVO
		String contents = request.getParameter("contents");
		String dueDate = request.getParameter("dueDate");
		String writer = uVo.getUserId();
		int teamId = tVo.getTeamId();
		vVo.setContents(contents);
		vVo.setDueDate(dueDate);
		vVo.setWriter(writer);
		vVo.setTeamId(teamId);
		
		
		//MatchVO
		//int TeamId 
		int stadiumId = tVo.getStadiumId();
		String schedule = request.getParameter("schedule");
		
		mVo.setTeamId(teamId);
		mVo.setStadiumId(stadiumId);
		mVo.setSchedule(schedule);
			vVo.setmVo(mVo);
		try {
			FootBallDAOImpl.getInstance().makeVote(vVo);
			vVo =  FootBallDAOImpl.getInstance().findVoteByTeamId(teamId);
			session.setAttribute("vVo", vVo);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return new ModelAndView(path);
	}
}
