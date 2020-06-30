package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FootBallDAOImpl;
import model.TeamVO;
import model.UserVO;
import model.VoteResultVO;
import model.VoteVO;

public class VoteController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "voteBulletin.do";
		HttpSession session = request.getSession();
		UserVO uVo = (UserVO) session.getAttribute("uVo");
		TeamVO tVo = (TeamVO) session.getAttribute("tVo");
		VoteVO vVo = (VoteVO) session.getAttribute("vVo");
		VoteResultVO vrVo = new VoteResultVO();
		String userId = uVo.getUserId();
		int teamId = tVo.getTeamId();
		int VoteId = vVo.getVoteId();
		int teamMemberId = FootBallDAOImpl.getInstance().getTeamMemberId(userId, teamId);
			vrVo.setAttendance(Integer.parseInt(request.getParameter("voteCheck")));
			vrVo.setTeamMemberId(teamMemberId);
			vrVo.setVoteId(VoteId);
		
		if(FootBallDAOImpl.getInstance().isVoteDone(teamMemberId, VoteId)) {
			FootBallDAOImpl.getInstance().VoteUpdate(vrVo);
		}else {
			FootBallDAOImpl.getInstance().insertVoteResult(vrVo);
		}
		
		
		
		return new ModelAndView(path);
	}

}
