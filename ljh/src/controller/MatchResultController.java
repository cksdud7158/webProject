package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FootBallDAOImpl;
import model.MatchResultVO;
import model.TeamInfoVO;
import model.TeamVO;
import model.VoteVO;

public class MatchResultController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MatchResultVO mrVo = new MatchResultVO();
		HttpSession session = request.getSession();
		TeamVO tVo = (TeamVO) session.getAttribute("tVo");
		TeamInfoVO tiVo = new TeamInfoVO();
		VoteVO vVo = (VoteVO) session.getAttribute("vVo");
		int matchId = vVo.getmVo().getMatchId();
		int teamId = tVo.getTeamId();
		int winningScore = 0;

		String homeScore = request.getParameter("homeScore");
		String awayScore = request.getParameter("awayScore");
		String score = homeScore + ":" + awayScore;
		int toHomeMannerScore = Integer.parseInt(request.getParameter("toHomeMannerScore"));
		int toAwayMannerScore = Integer.parseInt(request.getParameter("toAwayMannerScore"));

		mrVo.setMatchId(matchId);
		mrVo.setScore(score);
		mrVo.setToAwayMannerScore(toAwayMannerScore);
		mrVo.setToHomeMannerScore(toHomeMannerScore);

		tiVo = FootBallDAOImpl.getInstance().getTeamInfo(teamId);
		if (vVo.getTeamId() == teamId) {
			tiVo.setMannerScore((tiVo.getMannerScore()*tiVo.getMatchNum() + toHomeMannerScore) / (tiVo.getMatchNum() + 1));// 평균
			if (Integer.parseInt(homeScore) > Integer.parseInt(awayScore)) {
				winningScore = 3;
			} else if (Integer.parseInt(homeScore) == Integer.parseInt(awayScore)) {
				winningScore = 1;
			} else {
				winningScore = 0;
			}
		} else {
			tiVo.setMannerScore((tiVo.getMannerScore()*tiVo.getMatchNum() + toAwayMannerScore) / (tiVo.getMatchNum() + 1));// 평균
			if (Integer.parseInt(homeScore) < Integer.parseInt(awayScore)) {
				System.out.println(Integer.parseInt(homeScore)+"홈팀스코어");
				System.out.println(Integer.parseInt(awayScore)+"어웨이스코어");
				
				winningScore = 3;
			} else if (Integer.parseInt(homeScore) == Integer.parseInt(awayScore)) {
				winningScore = 1;
			} else {
				winningScore = 0;
			}
		}

		tiVo.setMatchNum((tiVo.getMatchNum() + 1));// 1 더하기

		tiVo.setWinningScore(tiVo.getWinningScore()+winningScore);//승점
		tiVo.setTeamScore(tiVo.getMannerScore()+tiVo.getMatchNum()+tiVo.getMemberNum()+tiVo.getWinningScore());
		System.out.println(mrVo+"매치리절트컨트롤러 매치리절트브이오입니다.");
		FootBallDAOImpl.getInstance().insertMatchResult(mrVo);
		System.out.println(tiVo+"매치리절트컨트롤러 팀인포브이오입니다.");	
		FootBallDAOImpl.getInstance().updateTeamInfo(tiVo);
		String path = "teamHome.do?teamId="+teamId;
		System.out.println(path+"매치리절트컨트롤러 path정보입니다.");
		return new ModelAndView(path);
	}

}
