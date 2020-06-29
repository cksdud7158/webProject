package controller;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FootBallDAOImpl;
import model.MatchVO;
public class matchHistoryController implements Controller {
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "test.html";
		int teamId = Integer.parseInt(request.getParameter("teamId"));
		ArrayList<MatchVO> history = FootBallDAOImpl.getInstance().matchHistory(teamId);
		if(!history.isEmpty()) {
			request.setAttribute("history", history);
			path = "matchHistory.jsp";
		}
		return new ModelAndView(path);
	}
}