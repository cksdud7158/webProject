package controller;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FootBallDAOImpl;
import model.MatchVO;
import model.TeamVO;
public class matchHistoryController implements Controller {
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "test.html";
		int teamId = Integer.parseInt(request.getParameter("teamId"));
		ArrayList<MatchVO> history = FootBallDAOImpl.getInstance().matchHistory(teamId);
		if(!history.isEmpty()) {
			// 승패 field 입력
			for(MatchVO match : history) {
				String[] score = match.getMrVo().getScore().split(":");
				if(match.getTeamId()==teamId) {//내가 홈팀이면
					if(Integer.parseInt(score[0]) > Integer.parseInt(score[1])) {
						match.setVictory(1); //1이면 승리, 0이면 무승부, -1이면 패배
					} else if(Integer.parseInt(score[0]) < Integer.parseInt(score[1])) {
						match.setVictory(-1);
					} else {
						match.setVictory(0);
					}
				} else {//내가 어웨이팀이면
					if(Integer.parseInt(score[1]) > Integer.parseInt(score[0])) {
						match.setVictory(1);
					} else if(Integer.parseInt(score[1]) < Integer.parseInt(score[0])) {
						match.setVictory(-1);
					} else {
						match.setVictory(0);
					}
				}
			}//for
			ArrayList<TeamVO> tVoList = FootBallDAOImpl.getInstance().showAllTeam();
			
			// 승리, 패배, 무승부를 카운트하는 배열 생성
			int[] arr = new int[3];
			for(MatchVO m : history) {				
				if(m.getVictory()==1) arr[0]+=1;
				else if(m.getVictory()==-1) arr[1]+=1;
				else if(m.getVictory()==0) arr[2]+=1;
			}
			
			// attribute 바인딩
			request.setAttribute("history", history);
			request.setAttribute("tVoList", tVoList);
			request.setAttribute("win", arr[0]);
			request.setAttribute("lose", arr[1]);
			request.setAttribute("draw", arr[2]);
			path = "matchHistory.jsp";
		}
		return new ModelAndView(path);
	}
}